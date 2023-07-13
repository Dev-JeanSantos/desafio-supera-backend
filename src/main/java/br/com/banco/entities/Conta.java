package br.com.banco.entities;

import br.com.banco.dtos.requesties.ContaRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_conta;
    private String nomeResponsavel;

    public static Conta converterRequest(ContaRequest contaRequest) {
        Conta conta = new Conta();
        conta.setId_conta(contaRequest.getIdConta());
        conta.setNomeResponsavel(contaRequest.getNomeResponsavel());

        return conta;
    }

}
