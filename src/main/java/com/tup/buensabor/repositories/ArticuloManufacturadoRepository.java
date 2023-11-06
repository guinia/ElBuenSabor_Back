package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {

    @Query(
            value = "SELECT * FROM articulo_manufacturado WHERE articulo_manufacturado.denominacion LIKE %:filtro% OR articulo_manufacturado.descripcion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloManufacturado> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM articulo_manufacturado WHERE articulo_manufacturado.denominacion LIKE %:filtro% OR articulo_manufacturado.descripcion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM articulo_manufacturado",
            nativeQuery = true
    )
    Page<ArticuloManufacturado> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
