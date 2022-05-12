/*
Kurs: 1IK153
Laboration: Labb2:1
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21 10/12
 */
package com.example.labb2;


import java.util.NoSuchElementException;

public class Kedjetest {
    public static void main(String[] args) throws NoSuchElementException {
        Kedja<String> enKedja = new Kedja<>();
        enKedja.addFirst("Itzamna");
        enKedja.addFirst("Kinich Ahau");
        enKedja.addFirst("Chaac");
        enKedja.addFirst("Bolon Dzacab");
        enKedja.addLast("Bacabs");
        enKedja.addAt(4, "Ek Chuah");



        System.out.println(enKedja.getFirst());
        System.out.println();

        for (String s : enKedja) {
            System.out.println(s);
        }


        System.out.println("Storlek: " + enKedja.getSize());
        enKedja.removeAt(4);
        System.out.println();

        for (String s : enKedja) {
            System.out.println(s);
        }


        System.out.println("Storlek: " + enKedja.getSize());
    }
}






