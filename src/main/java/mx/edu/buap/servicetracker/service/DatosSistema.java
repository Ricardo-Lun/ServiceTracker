package mx.edu.buap.servicetracker.service;

import mx.edu.buap.servicetracker.model.Servicio;

import java.util.ArrayList;
import java.util.List;

public class DatosSistema {

    public static final List<Servicio> servicios = new ArrayList<>();

    private DatosSistema() {
    }

    public static String generarNuevoFolio() {

        int mayor = 0;

        for (Servicio servicio : servicios) {

            String folio = servicio.getFolio();

            try {

                int numero = Integer.parseInt(
                        folio.replace("ST-", "")
                );

                if (numero > mayor) {
                    mayor = numero;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return String.format(
                "ST-%04d",
                mayor + 1
        );
    }
}