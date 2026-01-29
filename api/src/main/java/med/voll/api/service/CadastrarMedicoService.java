package med.voll.api.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.Medico;
import med.voll.api.dto.MedicoRequestDTO;
import med.voll.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarMedicoService {

    private final MedicoRepository medicoRepository;

    @Transactional
    public void cadastrarMedico(MedicoRequestDTO dto)
    {
        Medico medicoEntidade = new Medico(dto);

        medicoRepository.save(medicoEntidade);
    }
}
