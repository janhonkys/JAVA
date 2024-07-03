package projektPC2_designpatterns.Film;

import projektPC2_designpatterns.Actor;

import java.util.*;

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
        this.name = validateName(name);         // Set and validate the film name
        this.director = validateDirector(director); // Set and validate the director's name
        this.year = validateYear(year);                // Set and validate the release year
    }

    // Getter for the film name
    public String getName() {
        return name;
    }

    // Setter for the film name
    public void setName(String name) {
        this.name = validateName(name);
    }

    // Getter for the director's name
    public String getDirector() {
        return director;
    }

    // Setter for the director's name
    public void setDirector(String director) {
        this.director = validateDirector(director);
    }

    // Getter for the release year
    public int getYear() {
        return year;
    }

    // Setter for the release year
    public void setYear(int year) {
        this.year = validateYear(year);
    }

    // Getter for the list of scores
    public List<Integer> getScore() {
        return Collections.unmodifiableList(score);
    }

    // Setter for the list of scores
    public void setScore(ArrayList<Integer> score) {
        if (score == null) {
            throw new IllegalArgumentException("Score list cannot be null.");
        }
        this.score = score;
    }

    // Getter for the set of actors
    public Set<Actor> getActors() {
        return Collections.unmodifiableSet(actors);
    }

    // Setter for the set of actors
    public void setActors(HashSet<Actor> actors) {
        if (actors == null) {
            throw new IllegalArgumentException("Actors set cannot be null.");
        }
        this.actors = actors;
    }

    // Method to add an actor to the film
    public void addActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("Cannot add actor. Input is null or invalid.");
        }
        // Add the actor to the set
        actors.add(actor);
    }

    // Method to validate the film's name
    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Movie name cannot be null or empty.");
        }
        return name.trim();
    }

    // Method to validate the director's name
    private String validateDirector(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Director name cannot be null or empty.");
        }
        if (!name.matches("[a-zA-Z\\s-]+")) {
            throw new IllegalArgumentException("The director name can only contain letters, spaces and dashes.");
        }
        return name.trim();
    }

    // Method to validate the release year
    private int validateYear(int age) {
        if (age < 1900 || age > 2030) {
            throw new IllegalArgumentException("Year of release must be between 1900 and 2030..");
        }
        return age;
    }

    // Method to remove an actor from the film
    public void removeActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("Actor cannot be removed, input is null.");
        }
        if (!actors.remove(actor)) {
            throw new IllegalArgumentException("The actor cannot be removed because they are not listed in the film.");
        }
    }

    // Method to print all actors in the film
    public String printActors(){
        String result;
        if (actors.isEmpty()) {
            result = "No actors available.";
        }

        StringJoiner actorNames = new StringJoiner(", ");
        for (Actor actor : actors) {
            actorNames.add(actor.getFirstName() + " " + actor.getLastName());
        }
        result = actorNames.toString();
        return result;
    }

    // Override toString to provide a summary of the film
    @Override
    public String toString() {
        return "Film name: " + name + ", director: " + director +", year of release: "+ year;
    }

    // Method to add a score (review) to the film
    public void addReview(int points){
        score.add(points);
    }

    // Abstract method to print reviews (to be implemented by subclasses)
    public abstract void printReview();

    // Abstract method to print detailed film info (to be implemented by subclasses)
    public abstract void printInfo();


    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Film film = (Film) obj;
        return year == film.getYear() && name.equals(film.getName()) && director.equals(film.getDirector());
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(name, director, year);
    }
}