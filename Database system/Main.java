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

            int choice3 = Inputs.onlyNumbers(1, 13);
            switch (choice3) {
                case 1:
                    Film info = findfilm();
                    info.printInfo();
                    info.printReview();
                    break;

                case 2:
                    Film filmToUpdate = findfilm();
                    filmList.remove(filmToUpdate.getName());
                    System.out.println("Enter new name of the film:");
                    String newName = Inputs.nameAndDigit();
                    System.out.println("Enter name of director:");
                    String newDirector = Inputs.onlyName();
                    System.out.println("Enter year of release:");
                    int newYear = Inputs.onlyNumbers(0, 2024);
                    filmToUpdate.setName(newName);
                    filmToUpdate.setDirector(newDirector);
                    filmToUpdate.setYear(newYear);
                    if(filmToUpdate instanceof AFilm){
                        System.out.println("Enter recommended age of the viewers:");
                        int recommendedAge = Inputs.onlyNumbers(0, 100);
                        ((AFilm) filmToUpdate).setRecommendedAge(recommendedAge);
                    }
                    filmList.put(filmToUpdate.getName(), filmToUpdate);
                    break;

                case 3:
                    Film filmToDelete = findfilm();
                    filmList.remove(filmToDelete.getName());
                    System.out.println("Film was removed.");
                    break;

                case 4:
                    Film film = findfilm();
                    if (film instanceof HFilm) {
                         System.out.println("Enter number of stars 1-5:");
                         int rating = Inputs.onlyNumbers(1, 5);
                         film.addReview(rating);
                    } else {
                         System.out.println("Enter a point rating 1-10:");
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
                    System.out.println("Select a movie type");
                    System.out.println("1 - Feature film");
                    System.out.println("2 - Animated film");
                    int choice = Inputs.onlyNumbers(1, 2);

                    System.out.println("Enter the name of the movie:");
                    String filmName = Inputs.nameAndDigit();
                    System.out.println("Enter the director's name:");
                    String directorName = Inputs.onlyName();
                    System.out.println("Enter the year of publication:");
                    int year = Inputs.onlyNumbers(0, 2024);
                    Film newFilm;
                    if (choice == 1) {
                        newFilm = new HFilm(filmName, directorName, year);
                    } else {
                        System.out.println("Enter the recommended age of the viewers:");
                        int recommendedAge = Inputs.onlyNumbers(0, 100);
                        newFilm = new AFilm(filmName, directorName, year, recommendedAge);
                    }
                    filmList.put(newFilm.getName(), newFilm);
                    break;

                case 7:
                    if (actorList.isEmpty()) {
                        System.out.println("No actors in the database.");
                    } else {
                        for (Actor actor : actorList) {
                            if (actor.getFilms().size() > 1) {
                                actor.printFilms();
                            }
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
                                System.out.println("Animated film, name: " + lineArray[0] + ", director: " + lineArray[1] + ", year of publication: " + lineArray[2] + ", recommended age: " + lineArray[3]);
                            } else {
                                System.out.println("Feature film, name: " + lineArray[0] + ", director: " + lineArray[1] + ", year of publication: " + lineArray[2]);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 11:
                    Film film2 = findfilm();
                    Actor actor2;
                    System.out.println("1 - existing actor/animator");
                    System.out.println("2 - new actor/animator");
                    int choice2 = Inputs.onlyNumbers(1, 2);

                    if (choice2 == 1) {
                        actor2 = findActor();
                    } else {
                        System.out.println("Enter the name of the actor/animator:");
                        String actorName3 = Inputs.onlyName();
                        System.out.println("Enter the last name of the actor/animator:");
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
                        System.out.println("Actor was removed from the film.");
                    }else {
                        System.out.println("Actor is not in film list.");
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
        if(actorList.isEmpty()){
            System.out.println("Actor list is empty.");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        Actor actor = null;
        while(actor == null) {
            System.out.println("Enter name:");
            String actorName = Inputs.onlyName();
            System.out.println("Enter surname:");
            String actorSurname = Inputs.onlyName();
            for (Actor actor2 : actorList) {
                if (actor2.getFirstName().equals(actorName) && actor2.getLastName().equals(actorSurname)) {
                    actor = actor2;
                    break;
                }
            }
            if (actor == null) {
                System.out.println("Actor is not in database.");
            }
        }
        return actor;
    }

    private static Film findfilm() {
        if(filmList.isEmpty()){
            return null;
        }
        Scanner sc = new Scanner(System.in);
        Film film = null;
        while(film == null) {
            System.out.println("Enter film name:");
            String input = Inputs.nameAndDigit();
            film = filmList.get(input);
            if (film == null) {
                System.out.println("Film is not in database.");
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
