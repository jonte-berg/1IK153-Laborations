package com.example.labb2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class hashtabell<E extends Comparable<E>> implements Iterable<E> {

    private LinkedList<E>[] hashtable;
    private int storlek = 11;
    private int antalElement;


    public hashtabell() {
        hashtable = new LinkedList[storlek];
    }



    public int hash(E e) {

        //kolla mayaklass för implementerade metoden
        int i = e.hashCode();

        //gör om negativa till positiva
        if (i < 0)
            i = -i;

        //komprimera hashkoden
        return i % storlek;
    }

    //förel9
    public void add(E e) {
        int bucket = hash(e);

        //ifall värdet redan finns, så görs inget, metoden är färdig (duplication protection)
        if (contains(e))
            return;

        //kollen för o se ifall det är dags för rehash
       if (((double)antalElement/(double)storlek) > 0.75 )
           rehash();

        if (hashtable[bucket] == null)
            hashtable[bucket] = new LinkedList<>();

        //lägg till värdet E på positionen som bucket fick efter hashningen
        hashtable[bucket].add(e);

        antalElement++;

    }

    //förel 9
    public void displayTable() {
        for (int i = 0; i < storlek; i++) {
            System.out.println("[" + i + "]: ");
            if (hashtable[i] == null) {
                System.out.println("null");
            } else {
                for (E e : hashtable[i]) {
                    System.out.println(e.toString() + " -> ");
                }
            }
            System.out.println();

        }


    }

    //fungerar och kan användas vid behov
    public boolean remove(E e){
        if(!contains(e))
            return false;

        int pos=hash(e);

        if(hashtable[pos]!=null){
            boolean res=hashtable[pos].remove(e);
            if(hashtable[pos].isEmpty())
                hashtable[pos]=null;

            antalElement--;

            return res;
        }
        return false;
    }

    //förel9
    public boolean contains(E e){
        int pos = hash(e);
        if (hashtable[pos]!=null){
           return hashtable[pos].contains(e);
        }
        return false;

    }

    //förel9
    private void rehash(){
        LinkedList<E> gamlaVarden = new LinkedList<>();

        //fyll gamlavärden med hashtables alla vörden
        for (int i=0; i<storlek;i++){
           if(hashtable[i]!=null){
               gamlaVarden.addAll(hashtable[i]);
           }
        }

        storlek=storlek*2;
        antalElement=0;
        //ny lista med 2x size
        hashtable=new LinkedList[storlek];

        for(E e: gamlaVarden)
            this.add(e);

    }



    //iterera igenom hashtabellen för att finna MIN-värdet
    public E Min()  {

        E min=null;
        //använder en int för att slippa iterera igenom och jämföra det första värdet som hittas och agerar som "bas" för jämförelserna, sparar lite tid
       int firstValue=0;
        //hitta det första värdet i listan, och ge värdet min det första värdet.
        for(int i=0;i<storlek;i++){
            if(hashtable[i]!=null) {
                min = hashtable[i].getFirst();
                firstValue=i;
                break;
            }
        }

        //nu itereras resten av listan, för att jämföra alla värden och på så sätt hitta minsta (notera: börjar där första värdet hittades, för att slippa iterera i onödan)
        for (int i=firstValue; i<storlek;i++){

            if(hashtable[i]!=null){
                //för  position i inuti arrayen, hämta ut mayaobjekten (E)
                for(E e: hashtable[i]) {
                    //ifall (E(mayaobjektet)) är  mindre än min, uppdatera min
                    if(e.compareTo(min)<0)
                        min=e;
                }
            }
        }
        return min;

    }

    //iterera igenom hashtabellen för att finna MAX-värdet
    public E Max()  {

        E max=null;
        //använder en int för att slippa iterera igenom och jämföra det första värdet som hittas och agerar som "bas" för jämförelserna
        int firstValue=0;

        //hitta det första värdet i listan, och ge värdet max det första värdet som hittas.
        for(int i=0;i<storlek;i++){
          if(hashtable[i]!=null) {
              max = hashtable[i].getFirst();
              firstValue=i;
              break;
          }
        }

        //nu itereras resten av listan, för att jämföra alla värden och på så sätt hitta MAX (notera: börjar där första värdet hittades, för att slippa iterera i onödan)
        for (int i=firstValue; i<storlek;i++){


            if(hashtable[i]!=null){
                //för  position i inuti arrayen, hämta ut mayaobjekten (E)
                for(E e: hashtable[i]) {
                    //ifall E(mayaobjektet)  är större än max,uppdatera max
                    if(e.compareTo(max)>0)
                        max=e;
                }
            }
        }
        return max;

    }


    @Override
    public Iterator<E> iterator() {
        return new HashIterator();
    }

    private class HashIterator implements Iterator<E> {
        private ArrayList<E> lista = new ArrayList<>();
        private int nuvarande = 0;
        public HashIterator() {
            for(int i = 0; i < storlek; i++) {
                if(hashtable[i] != null){
                    lista.addAll(hashtable[i]);
                }
            }
        }
        public boolean hasNext() {
            if(nuvarande < lista.size()){
                return true;
            }
            return false;
        }
        @Override
        public E next() {
            return lista.get(nuvarande++);
        }
    }
}