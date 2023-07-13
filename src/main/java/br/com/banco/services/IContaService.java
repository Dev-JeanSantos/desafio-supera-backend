package br.com.banco.services;

import br.com.banco.dtos.requesties.ContaRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IContaService {

    public ContaRequest save (ContaRequest request);

    Page<ContaRequest> buscarTodosPaginados(PageRequest pageRequest);
}
