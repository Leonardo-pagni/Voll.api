package med.voll.api.domain;


import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.Enum.Especialidades;
import med.voll.api.dto.MedicoRequestDTO;

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

    public Medico(MedicoRequestDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.crm = dto.crm();
        this.telefone = dto.telefone();
        this.especialidade = dto.especialidade();
        this.endereco = new Endereco(dto.endereco());
    }
}

