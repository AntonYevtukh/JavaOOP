package homework.lection02.task03;

public abstract class Animal {

    protected String name;

    public void printName() {
        System.out.println(name);
    }

    public void jump() {
        System.out.println(name + " is jumping");
    }

    public void run() {
        System.out.println(name + " is running");
    }

    public void bite() {
        System.out.println(name + " is biting");
    }

    public abstract void voice();
}
