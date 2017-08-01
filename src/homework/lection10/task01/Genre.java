package homework.lection10.task01;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Anton on 30.07.2017.
 */
public enum Genre implements Serializable {

    ACTION, WAR, FAMILY, DETECTIVE, THRILLER, HORROR, HISTORICAL, ADVENTURE,
    COMEDY, DRAM, CATASTROPHE, SCIENCE_FICTION, FANTASY, SPORT;

    public static boolean isGenre(String s) {
        for (Genre genre : Genre.values())
            if (s.equals(genre.name()))
                return true;
        return false;
    }

    public static GenreComparator getComparator() {
        return new GenreComparator();
    }

    private static class GenreComparator implements Comparator<Genre>, Serializable {

        public int compare(Genre genre1, Genre genre2) {
            return genre1.name().compareTo(genre2.name());
        }
    }
}
