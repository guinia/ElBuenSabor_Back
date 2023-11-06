package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE %:filtro%",
            nativeQuery = true
    )
    List<Usuario> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM usuario",
            nativeQuery = true
    )
    Page<Usuario> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
