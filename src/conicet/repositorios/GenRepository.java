package conicet.repositorios;

import conicet.entidades.Gen;
import conicet.entidades.TipoCancer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class GenRepository {

    public static void guardar(TipoCancer tipoCancer, String gen_id, Integer pos) {

        EntityManager em = Persistence.createEntityManagerFactory("conicetPU").createEntityManager();
        em.getTransaction().begin();

        Gen gen = new Gen();
        gen.setId(gen_id);
        gen.setTipoCancer(tipoCancer);
        gen.setOrden(pos);

        em.persist(gen);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Gen> buscarTodos() {
        EntityManager em = Persistence.createEntityManagerFactory("conicetPU").createEntityManager();

        List<Gen> genes = em.createQuery("SELECT c FROM Gen c ORDER BY C.orden").getResultList();

        return genes;
    }

    public static Gen buscarPosicion(Integer orden) {

        EntityManager em = Persistence.createEntityManagerFactory("conicetPU").createEntityManager();

        return (Gen) em.createQuery("SELECT c FROM Gen c WHERE c.orden = :orden ").setParameter("orden", orden).getSingleResult();

    }

    public static void eliminarColumna() {

        EntityManager em = Persistence.createEntityManagerFactory("conicetPU").createEntityManager();

        em.createNativeQuery("ALTER TABLE Gen c DROP COLUMN c.ORDEN").executeUpdate();;

    }

}
