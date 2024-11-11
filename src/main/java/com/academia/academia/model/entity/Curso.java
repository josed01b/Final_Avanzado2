package com.academia.academia.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long asignatura_id;

    private Long profesor_id;

    @Column(length = 10)
    private String periodo;

    @Column(length = 20)
    private String horario;

    @Column(length = 11)
    private int cupo_maximo;

    @Column(length = 30)
    private String aula;
    
    public Curso() {
    }

    public Curso(Long id, String periodo, String horario, int cupo_maximo, String aula) {
        this.id = id;
        this.periodo = periodo;
        this.horario = horario;
        this.cupo_maximo = cupo_maximo;
        this.aula = aula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAsignatura_id() {
        return asignatura_id;
    }

    public void setAsignatura_id(Long asignatura_id) {
        this.asignatura_id = asignatura_id;
    }

    public Long getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(Long profesor_id) {
        this.profesor_id = profesor_id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCupo_maximo() {
        return cupo_maximo;
    }

    public void setCupo_maximo(int cupo_maximo) {
        this.cupo_maximo = cupo_maximo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    

    

    
}
