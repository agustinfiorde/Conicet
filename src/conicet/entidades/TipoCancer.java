
package conicet.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoCancer {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    private String nombreTipoCancer;

    public TipoCancer() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreTipoCancer() {
        return nombreTipoCancer;
    }

    public void setNombreTipoCancer(String nombreTipoCancer) {
        this.nombreTipoCancer = nombreTipoCancer;
    }

}
