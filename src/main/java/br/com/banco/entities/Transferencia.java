package br.com.banco.entities;

import br.com.banco.dtos.requesties.TransferenciaRequest;
import br.com.banco.dtos.responses.TransferenciaResponse;
import br.com.banco.enums.Tipo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataTransferencia;
    private double valor;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private String nomeOperadorTransacao;

    @OneToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;


    public static Transferencia transferenciaRequest(TransferenciaRequest transferenciaRequest, Conta conta) {
        Transferencia transferencia = new Transferencia();
        transferencia.setId(transferenciaRequest.getId());
        transferencia.setDataTransferencia(transferenciaRequest.getDataTransferencia());
        transferencia.setValor(transferenciaRequest.getValor());
        transferencia.setTipo(transferenciaRequest.getTipo());
        transferencia.setNomeOperadorTransacao(transferenciaRequest.getNomeOperadorTransacao());
        transferencia.setConta(conta);

        return transferencia;
    }

    public static Transferencia transferenciaResponse(TransferenciaResponse transferenciaResponse, Conta conta) {
        Transferencia transferencia = new Transferencia();
        transferencia.setDataTransferencia(transferenciaResponse.getDataTransferencia());
        transferencia.setValor(transferenciaResponse.getValor());
        transferencia.setTipo(transferenciaResponse.getTipo());
        transferencia.setNomeOperadorTransacao(transferenciaResponse.getNomeOperadorTransacao());
        transferencia.setConta(conta);

        return transferencia;
    }

}
