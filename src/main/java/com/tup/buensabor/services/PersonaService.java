package com.tup.buensabor.services;

import com.tup.buensabor.dtos.DTOCambiarDatos;
import com.tup.buensabor.dtos.DTORankingPersonas;
import com.tup.buensabor.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{
    List<Persona> search(String filtro) throws Exception;
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;

    Persona cambiarDatos(DTOCambiarDatos dtoCambiarDatos) throws Exception;

    List<DTORankingPersonas> rankingPersonas(Date desde, Date hasta) throws Exception;

}
