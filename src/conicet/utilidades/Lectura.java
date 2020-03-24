package conicet.utilidades;

import conicet.entidades.Gen;
import conicet.entidades.TipoCancer;
import conicet.repositorios.GenRepository;
import conicet.repositorios.SeccionRepository;
import conicet.repositorios.TipoCancerRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Lectura {

    private File archivo;
    private String tipoCancer;
    private List<Gen> genes = new ArrayList<>();

    public Lectura(String tipoCancer, String url) {

        this.tipoCancer = tipoCancer;
        this.archivo = new File(url);
        if (TipoCancerRepository.buscarTodos().isEmpty()) {
            TipoCancerRepository.guardar(tipoCancer);
        }

    }

    public void cargarGenes(String linea) {

//        TipoCancerRepository tipoCancerRepository = new TipoCancerRepository();
        TipoCancer tipoCancer = TipoCancerRepository.buscarTipoCancer(this.tipoCancer);

        String[] columnas = linea.split("\t");
        for (int n = 1; n < columnas.length; n++) {
            GenRepository.guardar(tipoCancer, columnas[n], n - 1);
            Gen gen = new Gen();
            gen.setTipoCancer(tipoCancer);
            gen.setId(columnas[n]);
            gen.setOrden(n - 1);
            genes.add(gen);
        }

    }

    public void leer() {
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            Boolean permiso = true;
            String linea = lector.readLine();
            cargarGenes(linea);
            linea = lector.readLine();
            List<Multi> hilos = new ArrayList<>();

            while (linea != null) {

                if (permiso) {
                    System.out.println("Entro");
                    for (int i = 0; i < 15; i++) {
                        Multi claseHilo = new Multi(genes, linea);
                        claseHilo.start();
                        linea = lector.readLine();
                        hilos.add(claseHilo);
                    }
                    permiso = false;
                }

                for (Multi hilo : hilos) {
                    if (hilo.getState()==(Thread.State.TERMINATED)) {
                        permiso = true;
                    } else {
                        permiso = false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

}
