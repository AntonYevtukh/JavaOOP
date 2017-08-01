package homework.lection10.task01;

import java.util.*;

/**
 * Created by Anton on 30.07.2017.
 */
public class Films {

    private List<Film> films = new ArrayList<>();

    public Films() {
    }

    public Films(Film... films) {
        addFilms(films);
    }

    public Films(Films anotherFilms) {
        for (Film film : anotherFilms.films)
            this.films.add(film);
    }

    public Films addFilms(Film... films) {
        for (Film film : films)
            this.films.add(film);
        return this;
    }

    public List<Film> getFilms() {
        return films;
    }

    public Films clearFilms() {
        films = new ArrayList<>();
        return this;
    }

    public Films foundByGenres(Genre... genres) {

        Set<Genre> requestedGenresSet = new TreeSet<Genre>(Arrays.asList(genres));
        Films foundFilms = new Films();
        for (Film film : films)
            for (Genre genre : film.getGenres())
                if (requestedGenresSet.contains(genre))
                    foundFilms.films.add(film);
        return foundFilms;
    }

    public Films foundByActors(Actor... actors) {
        Set<Actor> requestedActorsSet = new TreeSet<Actor>(Arrays.asList(actors));
        Films foundFilms = new Films();
        for (Film film : films)
            for (Actor actor : film.getActors())
                if (requestedActorsSet.contains(actor))
                    foundFilms.films.add(film);
        return foundFilms;
    }

    public Films foundByYears(int fromYear, int toYear) {
        Films foundFilms = new Films(this);
        foundFilms.films.removeIf((Film film) -> film.getYear() < fromYear || film.getYear() > toYear);
        return foundFilms;
    }
}
