package com.lmar.orquestadorservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestValidarTO {
    private int precio;

    @NotBlank(message = "La descripcion no puede ser nulo o vacío")
    private String descripcion;
}
