package projektPC2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringJoiner;

public abstract class Film {

    private String name;
    private String director;
    private int year;

    private ArrayList<Integer> score = new ArrayList<Integer>();
    private HashSet<Actor> actors = new HashSet<Actor>();

    public Film(String name, String director, int year) {
        validateName(name);
        validateDirector(director);
        validateYear(year);
        this.name = name.trim();
        this.director = director.trim();
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        validateDirector(director);
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        validateYear(year);
        this.year = year;
    }

    public ArrayList<Integer> getScore() {
        return score;
    }

    public void setScore(ArrayList<Integer> score) {
        this.score = score;
    }

    public HashSet<Actor> getActors() {
        return actors;
    }

    public void setActors(HashSet<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor act) {
        if(act == null){
            throw new IllegalArgumentException("Cannot to add actor, invalid input.");
        }
        if(!actors.contains(act)){
            actors.add(act);
        }
    }

    private void validateName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Movie name cannot be null or empty.");
        }
    }

    private void validateDirector(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Director name cannot be null or empty.");
        }
        if (!name.matches("[a-zA-Z\\s-]+")) {
            throw new IllegalArgumentException("The director name can only contain letters, spaces and dashes.");
        }
    }

    private void validateYear(int age) {
        if (age < 1900 || age > 2030) {
            throw new IllegalArgumentException("Date of publication must be between 1900 and 2030.");
        }
    }

    public void removeActor(Actor a) {
        if(a == null){
            throw new IllegalArgumentException("Cannot to remove actor, input is null.");
        }
        if(!actors.remove(a)){
            throw new IllegalArgumentException("The actor cannot be removed because he is not listed with the movie..");
        }
    }

    public void printActors(){
        if (actors.isEmpty()) {
            System.out.println("No actors available.");
            return;
        }

        // Using StringJoiner for efficient and clean concatenation
        StringJoiner actorNames = new StringJoiner(", ");
        for (Actor act : actors) {
            actorNames.add(act.getFirstName() + " " + act.getLastName());
        }
        System.out.println(actorNames.toString());
    }

    @Override
    public String toString() {
        return "Film name: " + name + ", director: " + director +", year of release: "+ year;
    }

    public void addReview(int a){
        score.add(a);
    }

    public abstract void printReview();


    public abstract void printInfo();
}
