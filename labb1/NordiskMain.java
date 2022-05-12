/*
Kurs: 1IK153
Laboration: Labb1:7
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21  19/11
 */
package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.ArrayList;


public class NordiskMain extends Application {
    @Override
    public void start(Stage stage)  {


        ArrayList<NordiskGud> gudLista = new ArrayList<>();
        NordiskGud g1 = new NordiskGud("Oden","Asa1","testbeskrivning1111111");
        NordiskGud g2 = new NordiskGud("Tor","Asa2","testbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222ebeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222eststbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222estbeskrivning222222");
        NordiskGud g3 = new NordiskGud("Loke","Asa3","testbeskrivning333333");
        NordiskGud g4 = new NordiskGud("Balder","Asa4","testbeskrivning444444");
        NordiskGud g5 = new NordiskGud("Frej","Asa5","testbeskrivning5555555");
        NordiskGud g6 = new NordiskGud("Brynhild","Asa6","testbeskrivning666666666");
        gudLista.add(g1);
        gudLista.add(g2);
        gudLista.add(g3);
        gudLista.add(g4);
        gudLista.add(g5);
        gudLista.add(g6);


        BorderPane pane = new BorderPane();
        Label l1 = new Label();
        l1.setText("Nordiska gudar och väsen");
        l1.setFont(new Font(26));
        pane.setTop(l1);


        // hur vill du?
        ObservableList<String> names = FXCollections.observableArrayList();

        for(int i =0;i<gudLista.size();i++)
        names.add(i,gudLista.get(i).getNamn());

        //ok?
        ListView<String> listView = new ListView<>(names);
        listView.setMaxSize(200, 500);
        pane.setLeft(listView);

        //har alternativ scrollpane implementation kommenterad




        //Scrollpane implementation
        //javafx.scene.control.ScrollPane beskrivningg = new javafx.scene.control.ScrollPane();

        GridPane beskrivning = new GridPane();
        beskrivning.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 1;" + "-fx-border-insets: 5;"
        + "-fx-border-radius: 2;" + "-fx-border-color: gray;");
        Text t1 = new Text();
        Text t2 = new Text();
        Text t3 = new Text();

        t1.setTextAlignment(TextAlignment.LEFT);
        t1.setFont(new Font(24));
        t2.setTextAlignment(TextAlignment.LEFT);
        t2.setFont(new Font(20));
        t3.setWrappingWidth(500);
        t3.setFont(new Font(14));
        t3.setTextAlignment(TextAlignment.JUSTIFY);


        //scrollpane implementation
        // beskrivningg.setMinWidth(200);
        //beskrivningg.setContent(t3);

        beskrivning.setMaxWidth(500);
        beskrivning.add(t1,0,0);
        beskrivning.add(t2,0,1);
        beskrivning.add(t3,0,4);
        pane.setCenter(beskrivning);

        Scene scene = new Scene(pane,730,500);
        stage.setTitle("Nordiska Gudar");
        stage.setScene(scene);
        stage.show();



        listView.setOnMouseClicked(e ->{

            String s;

            for (int i=0;i<gudLista.size();i++){

                s= gudLista.get(i).getNamn();
                if (s==listView.getSelectionModel().getSelectedItem()) {
                    t1.setText(gudLista.get(i).getNamn());
                    t2.setText(gudLista.get(i).getSlakte());
                    t3.setText(gudLista.get(i).getBeskrivning());
                    break;
                }
            }

        });

    }

    public static void main(String[] args) {
        launch(args);

    }

}