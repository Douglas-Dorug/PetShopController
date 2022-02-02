package one.digitalinnovation.CadastroClientePetshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CostumerNotFoundException extends Exception{
    public CostumerNotFoundException(Long id){
        super("Costumer not found with ID " + id);
    }

}
