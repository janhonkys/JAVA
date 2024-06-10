package projektPC2;


import java.util.StringJoiner;

public class HFilm extends Film {
    public HFilm(String name, String director, int year) {
        super(name, director, year);
    }

    @Override
    public void printReview() {
        if(!getScore().isEmpty()){
            StringJoiner joiner = new StringJoiner(", ");
            for(Integer rating: getScore()) {
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
            System.out.print("Audience rating: " + joiner.toString());
        } else {
            System.out.print("No ratings available.");
        }
    }

    @Override
    public void printInfo(){
        System.out.print(super.toString());
        if(!getActors().isEmpty()){
            System.out.print(", actors: ");
            printActors();
        }
    }
}
