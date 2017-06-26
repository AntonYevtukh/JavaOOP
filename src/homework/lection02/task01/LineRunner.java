package homework.lection02.task01;

public class LineRunner {

    public static void main(String[] args) {
        Point a = new Point('A',0.0,0.0);
        Point b = new Point('B',1.0, 1.0);
        Point c = new Point('C',14.0, 88.0);
        Point d = new Point();

        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line cb = new Line(c, b);
        Line ad = new Line(a, d);

        Lines lines = new Lines();
        System.out.println(lines);

        lines.add(ab);
        lines.add(bc);
        lines.add(cb);
        lines.add(ad);
        System.out.println(lines);
    }
}
