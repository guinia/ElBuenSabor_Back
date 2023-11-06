package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    @Query(
            value = "SELECT * FROM pedido WHERE pedido.estado LIKE %:filtro%",
            nativeQuery = true
    )
    List<Pedido> searchNativo(@Param("filtro") String filtro);

   /* @Query(
            value = "SELECT * FROM pedido WHERE pedido.id LIKE %:filtro%",
            nativeQuery = true
    )
    List<Pedido> searchNativo(@Param("filtro") Long filtro);
*/
    @Query(
            value = "SELECT * FROM pedido WHERE pedido.estado LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM pedido",
            nativeQuery = true
    )
    Page<Pedido> searchNativo(@Param("filtro") String filtro, Pageable pageable);

    /*@Query(
            value = "SELECT * FROM pedido WHERE pedido.id LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM pedido",
            nativeQuery = true
    )
    Page<Pedido> searchNativo(@Param("filtro") Long filtro, Pageable pageable);
*/

}
