package com.lmar.orquestadorservice.service.impl;

import com.lmar.orquestadorservice.service.ValidadorService;
import org.springframework.stereotype.Service;

@Service
public class ValidadorServiceImpl implements ValidadorService {
    @Override
    public String validar() {
        return "Validación correcta";
    }
}
