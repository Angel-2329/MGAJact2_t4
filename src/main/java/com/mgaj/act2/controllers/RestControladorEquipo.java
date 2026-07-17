package com.mgaj.act2.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgaj.act2.models.dto.Equipo;





@RestController
@RequestMapping ("/api/equipos")
public class RestControladorEquipo
{
    @PostMapping("/crear")
    public Equipo crearEquipoRest (@RequestBody Equipo equipo)
    {
        equipo.setNombre(equipo.getNombre() + " se registro con la API REST");
        return equipo;
    }
}
