module mx.edu.buap.servicetracker {

    requires javafx.controls;
    requires javafx.fxml;

    opens mx.edu.buap.servicetracker to javafx.fxml;
    opens mx.edu.buap.servicetracker.controller to javafx.fxml;

    exports mx.edu.buap.servicetracker;
    exports mx.edu.buap.servicetracker.controller;
}