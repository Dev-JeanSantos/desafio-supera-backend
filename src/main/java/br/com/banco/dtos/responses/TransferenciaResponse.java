package br.com.banco.dtos.responses;

import br.com.banco.entities.Transferencia;
import br.com.banco.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransferenciaResponse {

    private LocalDateTime dataTransferencia;
    private double valor;
    private Tipo tipo;
    private String nomeOperadorTransacao;
    private Integer contaId;

    public static TransferenciaResponse converter(Transferencia transferencia) {
        TransferenciaResponse response = new TransferenciaResponse();
        response.setDataTransferencia(transferencia.getDataTransferencia());
        response.setValor(transferencia.getValor());
        response.setTipo(transferencia.getTipo());
        response.setNomeOperadorTransacao(transferencia.getNomeOperadorTransacao());
        response.setContaId(transferencia.getConta().getId_conta());

        return response;
    }
}
