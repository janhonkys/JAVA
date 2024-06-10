package projektPC2;

import java.util.StringJoiner;

public class AFilm extends Film {
    private int recommendedAge;
    public AFilm(String name, String director, int year, int recommendedAge) {
        super(name, director, year);
        validateRecommendedAge(recommendedAge);
        this.recommendedAge = recommendedAge;
    }

    public int getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(int recommendedAge) {
        validateRecommendedAge(recommendedAge);
        this.recommendedAge = recommendedAge;
    }

    private void validateRecommendedAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Recommended age for the viewer is between 0 a 100.");
        }
    }

    @Override
    public void printReview() {
        if (getScore().isEmpty()) {
            System.out.println("There is no review available.");
        } else {
            StringJoiner joiner = new StringJoiner(", ");
            for (Integer score : getScore()) {
                joiner.add(score.toString());
            }
            System.out.println("Audience rating: "+joiner.toString());
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", recommended age for the viewer: "+getRecommendedAge();
    }

    @Override
    public void printInfo(){
        System.out.print(toString());
        if(!getActors().isEmpty()){
            System.out.print(", animators: ");
            printActors();
        }
    }
}
