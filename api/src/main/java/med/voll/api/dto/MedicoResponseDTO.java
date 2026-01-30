package med.voll.api.dto;

import med.voll.api.domain.Enum.Especialidades;
import med.voll.api.domain.Medico;

public record MedicoResponseDTO(String nome, String email, String crm, Especialidades especialidade) {

    public MedicoResponseDTO(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
