package projektPC2;


public class AFilm extends Film {
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
        for(Integer a: super.getScore()){
            System.out.println(a);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", doporučený věk diváka: "+getRecomendage();
    }

    @Override
    public void printInfo(){
        System.out.println("Jméno filmu: " + getName() + ", režisér: " + getDirector() + ", rok: " + getYear() + ", doporučený věk diváka: " + getRecomendage());
        if(super.getActorlist().isEmpty()){

        }
        else{
            System.out.println("Herci:");
            printActor();
        }
    }
}
