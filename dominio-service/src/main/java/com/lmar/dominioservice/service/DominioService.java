package com.lmar.dominioservice.service;

import com.lmar.dominioservice.entity.Dominio;

import java.util.List;

public interface DominioService {
    List<Dominio> listar();
    Dominio registrar(Dominio dominio);
}
