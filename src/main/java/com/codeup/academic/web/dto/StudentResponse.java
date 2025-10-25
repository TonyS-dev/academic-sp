package com.codeup.academic.web.dto;


public class StudentResponse {
    private Long id;
    private String nombre;

    public StudentResponse(Long id, String nombre) {
        this.id = id; this.nombre = nombre;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
}
