package one.digitalinnovation.CadastroClientePetshop.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.CadastroClientePetshop.dto.MessageResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.CostumerDTO;
import one.digitalinnovation.CadastroClientePetshop.entity.Costumer;
import one.digitalinnovation.CadastroClientePetshop.exception.CostumerNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.mapper.CostumerMapper;
import one.digitalinnovation.CadastroClientePetshop.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CostumerService {
    private CostumerRepository costumerRepository;

    private final CostumerMapper costumerMapper = CostumerMapper.INSTANCE;

    public MessageResponseDTO createCostumer(one.digitalinnovation.CadastroClientePetshop.dto.request.@Valid CostumerDTO costumerDTO){
        Costumer costumerToSave = costumerMapper.toModel(costumerDTO);
        Costumer savedCostumer = costumerRepository.save(costumerToSave);
        return createMessageResponse(savedCostumer.getId(),"Created costumer with ID ");
    }

    public List<CostumerDTO> listALL(){
        List<Costumer> allCostumer = costumerRepository.findAll();
        return allCostumer.stream()
                .map(costumerMapper::toDTO)
                .collect(Collectors.toList());
    }
    //Encontra uma ID
    public CostumerDTO findById(Long id) throws CostumerNotFoundException {
        Costumer costumer = verifyIfExists(id);
        return costumerMapper.toDTO(costumer);
    }
    //Deleta uma ID
    public void delete(Long id) throws CostumerNotFoundException {
        verifyIfExists(id);

        costumerRepository.deleteById(id);
    }
    //Atualizar informacoes por ID
    public MessageResponseDTO updateByID(Long id, CostumerDTO costumerDTO) throws CostumerNotFoundException {
        verifyIfExists(id);
        Costumer costumerToUpdate = costumerMapper.toModel(costumerDTO);
        Costumer updatedPerson = costumerRepository.save(costumerToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated Costumer with ID ");
    }

    //Parte do codigo que verifica se um determinado ID existe no banco de dados
    private Costumer verifyIfExists(Long id) throws CostumerNotFoundException {
        return costumerRepository.findById(id)
                .orElseThrow(() -> new CostumerNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
