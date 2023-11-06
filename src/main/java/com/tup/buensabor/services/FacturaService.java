package com.tup.buensabor.services;

import com.tup.buensabor.entities.Factura;
import com.tup.buensabor.entities.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;
import java.math.BigDecimal;


public interface FacturaService extends BaseService<Factura, Long> {

    List<Factura> search(String filtro) throws Exception;

    Page<Factura> search(String filtro, Pageable pageable) throws Exception;

    BigDecimal searchTotalVentas(Date desde, Date hasta) throws Exception;
}
