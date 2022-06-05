package one.digitalinnovation.CadastroClientePetshop.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.CadastroClientePetshop.dto.MessageResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.CostumerDTO;
import one.digitalinnovation.CadastroClientePetshop.entity.Costumer;
import one.digitalinnovation.CadastroClientePetshop.exception.CostumerNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.repository.CostumerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CostumerService {
    private CostumerRepository costumerRepository;

    public MessageResponseDTO saveCostumer(CostumerDTO costumerDTO){
        Costumer newCostumer = new Costumer();
        newCostumer.setCpf(costumerDTO.getCpf());
        newCostumer.setBairro(costumerDTO.getBairro());
        newCostumer.setBirthDate(costumerDTO.getBirthDate());
        newCostumer.setEmail(costumerDTO.getEmail());
        newCostumer.setFullName(costumerDTO.getFullName());
        newCostumer.setNumContato(costumerDTO.getNumContato());
        newCostumer.setRua(costumerDTO.getRua());
        newCostumer.setNumeroCasa(costumerDTO.getNumeroCasa());
        newCostumer.setReferencia(costumerDTO.getReferencia());

        costumerRepository.save(newCostumer);

        return createMessageResponse(newCostumer.getId(),"Created costumer with ID ");
    }

    public List<CostumerDTO> listAll(){
        List<Costumer> costumers = costumerRepository.findAll();
        List<CostumerDTO> costumersList = new ArrayList<CostumerDTO>();

        for (Costumer costumer : costumers){
            CostumerDTO costumerOnList = new CostumerDTO();
            BeanUtils.copyProperties(costumer, costumerOnList);

            costumersList.add(costumerOnList);
        }

        return costumersList;
    }

    //Encontra uma ID
    public CostumerDTO findById(Long id) throws CostumerNotFoundException{
        Costumer costumer = verifyIfExists(id);
        CostumerDTO costumerReturn = new CostumerDTO();
        BeanUtils.copyProperties(costumer, costumerReturn);

        return costumerReturn;
    }

    //Deleta uma ID
    public void delete(Long id) throws CostumerNotFoundException {
        verifyIfExists(id);
        costumerRepository.deleteById(id);
    }
    //Atualizar informacoes por ID
    public MessageResponseDTO updateByID (Long id, CostumerDTO costumerDTO) throws CostumerNotFoundException{
        verifyIfExists(id);
        Costumer costumerUpdated = new Costumer();
        BeanUtils.copyProperties(costumerDTO, costumerUpdated);

        Costumer updatedCostumer = costumerRepository.save(costumerUpdated);
        return createMessageResponse(updatedCostumer.getId(), "Updated Costumer with ID ");
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
