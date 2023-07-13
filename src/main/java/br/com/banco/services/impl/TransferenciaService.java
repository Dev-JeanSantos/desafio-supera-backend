package br.com.banco.services.impl;

import br.com.banco.dtos.requesties.TransferenciaRequest;
import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.services.ITransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService implements ITransferenciaService {

    @Autowired
    private TransferenciaRepository repository;

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public TransferenciaRequest save(TransferenciaRequest request) {
        Conta conta = contaRepository.getOne(request.getContaId());
        Transferencia transferencia = repository.save(Transferencia.transferenciaRequest(request, conta));

        return TransferenciaRequest.converter(transferencia);
    }
}