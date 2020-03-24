package conicet.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Gen {

    @Id
    private String id;

    @ManyToOne
    private TipoCancer tipoCancer;
    private Integer orden;

    public Gen() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoCancer getTipoCancer() {
        return tipoCancer;
    }

    public void setTipoCancer(TipoCancer TipoCancer) {
        this.tipoCancer = TipoCancer;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

}
