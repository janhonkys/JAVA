package projektPC2;


public class HFilm extends Film {
    public HFilm(String name, String director, Integer year) {
        super(name, director, year);
    }

    @Override
    public void printReview() {
        for(Integer a: super.getScore()) {
            switch (a) {
                case 1:
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("**");
                    break;
                case 3:
                    System.out.println("***");
                    break;
                case 4:
                    System.out.println("****");
                    break;
                case 5:
                    System.out.println("*****");
                    break;
            }
        }
    }

    @Override
    public void setRecomendage(Integer in100) {
    }

    @Override
    public Integer getRecomendage() {
        return null;
    }
    @Override
    public void printInfo(){
        System.out.println("Jméno filmu: " + getName() + ", režisér: " + getDirector() + ", rok: " + getYear());
        if(super.getActorlist().isEmpty()){

        }
        else{
            System.out.println("Herci:");
            printActor();
        }
    }
}
