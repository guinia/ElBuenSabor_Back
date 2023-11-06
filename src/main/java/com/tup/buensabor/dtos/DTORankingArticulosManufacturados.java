package com.tup.buensabor.dtos;

import com.tup.buensabor.entities.ArticuloManufacturado;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class DTORankingArticulosManufacturados {

    private ArticuloManufacturado articuloManufacturado;
    private Long cantidad;
    private BigDecimal total;


}
