/*
        Kurs: 1IK153
        Laboration: Labb3:1
        Kursdeltagare: Jonathan Berg
        Termin och datum: VT 2022 19/1
*/
package com.example.labb3;
import java.sql.*;

public class Visadata {

    static final String url = "jdbc:mysql://localhost/musikdatabasen";
    static final String user = "root";
    static final String pass = "123456789";

    public static void main(String[] args) throws Exception{
        Connection conn;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to selected database...");
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to database successfully...");
            Statement statement = conn.createStatement();

            //want to grab from artist first, i use this string to decide my query
            String s = "artist";

            //result = the query given, decided by String s
            ResultSet result = statement.executeQuery("Select * from "+ s);
            System.out.println("\n\n"+s+"\n=======");

            //as long as the resultset has values, i print the value of each row from each column
            while(result.next()){

                System.out.println(result.getString(1)+"  ("+result.getString(2)+")  : "+result.getString(3));

                //when done, i change the S variable to album, since it is now time to grab the albums
                s="album";

            }

            System.out.println("\n"+s+"\n=======");
            //the new result from the 2nd query
            result= statement.executeQuery("Select * from "+ s);

            //as long as the resultset has values, i prints thte value of each row from each coluimn
            while(result.next()){

                System.out.println(result.getString(1)+"  ("+result.getString(2)+")  : "+result.getString(3));


            }



        }catch (SQLException e){
            System.out.println("Something went wrong... " + e.getMessage());
        }
    }
}