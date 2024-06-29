package projektPC2.TestClasses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projektPC2.Actor;
import projektPC2.Film;
import projektPC2.HFilm;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

// Test class for Actor
class ActorTest {

    private Actor actor;
    private Film film1;
    private Film film2;

    @BeforeEach
    void setUp() {
        // Initialize a sample actor and films for testing
        actor = new Actor("Alice", "Johnson");
        film1 = new HFilm("The Matrix", "Lana Wachowski", 1999);
        film2 = new HFilm("Blade Runner", "Ridley Scott", 1982);
    }

    @Test
    void testActorGetters() {
        // Test that the getters for first name and last name return the expected values
        assertEquals("Alice", actor.getFirstName(), "Expected first name 'Alice', but got another value");
        assertEquals("Johnson", actor.getLastName(), "Expected last name 'Johnson', but got a different value");
    }

    @Test
    void testSetFirstName() {
        // Test the setter for first name by setting a new value and checking if it is correctly updated
        actor.setFirstName("   Emma    ");
        assertEquals("Emma", actor.getFirstName(), "After setting, expected first name to be 'Emma'");
    }

    @Test
    void testSetLastName() {
        // Test the setter for last name by setting a new value and checking if it is correctly updated
        actor.setLastName(" Williams    ");
        assertEquals("Williams", actor.getLastName(), "After setting, expected last name to be 'Williams'");
    }

    @Test
    void testInvalidFirstName() {
        // Test the constructor and setter for invalid first names (empty or null)
        assertThrows(IllegalArgumentException.class, () -> new Actor("", "Johnson"), "Should not accept empty first name");
        assertThrows(IllegalArgumentException.class, () -> new Actor(null, "Johnson"), "Should not accept null as first name");

        // Test the setter with an invalid first name containing non-alphabetic characters
        assertThrows(IllegalArgumentException.class, () -> actor.setFirstName("!!!"), "Invalid first name with non-alphabetic characters should throw");
    }

    @Test
    void testInvalidLastName() {
        // Test the constructor and setter for invalid last names (empty or null)
        assertThrows(IllegalArgumentException.class, () -> new Actor("Alice", ""), "Should not accept empty last name");
        assertThrows(IllegalArgumentException.class, () -> new Actor("Alice", null), "Should not accept null as last name");

        // Test the setter with an invalid last name containing non-alphabetic characters
        assertThrows(IllegalArgumentException.class, () -> actor.setLastName("Smith123"), "Invalid last name with non-alphabetic characters should throw");
    }

    @Test
    void testAddFilm() {
        // Test adding films to the actor's list of films
        actor.addFilm(film1);
        actor.addFilm(film2);
        assertTrue(actor.getFilms().contains(film1), "Expected 'The Matrix' to be in the film list");
        assertTrue(actor.getFilms().contains(film2), "Expected 'Blade Runner' to be in the film list");
    }

    @Test
    void testRemoveFilm() {
        // Test removing a film from the actor's list of films
        actor.addFilm(film1);
        actor.addFilm(film2);
        actor.removeFilm(film1);
        assertFalse(actor.getFilms().contains(film1), "'The Matrix' should have been removed from the list");
        assertEquals(1, actor.getFilms().size(), "The film list should contain exactly one film after removal");
    }

    @Test
    void testRemoveNonExistentFilm() {
        // Test removing a film that is not in the actor's list of films (expecting an exception)
        actor.addFilm(film2);
        assertThrows(NoSuchElementException.class, () -> actor.removeFilm(film1), "Trying to remove a non-existent film should throw an exception");
    }

    @Test
    void testAddNullFilm() {
        // Test adding null as a film to the actor's list of films (expecting an exception)
        assertThrows(IllegalArgumentException.class, () -> actor.addFilm(null), "Adding null as a film should throw an exception");
    }

    @Test
    void testRemoveNullFilm() {
        // Test removing null from the actor's list of films (expecting an exception)
        assertThrows(IllegalArgumentException.class, () -> actor.removeFilm(null), "Removing null from the film list should throw an exception");
    }

    @Test
    void testUnmodifiableSetOfFilms() {
        // Test that the set of films is unmodifiable directly (expecting an exception when trying to modify it)
        actor.addFilm(film1);
        assertThrows(UnsupportedOperationException.class, () -> actor.getFilms().add(film2), "Modifying the film list directly should throw an exception");
    }

    @Test
    void testToString() {
        // Test that the toString method returns the expected string representation of the actor
        assertEquals("Alice Johnson", actor.toString(), "Expected 'Alice Johnson' as the output from toString()");
    }

    @Test
    void testEqualsAndHashCode() {
        // Test that two actors with the same names are considered equal and have the same hash code
        Actor sameActor = new Actor("Alice", "Johnson");
        Actor differentActor = new Actor("Emma", "Williams");
        assertEquals(actor, sameActor, "Actors with identical names should be considered equal");
        assertNotEquals(actor, differentActor, "Actors with different names should not be equal");
        assertEquals(actor.hashCode(), sameActor.hashCode(), "Actors with the same names should have the same hash code");
        assertNotEquals(actor.hashCode(), differentActor.hashCode(), "Actors with different names should have different hash codes");
        film1.addActor(actor);
        film1.addActor(sameActor);
        assertEquals(film1.getActors().size(), 1, "There should be only one actor with the same name in the set.");
    }
}
