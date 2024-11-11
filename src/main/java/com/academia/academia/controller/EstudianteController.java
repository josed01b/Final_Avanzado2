package com.academia.academia.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.academia.academia.model.entity.Estudiante;
import com.academia.academia.model.service.AcademiaServiceIface;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/academia")
@SessionAttributes("estudiante")
public class EstudianteController {
    
    private final AcademiaServiceIface academiaService;

    public EstudianteController( AcademiaServiceIface academiaService) {
        this.academiaService = academiaService;
    }

    @GetMapping("/listadoestudiantes")
    public String estudiantesListar(Model model) {

        List<Estudiante> estudiantes = academiaService.todosEstudiantes();

        model.addAttribute("estudiantes", estudiantes);
        return "estudiante/listado_estudiantes";
    }

    @GetMapping("/estudianteconsultar/{id}")
    public String estudianteConsulta(@PathVariable Long id, RedirectAttributes flash, Model model) {
        Estudiante estudiante = academiaService.buscarEstudiante(id);
        
        if (estudiante == null) {
            flash.addFlashAttribute("warning", "El estudiante no existe");
            return "redirect:/academia/listadoestudiantes";
        }

        model.addAttribute("estudiante", estudiante);
        return "estudiante/consultar_estudiante";
    }

    @GetMapping("/estudiantenuevo")
    public String estudianteNuevo(Model model) {
        model.addAttribute("accion", "registrar");
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante/formulario_estudiante";
    }

    @GetMapping("/eliminarestudiante/{id}")
    public String estudianteEliminar(@PathVariable Long id, RedirectAttributes flash) {
        if (id > 0) {
            Estudiante estudiante = academiaService.buscarEstudiante(id);
            if (estudiante != null) {
                academiaService.eliminarEstudiante(id);
                flash.addFlashAttribute("success","Se elimino el estudiante");
            }
        } else {
            flash.addFlashAttribute("error", "No se elimino el estudiante");
        }
        return "redirect:/academia/listadoestudiantes";
    }

    @GetMapping("/modificarestudiante/{id}")
    public String estudianteModificar (@PathVariable Long id, RedirectAttributes flash, Model model) {
        Estudiante estudiante = null;

        if (id > 0) {
            estudiante = academiaService.buscarEstudiante(id);
            if (estudiante == null) {
                flash.addFlashAttribute("warning", "El estudiante no existe");
                return "redirect:/academia/listadoestudiantes";
            }
        }

        model.addAttribute("accion", "modificar");
        model.addAttribute("Titulo", "Modificar");
        model.addAttribute("estudiante", estudiante);
        return "estudiante/formulario_estudiante";
    }

    @PostMapping("/estudianteguardar")
    public String guardarEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result,
    Model model, SessionStatus status, RedirectAttributes flash) {
        
        String accion = (estudiante.getId() == null) ? "registrar" : "modificar";

        if (result.hasErrors()) {
            model.addAttribute("accion", accion );
            model.addAttribute("info", "Complete los campos del formulario");
            return "estudiante/formulario_estudiante";
        }

        academiaService.guardarEstudiante(estudiante);
        status.setComplete();
        flash.addFlashAttribute("success", "El estudiante " + (estudiante.getId() == null ? "registrado" : "modificado") + "con exito");

        return "redirect:/academia/listadoestudiantes";
    }
}
