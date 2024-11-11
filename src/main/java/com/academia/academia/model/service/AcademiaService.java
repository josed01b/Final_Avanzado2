package com.academia.academia.model.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.academia.academia.model.dao.EstudianteDAOIface;
import com.academia.academia.model.entity.Estudiante;

public class AcademiaService implements AcademiaServiceIface {

    
    private final EstudianteDAOIface estudianteDAO;

    public AcademiaService(EstudianteDAOIface estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> todosEstudiantes() {
        return estudianteDAO.findAll();
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        estudianteDAO.save(estudiante);
    }

    @Override
    public Estudiante buscarEstudiante(Long id) {
        return estudianteDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarEstudiante(Long id) {
       estudianteDAO.deleteById(id);
    }
    
}
