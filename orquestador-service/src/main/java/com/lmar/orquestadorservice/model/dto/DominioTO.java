package com.lmar.orquestadorservice.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DominioTO {
    private int id;

    @NotNull(message = "La descripción no puede ser nula")
    @NotBlank(message = "La descripción no puede ser vacío")
    @Size(max = 100, message = "La descripción debe tener 200 caracteres como máximo")
    private String descripcion;

    @NotNull(message = "El precio no puede ser nulo")
    @Min(value = 1, message = "El precio no puede ser menor que 1")
    @Max(value = 50, message = "El precio no puede ser mayor que 50")
    private double precio;

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad no puede ser menor que 1")
    @Max(value = 10, message = "La cantidad no puede ser mayor que 10")
    private int cantidad;

}
