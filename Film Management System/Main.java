package projektPC2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 The Main class serves as the entry point for the Film and Actor Management system application.
 Users interact with the system through a menu-driven interface to perform various actions such as managing films, actors, and their details.
 The system allows users to add, edit, delete, and view information about films and actors.
 The system supports two types of films: Animated Films (AFilm) and Feature Films (HFilm).
 Users can save film details to a file and load them back into the application.

 @author Jan Honkyš

 */


// Main class for managing films and actors.
public class Main {

    // TreeMap to store films, using film names as keys
    private static TreeMap<String, Film> filmList = new TreeMap<String, Film>();

    // HashSet to store actors, ensuring uniqueness of actors
    private static HashSet<Actor> actorList = new HashSet<Actor>();

    // File path for saving and loading film information
    private static final String FILE_PATH = "C:\\Users\\honky\\Desktop\\test.txt";

    public static void main(String[] args) {

        // Creating sample films and actors
        AFilm a = new AFilm("Shrek", "Andrew Perkinsont", 2008,10);
        AFilm b = new AFilm("Shrek2", "Andrew Hopkin", 2009, 15);
        HFilm c = new HFilm("Pelisky", "Pavel Hopkin", 2020);
        HFilm d = new HFilm("Slunce", "Marek Hopkin", 2015);

        b.printInfo();
        a.printInfo();
        c.printInfo();
        d.printInfo();

        Actor act = new Actor("Andy", "Harper");
        Actor act1 = new Actor("Pavel", "Bezruc");

        // Adding actors to the actor list
        actorList.add(act);
        actorList.add(act1);

        // Adding films to the actors and adding actors to the films
        addFilmToActor(a, act);
        addFilmToActor(b, act);
        addFilmToActor(c, act1);
        addFilmToActor(d, act1);

        // Adding reviews to films
        a.addReview(10);
        a.addReview(9);
        c.addReview(3);
        c.addReview(4);

        // Adding films to the film list
        filmList.put(a.getName(), a);
        filmList.put(b.getName(), b);
        filmList.put(c.getName(), c);
        filmList.put(d.getName(), d);

        // Main menu
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

            // User choice input
            int choice3 = Inputs.onlyNumbers(1, 13);
            switch (choice3) {
                case 1:
                    // Display film information and reviews
                    Film info = findfilm(); // Find the selected film
                    info.printInfo(); // Print basic information about the film
                    info.printReview(); // Print reviews of the film
                    break;

                case 2:
                    // Edit film details
                    Film filmToUpdate = findfilm(); // Find the film to be edited
                    filmList.remove(filmToUpdate.getName()); // Remove the film from the database to update its details
                    System.out.println("Enter new name of the film:");
                    String newName = Inputs.nameAndDigit(); // Get the new name of the film
                    System.out.println("Enter name of director:");
                    String newDirector = Inputs.onlyName(); // Get the new director's name
                    System.out.println("Enter year of release:");
                    int newYear = Inputs.onlyNumbers(0, 2024); // Get the new release year
                    filmToUpdate.setName(newName); // Update the film's name
                    filmToUpdate.setDirector(newDirector); // Update the film's director
                    filmToUpdate.setYear(newYear); // Update the film's release year
                    if(filmToUpdate instanceof AFilm){  //If film is animated
                        System.out.println("Enter recommended age of the viewers:");
                        int recommendedAge = Inputs.onlyNumbers(0, 100); // Get the new recommended age
                        ((AFilm) filmToUpdate).setRecommendedAge(recommendedAge); // Update the recommended age for animated films
                    }
                    filmList.put(filmToUpdate.getName(), filmToUpdate); // Add the updated film back to the database
                    break;

                case 3:
                    // Remove film from database
                    Film filmToDelete = findfilm(); // Find the film to be deleted
                    filmList.remove(filmToDelete.getName()); // Remove the film from the database
                    System.out.println("Film was removed.");
                    break;

                case 4:
                    // Add review to a film
                    Film film = findfilm(); // Find the film to add a review
                    if (film instanceof HFilm) {
                        System.out.println("Enter number of stars 1-5:");
                        int rating = Inputs.onlyNumbers(1, 5); // Get the star rating
                        film.addReview(rating); // Add the star rating as a review
                    } else {
                        System.out.println("Enter a point rating 1-10:");
                        int rating = Inputs.onlyNumbers(1, 10); // Get the point rating
                        film.addReview(rating); // Add the point rating as a review
                    }
                    break;

                case 5:
                    // Print all films
                    if (filmList.isEmpty()) {
                        System.out.println("No films available in the database.");
                    } else {
                        for (Film film1 : filmList.values()) {
                            film1.printInfo(); // Print basic information about each film
                        }
                    }
                    break;

                case 6:
                    // Add a new film
                    System.out.println("Select a movie type");
                    System.out.println("1 - Feature film");
                    System.out.println("2 - Animated film");
                    int choice = Inputs.onlyNumbers(1, 2); // Choose between feature film and animated film
                    System.out.println("Enter the name of the movie:");
                    String filmName = Inputs.nameAndDigit(); // Get the name of the new film
                    System.out.println("Enter the director's name:");
                    String directorName = Inputs.onlyName(); // Get the director's name for the new film
                    System.out.println("Enter the year of publication:");
                    int year = Inputs.onlyNumbers(1900, 2024); // Get the release year for the new film
                    Film newFilm;
                    if (choice == 1) {
                        newFilm = new HFilm(filmName, directorName, year); // Create a new feature film
                    } else {
                        System.out.println("Enter the recommended age of the viewers:");
                        int recommendedAge = Inputs.onlyNumbers(0, 100); // Get the recommended age for the new animated film
                        newFilm = new AFilm(filmName, directorName, year, recommendedAge); // Create a new animated film
                    }
                    filmList.put(newFilm.getName(), newFilm); // Add the new film to the database
                    break;

                case 7:
                    // Print a list of actors who have appeared in more than one film
                    if (actorList.isEmpty()) {
                        System.out.println("No actors in the database.");
                    } else {
                        for (Actor actor : actorList) {
                            if (actor.getFilms().size() > 1) {
                                actor.printFilms();  // Print films in which the actor appeared
                            }
                        }
                    }
                    break;

                case 8:
                    // Print films of a specific actor
                    Actor actor = findActor(); // Find the actor
                    actor.printFilms(); // Print films in which the actor appeared
                    break;

                case 9:
                    // Save film information to a file
                    Film filmToSave = findfilm(); // Find the film to save
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                        if(new File(FILE_PATH).length() != 0){
                            bw.newLine(); // Add newline if file is not empty
                        }
                        if (filmToSave instanceof AFilm) {
                            bw.write(filmToSave.getName() + ";" + filmToSave.getDirector() + ";" + filmToSave.getYear() + ";" + ((AFilm) filmToSave).getRecommendedAge());
                        } else {
                            bw.write(filmToSave.getName() + ";" + filmToSave.getDirector() + ";" + filmToSave.getYear());
                        }
                    } catch (Exception ex) {
                        return; // Error handling
                    }
                    System.out.println("Film "+filmToSave.getName()+ " was saved to file.");
                    break;

                case 10:
                    // Load film information from a file
                    File file = new File(FILE_PATH);
                    if(!file.exists()){
                        System.err.println("File not found: "+FILE_PATH);
                        return; // Error handling
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
                        e.printStackTrace(); // Error handling
                    }
                    break;

                case 11:
                    // Add an actor/animator to a film
                    Film film2 = findfilm(); // Find the film
                    Actor actor2;
                    System.out.println("1 - existing actor/animator");
                    System.out.println("2 - new actor/animator");
                    int choice2 = Inputs.onlyNumbers(1, 2); // Choose between existing or new actor/animator

                    if (choice2 == 1) {
                        actor2 = findActor(); // Find the existing actor/animator
                    } else {
                        System.out.println("Enter the name of the actor/animator:");
                        String actorName3 = Inputs.onlyName(); // Get the name of the new actor/animator
                        System.out.println("Enter the last name of the actor/animator:");
                        String actorSurname3 = Inputs.onlyName(); // Get the last name of the new actor/animator
                        actor2 = new Actor(actorName3, actorSurname3); // Create a new actor/animator
                        actorList.add(actor2); // Add the new actor/animator to the list
                    }
                    addFilmToActor(film2, actor2); // Add the actor/animator to the film
                    break;

                case 12:
                    // Remove an actor/animator from a film
                    Film findFilm4 = findfilm(); // Find the film
                    Actor actor4 = findActor(); // Find the actor/animator
                    if(findFilm4.getActors().contains(actor4)){
                        removeFilmFromActor(findFilm4, actor4); // Remove the actor/animator from the film
                        System.out.println("Actor was removed from the film.");
                    } else {
                        System.out.println("Actor is not in film list.");
                    }
                    break;

                case 13:
                    // Print all the actors and the movies they appeared in
                    if(actorList.isEmpty()){
                        System.out.println("No actors in the list.");
                    } else {
                        for(Actor actor3 : actorList){
                            actor3.printFilms(); // Print films of each actor
                        }
                    }
                    break;
            }
        }
    }

    // Method for finding an actor
    private static Actor findActor() {
        // Check if the actor list is empty
        if(actorList.isEmpty()){
            System.out.println("Actor list is empty."); // Print a message if the actor list is empty
            return null;
        }
        Scanner sc = new Scanner(System.in);
        Actor actor = null;
        while(actor == null) {
            System.out.println("Enter name:"); // Prompt the user to enter the actor's name
            String actorName = Inputs.onlyName(); // Get the actor's name
            System.out.println("Enter surname:"); // Prompt the user to enter the actor's surname
            String actorSurname = Inputs.onlyName(); // Get the actor's surname
            // Search for the actor in the actor list
            for (Actor actor2 : actorList) {
                if (actor2.getFirstName().equals(actorName) && actor2.getLastName().equals(actorSurname)) {
                    actor = actor2; // Assign the found actor to the variable
                    break; // Exit the loop once the actor is found
                }
            }
            if (actor == null) {
                System.out.println("Actor is not in database."); // Print a message if the actor was not found in the database
            }
        }
        return actor; // Return the found actor
    }

    // Method for finding a film
    private static Film findfilm() {
        // Check if the film list is empty
        if(filmList.isEmpty()){
            return null; // If the film list is empty, return null
        }
        Scanner sc = new Scanner(System.in);
        Film film = null;
        while(film == null) {
            System.out.println("Enter film name:"); // Prompt the user to enter the film name
            String input = Inputs.nameAndDigit(); // Get the film name from the user
            film = filmList.get(input); // Attempt to retrieve the film from the film list
            if (film == null) {
                System.out.println("Film is not in database."); // Print a message if the film was not found in the database
            }
        }
        return film; // Return the found film
    }

    // Method adds a film to the actor's list of films and adds the actor to the film's list of actors.
    private static void addFilmToActor(Film film, Actor a) {
        film.addActor(a);
        a.addFilm(film);
    }

    // Method removes a film from the actor's list of films and removes the actor from the film's list of actors.
    private static void removeFilmFromActor(Film film, Actor a) {
        film.removeActor(a);
        a.removeFilm(film);
    }
}
