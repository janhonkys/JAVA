package projektPC2_designpatterns;

import projektPC2_designpatterns.Film.AFilm;
import projektPC2_designpatterns.Film.Film;

import java.util.*;

public class Actor {
    private String firstName;   // First name of the actor
    private String lastName;    // Last name of the actor
    private HashSet<Film> films = new HashSet<>();  // Films the actor has worked on

    // Constructor
    public Actor(String firstName, String lastName) {
        this.firstName = validateName(firstName);  // Validate and trim the first name
        this.lastName = validateName(lastName);    // Validate and trim the last name
    }

    // Getter for the first name
    public String getFirstName() {
        return firstName;
    }

    // Setter for the first name
    public void setFirstName(String firstName) {
        this.firstName = validateName(firstName);
    }

    // Getter for the last name
    public String getLastName() {
        return lastName;
    }

    // Setter for the last name
    public void setLastName(String lastName) {
        this.lastName = validateName(lastName);  // Validate and trim the last name
    }

    // Validate name to ensure it's not null or empty and contains only valid characters
    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Actor name cannot be null or empty.");
        }
        if (!name.matches("[a-zA-Z\\s-]+")) {
            throw new IllegalArgumentException("Actor name can only contain letters, spaces, and dashes.");
        }
        return name.trim();  // Trim and return the validated name
    }

    // Getter for films
    public Set<Film> getFilms() {
        return Collections.unmodifiableSet(this.films);
    }

    // Method to add a film to the actor's list
    public void addFilm(Film film) {
        if (film == null) {
            throw new IllegalArgumentException("Film cannot be null.");
        }
        // Add the film to the set
        this.films.add(film);
    }

    // Method to remove a film from the actor's list
    public void removeFilm(Film film) {
        if (film == null) {
            throw new IllegalArgumentException("Film cannot be null.");
        }

        // Attempt to remove the film from the actor's list
        if (!films.remove(film)) {
            throw new NoSuchElementException("The movie cannot be removed, it is not in the actor's list.");
        }
    }

    // Method to print all films the actor worked on
    public void printFilms() {
        if (films.isEmpty()) {
            System.out.println(getFirstName() + " " + getLastName() + " did not work on any film.");
            return;
        }

        // Determine role based on the film type
        String role = films.stream().anyMatch(film -> film instanceof AFilm) ? "Animator" : "Actor";

        // Collect film names into a comma-separated string
        StringJoiner filmNames = new StringJoiner(", ");
        for (Film film : films) {
            filmNames.add(film.getName());
        }

        // Print the information about actor and films
        System.out.println(role + " " + getFirstName() + " " + getLastName() + " worked on these films: " + filmNames.toString());
    }

    // Override toString to return the actor's full name
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Actor actor = (Actor) obj;
        return firstName.equals(actor.firstName) && lastName.equals(actor.lastName);
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName);
    }
}