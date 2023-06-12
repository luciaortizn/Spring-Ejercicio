package com.example.Spring_Ejercicio.DAO;

import com.example.Spring_Ejercicio.Modelo.Alumno;

import java.util.List;

public interface alumnoDAO {
    List<Alumno> listarAlumnos();
    void delete(int id);
    void add(Alumno alumno);
    void edit(int id, String nombre, String nota);

}
