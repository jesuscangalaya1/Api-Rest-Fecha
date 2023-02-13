package com.Fechas.controller;

import com.Fechas.dto.Mensaje;
import com.Fechas.dto.TiendaDto;
import com.Fechas.models.Tienda;
import com.Fechas.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @GetMapping("/list")
    public ResponseEntity<List<Tienda>> list(){
        List<Tienda> lista = tiendaService.list();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody TiendaDto tiendaDto){
        tiendaService.save (new Tienda(tiendaDto.getNombre(), tiendaDto.getFecha(), tiendaDto.getHora()));
        return new ResponseEntity<>(new Mensaje("La tienda ha sido creado"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TiendaDto tiendaDto){
        if(!tiendaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La tienda no existe"),HttpStatus.NOT_FOUND);

        Tienda tienda = tiendaService.getOne(id).get();
        tienda.setNombre(tiendaDto.getNombre());
        tienda.setFecha(tiendaDto.getFecha());
        tienda.setHora(tiendaDto.getHora());

        tiendaService.save(tienda);
        return new ResponseEntity<>(new Mensaje("La tienda ha sido actualizada"),HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!tiendaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La tienda no existe"),HttpStatus.NOT_FOUND);
        tiendaService.delete(id);
        return new ResponseEntity<>(new Mensaje("La tienda ha sido eliminada"), HttpStatus.OK);
    }
}
