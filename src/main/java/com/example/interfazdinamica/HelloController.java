package com.example.interfazdinamica;

import javafx.animation.TranslateTransition;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private boolean isDesplegado;
    private TranslateTransition animacion, animacionbtn;
    @FXML
    private Button btnMenu;
    @FXML
    private VBox desplegable;
    @FXML
    private StackPane fondo;

    /*ejemplo StringProperty
    private StringProperty prueba;
    public String getPrueba() {return prueba.get();}
    public StringProperty pruebaProperty() {return prueba;}
    public void setPrueba(String prueba) {this.prueba.set(prueba);}*/


    //solo metodos o cosas que no tengan que ver con la vista
    public HelloController(){


    }

    // elementos de la vista
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        desplegable.setTranslateX(-52);
        isDesplegado=false;
    }

    private void despliegue(){
        animacion=new TranslateTransition(Duration.millis(300),desplegable);
        animacionbtn= new TranslateTransition(Duration.millis(300),btnMenu);

        if(!isDesplegado){
            animacion.setFromX(-desplegable.getWidth());
            animacion.setToX(0);
            animacionbtn.setFromX(0);
            animacionbtn.setToX(desplegable.getWidth());
            isDesplegado=true;

        }else{
            animacion.setFromX(0);
            animacion.setToX(-desplegable.getWidth());
            animacionbtn.setFromX(desplegable.getWidth());
            animacionbtn.setToX(0);
            isDesplegado=false;
        }
        animacion.play();
        animacionbtn.play();
    }

    @FXML
    protected void desplegarMenu(){
       despliegue();
    }

    @FXML
    protected void vista1(){
        fondo.setBackground(new Background(
                new BackgroundImage(
                        new Image("perros.jpg", fondo.getWidth(), fondo.getHeight(), false, true),
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT)));
        despliegue();
    }

    @FXML
    protected void vista2(){
        fondo.setBackground(new Background(
                new BackgroundImage(
                        new Image("samurai.jpg", fondo.getWidth(), fondo.getHeight(), false, true),
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT)));
        despliegue();
}}