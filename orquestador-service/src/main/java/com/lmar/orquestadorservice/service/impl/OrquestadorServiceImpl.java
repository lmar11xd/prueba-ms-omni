package com.lmar.orquestadorservice.service.impl;

import com.lmar.orquestadorservice.service.OrquestadorService;
import org.springframework.stereotype.Service;

@Service
public class OrquestadorServiceImpl implements OrquestadorService {
    @Override
    public String validar() {
        return "Validación correcta";
    }
}
