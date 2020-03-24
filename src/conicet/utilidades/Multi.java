package conicet.utilidades;

import conicet.entidades.Gen;
import conicet.repositorios.SeccionRepository;
import java.util.List;

public class Multi extends Thread {

    private List<Gen> genes;
    private String linea;

    public Multi(List<Gen> genes, String linea) {
        this.genes = genes;
        this.linea = linea;
    }

    @Override
    public void run() {
        leer();
    }

    public void leer() {
        try {

            if (linea != null) {
                String[] columnas = linea.split("\t");
                String seccion = columnas[0];
                for (int n = 1; n < columnas.length; n++) {
                    Gen gen = genes.get(n - 1);
                    if (!columnas[n].trim().isEmpty()) {
                        Double valor = Double.valueOf(columnas[n]);
                        SeccionRepository.guardar(gen, seccion, valor);
                    } else {
                        SeccionRepository.guardar(gen, seccion, null);
                    }
                }
            }
            stop();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

}
