/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Trabajadores.Controller;

/**
 *
 * @author Usuario
 */
import com.example.Trabajadores.Model.Trabajadores;
import com.example.Trabajadores.Repository.TrabajadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadoresController {

    @Autowired
    private TrabajadoresRepository repository;

    @GetMapping
    public String listarTrabajadores(Model model) {
        model.addAttribute("trabajadores", repository.findAll());
        return "listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("trabajador", new Trabajadores());
        return "registrar";
    }

    @PostMapping
    public String registrarTrabajador(@ModelAttribute Trabajadores trabajador) {
        repository.save(trabajador);
        return "redirect:/trabajadores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Trabajadores trabajador = repository.findById(id).orElse(null);
        model.addAttribute("trabajador", trabajador);
        return "editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizarTrabajador(@PathVariable Long id, @ModelAttribute Trabajadores trabajador) {
        trabajador.setId(id);
        repository.save(trabajador);
        return "redirect:/trabajadores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTrabajador(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/trabajadores";
    }
}