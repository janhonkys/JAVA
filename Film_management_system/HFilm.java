package projektPC2;

import java.util.Objects;
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
            for (Integer rating: getScore()) {
                switch (rating) {
                    case 1:
                        joiner.add("*");
                        break;
                    case 2:
                        joiner.add("**");
                        break;
                    case 3:
                        joiner.add("***");
                        break;
                    case 4:
                        joiner.add("****");
                        break;
                    case 5:
                        joiner.add("*****");
                        break;
                    default:
                        System.out.println("Invalid rating.");
                        break;
                }
            }
            // Print the joined star ratings
            System.out.print("Audience rating: " + joiner.toString());
        } else {
            // Print a message if there are no ratings
            System.out.print("No ratings available.");
        }
    }

    // Print detailed information about the film, including actors if available.
    @Override
    public void printInfo() {
        // Print basic film details
        System.out.print(super.toString());

        // If there are actors, print their details
        if (!getActors().isEmpty()) {
            System.out.print(", actors: ");
            printActors();
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