package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {

    @Query(
            value = "SELECT * FROM articulo_insumo WHERE articulo_insumo.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloInsumo> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM articulo_insumo WHERE articulo_insumo.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM articulo_insumo",
            nativeQuery = true
    )
    Page<ArticuloInsumo> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
