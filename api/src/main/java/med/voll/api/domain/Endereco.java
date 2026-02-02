package med.voll.api.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

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

    public void AtualizarEndereco(String logradouro, String numero, String bairro, String cep, String cidade, String uf, String complemento) {
        if(logradouro != null)
        {
            this.logradouro = logradouro;
        }
        if(numero != null)
        {
            this.numero = numero;
        }
        if(bairro != null)
        {
            this.bairro = bairro;
        }
        if(cep != null)
        {
            this.cep = cep;
        }
        if(cidade != null)
        {
            this.cidade = cidade;
        }
        if(uf != null)
        {
            this.uf = uf;
        }
        if(complemento != null)
        {
            this.complemento = complemento;
        }
    }
}