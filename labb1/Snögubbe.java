/*
Kurs: 1IK153
Laboration: Labb1:1
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21  19/11
 */
package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

import java.io.IOException;

public class Snögubbe extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Text text = new Text(20, 50, "Any sufficiently advanced technology is indistinguishable from magic.");
        Group root = new Group();
        Rectangle r1 = new Rectangle(0,0,500,350);
        Circle sol= new Circle(400,100,50);
        Circle c1= new Circle(250,300,50);
        Circle c2= new Circle(250,250,40);
        Circle c3= new Circle(250,200,30);
        Circle e1 = new Circle(240,190,5);
        Circle e2 = new Circle(260,190,5);
        Circle b1 = new Circle(250,240,5);
        Circle b2 = new Circle(250,255,5);
        Circle b3 = new Circle(250,270,5);


        Line line = new Line(250,200,260,200);
        r1.setFill(Color.MEDIUMBLUE);
        sol.setFill(Color.YELLOW);
        c1.setFill(Color.WHITE);
        c2.setFill(Color.WHITE);
        c3.setFill(Color.WHITE);

        root.getChildren().addAll(r1,sol,c1,c2,c3,line,e1,e2,b1,b2,b3);

        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Snowman");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}