/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conicet.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author AsteriX
 */
@Entity
public class DatosPhenotype {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    @ManyToOne
    private Phenotype phenotipo;

    private String dato;

    public DatosPhenotype() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Phenotype getPhenotipo() {
        return phenotipo;
    }

    public void setPhenotipo(Phenotype phenotipo) {
        this.phenotipo = phenotipo;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

}
