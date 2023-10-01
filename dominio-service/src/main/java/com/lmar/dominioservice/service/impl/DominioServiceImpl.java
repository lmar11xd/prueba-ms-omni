package com.lmar.dominioservice.service.impl;

import com.lmar.dominioservice.entity.Dominio;
import com.lmar.dominioservice.repository.DominioRepository;
import com.lmar.dominioservice.service.DominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DominioServiceImpl implements DominioService {

    @Autowired
    private DominioRepository dominioRepository;

    @Override
    public List<Dominio> listar() {
        return dominioRepository.findAll();
    }

    @Override
    public Dominio registrar(Dominio dominio) {
        return dominioRepository.save(dominio);
    }
}
