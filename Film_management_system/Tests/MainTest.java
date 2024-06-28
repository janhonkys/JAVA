package projektPC2.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projektPC2.*;

import java.util.HashSet;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

// Tests for Main class
class MainTest {
    private TreeMap<String, Film> filmList;
    private HashSet<Actor> actorList;

    @BeforeEach
    void setUp() {
        // Initialize filmList and actorList
        filmList = new TreeMap<>();
        actorList = new HashSet<>();

        // Create new sample films and actors
        AFilm newAFilm = new AFilm("Shrek", "Andrew Perkinsont", 2008, 10);
        AFilm newAFilm1 = new AFilm("Shrek2", "Andrew Hopkin", 2009, 15);
        HFilm newHFilm = new HFilm("Pelisky", "Pavel Hopkin", 2020);
        HFilm newHFilm1 = new HFilm("Slunce", "Marek Hopkin", 2015);

        Actor newActor = new Actor("Andy", "Harper");
        Actor newActor1 = new Actor("Pavel", "Bezruc");

        // Adding actors to the actor list
        actorList.add(newActor);
        actorList.add(newActor1);

        // Adding actors to films
        newAFilm.addActor(newActor);
        newAFilm1.addActor(newActor);
        newHFilm.addActor(newActor1);
        newHFilm1.addActor(newActor1);

        // Adding films to the actors' list
        newActor.addFilm(newAFilm);
        newActor.addFilm(newAFilm1);
        newActor1.addFilm(newHFilm);
        newActor1.addFilm(newHFilm1);

        // Adding films to the film list
        filmList.put(newAFilm.getName(), newAFilm);
        filmList.put(newAFilm1.getName(), newAFilm1);
        filmList.put(newHFilm.getName(), newHFilm);
        filmList.put(newHFilm1.getName(), newHFilm1);
    }

    @Test
    void testAddFilmToActor() {
        //Create film and actor
        HFilm film = new HFilm("New Film", "New Director", 2022);
        Actor actor = new Actor("John", "Doe");
        Actor actor1 = new Actor("Pablo", "Doe");

        // Add film to actor
        Main.addFilmToActor(film, actor);
        Main.addFilmToActor(film, actor1);

        assertEquals(true, actor.getFilms().contains(film), "New film should be in the actor's film list");
        assertEquals(true, film.getActors().contains(actor), "New actor should be in the film's actor list");
        assertEquals(2, film.getActors().size(), "New actor should be in the film's actor list");
    }

    @Test
    void testRemoveFilmFromActor() {
        //Create film and actor
        Actor actor = new Actor("Andy", "Harper");
        AFilm film = new AFilm("Shrek", "Andrew Perkinsont", 2008, 10);

        // Add film to actor and actor to film
        actor.addFilm(film);
        film.addActor(actor);

        // Remove film from actor
        Main.removeFilmFromActor(film, actor);

        assertEquals(false, actor.getFilms().contains(film), "Film should be removed from actor's film list");
        assertEquals(false, film.getActors().contains(actor), "Actor should be removed from film's actor list");
    }

    @Test
    void testFindFilm() {
        // Add a new film
        HFilm newFilm = new HFilm("Shrek", "Andrew Harper", 2022);
        filmList.put(newFilm.getName(), newFilm);

        // Simulate user input and find the film
        assertEquals("Shrek", filmList.get("Shrek").getName(), "Film should be found by name");
    }

    @Test
    void testFindActor() {
        Actor newActor = new Actor("Andy", "Harper");
        Actor newActor1 = new Actor("Andrew", "Pobla");

        // Add the actor to the list
        actorList.add(newActor);

        // Simulate user input and find the actor
        assertEquals(true, actorList.contains(newActor), "Actor should be found by name and surname");
        assertEquals(false, actorList.contains(newActor1), "Actor should be found by name and surname");
    }

    @Test
    void testPrintFilms() {
        // This test would validate non-empty filmList.
        assertEquals(false, filmList.isEmpty(), "Film list should not be empty");
    }
}

