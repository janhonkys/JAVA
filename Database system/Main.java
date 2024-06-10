package projektPC2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Main {
    static TreeMap<String, Film> filmList = new TreeMap<String, Film>();
    static HashSet<Actor> actorList = new HashSet<Actor>();
    private static final String FILE_PATH = "C:\\Users\\honky\\Desktop\\test.txt";

    public static void main(String[] args) {

        AFilm a = new AFilm("Shrek", "Andrew Perkinsont", 2008,10);
        AFilm b = new AFilm("Shrek2", "Andrew Hopkin", 2009, 15);

        HFilm c = new HFilm("Pelisky", "Pavel Hopkin", 2020);
        HFilm d = new HFilm("Slunce", "Marek Hopkin", 2015);

        Actor act = new Actor("Andy", "Harper");
        Actor act1 = new Actor("Pavel", "Bezruc");

        actorList.add(act);
        actorList.add(act1);

        addFilmToActor(a, act);
        addFilmToActor(b, act);
        addFilmToActor(c, act1);
        addFilmToActor(d, act1);

        a.addReview(10);
        a.addReview(9);
        c.addReview(3);
        c.addReview(4);

        filmList.put(a.getName(), a);
        filmList.put(b.getName(), b);
        filmList.put(c.getName(), c);
        filmList.put(d.getName(), d);

        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while(run) {
            System.out.println("");
            System.out.println("1. Info about film");
            System.out.println("2. Edit film");
            System.out.println("3. Delete film");
            System.out.println("4. Add rating to the film");
            System.out.println("5. Print films");
            System.out.println("6. Add film");
            System.out.println("7. List of actors or animators who have appeared in more than one film");
            System.out.println("8. List of all movies that contain a specific actor or animator ");
            System.out.println("9. Save info about the selected movie to file");
            System.out.println("10. Load all information about films from the file");
            System.out.println("11. Adding an actor/animator to a film");
            System.out.println("12. Remove the actor/animator from the film");
            System.out.println("13. Print actors");

            int volba = Inputs.onlyNumbers(1, 13);
            switch (volba) {
                case 1:
                    Film info = findfilm();
                    info.printInfo();
                    info.printReview();
                    break;

                case 2:
                    Film filmToUpdate = findfilm();
                    filmList.remove(filmToUpdate.getName());
                    System.out.println("Zadejte nový název filmu:");
                    String newName = Inputs.nameAndDigit();
                    System.out.println("Zadejte název režiséra:");
                    String newDirector = Inputs.onlyName();
                    System.out.println("Zadejte rok vydání:");
                    int newYear  = Inputs.onlyNumbers(0, 2024);
                    filmToUpdate.setName(newName);
                    filmToUpdate.setDirector(newDirector);
                    filmToUpdate.setYear(newYear);
                    if(filmToUpdate instanceof AFilm){
                        System.out.println("Zadejte doporučený věk diváků:");
                        int recommendedAge = Inputs.onlyNumbers(0, 100);
                        ((AFilm) filmToUpdate).setRecommendedAge(recommendedAge);
                    }
                    filmList.put(filmToUpdate.getName(), filmToUpdate);
                    break;

                case 3:
                    Film filmToDelete = findfilm();
                    filmList.remove(filmToDelete.getName());
                    System.out.println("Film byl smazán.");
                    break;

                case 4:
                    Film film = findfilm();
                    if (film instanceof HFilm) {
                         System.out.println("Zadejte počet hvězdiček 1-5:");
                         int rating = Inputs.onlyNumbers(1, 5);
                         film.addReview(rating);
                    } else {
                         System.out.println("Zadejte bodové hodnocení 1-10:");
                         int rating = Inputs.onlyNumbers(1, 10);
                         film.addReview(rating);
                    }
                    break;

                case 5:
                    if (filmList.isEmpty()) {
                        System.out.println("No films available in the database.");
                    } else {
                        for (Film film1 : filmList.values()) {
                            film1.printInfo();
                        }
                    }
                    break;

                case 6:
                    System.out.println("Veberte druh filmu");
                    System.out.println("1 - Hraný film");
                    System.out.println("2 - Animovaný film");
                    int choice = Inputs.onlyNumbers(1, 2);

                    System.out.println("Zadejte název filmu:");
                    String filmName = Inputs.nameAndDigit();
                    System.out.println("Zadejte název režiséra:");
                    String directorName = Inputs.onlyName();
                    System.out.println("Zadejte rok vydání:");
                    int year = Inputs.onlyNumbers(0, 2024);
                    Film newFilm;
                    if (choice == 1) {
                        newFilm = new HFilm(filmName, directorName, year);
                    } else {
                        System.out.println("Zadejte doporučený věk diváků:");
                        int recommendedAge = Inputs.onlyNumbers(0, 100);
                        newFilm = new AFilm(filmName, directorName, year, recommendedAge);
                    }
                    filmList.put(newFilm.getName(), newFilm);
                    break;

                case 7:
                    for (Actor actor : actorList) {
                        if (actor.getFilms().size() > 1) {
                            actor.printFilms();
                        }
                    }
                    break;

                case 8:
                    Actor actor = findActor();
                    actor.printFilms();
                    break;

                case 9:
                    Film filmToSave = findfilm();
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                         if(new File(FILE_PATH).length() != 0){
                             bw.newLine();
                         }
                         if (filmToSave instanceof AFilm) {
                             bw.write(filmToSave.getName() + ";" + filmToSave.getDirector() + ";" + filmToSave.getYear() + ";" + ((AFilm) filmToSave).getRecommendedAge());
                         } else {
                             bw.write(filmToSave.getName() + ";" + filmToSave.getDirector() + ";" + filmToSave.getYear());
                         }
                         bw.close();
                    } catch (Exception ex) {
                         return;
                    }
                    System.out.println("Film "+filmToSave.getName()+ " was saved to file.");
                    break;

                case 10:
                    File file = new File(FILE_PATH);
                    if(!file.exists()){
                        System.err.println("File not found: "+FILE_PATH);
                        return;
                    }
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
                    Film film2 = findfilm();
                    Actor actor2;
                    System.out.println("1 - existující herec/animátor");
                    System.out.println("2 - nový herec/animátor");
                    int choice2 = Inputs.onlyNumbers(1, 2);

                    if (choice2 == 1) {
                        actor2 = findActor();
                    } else {
                        System.out.println("Zadejte jméno herce/animátora:");
                        String actorName3 = Inputs.onlyName();
                        System.out.println("Zadejte přijmení herce/animátora:");
                        String actorSurname3 = Inputs.onlyName();
                        actor2 = new Actor(actorName3, actorSurname3);
                        actorList.add(actor2);
                    }
                    addFilmToActor(film2, actor2);
                    break;

                case 12:
                    Film findFilm4 = findfilm();
                    Actor actor4 = findActor();
                    if(findFilm4.getActors().contains(actor4)){
                        removeFilmFromActor(findFilm4, actor4);
                        System.out.println("Person was removed from the film.");
                    }else {
                        System.out.println("Person is not in film list.");
                    }
                    break;

                case 13:
                    if(actorList.isEmpty()){
                        System.out.println("No actors in the list.");
                    }else{
                        for(Actor actor3 : actorList){
                            actor3.printFilms();
                        }
                    }
                    break;
            }
        }
    }

    private static Actor findActor() {
        Scanner sc = new Scanner(System.in);
        Actor actor = null;
        boolean found = false;
        if(actorList.isEmpty()){
            System.out.println("Seznam herců je prázdný");
            return null;
        }
        while(!found) {
            System.out.println("Zadejte jméno:");
            String actorName = Inputs.onlyName();
            System.out.println("Zadejte příjmení:");
            String actorSurname = Inputs.onlyName();
            for (Actor actor2 : actorList) {
                if (actor2.getFirstName().equals(actorName) && actor2.getLastName().equals(actorSurname)) {
                    actor = actor2;
                    break;
                }
            }
            if (actor == null) {
                System.out.println("Herec/animátor není v databázi.");
            } else {
                found = true;
            }
        }
        return actor;
    }

    private static Film findfilm() {
        Scanner sc = new Scanner(System.in);
        Film film = null;
        boolean found = false;
        if(filmList.isEmpty()){
            return null;
        }
        while(!found) {
            System.out.println("Zadejte název filmu:");
            String input = Inputs.nameAndDigit();
            film = filmList.get(input);
            if (film == null) {
                System.out.println("Film není v databázi.");
            } else {
                found = true;
            }
        }
        return film;
    }

    private static void addFilmToActor(Film film, Actor a) {
        film.addActor(a);
        a.addFilm(film);
    }
    private static void removeFilmFromActor(Film film, Actor a) {
        film.removeActor(a);
        a.removeFilm(film);
    }
}
