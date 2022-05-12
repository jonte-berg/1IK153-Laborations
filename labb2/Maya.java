package com.example.labb2;


import java.util.Objects;

public class Maya implements Comparable<Maya>  {
    private String namn;
    private String typ;
    private String beskrivning;

    public Maya(String s){

        this.namn=  s;
    }



    public Maya(String namn, String typ, String beskrivning) {
        this.namn = namn;
        this.typ = typ;
        this.beskrivning = beskrivning;
    }

    public String getNamn() {
        return this.namn;
    }


    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }
@Override
public String toString(){
        return ""+this.getNamn()+" ("+this.getTyp()+") ";
}

    @Override
    public boolean equals(Object obj) {
        Maya temp = (Maya) obj;

        if(namn.equals(temp.getNamn()))
            return true;
        if (this==obj)
            return true;

        return false;


    }






    @Override
    public int compareTo(Maya o) {
        if ((int) this.getNamn().charAt(0) > (int) o.getNamn().charAt(0))
            return 1;
        else if ((int) this.getNamn().charAt(0) < (int) o.getNamn().charAt(0))
            return -1;
        else if((int) this.getNamn().charAt(0) == (int) o.getNamn().charAt(0)){
            //time to check more than one char
            for (int i=1;i<this.getNamn().length();i++){
                //when u finally find a different char in each string
                if((int)this.getNamn().charAt(i) != (int) o.getNamn().charAt(i)){

                    if ((int) this.getNamn().charAt(i) > (int) o.getNamn().charAt(i))
                        return 1;
                    else if ((int) this.getNamn().charAt(i) < (int) o.getNamn().charAt(i))
                        return -1;
                }
            }
            return 0;
        }
        else return 0;

    }

    @Override
    public int hashCode() {
        //obs, ifall två Maya objekt med samma namn men olika typer/beskrivningar existerar, kommer de generera SAMMA hash
        return Objects.hashCode(this.namn);
    }
}
