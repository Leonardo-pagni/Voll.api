package med.voll.api.domain;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.api.dto.EnderecoDTO;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    public Endereco(EnderecoDTO dto) {
        this.uf = dto.uf();
        this.cep = dto.cep();
        this.bairro = dto.bairro();
        this.logradouro = dto.logradouro();
        this.complemento = dto.complemento();
        this.cidade = dto.cidade();
        this.numero = dto.numero();
    }
}