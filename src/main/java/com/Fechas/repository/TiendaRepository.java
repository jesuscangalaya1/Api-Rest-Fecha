package com.Fechas.repository;

import com.Fechas.models.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Long> {
     boolean existsById(Long id);
}
