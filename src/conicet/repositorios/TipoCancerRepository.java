/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conicet.repositorios;

import conicet.entidades.Gen;
import conicet.entidades.Seccion;
import conicet.entidades.TipoCancer;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TipoCancerRepository {

    public static void guardar(String nombre) {

        TipoCancer tipoCancer = new TipoCancer();

        EntityManager em = Persistence.createEntityManagerFactory("conicetPU").createEntityManager();
        em.getTransaction().begin();

//        tipoCancer.setId(UUID.randomUUID().toString());
        tipoCancer.setNombreTipoCancer(nombre);

        tipoCancer.toString();

        em.persist(tipoCancer);
        em.getTransaction().commit();
        em.close();
    }

    public static TipoCancer buscarTipoCancer(String nombreTipoCancer) {

        EntityManager em = Persistence.createEntityManagerFactory("conicetPU").createEntityManager();

        TipoCancer tipoCancer = (TipoCancer) em.createQuery("SELECT c FROM TipoCancer c WHERE c.nombreTipoCancer = :nombreTipoCancer ").setParameter("nombreTipoCancer", nombreTipoCancer).getSingleResult();

        return tipoCancer;
    }
    

    public static List<TipoCancer> buscarTodos() {
        EntityManager em = Persistence.createEntityManagerFactory("conicetPU").createEntityManager();

        List<TipoCancer> genes = em.createQuery("SELECT c FROM TipoCancer c").getResultList();

        return genes;
    }
}
