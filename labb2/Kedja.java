/*
Kurs: 1IK153
Laboration: Labb2:1+2
Kursdeltagare: Jonathan Berg
Termin och datum: HT 21 10/12
 */

package com.example.labb2;


import java.util.*;
import java.util.function.Consumer;

public class Kedja<E extends Comparable<E>> implements Iterable<E> {


    private Node<E> huvud;
    private Node<E> svans;
    private int size;

    public Kedja(Node huvud, Node svans, int size) {
        this.huvud = huvud;
        this.svans = svans;
        this.size = size;
    }
    public Kedja(){

    }

    //klar
    public void removeAt(int p) {
        if (p < 0 || p >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            if (p == 0) {
                removeFirst();
            } else if (p==size-1){
                removeLast();
            }else {
                Node tidigare = huvud;
                for (int i = 1; i < p; i++) {
                    tidigare = tidigare.next;
                }
                Node nuvarande = tidigare.next;
                tidigare.next = nuvarande.next;
                size--;
            }
        }
    }

    //klar
    public void removeLast() {
        if(size == 0) {
            throw new IndexOutOfBoundsException();
        } else if(size == 1){
            huvud = svans = null;
            size = 0;
        } else {
            Node tidigare = huvud;
            for(int i = 0; i < size - 2; i++) {
                tidigare = tidigare.next;
            }
            svans = tidigare;
            svans.next = null;
            size--;
        }
    }

    //klar
    public E getAt(int p){


        if (p < 0 || p >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = huvud;

        for (int i = 0; i < p; i++) {
            current = current.next;
        }
        return (E) current.data;

    }

    //klar
    public void addAt(int p,E e){


        if (p < 0 || p > size) {
            throw new IndexOutOfBoundsException();
        }

        if (p==0){
            addFirst(e);

        }

        else {


            Node<E> current = huvud;

            for (int i = 1; i < p; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            Node<E> nyNod = new Node();
            nyNod.data= e;
            current.next =nyNod;
            nyNod.next = temp;
            size++;
        }
    }

    //klar
    public void removeFirst(){
        if(huvud == null){
            throw new NoSuchElementException();
        }
        huvud = huvud.next;
        size--;
        if(huvud==null)
            svans=null;
    }

//klar
public void addInorder(E e) {

    if (huvud != null) {
        Node<E> current = huvud;
        Node<E> previous = null;

        //iterera genom kedjan tills current.data är 1 (då är "e" på rätt position descending)
        while (current != null && current.data.compareTo(e) <= 0 ) {

            previous = current;
            current = current.next;

        }

        Node<E> temp = new Node<E>(e);
        //ifall vi är på första pos, så blir detta huvudet
        if (previous == null) {
            temp.next = huvud;
            huvud = temp;
        } else {
            temp.next = current;
            previous.next = temp;
        }

    }
    //ifall huvud=null,  sätt huvud till e
    else {
        Node<E> firstNode = new Node<E>(e);
        huvud = svans = firstNode;
    }

    size++;

    }









    //klar
    public E getFirst() {
        if(huvud == null) {
            throw new NoSuchElementException();
        }
        return (E) huvud.data;
    }


    //klar
    public E getLast() {
        if(svans == null) {
            throw new NoSuchElementException();
        }
        return (E) svans.data;
    }


    //klar
    public void addLast(E e){
        Node addNode= new Node(e);
        if (svans==null){

            huvud = svans= addNode;

        }

        else{
            svans.next=addNode;
            svans= svans.next;
        }

        size++;


    }

    //klar
    public void addFirst(E e) {

        Node newNode = new Node(e);
        newNode.next = this.huvud;
        huvud = newNode;

        if (svans==null){
            svans=huvud;
        }

        size++;
    }

    //klar
    public int getSize(){
        return this.size;
    }






    public boolean contains(E e){


        Node<E> temp = huvud;
        while(temp!=null){
            if(temp.data.equals(e))
            return true;
            temp=temp.next;
        }
        return false;



    }



    class Node<E> {

        E data;
        Node<E> next;


        public Node(E e) {
            this.data=e;
        }
        public Node(){

        }
        public String toString(){
            return ""+data;
        }


    }



    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node pekare = huvud;
        @Override
        public boolean hasNext() {
            return (pekare != null);
        }
        @Override
        public E next() {
            E data = (E) pekare.data;
            pekare = pekare.next;
            return (E)data;
        }
    }






}
