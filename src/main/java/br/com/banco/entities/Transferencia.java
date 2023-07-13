package br.com.banco.entities;

import br.com.banco.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transferencia {
    private Integer id;
    private LocalDate dataTransferencia;
    private double valor;
    private Enum<Tipo> tipo;
    private String nomeOperadorTransacao;
    private Conta conta;
}
