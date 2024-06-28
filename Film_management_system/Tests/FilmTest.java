package projektPC2.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projektPC2.Actor;
import projektPC2.Film;
import projektPC2.HFilm;

import static org.junit.jupiter.api.Assertions.*;

// Test class for abstract class Film
class FilmTest {

    private Film film;
    private Actor actor1;
    private Actor actor2;

    @BeforeEach
    void setUp() {
        // Initialize an HFilm object and actors for testing
        film = new HFilm("The Matrix", "Lana Wachowski", 1999);
        actor1 = new Actor("Keanu", "Reeves");
        actor2 = new Actor("Carrie-Anne", "Moss");
    }

    @Test
    void testFilmGetters() {
        // Test getters for film attributes
        assertEquals("The Matrix", film.getName(), "Film name should be 'The Matrix'");
        assertEquals("Lana Wachowski", film.getDirector(), "Director should be 'Lana Wachowski'");
        assertEquals(1999, film.getYear(), "Year should be 1999");
    }

    @Test
    void testSetFilmName() {
        // Test setting film name and getter
        film.setName("The Matrix Reloaded");
        assertEquals("The Matrix Reloaded", film.getName(), "Film name should be updated to 'The Matrix Reloaded'");
    }

    @Test
    void testSetFilmDirector() {
        // Test setting film director and getter
        film.setDirector("Lilly Wachowski");
        assertEquals("Lilly Wachowski", film.getDirector(), "Director should be updated to 'Lilly Wachowski'");
    }

    @Test
    void testSetFilmYear() {
        // Test setting film year and getter
        film.setYear(2003);
        assertEquals(2003, film.getYear(), "Year should be updated to 2003");
    }

    @Test
    void testAddAndRemoveActor() {
        // Test adding and removing actors from the film
        film.addActor(actor1);
        film.addActor(actor2);
        assertTrue(film.getActors().contains(actor1), "Actor list should contain 'Keanu Reeves'");
        assertTrue(film.getActors().contains(actor2), "Actor list should contain 'Carrie-Anne Moss'");

        film.removeActor(actor1);
        assertFalse(film.getActors().contains(actor1), "Actor list should not contain 'Keanu Reeves' after removal");
        assertEquals(1, film.getActors().size(), "Actor list should contain exactly one actor after removal");
    }

    @Test
    void testAddNullActor() {
        // Test adding null actor
        assertThrows(IllegalArgumentException.class, () -> film.addActor(null), "Adding a null actor should throw IllegalArgumentException");
    }

    @Test
    void testRemoveNonExistentActor() {
        // Test removing actor not in the list
        assertThrows(IllegalArgumentException.class, () -> film.removeActor(actor1), "Removing an actor not in the list should throw IllegalArgumentException");
    }

    @Test
    void testUnmodifiableActorsSet() {
        // Test that the actors set is unmodifiable
        film.addActor(actor1);
        assertThrows(UnsupportedOperationException.class, () -> film.getActors().add(actor2), "Actors set should be unmodifiable directly");
    }

    @Test
    void testAddAndRetrieveScores() {
        // Test adding reviews (scores) to the film and retrieving them
        film.addReview(8);
        film.addReview(9);
        assertEquals(2, film.getScore().size(), "There should be exactly 2 scores");
        assertTrue(film.getScore().contains(8), "Scores should contain 8");
        assertTrue(film.getScore().contains(9), "Scores should contain 9");
    }

    @Test
    void testToString() {
        // Test the toString method for correct string representation of the film
        assertEquals("Film name: The Matrix, director: Lana Wachowski, year of release: 1999", film.toString(), "toString should return proper film summary");
    }

    @Test
    void testEqualsAndHashCode() {
        // Test equals and hashCode methods for films
        Film sameFilm = new HFilm("The Matrix", "Lana Wachowski", 1999);
        Film differentFilm = new HFilm("The Matrix Reloaded", "Lana Wachowski", 2003);

        assertEquals(film, sameFilm, "Films with the same name, director, and year should be equal");
        assertNotEquals(film, differentFilm, "Films with different attributes should not be equal");
        assertEquals(film.hashCode(), sameFilm.hashCode(), "Films with the same attributes should have the same hash code");
    }
}
