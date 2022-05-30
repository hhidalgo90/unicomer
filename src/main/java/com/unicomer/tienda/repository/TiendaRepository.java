package com.unicomer.tienda.repository;

import com.unicomer.tienda.model.ProspectoUnicomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepository extends CrudRepository<ProspectoUnicomer, Long> {
}
