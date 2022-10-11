import java.awt.*;
import java.util.Random;

public class ComboStrategy implements DrawStrategy {
    private double width;
    private Random r;
    public ComboStrategy(int numStimuli, int screenArea){
        calculateAndSetSize(numStimuli, screenArea);
        r = new Random();
    }
    @Override
    public Shape generateNormal(Point p) {
        if (r.nextInt(2) == 1){
            Circle c = new Circle(p);
            c.setColor(Color.BLUE);
            c.setRadius((int)Math.floor(width/2));
            return c;
        }

        Square s = new Square(p, (int)Math.floor(width));
        s.setColor(Color.RED);
        return s;
    }

    @Override
    public Shape generateDifferent(Point p) {
        Circle c = new Circle(p);
        c.setColor(Color.RED);
        c.setRadius((int)Math.floor(width/2));
        return c;
    }


    @Override
    public String getDifferentName() {
        return "red circle";
    }

    @Override
    public String getStrategyName() {
        return "Combo";
    }

    public void calculateAndSetSize(int numStimuli, int screenArea){
        width = Math.sqrt((double)screenArea/numStimuli) / 2;
    }

    @Override
    public double getWidth() {
        return width;
    }
}
