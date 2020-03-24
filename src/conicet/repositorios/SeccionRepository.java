package conicet.repositorios;

import conicet.entidades.Gen;
import conicet.entidades.Seccion;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SeccionRepository {

    public static void guardar(Gen gen, String seccionString, Double valor) {

        EntityManager em = Persistence.createEntityManagerFactory("conicetPU").createEntityManager();
        em.getTransaction().begin();

        Seccion seccion = new Seccion();
//        seccion.setId(UUID.randomUUID().toString());
        seccion.setGen(gen);
        seccion.setSeccion(seccionString);
        seccion.setValor(valor);

        em.persist(seccion);
        em.getTransaction().commit();
        em.close();
    }

}
