package projektPC2_designpatterns.FilmFactory;

import projektPC2_designpatterns.Film.Film;
import projektPC2_designpatterns.Film.HFilm;

// Factory for creating feature films.
public class HFilmFactory implements FilmFactory {
    // Creates an HFilm.
    @Override
    public Film createFilm(String name, String director, int year) {
        return new HFilm(name, director, year);
    }
}
