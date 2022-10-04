import java.awt.*;

public class ColorStrategy implements DrawStrategy{
    @Override
    public Shape generateNormal(Point p) {
        Circle c = new Circle(p);
        c.setColor(Color.BLUE);
        return c;
    }

    @Override
    public Shape generateDifferent(Point p) {
        Circle c = new Circle(p);
        c.setColor(Color.RED);
        return c;
    }
}
