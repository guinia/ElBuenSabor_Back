package com.tup.buensabor.services;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.tup.buensabor.dtos.DTOCambiarEstado;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.enums.EstadoPedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{

    Pedido cambiarEstado (DTOCambiarEstado cambiarEstadoDTO) throws Exception;
    List<Pedido> search(String filtro) throws Exception;
    Page<Pedido> search(String filtro, Pageable pageable) throws Exception;

}

