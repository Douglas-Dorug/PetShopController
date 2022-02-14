package one.digitalinnovation.CadastroClientePetshop.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.CadastroClientePetshop.dto.MessageResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.CostumerDTO;
import one.digitalinnovation.CadastroClientePetshop.exception.CostumerNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/petshop")
public class PetShopController {

    private CostumerService costumerService;

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCostumer(@RequestBody @Valid CostumerDTO costumerDTO){
        return costumerService.createCostumer(costumerDTO);
    }

    @GetMapping("/clientes/listar-clientes")
    public List<CostumerDTO> listAll(){
        return costumerService.listALL();

    }
    //Procura por um cliente pelo seu ID
    @GetMapping("/clientes/listar-cliente/{id}")
    public CostumerDTO findById (@PathVariable Long id) throws CostumerNotFoundException {
        return costumerService.findById(id);
    }

    //Atualiza um ID
    @PutMapping("/clientes/atualizar-cliente/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody @Valid CostumerDTO costumerDTO) throws CostumerNotFoundException {
        return costumerService.updateByID(id,costumerDTO);
    }

    //Deleta um cliente por seu ID
    @DeleteMapping("/clientes/deletar-cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws CostumerNotFoundException {
        costumerService.delete(id);
    }

}
