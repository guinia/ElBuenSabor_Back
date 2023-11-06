package com.tup.buensabor.services;

import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{
    List<Pedido> search(String filtro) throws Exception;
    Page<Pedido> search(String filtro, Pageable pageable) throws Exception;
}

