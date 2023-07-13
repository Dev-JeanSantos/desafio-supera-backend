package br.com.banco.services.impl;

import br.com.banco.dtos.requesties.ContaRequest;
import br.com.banco.entities.Conta;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.services.IContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ContaService implements IContaService {

    @Autowired
    private ContaRepository repository;

    @Override
    public ContaRequest save(ContaRequest request) {
        Conta conta = repository.save(Conta.converterRequest(request));
        return ContaRequest.converter(conta);
    }

    @Override
    public Page<ContaRequest> buscarTodosPaginados(PageRequest pageRequest) {
        Page<Conta> lista = repository.findAll(pageRequest);
        return lista.map(ContaRequest::converter);
    }
}


