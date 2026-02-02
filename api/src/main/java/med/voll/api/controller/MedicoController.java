package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.AtualizarMedicoRequestDTO;
import med.voll.api.dto.CadastrarMedicoRequestDTO;
import med.voll.api.dto.MedicoResponseDTO;
import med.voll.api.service.AtualizarMedicoService;
import med.voll.api.service.CadastrarMedicoService;
import med.voll.api.service.ExcluirMedicoService;
import med.voll.api.service.ListarMedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final CadastrarMedicoService cadastrarMedicoService;
    private final ListarMedicoService listarMedicoService;
    private final AtualizarMedicoService atualizarMedicoService;
    private final ExcluirMedicoService excluirMedicoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CadastrarMedicoRequestDTO dados){
        try {
            cadastrarMedicoService.cadastrarMedico(dados);

            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
         return ResponseEntity.badRequest().body(ex.getMessage());
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

    @PutMapping
    public ResponseEntity Atualizar(@RequestBody @Valid AtualizarMedicoRequestDTO dados){
        try
        {
            atualizarMedicoService.AtualizarMedico(dados);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity Excluir(@PathVariable long id)
    {
        try
        {
            excluirMedicoService.ExcluirMedico(id);

            return ResponseEntity.ok().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
