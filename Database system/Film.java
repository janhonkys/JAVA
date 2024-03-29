package projektPC2;

import java.util.ArrayList;

public abstract class Film {        //abstraktni trida, z ktere dedi tridy AFilm a HFilm

    private String name;
    private String director;
    private Integer year;

    ArrayList<Integer> score = new ArrayList<Integer>();        //ArrayList na hodnoceni
    ArrayList<Actor> actorlist = new ArrayList<Actor>();        //ArrayList na herce

    @Override
    public String toString() {
        return "Název: " + name + ", režisér: " + director +", rok vydání: "+ year;
    }

    public Film(String name, String director, Integer year) {       //konstruktor
        this.name = name;
        this.director = director;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public ArrayList<Integer> getScore() {
        return score;
    }

    public void setScore(ArrayList<Integer> score) {
        this.score = score;
    }

    public ArrayList<Actor> getActorlist() {
        return actorlist;
    }

    public void setActorlist(ArrayList<Actor> actorlist) {
        this.actorlist = actorlist;
    }

    public void addActor(Actor act) {
        actorlist.add(act);
    }

    public void removeActor(Actor a) {
        if(actorlist.remove(a)){
            System.out.println("Herec byl odstraněn");
        }
        else{
            System.out.println("Herec nebyl odstraněn");
        }
    }

    public void printActor(){           //vypise arraylist hercu
        if(actorlist.isEmpty()){
            System.out.println("Film nemá žádného herce.");
        }else{
            for(Actor a:actorlist){     //for cyklus, vypis actorlist listu
                System.out.println(a);
            }
        }
    }

    public abstract void printReview();


    public void addReview(Integer a){
        score.add(a);
    }


    public abstract void setRecomendage(Integer in4);

    public abstract Integer getRecomendage();

    public abstract void printInfo();
}
