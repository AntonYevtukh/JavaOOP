package homework.lection10.task01;

/**
 * Created by Anton on 30.07.2017.
 */
public class Actor {

    private String name;
    private String surname;

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int hashCode() {
        return 31 * name.hashCode() + surname.hashCode();
    }

    public boolean equals(Object o) {
        if (this.getClass() != o.getClass())
            return false;
        else {
            Actor anotherActor = (Actor)o;
            if (anotherActor.hashCode() != this.hashCode())
                return false;
            if (anotherActor.name != this.name || anotherActor.surname != this.surname)
                return false;
            return true;
        }
    }

    public String toString() {
        return name + " " + surname;
    }
}
