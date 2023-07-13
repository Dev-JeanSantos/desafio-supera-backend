package br.com.banco.controllers;

import br.com.banco.dtos.requesties.ContaRequest;
import br.com.banco.services.impl.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/banco/conta")
public class ContaController {
    @Autowired
    private ContaService service;

    @PostMapping
    public ResponseEntity<ContaRequest> criarConta(@RequestBody @Valid ContaRequest request){
        request = service.save(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(request.getIdConta()).toUri();
        return ResponseEntity.created(uri).body(request);
    }
}
