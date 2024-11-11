package com.academia.academia.model.service;

import java.util.List;

import com.academia.academia.model.entity.Estudiante;

public interface AcademiaServiceIface {
    
    public List<Estudiante> todosEstudiantes();
    public void guardarEstudiante(Estudiante estudiante);
    public Estudiante buscarEstudiante(Long id);
    public void eliminarEstudiante(Long id);

}
