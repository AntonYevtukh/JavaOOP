package homework.lection10.task01;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Anton on 30.07.2017.
 */
public class Film implements Serializable {

    private String title;
    private int year;
    private Set<Actor> actors = new TreeSet<>(Actor.getComparator());
    private Set<Genre> genres = new TreeSet<>(Genre.getComparator());

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
        StringJoiner valuesJoiner;
        result.append(title);
        result.append(";\nYear: ");
        result.append(year);

        result.append(";\nActors: ");
        valuesJoiner = new StringJoiner(", ");
        for(Actor actor : actors)
            valuesJoiner.add(actor.toString());
        result.append(valuesJoiner.toString());

        result.append(";\nGenres: ");
        valuesJoiner = new StringJoiner(", ");
        for(Genre genre : genres)
            valuesJoiner.add(genre.name());
        result.append(valuesJoiner.toString());
        result.append(";\n");
        return result.toString();
    }
}
