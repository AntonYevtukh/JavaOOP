package homework.lection10.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Anton on 31.07.2017.
 */
public class IOFilms extends Films implements Serializable {

    private static final String FIELDS_DELIMITER = ";";
    private static final String VALUES_DELIMITER = ",";
    private static final String SEPARATOR = "------------------------------------------------------------------\n";

    public IOFilms readFilms(BufferedReader bufferedReader) {
        clearFilms();
        String line;
        int lineNumber = 1;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    getFilms().add(parseFilm(line, FIELDS_DELIMITER, VALUES_DELIMITER));
                } catch (FilmParseException exc) {
                    System.out.println("Error parsing film at line " + lineNumber + ":");
                    exc.printStackTrace(System.out);
                }
            }
        } catch (IOException exc) {
            System.out.println("Sorry, IOException");
        }
        return this;
    }

    public IOFilms readFilmsFromFile(String fileName)
            throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return readFilms(bufferedReader);
        }
    }

    public IOFilms writeFilms(PrintWriter printWriter) {
        for (Film film : getFilms())
            printWriter.println(filmToOutputString(film, FIELDS_DELIMITER, VALUES_DELIMITER));
        return this;
    }

    public IOFilms writeFilmsIntoFile(String filename)
            throws IOException {
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            writeFilms(printWriter);
        }
        return this;
    }

    public IOFilms readFilmsFromBinFile(String filename) {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(filename))) {
            clearFilms();
            List<Film> films = (List<Film>)objectInput.readObject();
            for (Film film : films)
                getFilms().add(film);
        } catch (ClassNotFoundException | ClassCastException | IOException exc) {
            throw new IllegalArgumentException("Binary file is corrupted or missed", exc);
        }
        return this;
    }

    public IOFilms writeFilmsIntoBinFile(String filename) {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutput.writeObject(getFilms());
        } catch (IOException exc) {
            System.out.println(exc);
            exc.printStackTrace();
        }
        return this;
    }

    /**
     * @throws FilmParseException
     */
    private static Film parseFilm(String line, String fieldsDelimiter, String valuesDelimiter) {
        String[] tokens = line.split(fieldsDelimiter);

        if (tokens.length < 4)
            throw new FilmParseException("Invalid input format or fields are missing");

        try {
            String title = tokens[0];
            int year = parseYear(tokens[1]);
            Actor[] actors = parseActors(tokens[2], valuesDelimiter);
            Genre[] genres = parseGenres(tokens[3], valuesDelimiter);
            return new Film(title, year).addActors(actors).addGenres(genres);
        } catch (YearParseException exc) {
            FilmParseException exc2 = new FilmParseException("Invalid year format or value");
            exc2.initCause(exc);
            throw exc2;
        }
    }

    private static Actor[] parseActors(String line, String valueDelimiter) {
        List<Actor> actors = new ArrayList<>();
        String[] tokens = line.split(valueDelimiter);
        for (String token : tokens) {
            try {
                actors.add(parseActor(token));
            } catch (ActorParseException exc) {
                System.out.println("Invalid actor's name; Ignored;");
            }
        }
        return actors.stream().toArray(Actor[]::new);
        //return actors.toArray(new Actor[actors.size()]);
    }

    private static Genre[] parseGenres(String line, String valueDelimiter) {
        List<Genre> genres = new ArrayList<>();
        String[] tokens = line.split(valueDelimiter);
        for (String token : tokens) {
            try {
                genres.add(parseGenre(token));
            } catch (GenreParseException exc) {
                System.out.println("Invalid genre; Ignored;");
            }
        }
        return genres.stream().toArray(Genre[]::new);
        //return genres.toArray(new Genre[genres.size()]);
    }

    private static Actor parseActor(String line) {
        if (line.matches("[ ]+"))
            throw new ActorParseException("Empty actor's name");
        String[] fullName = line.split(" ");
        if (fullName.length < 2)
            throw new ActorParseException("Invalid actor's full name");
        return new Actor(fullName[0], fullName[1]);
    }

    private static Genre parseGenre(String line) {
        if (line.matches("[ ]+"))
            throw new GenreParseException("Empty genre");
        if (!Genre.isGenre(line))
            throw new GenreParseException("Invalid genre");
        return Genre.valueOf(line);
    }

    private static int parseYear(String line) {
        try {
            int year = Integer.parseInt(line);
            if (year < 1900 || year > 2017)
                throw new YearParseException("Invalid year value - not in range <1900, 2017>");
            return year;
        } catch (IllegalArgumentException exc) {
            throw new YearParseException("Invalid year line - not an integer;");
        }
    }

    private static String filmToOutputString(Film film, String fieldsDelimiter, String valuesDelimiter) {
        StringJoiner fieldsJoiner = new StringJoiner(fieldsDelimiter);
        StringJoiner valuesJoiner;
        fieldsJoiner.add(film.getTitle());
        fieldsJoiner.add(String.valueOf(film.getYear()));

        if (film.getActors().isEmpty())
            fieldsJoiner.add(" ");
        else {
            valuesJoiner = new StringJoiner(valuesDelimiter);
            for (Actor actor : film.getActors())
                valuesJoiner.add(actor.toString());
            fieldsJoiner.add(valuesJoiner.toString());
        }
        if (film.getGenres().isEmpty())
            fieldsJoiner.add(" ");
        else {
            valuesJoiner = new StringJoiner(valuesDelimiter);
            for (Genre genre : film.getGenres())
                valuesJoiner.add(genre.name());
            fieldsJoiner.add(valuesJoiner.toString());
        }

        return fieldsJoiner.toString();
    }

    public String toString() {
        if (getFilms().isEmpty())
            return SEPARATOR + "Film list is empty\n" + SEPARATOR;
        else {
            StringJoiner filmJoiner = new StringJoiner("\n", SEPARATOR, SEPARATOR);
            for (Film film : getFilms())
                filmJoiner.add(film.toString());
            return filmJoiner.toString();
        }
    }
}
