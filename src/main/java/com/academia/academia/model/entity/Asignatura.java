package com.academia.academia.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")
public class Asignatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80)
    private String nombre;

    @Column(length = 11)
    private int numero_creditos;

    @Column(length = 50)
    private String departamento;

    private long plan_id;

    public Asignatura() {
    }

    public Asignatura(Long id, String nombre, int numero_creditos, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.numero_creditos = numero_creditos;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero_creditos() {
        return numero_creditos;
    }

    public void setNumero_creditos(int numero_creditos) {
        this.numero_creditos = numero_creditos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public long getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(long plan_id) {
        this.plan_id = plan_id;
    }

    
}
