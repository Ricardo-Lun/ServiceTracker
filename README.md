# ServiceTracker
Plataforma de gestión de tickets e incidencias de TI que permite registrar, asignar, monitorear y dar seguimiento a solicitudes de soporte técnico de manera eficiente.

Primer reunión con el cliente:
Se solicita la creación de una aplicación para el área de soporte técnico de una empresa, la aplicación debe asignar la prioridad de cada dispositivo, el estado en el que esta su reparación o mantenimiento, además debe de incluir una sección donde se añadan los comentarios de los dueños de los equipos, y al final se tiene que dar un reporte sobre lo que hizo en la reparación.

Segunda reunión con el cliente:
Se especificó que la aplicación debe de almacenar la prioridad que el encargado de soporte técnico le asigne al dispositivo, también se requiere que se haga un registro con el nombre del dueño del equipo, el área al que pertenece, las características del equipo (marca, modelo, etc.). Es necesario incluir una gestión del estado de la reparación, el nombre del técnico encargado de dar servicio al dispositivo, poder consultar los detalles de cada mantenimiento y el reporte debe tener con comentarios del técnico debe de poder ser exportado a pdf.

Requerimientos Funcionales
Los requerimientos funcionales describen las funciones que deberá realizar el sistema.
1. Registro de dispositivos
El sistema deberá permitir registrar cada dispositivo que ingrese al área de soporte técnico.
Datos a almacenar:
    • Nombre del propietario del equipo. 
    • Área o departamento al que pertenece. 
    • Marca del equipo. 
    • Modelo del equipo. 
    • Número de serie (opcional). 
    • Tipo de dispositivo (computadora, impresora, laptop, etc.). 
    • Fecha de ingreso. 
2. Asignación de prioridad
El sistema deberá permitir al encargado de soporte técnico asignar una prioridad al dispositivo.
Niveles de prioridad:
    • Alta. 
    • Media. 
    • Baja. 
La prioridad será determinada por el responsable del área de soporte.
3. Asignación del técnico responsable
El sistema deberá permitir asignar un técnico encargado para cada servicio o mantenimiento.
Información del técnico:
    • Nombre del técnico. 
    • Fecha de asignación. 
4. Gestión del estado de reparación
El sistema deberá permitir registrar y actualizar el estado del mantenimiento o reparación.
Estados posibles:
    • Recibido. 
    • En diagnóstico. 
    • En reparación. 
    • En mantenimiento. 
    • Esperando refacciones. 
    • Reparado. 
    • Entregado. 
    • Cancelado. 
5. Registro de comentarios del usuario
El sistema deberá permitir almacenar observaciones o comentarios proporcionados por el dueño del equipo al momento de recibir el dispositivo.
6. Registro de actividades realizadas
El sistema deberá permitir registrar las acciones efectuadas por el técnico durante la reparación o mantenimiento.
Ejemplos:
    • Limpieza interna. 
    • Cambio de memoria RAM. 
    • Instalación de sistema operativo. 
    • Actualización de software. 
    • Cambio de disco duro. 
7. Consulta de información de mantenimientos
El sistema deberá permitir consultar el historial y los detalles de cada servicio realizado.
La consulta deberá mostrar:
    • Datos del propietario. 
    • Características del equipo. 
    • Prioridad asignada. 
    • Estado actual. 
    • Técnico responsable. 
    • Comentarios del usuario. 
    • Actividades realizadas. 
    • Fecha de ingreso. 
    • Fecha de entrega. 
8. Generación de reporte técnico
El sistema deberá generar un reporte final del mantenimiento o reparación.
El reporte deberá contener:
    • Información del propietario. 
    • Área correspondiente. 
    • Datos del equipo. 
    • Prioridad asignada. 
    • Nombre del técnico encargado. 
    • Fecha de ingreso. 
    • Fecha de entrega. 
    • Diagnóstico del problema. 
    • Actividades realizadas. 
    • Comentarios finales del técnico. 
9. Exportación del reporte
El sistema deberá permitir exportar el reporte técnico en formato PDF.
El archivo PDF deberá poder:
    • Guardarse en el equipo. 
    • Imprimirse. 
10. Búsqueda de servicios
El sistema deberá permitir localizar registros mediante diferentes criterios.
Filtros de búsqueda:
    • Nombre del propietario. 
    • Área o departamento. 
    • Marca del equipo. 
    • Modelo. 
    • Técnico responsable. 
    • Estado del mantenimiento. 
    • Prioridad. 
11. Actualización de información
El sistema deberá permitir modificar la información de un registro mientras el servicio no haya sido concluido.
12. Consulta del historial de reparaciones
El sistema deberá conservar un historial de servicios realizados para futuras consultas.

Requerimientos No Funcionales
Los requerimientos no funcionales describen las características de calidad y restricciones del sistema.
1. Usabilidad
La aplicación deberá contar con una interfaz gráfica sencilla, intuitiva y fácil de utilizar por el personal de soporte técnico.
2. Rendimiento
Las consultas y búsquedas de información deberán responder en un tiempo menor a 3 segundos bajo condiciones normales de operación.
3. Disponibilidad
La aplicación deberá estar disponible durante el horario laboral del área de soporte técnico.
4. Seguridad de acceso
El sistema deberá permitir el acceso únicamente a usuarios autorizados mediante nombre de usuario y contraseña.
5. Integridad de la información
La información almacenada no deberá perderse ni alterarse accidentalmente.
6. Persistencia de datos
Toda la información deberá almacenarse en una base de datos para conservar los registros de mantenimiento y reparación.
7. Compatibilidad
La aplicación deberá poder ejecutarse en equipos con sistema operativo Windows 10 o superior.
8. Escalabilidad
El sistema deberá permitir agregar nuevas funcionalidades o módulos en el futuro sin afectar las funciones existentes.
9. Mantenibilidad
La estructura del sistema deberá facilitar la corrección de errores y la incorporación de mejoras.
10. Confiabilidad
El sistema deberá garantizar que los datos registrados y los reportes generados sean consistentes y precisos.
11. Generación de PDF
Los reportes exportados deberán conservar un formato legible y profesional, permitiendo su impresión sin pérdida de información.
12. Capacidad
El sistema deberá soportar el almacenamiento de múltiples registros de dispositivos y mantenimientos sin degradar significativamente el rendimiento.
