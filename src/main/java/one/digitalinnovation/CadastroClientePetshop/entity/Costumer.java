package one.digitalinnovation.CadastroClientePetshop.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@Builder
@Table(name = "clientes")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2,max = 100)
    @Column(nullable = false)
    private String fullName;

    @NotEmpty
    @CPF
    @Column(nullable = false, unique = true)
    private String cpf;

    @Email
    @Column(unique = true)
    private String email;

    private LocalDate birthDate;

    @NotEmpty
    @Size(min = 4, max = 100)
    @Column
    private String rua;

    @NotEmpty
    @Size(min = 4, max = 50)
    @Column
    private String bairro;

    @NotEmpty
    @Size( max = 10)
    @Column
    private String numeroCasa;

    @Size(max = 100)
    @Column
    private String referencia;

    @NotEmpty
    @Size(min = 9,max = 11 )
    @Column
    private String numContato;

}
