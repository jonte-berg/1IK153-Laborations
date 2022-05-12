/*
Kurs: 1IK153
Laboration: Labb1:3
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21  19/11
 */
package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Bild extends Application {


    @Override
    public void start(Stage stage) throws FileNotFoundException {



        Image image = new Image(new FileInputStream("C:\\ubuntu.png"));
        ImageView imageView = new ImageView(image);

        Group grp = new Group(imageView);
        Scene scene = new Scene(grp);
        stage.setScene(scene);


        stage.setTitle("Bild");
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);

    }
}