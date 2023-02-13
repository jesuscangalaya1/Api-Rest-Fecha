package com.Fechas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private LocalDateTime fecha;

    private LocalTime hora;


    public Tienda(String nombre, LocalDateTime fecha, LocalTime hora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }
}
