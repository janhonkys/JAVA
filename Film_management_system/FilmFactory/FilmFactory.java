package projektPC2_designpatterns.FilmFactory;

import projektPC2_designpatterns.Film.Film;

// Interface for creating film objects.
public interface FilmFactory {
    // Method to create a film with given details.
    Film createFilm(String name, String director, int year);
}
