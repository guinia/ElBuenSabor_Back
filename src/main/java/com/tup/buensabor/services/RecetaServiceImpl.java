package com.tup.buensabor.services;

import com.tup.buensabor.entities.Receta;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecetaServiceImpl extends BaseServiceImpl<Receta, Long> implements RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;


    public RecetaServiceImpl(BaseRepository<Receta, Long> baseRepository, RecetaRepository recetaRepository) {
        super(baseRepository);
        this.recetaRepository = recetaRepository;
    }


}