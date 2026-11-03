package com.ejemplo.personas.controller;

import com.ejemplo.personas.model.Persona;
import com.ejemplo.personas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("personas", personaRepository.findAll());
        model.addAttribute("persona", new Persona());
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Persona persona) {
        personaRepository.save(persona);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        personaRepository.deleteById(id);
        return "redirect:/";
    }
}
