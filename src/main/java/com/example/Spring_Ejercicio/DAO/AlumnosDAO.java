package com.example.Spring_Ejercicio.DAO;
import com.example.Spring_Ejercicio.Modelo.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@Transactional
public class AlumnosDAO implements alumnoDAO{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Alumno> listarAlumnos() {
        String query = "FROM Alumno ";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(int id) {
        Alumno alumno = entityManager.find(Alumno.class, id);
        entityManager.remove(alumno);
    }

    @Override
    public void add(Alumno alumno) {
        entityManager.merge(alumno);
    }

    @Override
    public void edit(int id, String nombre, String nota) {
        Alumno alumno = entityManager.find(Alumno.class, id);
        alumno.setId(id);
        alumno.setNombre(nombre);
        alumno.setNota(nota);
        add(alumno);
        entityManager.remove(Alumno.class);
        entityManager.merge(alumno);
    }
}
