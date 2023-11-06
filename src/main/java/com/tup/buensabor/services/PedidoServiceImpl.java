package com.tup.buensabor.services;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> search(String filtro) throws Exception {
        try{
            List<Pedido> pedido = pedidoRepository.searchNativo(filtro);
            return pedido;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Pedido> pedido = pedidoRepository.searchNativo(filtro, pageable);
            return pedido;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
