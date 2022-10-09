import java.awt.*;

public class ShapeStrategy implements DrawStrategy{
    private double width;

    public ShapeStrategy(int numStimuli, int screenWidth){
        calculateAndSetSize(numStimuli, screenWidth);
    }
    @Override
    public Shape generateNormal(Point p) {
        Circle c = new Circle(p);
        c.setColor(Color.RED);
        c.setRadius((int)Math.floor(width/2));
        return c;
    }

    @Override
    public Shape generateDifferent(Point p) {
        Square s = new Square(p, (int)Math.floor(width));
        s.setColor(Color.RED);
        return s;
    }

    @Override
    public String getDifferentName() {
        return "red square";
    }

    public void calculateAndSetSize(int numStimuli, int screenArea){
        double approxWidth = Math.sqrt((double)screenArea/numStimuli) / 2;
        width = approxWidth;
    }
}
