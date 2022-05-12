/*
Kurs: 1IK153
Laboration: Labb1:8
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21  19/11
 */
package com.example.demo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Tomte extends ImageView {
    public double x_speed;
    public double y_speed;
    int currentImage=0;
    public ArrayList<Image> others;



    public Tomte(ArrayList<Image> others) {
        super();

        this.setPreserveRatio(true);
        this.setFitWidth(200);
        this.setFitHeight(170);
        this.others = others;


        super.setX(0);
        super.setY(150);
        this.x_speed = 20;
        this.y_speed = 0;
    }
   /* public Tomte(String s){
        super();
       // this.setImage(new Image("C:/Users/JBerg/Downloads/santasprites/png/"+s+".png"));
        this.setPreserveRatio(true);
        this.setFitWidth(200);
        this.setFitHeight(200);

        super.setX(0);
        super.setY(150);
        this.x_speed = 20;
        this.y_speed = 0;

    }*/

    public void move() {

        if(this.getImage()==null){
            System.out.println("ngt är NULL (ingen bild satt)");
        this.setImage(others.get(0));}
        else {

            if (currentImage<others.size()){
                super.setImage(others.get(currentImage));
                currentImage++;
            }
            else
            currentImage=0;





        super.setX(super.getX()+this.x_speed);

        //this.setImage(imglist.get(0));

       // System.out.println(this.getX()+"\t"+this.getImage()+"\t"+this.getClass());


            //reaching the leftmost cap
        if(super.getX() <= 0){
            super.setX(0);
            super.setScaleX(1);
            //super.setImage(imglist.get(2));
            this.x_speed = (-this.x_speed);
        }

        //reaching the rightmost cap
        if(super.getX()>=(800)){
            super.setX(799);
            //turn around
            super.setScaleX(-1);
           // super.setImage(imglist.get(3));
            this.x_speed=(-this.x_speed);
        }

      // this.setImage(new Image("C:/Users/JBerg/Downloads/santasprites/png/"+"run (3)"+".png"));
    }
}}