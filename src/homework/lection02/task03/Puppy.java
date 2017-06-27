package homework.lection02.task03;

public class Puppy extends Dog {

    Puppy(String name) {
        super(name);
    }

    public void voice() {
        System.out.println(name + " is saying Тяф!");
    }
}
