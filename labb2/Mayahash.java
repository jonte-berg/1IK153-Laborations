package com.example.labb2;

public class Mayahash {
    public static void main(String[] args) {
        hashtabell<Maya> gudar = new hashtabell<>();
        gudar.add(new Maya("Chaac", "Regn och åska", "Chaac är mestadels en grupp åskgudar med anknytning till regn i mayaindianernas mytologi. De ansågs välvilligt inställda gentemot människorna och förknippades också med fruktbarhet och var därför viktiga som lantbruksgudar."));
        gudar.add(new Maya("Ah Puch", "Döden", "Ah Puch eller Ah Puh var i mayaindianernas mytologi en dödsgud, och härskare över Metnal, det värsta av de nio helvetena i underjorden, Xibalba."));
        gudar.add(new Maya("Bolon Dzacab", "Förfader", "Bolon Dzacab är en förfadersgud hos Mayafolket i dagens Mexiko. Han avbildas på monument som attribut för prominenta personer."));
        gudar.add(new Maya("Camazotz", "Fladdermus", "Camazotz, även benämnd Zotz, var en fladdermusgud i mayansk mytologi som härskade över det mörka \"fladdermusrummet\"[1]. Rummet låg i underjorden (Xibalba) och var omöjligt att fly från. Det finns också en bok som handlar om Camazotz. Det sägs att han hade ett tempel där en av fyra amuletter förvarades. En amulett såg ut som en fladdermus, en som en krona, och en som en halvmåne, och den sista ett öga. När de fyra amuletterna sammanfördes, skulle evig ondska härska (enligt mayansk tro)."));
        gudar.add(new Maya("Hunahpu", "Skapelse", "Hunahpu eller Hunahpu-Vuch var en skapelsegud hos mayafolket i Mexiko men också gryningens och solens gud.\n" + "Hunahpu intog olika gestalter och förknippades ibland med rävhonan och koyoten. Dock finns en förmodligen distinkt gestalt som bär samma namn, nämligen den ungdomlige hjälte som tillsammans med sin tvillingbror Xbalanque bekämpade Vucub-Caquix och hans högfärdiga söner.\n" + "\"Vuch\" är den korta skymningstiden precis innan gryningen."));
        gudar.add(new Maya("Ah Kinchil", "Sol", "Ah Kinchil eller Kinich Ahau (med flera namnformer) var i mytologin hos mayaindianerna en solgud med samma yttre kännetecken som Itzamna."));
        gudar.add(new Maya("Ix Ch'up", "Måne", "Ix Ch'up (\"Kvinnan\") var mångudinna hos mayaindianerna i Mexiko."));
        gudar.add(new Maya("Gucumatz", "Skapelse och orm", "Gucumatz deltog i alltings skapelse men hörde av allt att döma inte till de omnipotentas krets. Han misslyckades vid ett par tillfällen att skapa livskraftiga och dugliga varelser, varpå flera släkten gick under i översvämningar eller förvandlades till apor. Till slut skapade han och hans efterträdare Tepeu människan av majs och lyckades få till en varelse god nog att hylla gudarna och bringa dem gåvor."));
        gudar.add(new Maya("Kukulcán", "Krig", "Kukulcán (av Kukul, befjädrad och can, orm), även känd som Quetzalcóatl, var en av de viktigaste gudarna hos Maya- och Toltekindianerna i Mexiko.\n" + "Kukulcán framställs på byggnaderna i Yucatan och Teotihuakan som en befjädrad orm. I legenderna om honom berättas det att han anlände från väst och grundade sitt kungarike i Chichén Itzá. Han identifierades också med planeten Venus och kallas även Venus."));

        /* för felsökning
        System.out.println("\n---------------------\n");
        gudar.displayTable();
        */

        for(Maya m: gudar) {
            System.out.println(m.getNamn());
        }
        System.out.println();

        if(gudar.contains(new Maya("Hunahpu"))){
            System.out.println("Hittades!");
        } else {
            System.out.println("Fanns inte!");
        }

        if(gudar.contains(new Maya("Itzamná"))){
            System.out.println("Hittades!");
        } else {
            System.out.println("Fanns inte!");
        }

        System.out.println();
        gudar.add(new Maya("Itzamná", "Skapelse", "Itzamná (\"Ödlehuset\") var i mytologin hos mayaindianerna i Mexiko den högste guden, make till Ix Chel. Gudens namn talar om Mayafolkets tro att jorden skapades av reptilödlors kroppar. tzamná tillskrevs skrivkonsten och associerades allmänt med kunskap och inlärning. Itzamná ansågs vara stamfader till alla andra gudar. Han och hans hustru gestaltades som ett gammalt par."));
        gudar.add(new Maya("Alom", "Moder", "Alom (al, son, alan, att föda, \"hon som föder söner\") är en modergudinna i Mayaindianernas mytologi."));
        gudar.add(new Maya("Cumhau", "Döden", "Cumhau var en dödsgud hos Mayaindianerna som härskade i en av världarna i deras underjord, Xibalba."));

        for(Maya m: gudar) {
            System.out.println(m.getNamn());
        }
        /* för felsökning
        System.out.println("\n---------------------\n");
        gudar.displayTable();
        */
        if(gudar.contains(new Maya("Itzamná"))){
            System.out.println("Hittades!");
        } else {
            System.out.println("Fanns inte!");
        }

        System.out.println("\nMin i gudlistan = "+gudar.Min());
        System.out.println("\nMax i gudlistan = "+gudar.Max());
    }
}