package com.example.Spring_Ejercicio.DAO;
import com.example.Spring_Ejercicio.Modelo.Usuario;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public class UsuariosDAO implements usuarioDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> listarUsuarios() {
        String query = "FROM Usuario ";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void add(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void edit(int id, String nombre, String contrasenia) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setContrasenia(contrasenia);
        add(usuario);
        entityManager.remove(Usuario.class);
        entityManager.merge(usuario);
    }
}
