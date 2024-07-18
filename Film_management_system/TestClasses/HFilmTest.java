package projektPC2_designpatterns.TestClasses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projektPC2.Actor;
import projektPC2.HFilm;

import static org.junit.jupiter.api.Assertions.*;

// Test class for HFilm
class HFilmTest {

    private HFilm featureFilm;
    private Actor actor1;
    private Actor actor2;

    @BeforeEach
    void setUp() {
        // Initialize an HFilm object and actors for testing
        featureFilm = new HFilm("Inception", "Christopher Nolan", 2010);
        actor1 = new Actor("Leonardo", "DiCaprio");
        actor2 = new Actor("Joseph", "Gordon-Levitt");
    }

    @Test
    void testGetters() {
        // Test getters for film attributes
        assertEquals("Inception", featureFilm.getName(), "Expected film name 'Inception'");
        assertEquals("Christopher Nolan", featureFilm.getDirector(), "Expected director 'Christopher Nolan'");
        assertEquals(2010, featureFilm.getYear(), "Expected release year 2010");
    }

    @Test
    void testSetters() {
        // Test setters for film attributes
        featureFilm.setName("Interstellar");
        featureFilm.setDirector("Nolan");
        featureFilm.setYear(2014);
        assertEquals("Interstellar", featureFilm.getName(), "Expected updated film name 'Interstellar'");
        assertEquals("Nolan", featureFilm.getDirector(), "Expected updated director 'Nolan'");
        assertEquals(2014, featureFilm.getYear(), "Expected updated release year 2014");
    }

    @Test
    void testAddAndRemoveActor() {
        // Test adding and removing actors from the film
        featureFilm.addActor(actor1);
        featureFilm.addActor(actor2);
        assertTrue(featureFilm.getActors().contains(actor1), "Expected 'Leonardo DiCaprio' to be in the actor list");
        assertTrue(featureFilm.getActors().contains(actor2), "Expected 'Joseph Gordon-Levitt' to be in the actor list");

        featureFilm.removeActor(actor1);
        assertFalse(featureFilm.getActors().contains(actor1), "'Leonardo DiCaprio' should have been removed from the actor list");
        assertEquals(1, featureFilm.getActors().size(), "Actor list should contain exactly one actor after removal");
    }

    @Test
    void testAddAndRetrieveScores() {
        // Test adding reviews (scores) to the film and retrieving them
        featureFilm.addReview(4);
        featureFilm.addReview(5);
        assertEquals(2, featureFilm.getScore().size(), "There should be exactly 2 scores");
        assertTrue(featureFilm.getScore().contains(4), "Scores should contain 4");
        assertTrue(featureFilm.getScore().contains(5), "Scores should contain 5");
    }

    @Test
    void testToString() {
        // Test the toString method for correct string representation of the film
        assertEquals("Film name: Inception, director: Christopher Nolan, year of release: 2010", featureFilm.toString(), "Expected proper string representation of the film");
    }

    @Test
    void testEqualsAndHashCode() {
        // Test equals and hashCode methods for films
        HFilm sameFilm = new HFilm("Inception", "Christopher Nolan", 2010);
        HFilm differentFilm = new HFilm("Interstellar", "Christopher Nolan", 2014);

        assertEquals(featureFilm, sameFilm, "Films with the same attributes should be equal");
        assertNotEquals(featureFilm, differentFilm, "Films with different attributes should not be equal");
        assertEquals(featureFilm.hashCode(), sameFilm.hashCode(), "Hashcodes for equal films should be identical");
    }

}
