package com.tup.buensabor.services;

import com.tup.buensabor.dtos.DTORankingArticulosManufacturados;
import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long>{
    List<ArticuloManufacturado> search(String filtro) throws Exception;
    Page<ArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception;

    List<DTORankingArticulosManufacturados> filtradoPorProductoVendido() throws Exception;

    List<DTORankingArticulosManufacturados> filtradoPorProductoVendidoPorFecha(Date filtro1, Date filtro2) throws Exception;

}
