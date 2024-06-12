package projektPC2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringJoiner;

// Class represents a generic film with attributes such as name, director, release year, scores, and actors.
// This class is abstract and should be subclassed to provide specific types of films.
public abstract class Film {

    private String name;       // The name of the film
    private String director;   // The director of the film
    private int year;          // The year the film was released

    // List of scores (ratings) for the film
    private ArrayList<Integer> score = new ArrayList<>();

    // Set of actors who acted in the film
    private HashSet<Actor> actors = new HashSet<>();

    public Film(String name, String director, int year) {
        validateName(name);              // Validate the film name
        validateDirector(director);      // Validate the director's name
        validateYear(year);              // Validate the release year
        this.name = name.trim();         // Set the film name
        this.director = director.trim(); // Set the director's name
        this.year = year;                // Set the release year
    }

    // Getter for the film name
    public String getName() {
        return name;
    }

    // Setter for the film name
    public void setName(String name) {
        validateName(name);
        this.name = name.trim();
    }

    // Getter for the director's name
    public String getDirector() {
        return director;
    }

    // Setter for the director's name
    public void setDirector(String director) {
        validateDirector(director);
        this.director = director;
    }

    // Getter for the release year
    public int getYear() {
        return year;
    }

    // Setter for the release year
    public void setYear(int year) {
        validateYear(year);
        this.year = year;
    }

    // Getter for the list of scores
    public ArrayList<Integer> getScore() {
        return score;
    }

    // Setter for the list of scores
    public void setScore(ArrayList<Integer> score) {
        this.score = score;
    }

    // Getter for the set of actors
    public HashSet<Actor> getActors() {
        return actors;
    }

    // Setter for the set of actors
    public void setActors(HashSet<Actor> actors) {
        this.actors = actors;
    }

    // Method to add an actor to the film
    public void addActor(Actor act) {
        if(act == null){
            throw new IllegalArgumentException("Cannot add actor. Input is null or invalid.");
        }
        // Add the actor if not already in the set
        if(!actors.contains(act)){
            actors.add(act);
        }
    }

    // Method to validate the film's name
    private void validateName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Movie name cannot be null or empty.");
        }
    }

    // Method to validate the director's name
    private void validateDirector(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Director name cannot be null or empty.");
        }
        if (!name.matches("[a-zA-Z\\s-]+")) {
            throw new IllegalArgumentException("The director name can only contain letters, spaces and dashes.");
        }
    }

    // Method to validate the release year
    private void validateYear(int age) {
        if (age < 1900 || age > 2030) {
            throw new IllegalArgumentException("Year of release must be between 1900 and 2030..");
        }
    }

    // Method to remove an actor from the film
    public void removeActor(Actor a) {
        if(a == null){
            throw new IllegalArgumentException("Actor cannot be removed, input is null.");
        }
        if(!actors.remove(a)){
            throw new IllegalArgumentException("The actor cannot be removed because they are not listed in the film.");
        }
    }

    // Method to print all actors in the film
    public void printActors(){
        if (actors.isEmpty()) {
            System.out.println("No actors available.");
            return;
        }

        StringJoiner actorNames = new StringJoiner(", ");
        for (Actor act : actors) {
            actorNames.add(act.getFirstName() + " " + act.getLastName());
        }
        System.out.println(actorNames.toString());
    }

    // Override toString to provide a summary of the film
    @Override
    public String toString() {
        return "Film name: " + name + ", director: " + director +", year of release: "+ year;
    }

    // Method to add a score (review) to the film
    public void addReview(int a){
        score.add(a);
    }

    // Abstract method to print reviews (to be implemented by subclasses)
    public abstract void printReview();

    // Abstract method to print detailed film info (to be implemented by subclasses)
    public abstract void printInfo();
}
