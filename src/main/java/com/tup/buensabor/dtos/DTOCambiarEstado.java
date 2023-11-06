package com.tup.buensabor.dtos;

import com.tup.buensabor.enums.EstadoPedido;
import lombok.Data;

@Data
public class DTOCambiarEstado {

    private Long idPedido;
    private EstadoPedido estadoPedido;

}
