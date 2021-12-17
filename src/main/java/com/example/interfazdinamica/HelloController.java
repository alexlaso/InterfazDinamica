package com.example.interfazdinamica;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private boolean isDesplegado;
    private TranslateTransition animacion;
    @FXML
    private Button btnMenu;
    @FXML
    private VBox desplegable;
    @FXML
    private StackPane fondo;

    //solo metodos o cosas que no tengan que ver con la vista
    public HelloController(){
    isDesplegado=false;

    }

    // elementos de la vista
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        desplegable.translateXProperty().bind(desplegable.widthProperty());

        initAnimacion();
    }

    private void initAnimacion(){
        animacion=new TranslateTransition(Duration.millis(17));
        animacion.setFromX(-fondo.getWidth()-desplegable.getWidth());
        animacion.setToX(-fondo.getWidth());
        animacion.play();
    }
}