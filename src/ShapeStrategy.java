import java.awt.*;

public class ShapeStrategy implements DrawStrategy{
    @Override
    public Shape generateNormal(Point p) {
        Circle c = new Circle(p);
        c.setColor(Color.RED);
        c.setRadius(10);
        return c;
    }

    @Override
    public Shape generateDifferent(Point p) {
        Square s = new Square(p, 20);
        s.setColor(Color.RED);
        return s;
    }

    @Override
    public String getDifferentName() {
        return "red square";
    }
}
