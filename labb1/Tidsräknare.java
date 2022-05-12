/*
Kurs: 1IK153
Laboration: Labb1:5
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21  19/11
 */
package com.example.demo;

import javafx.application.Application;

import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;






public class Tidsräknare extends Application {
    @Override
    public void start(Stage stage)  {



        GridPane pane = new GridPane();





        pane.setAlignment(Pos.TOP_LEFT);
        pane.add(new Label("Ange antal sekunder: "),0,0);

        TextField textField = new TextField();
        Button b1 = new Button("Beräkna");
        Label timmar = new Label("Timmar:");
        Label minuter = new Label("Minuter:");
        Label sekunder = new Label("Sekunder:");

        pane.add(textField,1,0);
        pane.add(b1,0,1);
        pane.add(timmar,0,3);
        pane.add(minuter,0,4);
        pane.add(sekunder,0,5);
        //pane.getChildren().addAll(label,textField);

        Scene scene = new Scene(pane);
        stage.setTitle("Tidsräknare");
        stage.setScene(scene);
        stage.show();


        b1.setOnAction(e ->{

                String s = textField.getText();
                int i = Integer.parseInt(s);
                int hours = i / 3600;
                int minutes = ((i % 3600) / 60);
                int sec = i % 60;


                timmar.setText("Timmar: " + hours);
                minuter.setText("Minuter: " + minutes);
                sekunder.setText("Sekunder: " + sec);


        });
    }

    public static void main(String[] args) {
        launch(args);

    }
}