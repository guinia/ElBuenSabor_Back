package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Receta;
import com.tup.buensabor.services.RecetaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/recetas")
public class RecetaController extends BaseControllerImpl<Receta, RecetaServiceImpl> {


}
