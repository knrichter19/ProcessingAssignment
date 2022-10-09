import java.awt.*;
import java.util.Random;

public class ComboStrategy implements DrawStrategy {
    private Random r;
    public ComboStrategy(){
        r = new Random();
    }
    @Override
    public Shape generateNormal(Point p) {
        if (r.nextInt(2) == 1){
            Circle c = new Circle(p);
            c.setColor(Color.BLUE);
            c.setRadius(10);
            return c;
        }

        Square s = new Square(p, 20);
        s.setColor(Color.RED);
        return s;
    }

    @Override
    public Shape generateDifferent(Point p) {
        Circle c = new Circle(p);
        c.setColor(Color.RED);
        c.setRadius(10);
        return c;
    }


    @Override
    public String getDifferentName() {
        return "red circle";
    }
}
