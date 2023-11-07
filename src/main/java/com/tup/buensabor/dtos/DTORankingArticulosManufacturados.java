package com.tup.buensabor.dtos;

import com.tup.buensabor.entities.ArticuloManufacturado;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class DTORankingArticulosManufacturados {

    private ArticuloManufacturado articuloManufacturado;
    private Long cantidad;
    private BigDecimal total;

    @SqlResultSetMapping(
            name = "filtroPorProductos",
            entities = {
                    @EntityResult(
                            entityClass = ArticuloManufacturadoDTO.class,
                            fields = {
                                    @FieldResult(name = "denominacion", column = "denominacion"),
                                    @FieldResult(name = "cantidad_productos_vendidos", column = "cantidad_productos_vendidos")
                            }
                    )
            }
    )
    public interface ArticuloManufacturadoDTO {
        String getdenominacion();

        Integer getcantidad_productos_vendidos();

    }


}
