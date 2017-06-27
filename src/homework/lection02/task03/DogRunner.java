package homework.lection02.task03;

import java.util.ArrayList;

public class DogRunner {

    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Rex"));
        dogs.add(new Dog("Max"));
        dogs.add(new Puppy("Kebab"));

        for (Dog dog : dogs) {
            dog.printName();
            dog.run();
            dog.jump();
            dog.bite();
            dog.voice();
        }
    }
}
