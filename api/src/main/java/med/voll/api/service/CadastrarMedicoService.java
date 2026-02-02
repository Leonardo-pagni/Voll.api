package med.voll.api.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.Endereco;
import med.voll.api.domain.Medico;
import med.voll.api.dto.CadastrarMedicoRequestDTO;
import med.voll.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarMedicoService {

    private final MedicoRepository medicoRepository;

    @Transactional
    public void cadastrarMedico(CadastrarMedicoRequestDTO dto)
    {
        Endereco endereco = new Endereco(dto.endereco().logradouro(), dto.endereco().numero(), dto.endereco().bairro(), dto.endereco().cep(), dto.endereco().cidade(), dto.endereco().uf(), dto.endereco().complemento());
        Medico medicoEntidade = new Medico(dto.nome(), dto.email(), dto.crm(),dto.telefone(), dto.especialidade(),endereco);

        medicoRepository.save(medicoEntidade);
    }
}
