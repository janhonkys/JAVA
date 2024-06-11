package projektPC2;

import java.util.StringJoiner;

// Class represents an animated film (AFilm) which includes a recommended age for viewers.
// Inherits from the abstract Film class.
public class AFilm extends Film {

    // Recommended viewing age for the film
    private int recommendedAge;

    // Constructor
    public AFilm(String name, String director, int year, int recommendedAge) {
        super(name, director, year);
        validateRecommendedAge(recommendedAge);
        this.recommendedAge = recommendedAge;
    }

    // Getter for the recommended age
    public int getRecommendedAge() {
        return recommendedAge;
    }

    // Setter for the recommended age
    public void setRecommendedAge(int recommendedAge) {
        validateRecommendedAge(recommendedAge);
        this.recommendedAge = recommendedAge;
    }

    // Validates recommended age
    private void validateRecommendedAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Recommended age for the viewer is between 0 a 100.");
        }
    }

    // Prints the film's reviews (scores)
    @Override
    public void printReview() {
        if (getScore().isEmpty()) {
            System.out.println("There is no review available.");
        } else {
            // Join scores with a comma separator
            StringJoiner joiner = new StringJoiner(", ");
            for (Integer score : getScore()) {
                joiner.add(score.toString());
            }
            System.out.println("Audience rating: "+joiner.toString());
        }
    }

    // Returns a string representation of the film
    @Override
    public String toString() {
        return super.toString() + ", recommended age for the viewer: "+getRecommendedAge();
    }

    // Prints detailed information about the film, including actors if available
    @Override
    public void printInfo(){
        // Print basic film details
        System.out.print(toString());

        // If there are actors, print them
        if(!getActors().isEmpty()){
            System.out.print(", animators: ");
            printActors();
        }
    }
}
