package mx.edu.buap.servicetracker.service;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import mx.edu.buap.servicetracker.model.Actividad;
import mx.edu.buap.servicetracker.model.Servicio;

import java.io.FileOutputStream;
import java.io.File;

public class PdfService {

    public static boolean generarReporte(
            Servicio servicio,
            String diagnostico,
            String comentariosFinales
    ) {

        try {
            String ruta = "data/reportes/" + servicio.getFolio() + ".pdf";
            File archivo = new File(ruta);

            if (archivo.exists()) {
                if (!archivo.delete()) {
                    return false;
                }
            }

            Document documento = new Document();

            PdfWriter.getInstance(documento, new FileOutputStream(ruta));

            // Comienza la escritura del documento PDF
            documento.open();

            var dispositivo = servicio.getDispositivo();

            documento.add(new Paragraph("SERVICETRACKER"));
            documento.add(new Paragraph("Reporte Técnico"));
            documento.add(new Paragraph(" "));

            //======================================

            documento.add(new Paragraph("DATOS DEL PROPIETARIO"));
            documento.add(new Paragraph("Nombre: " + dispositivo.getPropietario()));
            documento.add(new Paragraph("Área: " + dispositivo.getArea()));
            documento.add(new Paragraph(" "));

            //======================================

            documento.add(new Paragraph("DATOS DEL EQUIPO"));
            documento.add(new Paragraph("Marca: " + dispositivo.getMarca()));
            documento.add(new Paragraph("Modelo: " + dispositivo.getModelo()));
            documento.add(new Paragraph("Serie: " + dispositivo.getNumeroSerie()));
            documento.add(new Paragraph("Tipo: " + dispositivo.getTipo()));
            documento.add(new Paragraph(" "));

            //======================================

            documento.add(new Paragraph("INFORMACIÓN DEL SERVICIO"));
            documento.add(new Paragraph("Folio: " + servicio.getFolio()));
            documento.add(new Paragraph("Prioridad: " + dispositivo.getPrioridad()));
            documento.add(new Paragraph("Estado: " + servicio.getEstado()));
            documento.add(new Paragraph("Técnico: " + servicio.getTecnico()));
            documento.add(new Paragraph("Fecha ingreso: " + dispositivo.getFechaIngreso()));

            //======================================

            documento.add(new Paragraph("Fecha asignación: " + (servicio.getFechaAsignacion() != null ? servicio.getFechaAsignacion() : "No asignada")));
            documento.add(new Paragraph("Fecha estimada de entrega: " + (servicio.getFechaEstimadaEntrega() != null ? servicio.getFechaEstimadaEntrega() : "No definida")));
            documento.add(new Paragraph(" "));

            //======================================

            documento.add(new Paragraph("DIAGNÓSTICO"));
            documento.add(new Paragraph(diagnostico));
            documento.add(new Paragraph(" "));

            //======================================

            documento.add(new Paragraph("ACTIVIDADES REALIZADAS"));
            documento.add(new Paragraph(" "));

            for (Actividad actividad : servicio.getActividades()) {
                documento.add(
                        new Paragraph(
                                actividad.getFecha()
                                        + " | "
                                        + actividad.getTecnico()
                                        + " | "
                                        + actividad.getDescripcion()
                        )
                );
            }

            //======================================

            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("COMENTARIOS FINALES"));
            documento.add(new Paragraph(comentariosFinales));

            //======================================

            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("Documento generado por ServiceTracker"));

            documento.close();
            System.out.println("PDF generado correctamente");

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}