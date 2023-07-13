package br.com.banco.dtos.requesties;

import br.com.banco.entities.Conta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContaRequest {

    @NotNull
    private Integer idConta;
    @NotBlank
    private String nomeResponsavel;

    public static ContaRequest converter(Conta conta) {
        ContaRequest request = new ContaRequest();
        request.setIdConta(conta.getId_conta());
        request.setNomeResponsavel(conta.getNomeResponsavel());

        return request;
    }
}
