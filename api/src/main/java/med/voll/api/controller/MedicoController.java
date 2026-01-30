package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.Medico;
import med.voll.api.dto.MedicoRequestDTO;
import med.voll.api.dto.MedicoResponseDTO;
import med.voll.api.service.CadastrarMedicoService;
import med.voll.api.service.ListarMedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final CadastrarMedicoService cadastrarMedicoService;
    private final ListarMedicoService listarMedicoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid MedicoRequestDTO dados){
        try {
            cadastrarMedicoService.cadastrarMedico(dados);

            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
         return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<MedicoResponseDTO>> listar(Pageable paginacao){
        try
        {
            Page<MedicoResponseDTO> response = listarMedicoService.listar(paginacao);
            return ResponseEntity.ok(response);
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().build();
        }
    }

}
