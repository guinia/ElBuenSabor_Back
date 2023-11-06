package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloManufacturado;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ArticuloManufacturadoRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Test
    void testSearchString(){
        ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();
        articuloManufacturado.setDenominacion("Hamburguesa");

        List<ArticuloManufacturado> listaEnviada = new ArrayList();
        listaEnviada.add(articuloManufacturado);

        entityManager.persist(articuloManufacturado);
        entityManager.flush();

        assertEquals(listaEnviada, articuloManufacturadoRepository.searchNativo("Hamburguesa"));



    }


}
