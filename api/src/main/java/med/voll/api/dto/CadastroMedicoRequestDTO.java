package med.voll.api.dto;

import med.voll.api.dto.Enum.Especialidades;

public record CadastroMedicoRequestDTO(String nome, String email, String crm, Especialidades especialidade, CadastroEndereco endereco) {
}
