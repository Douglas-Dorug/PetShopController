package one.digitalinnovation.CadastroClientePetshop.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.CadastroClientePetshop.dto.MessageResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.CostumerDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.PetDTO;
import one.digitalinnovation.CadastroClientePetshop.entity.Pet;
import one.digitalinnovation.CadastroClientePetshop.exception.CostumerNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.exception.PetNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.service.CostumerService;
import one.digitalinnovation.CadastroClientePetshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/petshop")
public class PetsController {

    @Autowired
    private CostumerService costumerService;

    @Autowired
    private PetService petService;

    @PostMapping("/pets")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPet(@RequestBody @Valid PetDTO petDTO) throws CostumerNotFoundException {
        return petService.createPet(petDTO);
    }

    @PutMapping("/pets/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PetDTO petDTO) throws PetNotFoundException {
        return petService.updateByID(id, petDTO);
    }

    @GetMapping(value = "/pets/consulta-pets-por-id-cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pet> listAllByCliente(@PathVariable Long id) throws CostumerNotFoundException {
        return petService.obterPetsPorIdCliente(id);
    }

    @GetMapping("/pets/consultar-pets/{id}")
    public PetDTO findById(@PathVariable Long id) throws PetNotFoundException {
        return petService.findById(id);
    }

    @DeleteMapping("/pets/deletar-pets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PetNotFoundException{
        petService.delete(id);
    }
}