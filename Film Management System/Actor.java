package projektPC2;

import java.util.HashSet;
import java.util.StringJoiner;

// This class represents an actor with a first name, last name, and a list of films.
public class Actor {
    private String firstName;   // First name of the actor
    private String lastName;    // Last name of the actor
    private HashSet<Film> films = new HashSet<>();  // Films the actor has worked on

    // Constructor
    public Actor (String firstName, String lastName) {
        validateName(firstName);  // Validate the first name
        validateName(lastName);   // Validate the last name
        this.firstName = firstName.trim();  // Set the first name
        this.lastName = lastName.trim();    // Set the last name
    }

    // Getter for the first name
    public String getFirstName() {
        return firstName;
    }

    // Setter for the first name
    public void setFirstName(String firstName) {
        validateName(firstName);
        this.firstName = firstName.trim();
    }

    // Getter for the last name
    public String getLastName() {
        return lastName;
    }

    // Setter for the last name
    public void setLastName(String lastName) {
        validateName(lastName);  // Validate the last name
        this.lastName = lastName.trim();  // Set the last name
    }

    // Validate name to ensure it's not null or empty and contains only valid characters
    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Actor name cannot be null or empty.");
        }
        if (!name.matches("[a-zA-Z\\s-]+")) {
            throw new IllegalArgumentException("Actor name can only contain letters, spaces and dashes.");
        }
    }

    // Getter for films
    public HashSet<Film> getFilms() {
        return films;
    }

    // Method to add a film to the actor's list
    public void addFilm(Film film) {
        if (film == null) {
            throw new IllegalArgumentException("Film cannot be null.");
        }
        // Add the film to the set
        films.add(film);
    }

    // Method to remove a film from the actor's list
    public void removeFilm(Film film) {
        if (film == null) {
            throw new IllegalArgumentException("Film cannot be null.");
        }

        // Attempt to remove the film from the actor's list
        if (!films.remove(film)) {
            throw new IllegalArgumentException("The movie cannot be removed, it is not in the actor's list..");
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
        return firstName +
                " " + lastName;
    }
}



