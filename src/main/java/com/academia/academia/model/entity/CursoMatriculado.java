package com.academia.academia.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class CursoMatriculado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private List<Estudiante> estudiantes;

    @ManyToOne
    private List<Curso> cursos;

    @Column(length = 50)
    private String periodo;

    @Column(length = 20)
    private String estado_curso;

    @Column
    private double nota_final;


}
