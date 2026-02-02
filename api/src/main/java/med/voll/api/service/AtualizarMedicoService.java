package med.voll.api.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import med.voll.api.domain.Endereco;
import med.voll.api.domain.Medico;
import med.voll.api.dto.AtualizarMedicoRequestDTO;
import med.voll.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarMedicoService {

    private final MedicoRepository repository;

    @Transactional
    public void AtualizarMedico(AtualizarMedicoRequestDTO dto)
    {

        Medico medico = repository.getReferenceById(dto.id());
        Endereco endereco = new Endereco();

        if(dto.endereco() != null) {
            endereco.AtualizarEndereco(dto.endereco().logradouro(), dto.endereco().numero(), dto.endereco().bairro(), dto.endereco().cep(), dto.endereco().cidade(), dto.endereco().uf(), dto.endereco().complemento());
        }
        else {
            endereco = null;
        }
        medico.AtualizarMedico(dto.nome(), dto.telefone(), endereco);
    }
}
