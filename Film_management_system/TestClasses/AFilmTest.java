package projektPC2.TestClasses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projektPC2.AFilm;
import projektPC2.Actor;

import static org.junit.jupiter.api.Assertions.*;

// Test class for AFilm
class AFilmTest {

    private AFilm animatedFilm;
    private Actor actor1;
    private Actor actor2;

    @BeforeEach
    void setUp() {
        // Initialize a sample animated film and actors for testing
        animatedFilm = new AFilm("Shrek", "Andrew Adamson", 2001, 6);
        actor1 = new Actor("Mike", "Myers");
        actor2 = new Actor("Eddie", "Murphy");
    }

    @Test
    void testGetters() {
        // Test getters for film attributes
        assertEquals("Shrek", animatedFilm.getName(), "Expected film name 'Shrek'");
        assertEquals("Andrew Adamson", animatedFilm.getDirector(), "Expected director 'Andrew Adamson'");
        assertEquals(2001, animatedFilm.getYear(), "Expected release year 2001");
        assertEquals(6, animatedFilm.getRecommendedAge(), "Expected recommended age 6");
    }

    @Test
    void testSetRecommendedAge() {
        // Test setting the recommended age and getter
        animatedFilm.setRecommendedAge(12);
        assertEquals(12, animatedFilm.getRecommendedAge(), "Recommended age should be updated to 12");
    }

    @Test
    void testInvalidRecommendedAge() {
        // Test invalid recommended ages (out of range)
        assertThrows(IllegalArgumentException.class, () -> animatedFilm.setRecommendedAge(-1), "Setting recommended age to -1 should throw an exception");
        assertThrows(IllegalArgumentException.class, () -> animatedFilm.setRecommendedAge(101), "Setting recommended age to 101 should throw an exception");
    }

    @Test
    void testAddAndRemoveActor() {
        // Test adding and removing actors from the film
        animatedFilm.addActor(actor1);
        animatedFilm.addActor(actor2);
        assertTrue(animatedFilm.getActors().contains(actor1), "Expected 'Mike Myers' to be in the actor list");
        assertTrue(animatedFilm.getActors().contains(actor2), "Expected 'Eddie Murphy' to be in the actor list");

        animatedFilm.removeActor(actor1);
        assertFalse(animatedFilm.getActors().contains(actor1), "'Mike Myers' should have been removed from the actor list");
        assertEquals(1, animatedFilm.getActors().size(), "Actor list should contain exactly one actor after removal");
    }

    @Test
    void testAddAndRetrieveScores() {
        // Test adding reviews (scores) to the film and retrieving them
        animatedFilm.addReview(9);
        animatedFilm.addReview(8);
        assertEquals(2, animatedFilm.getScore().size(), "There should be exactly 2 scores");
        assertTrue(animatedFilm.getScore().contains(9), "Scores should contain 9");
        assertTrue(animatedFilm.getScore().contains(8), "Scores should contain 8");
    }

    @Test
    void testToString() {
        // Test the toString method for correct string representation of the film
        assertEquals("Film name: Shrek, director: Andrew Adamson, year of release: 2001, recommended age for the viewer: 6", animatedFilm.toString(), "Expected proper string representation of the film");
    }

    @Test
    void testEqualsAndHashCode() {
        // Test equals and hashCode methods for films
        AFilm sameFilm = new AFilm("Shrek", "Andrew Adamson", 2001, 6);
        AFilm differentFilm = new AFilm("Shrek 2", "Andrew Adamson", 2004, 6);
        AFilm differentAgeFilm = new AFilm("Shrek", "Andrew Adamson", 2001, 8);

        assertEquals(animatedFilm, sameFilm, "Films with the same attributes should be equal");
        assertNotEquals(animatedFilm, differentFilm, "Films with different attributes should not be equal");
        assertNotEquals(animatedFilm, differentAgeFilm, "Films with different recommended ages should not be equal");
        assertEquals(animatedFilm.hashCode(), sameFilm.hashCode(), "Hashcodes for equal films should be identical");
        assertNotEquals(animatedFilm.hashCode(), differentFilm.hashCode(), "Hashcodes for not equal films should not be identical");
    }
}
