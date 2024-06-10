package projektPC2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringJoiner;

public class Actor {
    private String firstName;
    private String lastName;

    private HashSet<Film> films = new HashSet<>();

    public Actor(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName);
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateName(lastName);
        this.lastName = lastName.trim();
    }

    private void validateName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Actor name cannot be null or empty.");
        }
        if (!name.matches("[a-zA-Z\\s-]+")) {
            throw new IllegalArgumentException("Actor name can only contain letters, spaces and dashes.");
        }
    }

    public HashSet<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        if(film == null){
            throw new IllegalArgumentException("Film cannot be null.");
        }
        films.add(film);
    }

    public void removeFilm(Film film) {
        if(film == null){
            throw new IllegalArgumentException("Film cannot be null.");
        }
        if(!films.remove(film)){
            throw new IllegalArgumentException("The movie cannot be removed, it is not in the actor's list..");
        }
    }

    public void printFilms() {

        if (films.isEmpty()) {
            System.out.println(getFirstName() + " " + getLastName() + " did not work on any film.");
            return;
        }
        String role = films.stream().anyMatch(film -> film instanceof AFilm) ? "Animator" : "Actor";
        StringJoiner filmNames = new StringJoiner(", ");
        for (Film film : films) {
            filmNames.add(film.getName());
        }
        System.out.println(role + " " + getFirstName() + " " + getLastName() + " worked on these films: " + filmNames.toString());
    }


    @Override
    public String toString() {
        return firstName +
                " " + lastName;
    }
}



