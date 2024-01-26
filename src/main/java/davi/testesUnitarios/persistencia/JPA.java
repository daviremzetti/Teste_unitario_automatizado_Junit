
package davi.testesUnitarios.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author davi_
 */
public class JPA {
    
    private static String unidadePersistencia = "Funcionarios-PU";
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static EntityManager getEntityManager(){
        if(em == null || !em.isOpen()){
            emf = Persistence.createEntityManagerFactory(unidadePersistencia);
            em = emf.createEntityManager();
        }
        return em;
    }
    
    public static void closeEntity(){
        if(em.isOpen()){
            em.close();
            emf.close();
        }
    }
}
