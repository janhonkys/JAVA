package projektPC2;

import java.util.ArrayList;

public class Actor {        //trida Actor - herci, parametry Prijmeni, jmeno
    private String Firstname;
    private String Lastname;

    @Override
    public String toString() {
        return  Firstname +" " + Lastname;
    }

    ArrayList<Film> filmlist = new ArrayList<Film>();       //Arraylist filmů

    public Actor(String firstname, String lastname) {       //konstruktor - jmeno a prijmeni herce
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

    public ArrayList<Film> getFilmlist() {      //vraci Arraylist filmlist
        return filmlist;
    }

    public void addFilm(Film tech) {        //do Arraylistu prida film
        filmlist.add(tech);
    }

    public void removeFilm(Film film) {     //odstraneni limu z listu
        if(filmlist.remove(film)){
            System.out.println("Film byl odstraněn");
        }
        else{
            System.out.println("Film nebyl odstraněn");
        }
    }

    public void printFilms() {      //vypis filmů
        boolean flag = false;       //pomocna promenná
        for(Film f: filmlist) {     //for cyklus, proiteruje list filmlist
            if (f instanceof AFilm) {       //pokud jsou filmy animované (objekt f je AFilm), do flag se dá true
                flag = true;
            }
        }
        if(flag) {      //pokud animovane filmy - animátor pracoval na těchto filmech
            System.out.println("Animátor "+getFirstname() +" "+ getLastname()+ " pracoval na těchto filmech:");
            for(Film f1: filmlist){     //for cyklus vypis filmu z listu
                System.out.println(f1.getName());       //vypis jmena filmy
            }
        }else {
            System.out.println("Herec "+getFirstname() +" "+ getLastname()+ " pracoval na těchto filmech:");        //pokud je Hrany film
            for(Film f1: filmlist){
                System.out.println(f1.getName());
            }
        }
        }
    }



