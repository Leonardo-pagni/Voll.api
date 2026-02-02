package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.Endereco;

public record AtualizarMedicoRequestDTO(
        @NotNull Long id,
        String nome ,
        String telefone,
        EnderecoDTO endereco) {
}
