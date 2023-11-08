package com.tup.buensabor.repositories;
import com.tup.buensabor.dtos.DTORankingPersonas;
import com.tup.buensabor.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT sum(f.total_venta) as total, p.nombre as persona, count(e.id) as cantidadPedidos " +
                    "FROM persona as p " +
                    "LEFT JOIN pedido as e ON e.id_cliente LIKE p.id " +
                    "LEFT JOIN factura as f ON f.id LIKE e.id_factura " +
                    "WHERE f.fecha_facturacion BETWEEN :desde AND :hasta " +
                    "GROUP BY p.id, p.nombre " +
                    "ORDER BY cantidadPedidos DESC ",
            nativeQuery = true
    )
    List<DTORankingPersonas> rankingPersonas(@Param("desde") Date desde, @Param("hasta") Date hasta);
}
