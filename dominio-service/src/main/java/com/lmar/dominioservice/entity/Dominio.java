package com.lmar.dominioservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "dominio")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dominio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private double precio;
    private int cantidad;
}
