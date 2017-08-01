package homework.lection10.task01;

/**
 * Created by Anton on 01.08.2017.
 */
public class IOFilmsRunner {

    public static void main(String[] args) {
        Actor stallone = new Actor("Sylvester", "Stallone");
        Actor lundgren = new Actor("Dolph", "Lundgren");
        Actor stathem = new Actor("Jason", "Stathem");
        Actor willis = new Actor("Bruce", "Willis");
        Actor schwarzenegger = new Actor("Arnold", "Schwarzenegger");
        Actor norris = new Actor("Chuck", "Norris");

        Film rocky4 = new Film("Rocky 4", 1985);
        rocky4.addActors(stallone, lundgren);
        rocky4.addGenres(Genre.DRAM, Genre.SPORT);

        Film expendables = new Film("The Expendables", 2010);
        expendables.addActors(stallone, lundgren, stathem);
        expendables.addGenres(Genre.ACTION, Genre.COMEDY);

        Film expendables2 = new Film("The expendables 2", 2012);
        expendables2.addActors(stallone, lundgren, stathem, schwarzenegger, willis, norris);
        expendables2.addGenres(Genre.ACTION, Genre.COMEDY);

        IOFilms ioFilms = new IOFilms();
        ioFilms.addFilms(rocky4, expendables, expendables2);

        try {
            System.out.println("Films, created by runner:");
            System.out.println(ioFilms);
            ioFilms.writeFilmsIntoFile("Films.csv");
            ioFilms.clearFilms();
            System.out.println("Films after clearing:");
            System.out.println(ioFilms);
            System.out.println("Films after reading from csv file:");
            ioFilms.readFilmsFromFile("Films.csv");
            System.out.println(ioFilms);

            ioFilms.writeFilmsIntoBinFile("Films.dat");
            ioFilms.clearFilms();
            System.out.println("Films after clearing:");
            System.out.println(ioFilms);
            System.out.println("Films after reading from binary file:");
            ioFilms.readFilmsFromBinFile("Films.dat");
            System.out.println(ioFilms);
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}
