package com.unicomer.tienda.service.impl;

import com.unicomer.tienda.model.ProspectoUnicomer;
import com.unicomer.tienda.repository.TiendaRepository;
import com.unicomer.tienda.service.TiendaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TiendaServiceImpl implements TiendaService {
    private static final Logger logger = LoggerFactory.getLogger(TiendaServiceImpl.class);

    @Autowired
    TiendaRepository tiendaRepository;

    @Override
    public ProspectoUnicomer getById(Long id){
        Optional<ProspectoUnicomer> prospectoUnicomer = tiendaRepository.findById(id);

        if(prospectoUnicomer.isPresent()){
            return prospectoUnicomer.get();
        }
        else {
            return null;
        }
    }

    @Override
    public ResponseEntity registrar(ProspectoUnicomer prospectoUnicomer){
        logger.info("Se registrará prospecto unicomer: " + prospectoUnicomer.toString());
        try {
            return ResponseEntity.ok(tiendaRepository.save(prospectoUnicomer));
        } catch (RuntimeException e) {
            logger.error("Error al guardar prospecto unicomer: " + e.getMessage());
            return new ResponseEntity("Ha ocurrido un error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public boolean delete(Long id){
        try {
            tiendaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            logger.error("Error al eliminar prospecto unicomer: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<ProspectoUnicomer> getAll(){
        Iterable<ProspectoUnicomer> respuestaServicio = tiendaRepository.findAll();

        List<ProspectoUnicomer> prospectoUnicomers = new ArrayList<>();

        respuestaServicio.forEach(a -> {
            prospectoUnicomers.add(a);
        });

        return prospectoUnicomers;
    }

}
