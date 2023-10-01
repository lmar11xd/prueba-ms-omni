package com.lmar.orquestadorservice.service.impl;

import com.lmar.orquestadorservice.feignclient.DominioFeignClient;
import com.lmar.orquestadorservice.model.dto.DominioTO;
import com.lmar.orquestadorservice.service.OrquestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrquestadorServiceImpl implements OrquestadorService {
    @Autowired
    private DominioFeignClient dominioFeignClient;

    @Override
    public List<DominioTO> listarDominios() {
        return dominioFeignClient.listarDominios();
    }

    @Override
    public DominioTO registrarDominio(DominioTO dominio) {
        return dominioFeignClient.registrarDominio(dominio);
    }
}
