package projektPC2_designpatterns.FilmFactory;

import projektPC2_designpatterns.Film.AFilm;
import projektPC2_designpatterns.Film.Film;
import projektPC2_designpatterns.Inputs;

// Factory for creating animated films.
public class AFilmFactory implements FilmFactory {
    // Creates an AFilm with a recommended age.
    @Override
    public Film createFilm(String name, String director, int year) {
        int recommendedAge = Inputs.onlyNumbers(0, 100);
        return new AFilm(name,director,year,recommendedAge);
    }
}
