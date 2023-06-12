package com.example.Spring_Ejercicio.DAO;

import com.example.Spring_Ejercicio.Modelo.Usuario;

import java.util.List;

public interface usuarioDAO {
    List<Usuario> listarUsuarios();
    void delete(int id);
    void add(Usuario usuario);
    void edit(int id, String nombre, String contrasenia);
}
