package com.example.Spring_Ejercicio.Controller;
import com.example.Spring_Ejercicio.DAO.AlumnosDAO;
import com.example.Spring_Ejercicio.DAO.UsuariosDAO;
import com.example.Spring_Ejercicio.Modelo.Alumno;
import com.example.Spring_Ejercicio.Modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    UsuariosDAO userDAO;
    @Autowired
    AlumnosDAO alumnoDAO;

    //Ruta relativa
    @GetMapping("/listar")
    public List<Alumno> listar() {
        return alumnoDAO.listarAlumnos();
    }
    @GetMapping("/listar2")
    public List<Usuario> listar2() {
        return userDAO.listarUsuarios();
    }
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable int id) {
        alumnoDAO.delete(id);
    }
    @DeleteMapping("/eliminar2/{id}")
    public void delete2(@PathVariable int id) {
        userDAO.delete(id);
    }

    //rutas no tienen pq llamarse como el método
    @PostMapping("/add/")
    public void add(@RequestBody Alumno alumno) {
        alumnoDAO.add(alumno);
    }
    @PostMapping("/add2/")
    public void add(@RequestBody Usuario usuario) {
        userDAO.add(usuario);
    }

    @PutMapping("/edit/{id}/{nombre}/{nota}")
    public void edit(@PathVariable int id, @PathVariable String nombre, @PathVariable String nota) {
        alumnoDAO.edit(id, nombre, nota);
    }

    @PutMapping("/edit2/{id}/{nombre}/{contrasenia}")
    public void edit2(@PathVariable int id, @PathVariable String nombre, @PathVariable String contrasenia) {
        alumnoDAO.edit(id, nombre, contrasenia);
    }
}

