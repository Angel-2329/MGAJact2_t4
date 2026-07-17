package com.mgaj.act2.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mgaj.act2.models.dto.Equipo;

@Controller
@RequestMapping("/mvc/equipos")
public class ControladorEquipo 
{
    @Value("${proyecto.estudiante.nombre}")
    private String nombreEstudiante;

    @GetMapping("/lista")
    public String listarEquipos(Model modelo) 
    {
        List<Equipo> equipos = Arrays.asList(
                new Equipo("Real Madrid", "España", 14),
                new Equipo("Barcelona", "España", 6),
                new Equipo("Manchester City", "Inglaterra", 7),
                new Equipo("Liverpool", "Inglaterra", 17),
                new Equipo("Juventus", "Italia", 12),
                new Equipo("Bayer Munich", "Alemania", 20)
        );
        modelo.addAttribute("equipos", equipos);
        modelo.addAttribute("autor", nombreEstudiante); 
        return "lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model modelo) 
    {
        modelo.addAttribute("autor", nombreEstudiante);
        modelo.addAttribute("equipo", new Equipo());
        return "index";
    }

    @PostMapping("/guardar")
    public String guardarEquipo(@ModelAttribute Equipo equipo, Model modelo) 
    {
        modelo.addAttribute("autor", nombreEstudiante);
        modelo.addAttribute("mensajeForm", "Equipo guardado: " + equipo.getNombre() + " de " + equipo.getPais());
        modelo.addAttribute("equipo", new Equipo());
        return "index";
    }

    @GetMapping("/buscar")
    public String buscarPorPais(@RequestParam(name="pais", required=false, defaultValue="Todos") String pais, Model modelo) 
    {
        modelo.addAttribute("autor", nombreEstudiante);
        modelo.addAttribute("mensajeParam", "Buscando equipos del país: " + pais);
        modelo.addAttribute("equipo", new Equipo());
        return "index";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") int id, Model modelo) 
    {
        modelo.addAttribute("autor", nombreEstudiante);
        modelo.addAttribute("mensajePath", "Viendo detalles del equipo con ID: " + id);
        modelo.addAttribute("equipo", new Equipo());
        return "index";
    }
}