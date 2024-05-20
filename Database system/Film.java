package projektPC2;

import java.util.ArrayList;

public abstract class Film {

    private String name;
    private String director;
    private int year;

    ArrayList<Integer> score = new ArrayList<Integer>();
    ArrayList<Actor> actorlist = new ArrayList<Actor>();

    public Film(String name, String director, int year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Název: " + name + ", režisér: " + director +", rok vydání: "+ year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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

    public void printActor(){
        if(actorlist.isEmpty()){
            System.out.println("Film nemá žádného herce.");
        }else{
            for(Actor a:actorlist){
                System.out.println(a);
            }
        }
    }

    public void addReview(int a){
        score.add(a);
    }

    public abstract void printReview();

    public abstract void setRecomendage(int in);

    public abstract int getRecomendage();

    public abstract void printInfo();
}
