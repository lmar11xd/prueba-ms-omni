package com.lmar.dominioservice.controller;

import com.lmar.dominioservice.entity.Dominio;
import com.lmar.dominioservice.service.DominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dominio")
public class DominioController {

    @Autowired
    private DominioService dominioService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        List<Dominio> dominios = dominioService.listar();
        if(dominios.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(dominios);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Dominio dominio) {
        Dominio nuevoDominio = dominioService.registrar(dominio);
        if(nuevoDominio == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(nuevoDominio);
    }

}
