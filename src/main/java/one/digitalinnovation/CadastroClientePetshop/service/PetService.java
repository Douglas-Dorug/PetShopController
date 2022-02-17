package one.digitalinnovation.CadastroClientePetshop.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.CadastroClientePetshop.dto.MessageResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.CostumerDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.PetDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.response.PetResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.entity.Costumer;
import one.digitalinnovation.CadastroClientePetshop.entity.Pet;
import one.digitalinnovation.CadastroClientePetshop.exception.CostumerNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.exception.PetNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.mapper.PetMapper;
import one.digitalinnovation.CadastroClientePetshop.repository.CostumerRepository;
import one.digitalinnovation.CadastroClientePetshop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private CostumerService costumerService;

    private final PetMapper petMapper = PetMapper.INSTANCE;

    public MessageResponseDTO createPet(one.digitalinnovation.CadastroClientePetshop.dto.request.@Valid PetDTO petDTO) throws CostumerNotFoundException {
        Pet petToSave = petMapper.toModel(petDTO);
        Costumer costumer = costumerRepository.getById(petDTO.getIdCliente());
        petToSave.setCostumer(costumer);
        Pet savedPet = petRepository.save(petToSave);
        return createMessageResponse(savedPet.getId(),"Created pet with ID ");
    }

    public List<Pet> obterPetsPorIdCliente (Long id) throws CostumerNotFoundException {
        CostumerDTO dto = costumerService.findById(id);
        Costumer costumer = costumerRepository.getById(dto.getId());
        List<Pet> listaPetsCliente = petRepository.findByCostumer(costumer);
        return listaPetsCliente;
    }

    public void delete(Long id) throws PetNotFoundException {
        verifyIfExists(id);
        petRepository.deleteById(id);
    }

    public MessageResponseDTO updateByID(Long id, PetDTO petDTO) throws PetNotFoundException {
        verifyIfExists(id);
        Pet petToUpdate = petMapper.toModel(petDTO);
        Pet updatedPet = petRepository.save(petToUpdate);
        return createMessageResponse(updatedPet.getId(), "Updated Costumer with ID ");
    }

    public PetDTO findById(Long id) throws PetNotFoundException {
        Pet pet = verifyIfExists(id);
        return petMapper.toDTO(pet);
    }

    public List<PetResponseDTO> listALL(){
        List<Pet> allPets = petRepository.findAll();
        return allPets.stream()
                .map(petMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    private Pet verifyIfExists(Long id) throws  PetNotFoundException{
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}