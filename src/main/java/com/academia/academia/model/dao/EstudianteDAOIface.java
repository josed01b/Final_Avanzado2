package com.academia.academia.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.academia.model.entity.Estudiante;

public interface EstudianteDAOIface  extends JpaRepository<Estudiante, Long>{
    
}
