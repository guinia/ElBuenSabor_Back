package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloInsumo;
import com.tup.buensabor.entities.RubroArticuloManufacturado;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroArticuloInsumoRepository;
import com.tup.buensabor.repositories.RubroArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroArticuloManufacturadoServiceImpl extends BaseServiceImpl<RubroArticuloManufacturado, Long> implements RubroArticuloManufacturadoService {
    @Autowired
    private RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository;

    public RubroArticuloManufacturadoServiceImpl(BaseRepository<RubroArticuloManufacturado, Long> baseRepository, RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository) {
        super(baseRepository);
        this.rubroArticuloManufacturadoRepository = rubroArticuloManufacturadoRepository;
    }
}
