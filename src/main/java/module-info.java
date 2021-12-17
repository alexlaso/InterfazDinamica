module com.example.interfazdinamica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.interfazdinamica to javafx.fxml;
    exports com.example.interfazdinamica;
}