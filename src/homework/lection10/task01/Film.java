package homework.lection10.task01;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Anton on 30.07.2017.
 */
public class Film {

    private String title;
    private int year;
    private Set<Actor> actors = new TreeSet<>(Comparator.comparing((Actor actor) -> actor.toString()));
    private Set<Genre> genres = new TreeSet<>();

    public Film(String title, int year) {
        this.title = title;
        if (year < 1900 || year > 2017)
            throw new IllegalArgumentException("Invalid year value");
        this.year = year;
    }

    public Film addActors(Actor... actors) {
        for(Actor actor : actors)
            this.actors.add(actor);
        return this;
    }

    public Film addGenres(Genre... genres) {
        for (Genre genre : genres)
            this.genres.add(genre);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Title: ");
        result.append(title);
        result.append(";\nYear: ");
        result.append(year);
        result.append(";\nActors: ");
        for(Actor actor : actors)
            result.append(actor + "; ");
        for(Genre genre : genres)
            result.append(genre + "; ");
        result.append("\n");
        return result.toString();
    }
}
