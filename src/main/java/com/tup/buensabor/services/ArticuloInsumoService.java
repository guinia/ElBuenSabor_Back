package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long>{
    List<ArticuloInsumo> search(String filtro) throws Exception;
    Page<ArticuloInsumo> search(String filtro, Pageable pageable) throws Exception;
    Page<ArticuloInsumo> getStockBajo(Pageable pageable) throws Exception;
}
