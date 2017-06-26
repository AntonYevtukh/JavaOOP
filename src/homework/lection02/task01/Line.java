package homework.lection02.task01;

public class Line {

    final private Point start;
    final private Point end;

    Line()
    {
        this.start = new Point();
        this.end = new Point('1',1.0,1.0);
    }

    Line(Point start, Point end) {
        if (start.getX() != end.getX() || start.getY() != end.getY()) {
            this.start = start;
            this.end = end;
        }
        else {
            this.start = new Point();
            this.end = new Point('1',1.0, 1.0);
            System.out.println("Start and end points are equals. Line initialized by default points values 0(0, 0) and 1(1, 1)");
        }
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    double getLength() {
        return Math.sqrt((end.getX() - start.getX()) * (end.getX() - start.getX()) + (end.getY() - start.getY()) * (end.getY() - start.getY()));
    }

    public String toString()
    {
        return "Line's name is " + start.getName() + end.getName() + ", start is " + start.toString() + ", end is " + end.toString() + ", length is " +
                String.format("%.4f",getLength()) + ".";
    }
}
