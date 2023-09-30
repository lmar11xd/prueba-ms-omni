package com.lmar.orquestadorservice.controller;

import com.lmar.orquestadorservice.model.dto.RequestValidarTO;
import com.lmar.orquestadorservice.service.ValidadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/validador")
public class ValidadorController {

    @Autowired
    private ValidadorService validadorService;

    @PostMapping("/validar")
    public ResponseEntity<?> validar(@RequestBody RequestValidarTO request) {
        String result = validadorService.validar();
        return ResponseEntity.ok(result);
    }
}
