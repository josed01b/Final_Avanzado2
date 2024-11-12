package com.academia.academia.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas_planes")
public class AsignaturaPlan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PlanEstudio planEstudio;

    @ManyToOne
    private List<Asignatura> asignaturas;

    @Column(length = 11)
    private int semestre_nivel;

    @Column(length = 20)
    private Long prerequisito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanEstudio getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(PlanEstudio planEstudio) {
        this.planEstudio = planEstudio;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public int getSemestre_nivel() {
        return semestre_nivel;
    }

    public void setSemestre_nivel(int semestre_nivel) {
        this.semestre_nivel = semestre_nivel;
    }

    public Long getPrerequisito() {
        return prerequisito;
    }

    public void setPrerequisito(Long prerequisito) {
        this.prerequisito = prerequisito;
    }

    
}
