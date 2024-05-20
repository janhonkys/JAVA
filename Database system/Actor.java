package projektPC2;

import java.util.ArrayList;

public class Actor {
    private String firstName;
    private String lastName;

    ArrayList<Film> filmlist = new ArrayList<Film>();

    public Actor(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Film> getFilmlist() {
        return filmlist;
    }

    @Override
    public String toString() {
        return  firstName +" " + lastName;
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
                break;
            }
        }
        if(flag) {
            System.out.println("Animátor "+ getFirstName() +" "+ getLastName()+ " pracoval na těchto filmech:");
            for(Film f1: filmlist){
                System.out.println(f1.getName());
            }
        }else {
            System.out.println("Herec "+ getFirstName() +" "+ getLastName()+ " pracoval na těchto filmech:");
            for(Film f1: filmlist){
                System.out.println(f1.getName());
            }
        }
        }
    }



