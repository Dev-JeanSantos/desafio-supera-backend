package br.com.banco.controllers;

import br.com.banco.dtos.requesties.TransferenciaRequest;
import br.com.banco.dtos.responses.TransferenciaResponse;
import br.com.banco.services.impl.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/banco/transferencias")
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

    @GetMapping
    public ResponseEntity<Page<TransferenciaResponse>> buscarTodasTransferenciasPaginadas(
            @RequestParam(value = "dataInicio", defaultValue = "") LocalDateTime dataInicio,
            @RequestParam(value = "dataFim", defaultValue = "") LocalDateTime dataFim,
            @RequestParam(value = "nomeOperadorTransacao", defaultValue = "") String nomeOperadorTransacao,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy );
        Page<TransferenciaResponse> list = service.buscarTransferenciasPaginados(dataInicio, dataFim, nomeOperadorTransacao, pageRequest);
        return ResponseEntity.ok().body(list);
    }

}
