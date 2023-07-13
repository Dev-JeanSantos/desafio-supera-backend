package br.com.banco.services;

import br.com.banco.dtos.requesties.TransferenciaRequest;
import br.com.banco.dtos.responses.TransferenciaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;

public interface ITransferenciaService {

    public TransferenciaRequest save (TransferenciaRequest request);

    Page<TransferenciaResponse> buscarTransferenciasPaginados(LocalDateTime dataInicio, LocalDateTime dataFim, String nomeOperadorTransacao, PageRequest pageRequest);

}
