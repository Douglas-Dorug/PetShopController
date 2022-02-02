package one.digitalinnovation.CadastroClientePetshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CostumerDTO {

    private Long id;

    private String fullName;

    private String cpf;

    private String email;

    private String rua;

    private String bairro;

    private String numeroCasa;

    private String referencia;

    private String numContato;

    private String birthDate;

}
