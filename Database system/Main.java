package projektPC2;

import file_write_treemap.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//public AFilm(String name, String director, String year) {
        AFilm a = new AFilm("Shrek", "Andrew Perkinsont", 2008,10);
        AFilm b = new AFilm("Shrek2", "Andrew Hopkin", 2009, 15);

        HFilm c = new HFilm("Pelisky", "Pavel Hopkin", 2020);
        HFilm d = new HFilm("Slunce", "Marek Hopkin", 2015);

        Actor act = new Actor("Andy", "Harper");
        Actor act1 = new Actor("Pavel", "Bezruc");

        //vytvoření arraylistu pro herce pro jednodušší práci
        ArrayList<Actor> actorlist = new ArrayList<Actor>();
        //přidání herců do listu
        actorlist.add(act);
        actorlist.add(act1);

        //zavolání funkce, která priradi film k herci navzájem
        prirad(a, act);
        prirad(b, act);
        prirad(c, act1);
        prirad(d, act1);

        //pridani hodnoceni filmu
        a.addReview(10);
        a.addReview(9);
        c.addReview(3);
        c.addReview(4);
        //vytvoreni hlavniho listu, do ktereho se ukladaji filmy, podle klice String - jmeno filmu
        TreeMap<String, Film> list = new TreeMap<String, Film>();
        //pridani filmu do list - klic jmeno filmu
        list.put(a.getName(), a);
        list.put(b.getName(), b);
        list.put(c.getName(), c);
        list.put(d.getName(), d);



        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while(run) {
            System.out.println("");
            System.out.println("1. Info o filmu");
            System.out.println("2. Upravení filmu");
            System.out.println("3. Smazání filmu");
            System.out.println("4. Přidání hodnocení danému filmu");
            System.out.println("5. Vypsat filmy");
            System.out.println("6. Přidání filmu");
            System.out.println("7. Výpis herců nebo animátorů, kteří se podíleli na více než jednom filmu");
            System.out.println("8. Výpis všech filmů, které obsahují konkrétního herce nebo animátora ");
            System.out.println("9. Uložení informace o vybraném filmu");
            System.out.println("10. Načtení všech informací o daném filmu ze souboru ");
            System.out.println("11. Přidání herce/animátora k filmu");
            System.out.println("12. Odebrani herce/animátora od filmu");


            Integer volba = Inputs.pouzeCislo(1, 12);    //zavolani funkce v tride Inputs - rozsah cisel 1-11 v pripade spatneho vstupu hlasi chybu
            switch (volba) {
                case 1:
                    System.out.println("Zadejte název filmu:");
                    //java.util.Scanner sc = new java.util.Scanner(System.in);
                    String in = sc.nextLine();

                    Film info = list.get(in);               //do promenne info se dostane objekt film podle jmena(klic v treemap)
                    if (info instanceof HFilm) {        //pokud info je HFilm (hrany film
                        System.out.println("Jméno: " + info.getName() + ", režisér: " + info.getDirector() + ", rok: " + info.getYear());
                        System.out.println("Seznam herců:");
                        info.printActor();          //zavolani funkce, ktera vypise herce
                        System.out.println("Hodnocení diváků:");
                        info.printReview();     //zavolani funkce, ktera vypise hodnoceni
                    } else {            //pokud info je AFilm  (animovany film)
                        System.out.println("Jméno: " + info.getName() + ", režisér: " + info.getDirector() + ", rok: " + info.getYear() + ", doporučený věk diváka: " + info.getRecomendage());
                        System.out.println("Seznam herců:");
                        info.printActor();
                        System.out.println("Hodnocení diváků:");
                        info.printReview();
                    }
                    break;

                case 2:
                    System.out.println("Zadejte název filmu:");
                    //java.util.Scanner sc = new java.util.Scanner(System.in);

                    //b) Upravení filmu – uživatel vybere film podle názvu a může provést úpravu názvu, režiséra, roku
                    //vydání, seznamu herců nebo animátorů a v případě animovaných filmů i doporučený věk diváků.
                    String in1 = sc.nextLine();
                    Film info1 = list.get(in1);
                    if (info1 == null) {          //pokud zadáno špatné jmeno filmu
                        System.out.println("Film není v databázi.");
                    } else {
                        if (info1 instanceof HFilm) {
                            System.out.println("Zadejte název filmu:");
                            String in2 = sc.nextLine();
                            System.out.println("Zadejte název režiséra:");
                            String in3 = sc.nextLine();
                            System.out.println("Zadejte rok vydání:");
                            Integer in4 = Inputs.pouzeCislo(0, 2024);
                            info1.setName(in2);
                            info1.setDirector(in3);  //nastavení nového rezisera
                            info1.setYear(in4);
                        } else {
                            System.out.println("Zadejte název filmu:");
                            String in2 = sc.nextLine();
                            System.out.println("Zadejte název režiséra:");
                            String in3 = sc.nextLine();
                            System.out.println("Zadejte rok vydání:");
                            Integer in4 = Inputs.pouzeCislo(0, 2024);
                            System.out.println("Zadejte doporučený věk diváků:");
                            Integer in5 = Inputs.pouzeCislo(0, 100);
                            info1.setName(in2);
                            info1.setDirector(in3);
                            info1.setYear(in4);
                            info1.setRecomendage(in5);
                        }
                    }
                    break;
                //c) Smazání filmu – uživatel vybere film podle názvu a smaže ho ze seznamu.
                case 3:
                    System.out.println("Zadejte název filmu:");

                    String in6 = sc.nextLine();
                    Film info3 = null;
                    boolean flag2 = false;      //pomocny boolean pro osetreni podminky
                    try {
                        info3 = list.get(in6);
                        //System.out.println(info3.getName());
                        list.remove(info3.getName());       //smazani filmu z list, podle klice jmeno filmu

                    } catch (NullPointerException e) {      //pri chybe, kdyz se zada spatne jmeno filmu
                        System.out.println("Film není v databázi.");
                        flag2 = true;
                    }
                    if (!flag2) {     //kdyz flag2 = false
                        System.out.println("Film byl smazán");
                    }
                    break;
                case 4:

                    System.out.println("Zadejte název filmu:");

                    String in7 = sc.nextLine();
                    Film info4 = null;
                    boolean flag10 = false;
                    info4 = list.get(in7);
//                    try {
//                        info4 = list.get(in7);      //jestli je zadane spravne jmeno filmu
//
//                    } catch (NullPointerException e) {
//
//                    }
                    if (info4 == null) {          //pokud info4 = null, to znamená že se zadalo špatné jmeno a do toho info4 se nic neodkázalo
                        System.out.println("Film není v databízi.");
                    } else {
                        if (info4 instanceof HFilm) {         //pokud info4 je HFilm
                            System.out.println("Zadejte počet hvězdiček 1-5:");
                            Integer in8 = Inputs.pouzeCislo(1, 5);       //hodnocení od 1-5
                            info4.addReview(in8);       //pridani hodnoceni filmu
                        } else {
                            System.out.println("Zadejte bodové hodnocení 1-10:");
                            Integer in9 = Inputs.pouzeCislo(1, 10);
                            info4.addReview(in9);
                        }
                    }
                    break;

                case 5:     //Výpis filmů – uživatel může nechat vypsat všechny filmy, přičemž se zobrazí název, režisér,
                    // rok vydání a seznam herců nebo animátorů a v případě animovaného filmu doporučený věk diváků.

                    Iterator<Film> iterator = list.values().iterator();     //iterator, kterým se přeiteruje celý ten list
                    while (iterator.hasNext()) {        //dokud je něco v listu

                        //System.out.println(iterator.next());
                        iterator.next().printInfo();        //spustí se funkce, která vypíše info, AFilm a HFilm to mají jinak trochu..

                    }
                    break;

                case 6:
                    //a) Přidání nového filmu – uživatel vybere druh filmu, zadá název, režiséra, rok vydání a případně
                    //seznam herců nebo animátorů. Pokud jde o animovaný film, uživatel zadá kromě názvu, režiséra a roku
                    //vydání také doporučený věk diváka.
                    System.out.println("Veberte druh filmu");
                    System.out.println("1 - Hraný film");
                    System.out.println("2 - Animovaný film");
                    Integer in8 = Inputs.pouzeCislo(1, 2);

                    System.out.println("Zadejte název filmu:");
                    String in2 = sc.nextLine();
                    System.out.println("Zadejte název režiséra:");
                    String in3 = sc.nextLine();
                    System.out.println("Zadejte rok vydání:");
                    Integer in4 = Inputs.pouzeCislo(0, 2024);
                    if (in8 == 1) {       //pokud se jednná o Hraný film
                        HFilm f = new HFilm(in2, in3, in4); //vytvoreni noveho objektu,
                        list.put(f.getName(), f);       //pridani filmu do listu, klic jmeno
                    } else {
                        System.out.println("Zadejte doporučený věk diváků:");   //kdyz jde o animovany film
                        Integer in5 = Inputs.pouzeCislo(0, 100);
                        AFilm g = new AFilm(in2, in3, in4, in5);
                        list.put(g.getName(), g);
                    }
                    break;

                case 7:
                    for (Actor a1 : actorlist) {        //for cyklus, ktery proiteruje celý Arraylist actorlist
                        if (a1.getFilmlist().size() > 1) {            //kdyz má Actor více, než 1 film
                            a1.printFilms();        //spustí se funkce, která vypíše filmy
                        }
                    }
                    break;

                case 8:
                    ////h) Výpis všech filmů, které obsahují konkrétního herce nebo animátora – uživatel zadá jméno herce
                    ////nebo animátora a zobrazí se mu seznam filmů, ve kterých hrál nebo na kterých se podílel.
                    System.out.println("Zadejte jméno herce/animátora:");
                    String in10 = sc.nextLine();
                    System.out.println("Zadejte přijmení herce/animátora:");
                    String in11 = sc.nextLine();
                    Actor a5 = null;
                    for (Actor a2 : actorlist) {            //for cyklus, ktery proiteruje celý Arraylist actorlist
                        if (a2.getFirstname().equals(in10) && a2.getLastname().equals(in11)) {        //kdyz u toho objektu je stejné jmeno a prijmeni jako jsi zadal
                            a5 = a2;                //do a5 se odkáže ten objekt, který splnuje podminku
                        }
                    }
                    if (a5 == null) {        //kdyz spatne zadane jmeno herce
                        System.out.println("Zadali jste špatné jméno herce/animátora.");
                    } else {
                        a5.printFilms();
                    }
                    break;

                case 9:
                    System.out.println("Zadejte název filmu:");
                    String in12 = sc.nextLine();
                    Film info5 = null;
                    info5 = list.get(in12);
//                    try {
//                        info5 = list.get(in12);
//                    } catch (Exception e) {
//                        System.out.println(e);
//                    }
                    if (info5 == null) {
                        System.out.println("Film není v databázi.");
                    } else {
                        try {           //výpis do souboru, nutné si předělat cestu k souboru
                            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\honky\\Desktop\\test.txt"));       //predelat tady tu cestu
                            if (info5 instanceof AFilm) {     //pokud objekt info5 je Animovany film..
                                bw.write(info5.getName() + ";" + info5.getDirector() + ";" + info5.getYear() + ";" + info5.getRecomendage());
                            } else {    //pokud objekt info5 je Hrany film..
                                bw.write(info5.getName() + ";" + info5.getDirector() + ";" + info5.getYear());   //tohle se vypise do souboru
                                //bw.newLine();   //novy radek v .txt
                                //bw.write(info5.getName());
                            }
                            bw.close();         //uzavreni souboru
                        } catch (Exception ex) {            //catch na exception
                            return;
                        }
                    }
                    break;

                case 10:
                    File file = new File("C:\\Users\\xhonky00\\Desktop\\test.txt");     //cesta k souboru - predelat
                    Scanner scan = null;
                    try {
                        scan = new Scanner(file);
                        while (scan.hasNextLine()) {        //dokud jsou v řádku další řádky
                            String line = scan.nextLine();          //do line se dá aktuální rádek
                            String[] lineArray = line.split(";");       //rozsekání stringu podle pomocné ; na části - uložení do pole lineArray
                            if (lineArray.length == 4) {          //pokud délka pole je 4 - animovany film
                                System.out.println("Animovaný film, jméno: " + lineArray[0] + ", režisér: " + lineArray[1] + ", rok vydání: " + lineArray[2] + ", doporučený věk: " + lineArray[3]);
                            } else {
                                System.out.println("Hraný film, jméno: " + lineArray[0] + ", režisér: " + lineArray[1] + ", rok vydání: " + lineArray[2]);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 11:        //prirazeni herce k filmu

                    System.out.println("Zadejte název filmu:");
                    String in14 = sc.nextLine();
                    Film info6 = null;

                    try {
                        info6 = list.get(in14);
                    } catch (NullPointerException e) {
                        System.out.println("ef");
                    }
                    if (info6 == null) {          //stejne jak predtim
                        System.out.println("Film není v databázi.");
                        break;
                    }

                    System.out.println("1 - existující herec/animátor");
                    System.out.println("2 - nový herec/animátor");
                    Integer in15 = Inputs.pouzeCislo(1, 2);
                    if (in15 == 1) {
                        System.out.println("Zadejte jméno herce/animátora:");
                        String in20 = sc.nextLine();
                        System.out.println("Zadejte přijmení herce/animátora:");
                        String in21 = sc.nextLine();
                        boolean flag3 = false;
                        Actor a10 = null;
                        for (Actor a2 : actorlist) {            //proiteruje se cely ten actorlist
                            if (a2.getFirstname().equals(in20) && a2.getLastname().equals(in21)) {            //pokud objekt a2 má stejné jmeno a prijmeni jake jste zadali
                                a10 = a2;
                                flag3 = true;       //pomocna promena
                            }
                        }
                        if (!flag3) {
                            System.out.println("Zadali jste špatné jméno herce/animátora.");        //pokud spatne jmeno
                        }
                        if (flag3) {
                            prirad(info6, a10);     //pokud spravne jmeno, spusti se funkce, priradi film k hercovi a naopak
                        }
                    } else {
                        System.out.println("Zadejte jméno herce/animátora:");
                        String in18 = sc.nextLine();
                        System.out.println("Zadejte přijmení herce/animátora:");
                        String in19 = sc.nextLine();
                        Actor a12 = new Actor(in18, in19);      //vytvoreni noveho objektu
                        actorlist.add(a12);
                        prirad(info6, a12);
                    }
                    break;

                case 12:
                    boolean run2 = true;
                    Film filmz = null;
                    while (run2) {
                        System.out.println("Zadejte nazev filmu");
                        String in18 = sc.nextLine();
                        filmz = list.get(in18);
                        if (filmz == null) {
                            System.out.println("Zadali jste špatný název filmu.");
                        } else {
                            break;
                        }
                    }

                    Actor a11 = null;
                    boolean run3 = true;
                    while (run3) {
                        System.out.println("Zadejta jmeno herce/animatora");
                        String in19 = sc.nextLine();
                        System.out.println("Zadejta prijmeni herce/animatora");
                        String in20 = sc.nextLine();

                        boolean flag3 = false;
                        for (Actor a2 : actorlist) {
                            if (a2.getFirstname().equals(in19) && a2.getLastname().equals(in20)) {
                                a11 = a2;
                                flag3 = true;
                            }
                        }
                        if (!flag3) {
                            System.out.println("Zadali jste špatné jmeno herce.");
                        }else{
                            run3 = false;
                        }
                    }

                    boolean flag24 = false;
                    for (Actor a21 : filmz.getActorlist()) {
                        if (a21 == a11) {
                              flag24 = true;
                              break;
                         }
                    }
                    if (flag24) {
                         oddelej(filmz, a11);
                    } else {
                         System.out.println("Herec neučinkoval v daném filmu.");
                    }
            }
        }
    }

    private static void prirad(Film film, Actor a) {
        film.addActor(a);         //k filmu se prida do listu herec
        a.addFilm(film);          //k herci se prida do listu film
    }
    private static void oddelej(Film film, Actor a) {       //odebrani herce od filmu navzajem
        film.removeActor(a);
        a.removeFilm(film);
    }

}
