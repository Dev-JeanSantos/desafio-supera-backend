package br.com.banco.services.impl;

import br.com.banco.dtos.requesties.ContaRequest;
import br.com.banco.entities.Conta;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.services.IContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContaService implements IContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public ContaRequest save(ContaRequest request) {
        Conta conta = contaRepository.save(Conta.converterRequest(request));
        return ContaRequest.converter(conta);
    }
}
