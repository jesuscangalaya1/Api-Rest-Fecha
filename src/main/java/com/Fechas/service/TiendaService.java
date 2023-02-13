package com.Fechas.service;


import com.Fechas.models.Tienda;
import com.Fechas.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    public List<Tienda> list(){
        return tiendaRepository.findAll();
    }

    public void save(Tienda tienda){tiendaRepository.save(tienda);}
    public void delete(Long id){tiendaRepository.deleteById(id);}
    public boolean existsById(Long id ){ return tiendaRepository.existsById(id);}
    public Optional<Tienda> getOne(Long id ){return tiendaRepository.findById(id);}

}
