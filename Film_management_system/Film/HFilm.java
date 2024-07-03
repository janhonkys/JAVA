package projektPC2_designpatterns.Film;

import java.util.StringJoiner;

// Class represents a feature film (HFilm) with specific rating and information display methods.
// Inherits from the abstract Film class.
public class HFilm extends Film {
    public HFilm(String name, String director, int year) {
        super(name, director, year);
    }

    // Prints the film's reviews (ratings) using a star (*) system for ratings from 1 to 5.
    @Override
    public void printReview() {
        if (!getScore().isEmpty()) {
            // Join the ratings with a comma separator
            StringJoiner joiner = new StringJoiner(", ");

            // Convert each rating to a string of stars
            for (Integer rating : getScore()) {
                joiner.add(convertToStars(rating));
            }
            // Print the joined star ratings
            System.out.print("Audience rating: " + joiner.toString());
        } else {
            // Print a message if there are no ratings
            System.out.print("No ratings available.");
        }
    }

    // Converts a rating integer to a star representation
    private String convertToStars(int rating) {
        switch (rating) {
            case 1:
                return "*";
            case 2:
                return "**";
            case 3:
                return "***";
            case 4:
                return "****";
            case 5:
                return "*****";
            default:
                throw new IllegalArgumentException("Invalid rating.");
        }
    }

    // Print detailed information about the film, including actors if available.
    @Override
    public void printInfo() {
        // Print basic film details if there are actors, print them
        if (!getActors().isEmpty()) {
            System.out.println(super.toString() + ", actors: " +printActors());
        } else {
            System.out.println(super.toString());
        }
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}