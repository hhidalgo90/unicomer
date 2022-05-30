package com.unicomer.tienda.service;

import com.unicomer.tienda.model.ProspectoUnicomer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TiendaService {

    ProspectoUnicomer getById(Long id);

    ResponseEntity registrar(ProspectoUnicomer prospectoUnicomer);

    boolean delete(Long id);

    List<ProspectoUnicomer> getAll();
}
