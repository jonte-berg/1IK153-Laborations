/*
        Kurs: 1IK153
        Laboration: Labb3:3
        Kursdeltagare: Jonathan Berg
        Termin och datum: VT 2022 19/1
*/
package com.example.labb3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class addData extends Application {
    @Override
    public void start(Stage stage) throws SQLException, ClassNotFoundException {



        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_LEFT);

        ObservableList<String> options = FXCollections.observableArrayList();
        //hämta fresh från DB
        ArrayList<String> dbArtist = dbGrab();

        //fyll med options FRÅN DB
        for (int i =0;i<dbArtist.size();i++)
        options.add(dbArtist.get(i));

        ComboBox comboBox = new ComboBox(options);


        Button b1 = new Button("Sätt in");
        Button b2 = new Button("Skapa ny artist");
        Button b3 = new Button("Lägg till");
        b3.setVisible(false);

        Label titel = new Label("MusikDB insättare");
        titel.setFont(new Font(18));

        Label l1 = new Label("Namn:");
        l1.setFont(new Font(18));

        Label l2 = new Label("Utgivningsår:");
        l2.setFont(new Font(18));

        Label l3 = new Label("Genre: ");
        l3.setFont(new Font(18));
        l3.setVisible(false);






        TextField namnTF= new TextField();
        TextField arTF = new TextField();
        TextField genreTF = new TextField();
        genreTF.setVisible(false);

        pane.add(titel,0,0);


        pane.add(comboBox,0,1);
        pane.add(b2,1,1);

        pane.add(l1,0,3);
        pane.add(namnTF,1,3);

        pane.add(l2,0,4);
        pane.add(arTF,1,4);

        pane.add(l3,0,5);
        pane.add(genreTF,1,5);

        pane.add(b1,0,5);
        pane.add(b3,1,7);


        Scene scene = new Scene(pane,400,200);
        stage.setTitle("Insättning");
        stage.setScene(scene);
        stage.show();







        b1.setOnAction(e ->{

            //min "lagom" felhantering
            if (comboBox.getValue()!=null && !comboBox.getValue().toString().isEmpty()
                    && !namnTF.getText().isEmpty() && namnTF.getText()!=""
                    && !arTF.getText().isEmpty() && arTF.getText().matches("[0-9]+")){


                String query;
                //insert album query
                query="INSERT INTO album VALUES ('"+namnTF.getText()+"',"+arTF.getText()+",'"+comboBox.getValue()+"');";

                try {
                    dbAdd(query);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Success!");
                    alert.setHeaderText("Album added to database!");
                    alert.setContentText("The album is now added to the database");

                    alert.showAndWait();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }


            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("!!!!!");
                alert.setContentText("Du behöver välja en artist och fylla ut dina fält med godtyckliga värden!");

                alert.showAndWait();
            }


        });

        b2.setOnAction(e ->{
            l2.setText("Bildades: ");
            l3.setVisible(true);
            genreTF.setVisible(true);
            b1.setVisible(false);
            b3.setVisible(true);



        });

        b3.setOnAction(e ->{

            if(!namnTF.getText().isEmpty()
                    && !arTF.getText().isEmpty() && arTF.getText().matches("[0-9]+")
                    && !genreTF.getText().isEmpty()){



                String query;
                //insert album query
                query="INSERT INTO artist VALUES ('"+namnTF.getText()+"',"+arTF.getText()+",'"+genreTF.getText()+"');";

                try {
                    dbAdd(query);
                    options.add(namnTF.getText());
                    comboBox.setItems(options);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }





            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("!!!!!");
                alert.setContentText("Du behöver välja en artist och fylla ut dina fält med godtyckliga värden!");

                alert.showAndWait();
            }



            //sista som händer, reset layout
            l2.setText("Utgivningsår: ");
            l3.setVisible(false);
            genreTF.setVisible(false);
            b1.setVisible(true);
            b3.setVisible(false);

        });
    }




    public static void main(String[] args) {
        launch(args);

    }
    public ArrayList<String> dbGrab() throws SQLException, ClassNotFoundException {
        final String url = "jdbc:mysql://localhost/musikdatabasen";
        final String user = "root";
        final String pass = "123456789";

        ArrayList<String> dbNamn = new ArrayList<>();
        Connection conn;

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to selected database...");
        conn = DriverManager.getConnection(url, user, pass);
        System.out.println("Connected to database successfully...");
        Statement statement = conn.createStatement();

        //want to grab from artist , i use this string to decide from which DBN to grab from and use in my query
        String s = "artist";

        //result = the query given, decided by String s
        ResultSet result = statement.executeQuery("Select * from "+ s);


        //as long as the resultset has values, i print the value of each row from each column
        while(result.next()){
            //OBS! jag HÄMTAR IFRÅN KOLLUMN 1 (NAMN) , kol 2=bildades,kol3=genre
            dbNamn.add(result.getString(1));
        }



        return  dbNamn;
    }

    public void dbAdd(String s) throws SQLException, ClassNotFoundException {
        final String url = "jdbc:mysql://localhost/musikdatabasen";
        final String user = "root";
        final String pass = "123456789";

        ArrayList<String> dbFresh = new ArrayList<>();
        Connection conn;

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to selected database...");
        conn = DriverManager.getConnection(url, user, pass);
        System.out.println("Connected to database successfully...");

        System.out.println(s);
        PreparedStatement stmt = conn.prepareStatement(s);
        stmt.executeUpdate();
        System.out.println("Done");
/*
        //as long as the resultset has values, i print the value of each row from each column
        while(result.next()){
            //OBS! jag HÄMTAR IFRÅN KOLLUMN 1 (NAMN) , kol 2=bildades,kol3=genre
            dbFresh.add(result.getString(1));
        }



        return  dbFresh;*/
    }
}
