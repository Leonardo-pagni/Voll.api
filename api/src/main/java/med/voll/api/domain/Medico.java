package med.voll.api.domain;


import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.Enum.Especialidades;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidades especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(String nome, String email, String crm, String telefone, Especialidades especialidade, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public void AtualizarMedico(String nome, String telefone, Endereco endereco)
    {
        if(nome != null)
        {
            this.nome = nome;
        }
        if(telefone != null)
        {
            this.telefone = telefone;
        }
        if(endereco != null)
        {
            this.endereco = endereco;
        }
    }
}

