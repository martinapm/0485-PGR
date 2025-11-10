package es.foc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductoController {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ProductoController() {
        emf = Persistence.createEntityManagerFactory("Tarea8PU");
        em = emf.createEntityManager();
    }

    // Insertar producto
    public void insertarProducto(Producto p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    // Buscar producto por código
    public Producto buscarProducto(int codigoProducto) {
        return em.find(Producto.class, codigoProducto);
    }

    // Modificar producto
    public void modificarProducto(Producto producto) {
        em.getTransaction().begin();
        em.merge(producto);
        em.getTransaction().commit();
    }

    // Borrar producto
    public void borrarProducto(int codigoProducto) {
        Producto p = buscarProducto(codigoProducto);
        if (p != null) {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }
    }

    // Listar todos los productos
    public List<Producto> listarProductos() {
        TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p", Producto.class);
        return query.getResultList();
    }

    // Cerrar la conexión
    public void cerrar() {
        if (em != null) {
            em.close();
            if (emf != null && emf.isOpen())
                emf.close();
        }
    }
}
