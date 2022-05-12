/*
Kurs: 1IK153
Laboration: Labb1:4
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21  19/11
 */

package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.util.concurrent.atomic.AtomicInteger;

public class Knappen extends Application {

    @Override
    public void start(Stage stage)  {

        //inte snyggt men hmmmm
        AtomicInteger antalKlick = new AtomicInteger();
        HBox hbox = new HBox(2);


        Button b1 = new Button("Tryck mig!");

        hbox.getChildren().add(b1);

        Label label = new Label();
        label.setText("");
        label.setFont(Font.font(18));
        hbox.getChildren().add(label);

        //onclick action
        b1.setOnAction(e ->{
            antalKlick.getAndIncrement();
            label.setText("Antal klick: "+antalKlick);
        });


        Scene scene = new Scene(hbox,200,50);
        stage.setScene(scene);
        stage.setTitle("Tryck på knappen");
        stage.show();


    }

   
    public static void main(String[] args) {
        launch(args);
    }



}
