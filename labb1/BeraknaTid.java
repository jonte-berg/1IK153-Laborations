/*
Kurs: 1IK153
Laboration: Labb1:6
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21  19/11
 */

package com.example.demo;

import javafx.application.Application;

import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;




public class BeraknaTid extends Application {
    @Override
    public void start(Stage stage)  {



        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_LEFT);
        pane.add(new Label("Ange tid: "),0,1);
        pane.add(new Label("Ange tid: "),0,1);
        TextField textFieldHour = new TextField();
        textFieldHour.setMaxSize(50,20);
        TextField textFieldMinute = new TextField();
        textFieldMinute.setMaxSize(50,20);
        TextField textFieldSec = new TextField();
        textFieldSec.setMaxSize(50,20);


        Button b1 = new Button("Beräkna");


        pane.add(textFieldHour,1,1);
        pane.add(textFieldMinute,3,1);
        pane.add(textFieldSec,5,1);
        pane.add(new Label(" h  "),2,1);
        pane.add(new Label(" m  "),4,1);
        pane.add(new Label(" s  "),6,1);
        pane.add(b1,0,2);



        Scene scene = new Scene(pane);
        stage.setTitle("Beräkna tid");
        stage.setScene(scene);
        stage.show();


        b1.setOnAction(e ->{
            Alert alertError = new Alert(Alert.AlertType.WARNING);
            Alert alertSuccess= new Alert(Alert.AlertType.INFORMATION);
            if (textFieldHour.getText().isEmpty()||textFieldMinute.getText().isEmpty()||textFieldSec.getText().isEmpty()){
                alertError.setContentText("Du har inte skrivit in något i alla rutor.");
                alertError.show();
            }

            else{

                int totalSec=0;
                totalSec+=((Integer.parseInt(textFieldHour.getText())*60)*60);
                totalSec+=(Integer.parseInt(textFieldMinute.getText())*60);
                totalSec+=Integer.parseInt(textFieldSec.getText());
                alertSuccess.setContentText("Det blir: "+totalSec+" sekunder.");

                alertSuccess.show();
            }

        });
    }

    public static void main(String[] args) {
        launch(args);

    }
}