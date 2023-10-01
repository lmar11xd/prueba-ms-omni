package com.lmar.orquestadorservice.controller;

import com.lmar.orquestadorservice.model.dto.RequestValidarTO;
import com.lmar.orquestadorservice.service.OrquestadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orquestador")
public class OrquestadorController {

    @Autowired
    private OrquestadorService orquestadorService;

    @PostMapping("/validar")
    public ResponseEntity<?> validar(@Valid @RequestBody RequestValidarTO request) {
        String result = orquestadorService.validar();
        return ResponseEntity.ok(result);
    }
}
