package med.voll.api.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.MedicoResponseDTO;
import med.voll.api.repository.MedicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarMedicoService {
    private final MedicoRepository repository;

    public Page<MedicoResponseDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(MedicoResponseDTO::new);
    }
}
