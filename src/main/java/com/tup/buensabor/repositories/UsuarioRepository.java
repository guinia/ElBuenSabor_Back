package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE :usuario AND usuario.password LIKE :password",
            nativeQuery = true
    )
    List<Usuario> searchNativo(@Param("filtro") String username, String password);

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE usuario SET password = :contraseniaNueva WHERE id = :id",
            nativeQuery = true
    )
    public int cambiarContrasena(@Param("id") Long id,
                                 @Param("contrasenaNueva") String contrasenaNueva);

  /*  @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE %:filtro% AND usuario.password LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM usuario",
            nativeQuery = true
    )
    Page<Usuario> searchNativo(@Param("filtro") String filtro, Pageable pageable);

    comentado por que nunca traeriamos listas de usuarios, sino de personas y menos paginables

   */
}
