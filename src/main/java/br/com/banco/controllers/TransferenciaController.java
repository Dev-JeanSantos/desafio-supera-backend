package br.com.banco.controllers;

import br.com.banco.dtos.requesties.TransferenciaRequest;
import br.com.banco.services.impl.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/banco/transferencia")
public class TransferenciaController {
    @Autowired
    private TransferenciaService service;

    @PostMapping()
    public ResponseEntity<TransferenciaRequest> criarTransferencia(@Valid @RequestBody TransferenciaRequest request){
        request.setDataTransferencia(LocalDateTime.now());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(service.save(request));
    }

}
