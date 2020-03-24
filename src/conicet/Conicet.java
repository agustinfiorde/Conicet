package conicet;

import conicet.utilidades.Lectura;
import conicet.utilidades.Multi;

public class Conicet {

    public static void main(String[] args) {
        Lectura lectura = new Lectura("Cancer de Mamas", "C:\\Users\\AsteriX\\Desktop\\Conicet\\zip\\Cancer de Mamas\\TCGA-BRCA.methylation450.tsv");
        lectura.leer();
//        "C:\\Users\\AsteriX\\Desktop\\Conicet\\prueba.tsv"
//        "C:\\Users\\AsteriX\\Desktop\\Conicet\\zip\\Cancer de Mamas\\TCGA-BRCA.methylation450.tsv"
    }

}
