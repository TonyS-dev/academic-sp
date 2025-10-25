package com.codeup.academic.web.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequest {
    @NotBlank(message = "name es obligatorio")
    @Size(min = 3, max = 50, message = "name debe tener entre 3 y 50 caracteres")
    private String name;
    private int age;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
