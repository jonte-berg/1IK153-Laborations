/*
Kurs: 1IK153
Laboration: Labb1:8
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21  19/11
 */


package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

//wip

public class Animering extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {



        ArrayList<Tomte> tomteArrayList = new ArrayList<>();
        ArrayList<Image> bilder = new ArrayList<>();

        bilder.add(new Image(new FileInputStream("C:/Users/JBerg/Downloads/santasprites/png/run (1).png")));
        bilder.add(new Image(new FileInputStream("C:/Users/JBerg/Downloads/santasprites/png/run (2).png")));
        bilder.add(new Image(new FileInputStream("C:/Users/JBerg/Downloads/santasprites/png/run (3).png")));
        bilder.add(new Image(new FileInputStream("C:/Users/JBerg/Downloads/santasprites/png/run (4).png")));
        bilder.add(new Image(new FileInputStream("C:/Users/JBerg/Downloads/santasprites/png/run (5).png")));
        bilder.add(new Image(new FileInputStream("C:/Users/JBerg/Downloads/santasprites/png/run (6).png")));

        Group root = new Group();
        StackPane stackPane = new StackPane();



        tomteArrayList.add(new Tomte(bilder));
        tomteArrayList.add(new Tomte(bilder));




        root.getChildren().addAll(tomteArrayList);

        Image tileSet = new Image(new FileInputStream("C:/Users/JBerg/Downloads/wintertileset/png/Tiles/1.png"));
        ImageView imageViewTile= new ImageView(tileSet);
        imageViewTile.setFitWidth(900);
        imageViewTile.setFitHeight(50);





        stackPane.getChildren().addAll(root,imageViewTile);
        stackPane.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("C:/Users/JBerg/Downloads/wintertileset/png/BG/BG.png")),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        stackPane.setAlignment(Pos.BOTTOM_LEFT);

        Scene scene = new Scene(stackPane, 900, 490);
        stage.setTitle("TomteTest1");
        stage.setScene(scene);
        stage.show();

        KeyFrame k = new KeyFrame(Duration.millis(50), event -> {

            tomteArrayList.get(0).move();
            System.out.println(tomteArrayList.get(0).getX());

        });
        Timeline t = new Timeline(k);
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();


    }

    public static void main(String[] args) {
        launch(args);

    }

}