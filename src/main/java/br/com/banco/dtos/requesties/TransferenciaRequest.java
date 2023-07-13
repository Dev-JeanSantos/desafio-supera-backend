package br.com.banco.dtos.requesties;

import br.com.banco.entities.Transferencia;
import br.com.banco.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransferenciaRequest {
    private Integer id;
    private LocalDateTime dataTransferencia;
    @NotNull
    private double valor;
    private Tipo tipo;
    @NotBlank
    private String nomeOperadorTransacao;
    @NotNull
    private Integer contaId;


    public static TransferenciaRequest converter(Transferencia transferencia) {
        TransferenciaRequest request = new TransferenciaRequest();
        request.setId(transferencia.getId());
        request.setDataTransferencia(transferencia.getDataTransferencia());
        request.setValor(transferencia.getValor());
        request.setTipo(transferencia.getTipo());
        request.setNomeOperadorTransacao(transferencia.getNomeOperadorTransacao());
        request.setContaId(transferencia.getConta().getId_conta());

        return request;
    }
}


