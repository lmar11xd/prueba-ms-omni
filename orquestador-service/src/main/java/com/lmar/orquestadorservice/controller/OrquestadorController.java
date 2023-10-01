package com.lmar.orquestadorservice.controller;

import com.lmar.orquestadorservice.model.dto.DominioTO;
import com.lmar.orquestadorservice.service.OrquestadorService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orquestador")
public class OrquestadorController {

    @Autowired
    private OrquestadorService orquestadorService;

    @CircuitBreaker(name = "dominioCB", fallbackMethod = "fallBackListarDominios")
    @GetMapping("/listarDominios")
    public ResponseEntity<?> listarDominios() {
        List<DominioTO> dominios = orquestadorService.listarDominios();
        return ResponseEntity.ok(dominios);
    }

    @CircuitBreaker(name = "dominioCB", fallbackMethod = "fallBackGuardarDominio")
    @PostMapping("/validar")
    public ResponseEntity<?> validar(@Valid @RequestBody DominioTO dominio) {
        DominioTO nuevoDominio = orquestadorService.registrarDominio(dominio);
        return ResponseEntity.ok(nuevoDominio);
    }

    public ResponseEntity<List<DominioTO>> fallBackListarDominios(RuntimeException e) {
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }

    public ResponseEntity<DominioTO> fallBackGuardarDominio(@RequestBody DominioTO dominio, RuntimeException e) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
