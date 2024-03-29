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

        AFilm a = new AFilm("Shrek", "Andrew Perkinsont", 2008,10);
        AFilm b = new AFilm("Shrek2", "Andrew Hopkin", 2009, 15);

        HFilm c = new HFilm("Pelisky", "Pavel Hopkin", 2020);
        HFilm d = new HFilm("Slunce", "Marek Hopkin", 2015);

        Actor act = new Actor("Andy", "Harper");
        Actor act1 = new Actor("Pavel", "Bezruc");


        ArrayList<Actor> actorlist = new ArrayList<Actor>();

        actorlist.add(act);
        actorlist.add(act1);


        prirad(a, act);
        prirad(b, act);
        prirad(c, act1);
        prirad(d, act1);


        a.addReview(10);
        a.addReview(9);
        c.addReview(3);
        c.addReview(4);

        TreeMap<String, Film> list = new TreeMap<String, Film>();

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


            Integer volba = Inputs.pouzeCislo(1, 12);
            switch (volba) {
                case 1:
                    System.out.println("Zadejte název filmu:");

                    String in = sc.nextLine();

                    Film info = list.get(in);
                    if (info instanceof HFilm) {
                        System.out.println("Jméno: " + info.getName() + ", režisér: " + info.getDirector() + ", rok: " + info.getYear());
                        System.out.println("Seznam herců:");
                        info.printActor();
                        System.out.println("Hodnocení diváků:");
                        info.printReview();
                    } else {
                        System.out.println("Jméno: " + info.getName() + ", režisér: " + info.getDirector() + ", rok: " + info.getYear() + ", doporučený věk diváka: " + info.getRecomendage());
                        System.out.println("Seznam herců:");
                        info.printActor();
                        System.out.println("Hodnocení diváků:");
                        info.printReview();
                    }
                    break;

                case 2:
                    System.out.println("Zadejte název filmu:");

                    String in1 = sc.nextLine();
                    Film info1 = list.get(in1);
                    if (info1 == null) {
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
                            info1.setDirector(in3);
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

                case 3:
                    System.out.println("Zadejte název filmu:");

                    String in6 = sc.nextLine();
                    Film info3 = null;
                    boolean flag2 = false;
                    try {
                        info3 = list.get(in6);

                        list.remove(info3.getName());

                    } catch (NullPointerException e) {
                        System.out.println("Film není v databázi.");
                        flag2 = true;
                    }
                    if (!flag2) {
                        System.out.println("Film byl smazán");
                    }
                    break;
                case 4:

                    System.out.println("Zadejte název filmu:");

                    String in7 = sc.nextLine();
                    Film info4 = null;
                    boolean flag10 = false;
                    info4 = list.get(in7);

                    if (info4 == null) {
                        System.out.println("Film není v databízi.");
                    } else {
                        if (info4 instanceof HFilm) {
                            System.out.println("Zadejte počet hvězdiček 1-5:");
                            Integer in8 = Inputs.pouzeCislo(1, 5);
                            info4.addReview(in8);
                        } else {
                            System.out.println("Zadejte bodové hodnocení 1-10:");
                            Integer in9 = Inputs.pouzeCislo(1, 10);
                            info4.addReview(in9);
                        }
                    }
                    break;

                case 5:
                    Iterator<Film> iterator = list.values().iterator();
                    while (iterator.hasNext()) {

                        iterator.next().printInfo();

                    }
                    break;

                case 6:


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
                    if (in8 == 1) {
                        HFilm f = new HFilm(in2, in3, in4);
                        list.put(f.getName(), f);
                    } else {
                        System.out.println("Zadejte doporučený věk diváků:");
                        Integer in5 = Inputs.pouzeCislo(0, 100);
                        AFilm g = new AFilm(in2, in3, in4, in5);
                        list.put(g.getName(), g);
                    }
                    break;

                case 7:
                    for (Actor a1 : actorlist) {
                        if (a1.getFilmlist().size() > 1) {
                            a1.printFilms();
                        }
                    }
                    break;

                case 8:

                    System.out.println("Zadejte jméno herce/animátora:");
                    String in10 = sc.nextLine();
                    System.out.println("Zadejte přijmení herce/animátora:");
                    String in11 = sc.nextLine();
                    Actor a5 = null;
                    for (Actor a2 : actorlist) {
                        if (a2.getFirstname().equals(in10) && a2.getLastname().equals(in11)) {
                            a5 = a2;
                        }
                    }
                    if (a5 == null) {
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

                    if (info5 == null) {
                        System.out.println("Film není v databázi.");
                    } else {
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\honky\\Desktop\\test.txt"));
                            if (info5 instanceof AFilm) {
                                bw.write(info5.getName() + ";" + info5.getDirector() + ";" + info5.getYear() + ";" + info5.getRecomendage());
                            } else {
                                bw.write(info5.getName() + ";" + info5.getDirector() + ";" + info5.getYear());
                            }
                            bw.close();
                        } catch (Exception ex) {
                            return;
                        }
                    }
                    break;

                case 10:
                    File file = new File("C:\\Users\\xhonky00\\Desktop\\test.txt");
                    Scanner scan = null;
                    try {
                        scan = new Scanner(file);
                        while (scan.hasNextLine()) {
                            String line = scan.nextLine();
                            String[] lineArray = line.split(";");
                            if (lineArray.length == 4) {
                                System.out.println("Animovaný film, jméno: " + lineArray[0] + ", režisér: " + lineArray[1] + ", rok vydání: " + lineArray[2] + ", doporučený věk: " + lineArray[3]);
                            } else {
                                System.out.println("Hraný film, jméno: " + lineArray[0] + ", režisér: " + lineArray[1] + ", rok vydání: " + lineArray[2]);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 11:

                    System.out.println("Zadejte název filmu:");
                    String in14 = sc.nextLine();
                    Film info6 = null;

                    try {
                        info6 = list.get(in14);
                    } catch (NullPointerException e) {
                        System.out.println("ef");
                    }
                    if (info6 == null) {
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
                        for (Actor a2 : actorlist) {
                            if (a2.getFirstname().equals(in20) && a2.getLastname().equals(in21)) {
                                a10 = a2;
                                flag3 = true;
                            }
                        }
                        if (!flag3) {
                            System.out.println("Zadali jste špatné jméno herce/animátora.");
                        }
                        if (flag3) {
                            prirad(info6, a10);
                        }
                    } else {
                        System.out.println("Zadejte jméno herce/animátora:");
                        String in18 = sc.nextLine();
                        System.out.println("Zadejte přijmení herce/animátora:");
                        String in19 = sc.nextLine();
                        Actor a12 = new Actor(in18, in19);
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
        film.addActor(a);
        a.addFilm(film);
    }
    private static void oddelej(Film film, Actor a) {
        film.removeActor(a);
        a.removeFilm(film);
    }

}
