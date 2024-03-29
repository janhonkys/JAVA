package projektPC2;


public class AFilm extends Film {       //Animovani Film, dedi z tridy Film
    Integer recomendage;
    public AFilm(String name, String director, Integer year, Integer recomendage) {
        super(name, director, year);
        this.recomendage = recomendage;
    }

    @Override
    public Integer getRecomendage() {
        return recomendage;
    }

    @Override
    public void setRecomendage(Integer recomendage) {
        this.recomendage = recomendage;
    }

    @Override
    public void printReview() {
        for(Integer a: super.getScore()){       //super.getScore() vraci arraylist score z tridy Film z ktere dedi
            System.out.println(a);      //vypisu obsah listu score
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", doporučený věk diváka: "+getRecomendage();
    }

    @Override
    public void printInfo(){        //vypis info o filmu
        System.out.println("Jméno filmu: " + getName() + ", režisér: " + getDirector() + ", rok: " + getYear() + ", doporučený věk diváka: " + getRecomendage());
        if(super.getActorlist().isEmpty()){     //pokud nema herce

        }
        else{   //ma herce
            System.out.println("Herci:");
            printActor();       //volani funkce z tridy Film, vypis hercu
        }
    }
}
