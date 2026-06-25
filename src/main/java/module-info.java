module mx.edu.buap.servicetracker {

    requires javafx.controls;
    requires javafx.fxml;

    //Módulos de JSON
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

    //Modulo para manejo de PDF
    requires com.github.librepdf.openpdf;

    opens mx.edu.buap.servicetracker to javafx.fxml;
    opens mx.edu.buap.servicetracker.controller to javafx.fxml;

    //Módulos de controller, model, service y util
    exports mx.edu.buap.servicetracker;
    exports mx.edu.buap.servicetracker.controller;
    exports mx.edu.buap.servicetracker.model;
    exports mx.edu.buap.servicetracker.service;
    exports mx.edu.buap.servicetracker.util;
}