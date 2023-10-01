package com.lmar.orquestadorservice.feignclient;

import com.lmar.orquestadorservice.model.dto.DominioTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "dominio-service")
public interface DominioFeignClient {
    @GetMapping("api/dominio/listar")
    List<DominioTO> listarDominios();

    @PostMapping("api/dominio/registrar")
    DominioTO registrarDominio(DominioTO dominio);
}
