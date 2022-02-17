package one.digitalinnovation.CadastroClientePetshop.entity;

import lombok.*;
import one.digitalinnovation.CadastroClientePetshop.enums.PetType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@Table(name = "pets")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PetType type;

    @NotEmpty
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String nome;

    @Column
    private String idade;

    @NotEmpty
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String raca;

    @ManyToOne
    @JoinColumn(name = "fk_clientes_id", nullable = false)
    private Costumer costumer;
}
