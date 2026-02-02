package med.voll.api.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import med.voll.api.domain.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExcluirMedicoService {

    private final MedicoRepository repository;

    @Transactional
    public void ExcluirMedico(long id)
    {
        Medico medico = repository.getReferenceById(id);
        medico.inativar();
    }
}
