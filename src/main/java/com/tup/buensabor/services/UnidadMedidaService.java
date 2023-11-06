package com.tup.buensabor.services;

import com.tup.buensabor.entities.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UnidadMedidaService extends BaseService<UnidadMedida, Long>{

    List<UnidadMedida> search(String filtro) throws Exception;
    Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception;


}
