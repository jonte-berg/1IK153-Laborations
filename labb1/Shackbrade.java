/*
Kurs: 1IK153
Laboration: Labb1:2
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21  19/11
 */
package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.text.Format;


public class Shackbrade extends Application {

    @Override
    public void start(Stage stage)  {




        Group grp = new Group();
        Scene scene = new Scene(grp);
        stage.setScene(scene);


        for(int y = 0 ;y<8;y++) {
            for (int i = 0; i < 8; i++) {
                Rectangle r = new Rectangle();
                r.setX(i * 100);
                r.setY(y * 100);
                r.setWidth(100);
                r.setHeight(100);
                if ((y%2==0 && i%2==0)||(y%2!=0 && i%2!=0))
                    r.setFill(Color.WHITE);
                else
                    r.setFill(Color.BLACK);

                grp.getChildren().add(r);
            }
        }

        scene.setRoot(grp);
        stage.setTitle("Shack");
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);

    }


}