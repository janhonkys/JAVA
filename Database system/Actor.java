package projektPC2;

import java.util.ArrayList;

public class Actor {
    private String Firstname;
    private String Lastname;

    @Override
    public String toString() {
        return  Firstname +" " + Lastname;
    }

    ArrayList<Film> filmlist = new ArrayList<Film>();

    public Actor(String firstname, String lastname) {
        Firstname = firstname;
        Lastname = lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public ArrayList<Film> getFilmlist() {
        return filmlist;
    }

    public void addFilm(Film tech) {
        filmlist.add(tech);
    }

    public void removeFilm(Film film) {
        if(filmlist.remove(film)){
            System.out.println("Film byl odstraněn");
        }
        else{
            System.out.println("Film nebyl odstraněn");
        }
    }

    public void printFilms() {
        boolean flag = false;
        for(Film f: filmlist) {
            if (f instanceof AFilm) {
                flag = true;
            }
        }
        if(flag) {
            System.out.println("Animátor "+getFirstname() +" "+ getLastname()+ " pracoval na těchto filmech:");
            for(Film f1: filmlist){
                System.out.println(f1.getName());
            }
        }else {
            System.out.println("Herec "+getFirstname() +" "+ getLastname()+ " pracoval na těchto filmech:");
            for(Film f1: filmlist){
                System.out.println(f1.getName());
            }
        }
        }
    }



