
package davi.testesUnitarios.persistencia;

import davi.testesUnitarios.modelo.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 *
 * @author davi_
 */
public class FuncionarioDAO {
    
    public boolean cadastrarFuncionario(Funcionario funcionario){
        try{
            EntityManager em = JPA.getEntityManager();
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }finally{
            JPA.closeEntity();
        }
    }
    
    public Funcionario buscarFuncionario(Funcionario funcionario){
        System.out.println("buscarFuncionario: " + funcionario.getId());
        Funcionario func = null;
        try{
            EntityManager em = JPA.getEntityManager();
            Query consulta = em.createQuery("SELECT f FROM Funcionario f WHERE f.id = :id");
            consulta.setParameter("id", funcionario.getId());
            func = (Funcionario) consulta.getSingleResult();
        }catch(Exception e){
            System.out.println("Erro na comunicação com o banco de dados!" + e.getMessage());
        }finally{
            JPA.closeEntity();
        }
        return func;
    }
    
    public Funcionario atualizarSalario(Funcionario funcionario){
        try{
            EntityManager em = JPA.getEntityManager();
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();
            return funcionario;
        }catch(Exception e){
            return null;
        }finally{
            JPA.closeEntity();
        }
    }
    
}
