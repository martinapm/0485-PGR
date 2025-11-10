package es.foc;

import jakarta.persistence.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Usando persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

        //Se puede especificar directamente el directorio que guardara la base de datos.

        EntityManager em = emf.createEntityManager();

        // INSERTAR datos
        em.getTransaction().begin();

        // Crear personas
        Persona p1 = new Persona("Carlos Pérez", 35);
        Persona p2 = new Persona("Ana López", 28);
        em.persist(p1);
        em.persist(p2);

        // Agregar domicilios
        Domicilio dom1 = new Domicilio("Calle A, 123", "Madrid", p1);
        Domicilio dom2 = new Domicilio("Avenida B, 456", "Barcelona", p1);
        em.persist(dom1);
        em.persist(dom2);


        // Agregar teléfonos
        Telefono tel1 = new Telefono("600123456", "Móvil", p1);
        Telefono tel2 = new Telefono("911223344", "Casa", p1);
        em.persist(tel1);
        em.persist(tel2);


        // Crear proyectos
        Proyecto proy1 = new Proyecto("Desarrollo Web");
        Proyecto proy2 = new Proyecto("IA con Java");
        em.persist(proy1);
        em.persist(proy2);


        // Asignar proyectos a personas (Many-to-Many)
        p1.setProyectos(Arrays.asList(proy1, proy2));
        p2.setProyectos(Arrays.asList(proy1));

        proy1.setPersonas(Arrays.asList(p1, p2));
        proy2.setPersonas(Arrays.asList(p1));

        em.getTransaction().commit();

        // CONSULTAR datos
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p", Persona.class);
        List<Persona> personas = query.getResultList();
        for (Persona p : personas) {
            System.out.println("Nombre: " + p.getNombre());
            for (Domicilio d : p.getDomicilios()) {
                System.out.println("  Dirección: " + d.getCiudad()+ " " + d.getCalle());
            }
        }



        // Consultar personas con proyectos
        query = em.createQuery("SELECT p FROM Persona p", Persona.class);
        for (Persona p : query.getResultList()) {
            System.out.println("👤 " + p.getNombre() + " (" + p.getEdad() + " años)");
            p.getProyectos().forEach(pr -> System.out.println("📂 Proyecto: " + pr.getNombre()));
        }


        // ACTUALIZAR datos
        em.getTransaction().begin();
        p1.setNombre("Juan Actualizado");
        em.merge(p1);
        em.getTransaction().commit();

        // BORRAR datos
        try {
            em.getTransaction().begin();
            em.remove(p1);
            em.getTransaction().commit();
        } catch (jakarta.persistence.PersistenceException e) {
            // En caso de error, hace rollback de la transacción
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            // Log para la excepción
            //e.printStackTrace();
            System.out.println("Ocurrió un error al intentar eliminar la persona: " + e.getMessage());
        }

        //EJEMPLO QUERY

        Query query1 = em.createQuery("SELECT p FROM Persona p WHERE p.nombre = :nombre");
        query1.setParameter("nombre", "Juan");
        List<Persona> personas1 = query1.getResultList();

        for (Object obj : personas1) {
            Persona p = (Persona) obj;  // Necesita casting
            System.out.println(p.getNombre());
        }

        //EJEMPLO TYPEDQUERY
        TypedQuery<Persona> query2 = em.createQuery("SELECT p FROM Persona p WHERE p.nombre = :nombre", Persona.class);
        query2.setParameter("nombre", "Juan");
        List<Persona> personas2 = query.getResultList();

        for (Persona p : personas2) {
            System.out.println(p.getNombre()); // No necesita casting
        }


        query2 = em.createNamedQuery("Persona.buscarPorNombre", Persona.class);
        query2.setParameter("nombre", "Juan");
        personas2 = query.getResultList();

        for (Persona p : personas2) {
            System.out.println(p.getNombre());
        }


        em.close();
        emf.close();
    }
}


