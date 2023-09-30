package com.lmar.orquestadorservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestValidarTO {
    private int precio;
    private String descripcion;
}
