package br.com.banco.controllers;

import br.com.banco.dtos.requesties.ContaRequest;
import br.com.banco.services.impl.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/banco/contas")
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

    @GetMapping
    public ResponseEntity<Page<ContaRequest>> buscarTodasContasPaginadas(

            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "nomeResponsavel") String orderBy
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy );
        Page<ContaRequest> list = service.buscarTodosPaginados(pageRequest);
        return ResponseEntity.ok().body(list);
    }
}
