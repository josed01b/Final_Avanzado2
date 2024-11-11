package com.academia.academia.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String identificacion;

    @Column(length = 50)
    private String apellidos;

    @Column(length = 50)
    private String nombres;

    @Column(length = 11)
    private int semestre_actual;

    private Long programa_id;

    public Estudiante() {
    }

    public Estudiante(Long id, String identificacion, String apellidos, String nombres, int semestre_actual) {
        this.id = id;
        this.identificacion = identificacion;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.semestre_actual = semestre_actual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getSemestre_actual() {
        return semestre_actual;
    }

    public void setSemestre_actual(int semestre_actual) {
        this.semestre_actual = semestre_actual;
    }

    public Long getPrograma_id() {
        return programa_id;
    }

    public void setPrograma_id(Long programa_id) {
        this.programa_id = programa_id;
    }

    
    
}
