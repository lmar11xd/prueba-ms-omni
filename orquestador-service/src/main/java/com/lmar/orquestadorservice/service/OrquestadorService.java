package com.lmar.orquestadorservice.service;

import com.lmar.orquestadorservice.model.dto.DominioTO;

import java.util.List;

public interface OrquestadorService {
    List<DominioTO> listarDominios();
    DominioTO registrarDominio(DominioTO dominio);
}
