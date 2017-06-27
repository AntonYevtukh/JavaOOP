package homework.lection02.task03;


public class Dog extends Animal {

    Dog(String name) {
        this.name = name;
    }

    public void voice() {
        System.out.println(name + " is saying Гавк!");
    }
}
