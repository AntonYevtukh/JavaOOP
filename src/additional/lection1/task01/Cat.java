package additional.lection1.task01;

public class Cat {

    private final String name;
    private final CatColor color;
    private final double weight;
    private int health = 100;
    private int strength = 20;

    Cat(String name, CatColor color, double weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public CatColor getColor() {
        return color;
    }

    public String voice() {
        return "Meau!";
    }

    public void attack(Cat anotherCat) {
        if (health > 10 && anotherCat != this) {
            System.out.println(this + "Attacking cat " + anotherCat.name + " on " + calculateDamage() + " damage");
            anotherCat.defend(this);
        }
    }

    public void defend(Cat anotherCat) {
        if (anotherCat != this) {
            health = health - anotherCat.calculateDamage();
            strength = strength > 2 ? (strength - health / 40) : 2;
            if (health > 10)
                attack(anotherCat);
            else
                System.out.println("Meau! Cat " + anotherCat.name + " wins!");
        }

    }

    private int calculateDamage() {
        return (int) (strength * weight / 10);
    }

    public enum CatColor {
        BLACK, WHITE, GREY, GINGER, MULTICOLOR
    }

    public String toString() {
        return color + " cat " + name + ": weight " + weight + ", health " + health + ", strength: " + strength + ".\n";
    }
}
