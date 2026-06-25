package mx.edu.buap.servicetracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import mx.edu.buap.servicetracker.model.Servicio;

public class JsonService {

    private static final String DATA_DIR = "data";

    private static final String SERVICIOS_FILE = DATA_DIR + "/servicios.json";

    private static final String REPORTES_DIR = DATA_DIR + "/reportes";

    //private static final String USUARIOS_FILE = DATA_DIR + "/usuarios.json"; //Implementación futura


    private static final ObjectMapper mapper =
            new ObjectMapper();

    static {

        mapper.registerModule(
                new JavaTimeModule()
        );

        mapper.enable(
                SerializationFeature.INDENT_OUTPUT
        );

        File carpeta = new File(DATA_DIR);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        File reportesDir = new File(REPORTES_DIR);
        if (!reportesDir.exists()) {
            reportesDir.mkdirs();
        }
    }

    public static void guardarServicios() {

        try {

            mapper.writeValue(
                    new File(SERVICIOS_FILE),
                    DatosSistema.servicios
            );

            System.out.println(
                    "Servicios guardados correctamente"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void cargarServicios() {

        try {

            File archivo = new File(SERVICIOS_FILE);

            if (!archivo.exists()) {
                return;
            }

            List<Servicio> servicios =
                    mapper.readValue(
                            archivo,

                            new TypeReference<
                                    List<Servicio>>() {}
                    );

            DatosSistema.servicios.clear();

            DatosSistema.servicios.addAll(
                    servicios
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
