# ServiceTracker
Plataforma de gestión de tickets e incidencias de TI que permite registrar, asignar, monitorear y dar seguimiento a solicitudes de soporte técnico de manera eficiente.

---

# Levantamiento de Requerimientos

## Primera reunión con el cliente

Se solicitó la creación de una aplicación para el área de soporte técnico de una empresa. La aplicación debe:

* Asignar la prioridad de cada dispositivo.
* Registrar el estado de la reparación o mantenimiento.
* Incluir una sección para almacenar los comentarios realizados por los dueños de los equipos.
* Generar un reporte final sobre las actividades realizadas durante la reparación.

---

## Segunda reunión con el cliente

Durante la segunda reunión se definieron con mayor detalle los requerimientos del sistema. Se estableció que la aplicación deberá:

* Almacenar la prioridad asignada por el encargado de soporte técnico.
* Registrar el nombre del propietario del equipo.
* Registrar el área o departamento al que pertenece el dispositivo.
* Almacenar las características del equipo (marca, modelo, entre otras).
* Gestionar el estado de la reparación o mantenimiento.
* Registrar el nombre del técnico encargado del servicio.
* Permitir consultar los detalles de cada mantenimiento realizado.
* Generar reportes con comentarios del técnico.
* Permitir exportar los reportes en formato PDF.

---

# Requerimientos Funcionales

## RF-01. Registro de dispositivos

El sistema deberá permitir registrar cada dispositivo que ingrese al área de soporte técnico.

### Datos a almacenar

* Nombre del propietario.
* Área o departamento al que pertenece.
* Marca del equipo.
* Modelo del equipo.
* Número de serie (opcional).
* Tipo de dispositivo.
* Fecha de ingreso.

---

## RF-02. Asignación de prioridad

El sistema deberá permitir asignar una prioridad al dispositivo.

### Niveles de prioridad

* Alta
* Media
* Baja

---

## RF-03. Asignación del técnico responsable

El sistema deberá permitir asignar un técnico responsable para cada servicio.

### Información del técnico

* Nombre del técnico.
* Fecha de asignación.

---

## RF-04. Gestión del estado de reparación

El sistema deberá permitir registrar y actualizar el estado de la reparación.

### Estados posibles

* Recibido.
* En diagnóstico.
* En reparación.
* En mantenimiento.
* Esperando refacciones.
* Reparado.
* Entregado.
* Cancelado.

---

## RF-05. Registro de comentarios del usuario

El sistema deberá almacenar observaciones o comentarios proporcionados por el dueño del equipo.

---

## RF-06. Registro de actividades realizadas

El sistema deberá registrar las acciones realizadas por el técnico durante el servicio.

### Ejemplos

* Limpieza interna.
* Cambio de memoria RAM.
* Instalación de sistema operativo.
* Actualización de software.
* Cambio de disco duro.

---

## RF-07. Consulta de información de mantenimientos

El sistema deberá permitir consultar el historial y los detalles de cada servicio realizado.

### Información mostrada

* Datos del propietario.
* Características del equipo.
* Prioridad asignada.
* Estado actual.
* Técnico responsable.
* Comentarios del usuario.
* Actividades realizadas.
* Fecha de ingreso.
* Fecha de entrega.

---

## RF-08. Generación de reporte técnico

El sistema deberá generar un reporte final del mantenimiento o reparación.

### El reporte deberá contener

* Información del propietario.
* Área correspondiente.
* Datos del equipo.
* Prioridad asignada.
* Nombre del técnico encargado.
* Fecha de ingreso.
* Fecha de entrega.
* Diagnóstico del problema.
* Actividades realizadas.
* Comentarios finales del técnico.

---

## RF-09. Exportación del reporte

El sistema deberá permitir exportar el reporte técnico en formato PDF.

### El archivo PDF deberá poder

* Guardarse en el equipo.
* Imprimirse.

---

## RF-10. Búsqueda de servicios

El sistema deberá permitir localizar registros mediante diferentes criterios.

### Filtros de búsqueda

* Nombre del propietario.
* Área o departamento.
* Marca del equipo.
* Modelo.
* Técnico responsable.
* Estado del mantenimiento.
* Prioridad.

---

## RF-11. Actualización de información

El sistema deberá permitir modificar la información de un registro mientras el servicio no haya sido concluido.

---

## RF-12. Consulta del historial de reparaciones

El sistema deberá conservar un historial de servicios realizados para futuras consultas.

---

# Requerimientos No Funcionales

## RNF-01. Usabilidad

La aplicación deberá contar con una interfaz gráfica sencilla, intuitiva y fácil de utilizar por el personal de soporte técnico.

---

## RNF-02. Rendimiento

Las consultas y búsquedas deberán responder en un tiempo menor a tres segundos bajo condiciones normales de operación.

---

## RNF-03. Disponibilidad

La aplicación deberá estar disponible durante el horario laboral del área de soporte técnico.

---

## RNF-04. Seguridad de acceso

El sistema deberá permitir el acceso únicamente a usuarios autorizados mediante nombre de usuario y contraseña.

---

## RNF-05. Integridad de la información

La información almacenada no deberá perderse ni alterarse accidentalmente.

---

## RNF-06. Persistencia de datos

Toda la información deberá almacenarse en una base de datos para conservar los registros de mantenimiento y reparación.

---

## RNF-07. Compatibilidad

La aplicación deberá poder ejecutarse en equipos con sistema operativo Windows 10 o superior.

---

## RNF-08. Escalabilidad

El sistema deberá permitir agregar nuevas funcionalidades o módulos sin afectar las funciones existentes.

---

## RNF-09. Mantenibilidad

La estructura del sistema deberá facilitar la corrección de errores y la incorporación de mejoras.

---

## RNF-10. Confiabilidad

El sistema deberá garantizar que los datos registrados y los reportes generados sean consistentes y precisos.

---

## RNF-11. Generación de PDF

Los reportes exportados deberán conservar un formato legible y profesional, permitiendo su impresión sin pérdida de información.

---

## RNF-12. Capacidad

El sistema deberá soportar el almacenamiento de múltiples registros de dispositivos y mantenimientos sin degradar significativamente el rendimiento.

---

# Actores del Sistema

| Actor                        | Descripción                                                             |
| ---------------------------- | ----------------------------------------------------------------------- |
| Encargado de soporte técnico | Registra equipos, asigna prioridades y técnicos responsables.           |
| Técnico de soporte           | Actualiza el estado del servicio y registra las actividades realizadas. |
| Administrador                | Gestiona usuarios y consulta toda la información del sistema.           |
| Propietario del equipo       | Proporciona información y comentarios sobre las fallas del dispositivo. |

---

# Objetivo

Desarrollar una aplicación que permita administrar de manera eficiente el proceso de recepción, mantenimiento y reparación de equipos dentro del área de soporte técnico, facilitando el seguimiento de cada servicio y la generación de reportes técnicos en formato PDF.
