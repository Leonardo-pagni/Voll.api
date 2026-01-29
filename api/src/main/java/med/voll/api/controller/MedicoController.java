package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.Medico;
import med.voll.api.dto.MedicoRequestDTO;
import med.voll.api.service.CadastrarMedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final CadastrarMedicoService service;
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid MedicoRequestDTO dados){
        try {
            service.cadastrarMedico(dados);

            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
         return ResponseEntity.badRequest().build();
        }
    }


}
