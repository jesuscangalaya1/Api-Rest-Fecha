package com.Fechas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TiendaDto {

    private String nombre;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy'T'HH:mm")
    private LocalDateTime fecha;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
    private LocalTime hora;


}
