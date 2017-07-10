package additional.lection01.task01;

public class CatRunner {

    public static void main(String[] args) {
        Cat filya = new Cat("Filua", Cat.CatColor.BLACK, 7.5);
        Cat kapa = new Cat("Kapa", Cat.CatColor.BLACK, 3.5);
        kapa.attack(filya);
    }
}
