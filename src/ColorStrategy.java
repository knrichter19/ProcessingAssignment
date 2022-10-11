import java.awt.*;

public class ColorStrategy implements DrawStrategy{
    private int radius;

    public ColorStrategy(int numStimuli, int screenArea){
        calculateAndSetSize(numStimuli, screenArea);
    }
    @Override
    public Shape generateNormal(Point p) {
        Circle c = new Circle(p);
        c.setColor(Color.BLUE);
        c.setRadius(radius);
        return c;
    }

    @Override
    public Shape generateDifferent(Point p) {
        Circle c = new Circle(p);
        c.setColor(Color.RED);
        c.setRadius(radius);
        return c;
    }
    @Override
    public String getDifferentName() {
        return "red circle";
    }

    @Override
    public String getStrategyName() {
        return "Color";
    }

    public void calculateAndSetSize(int numStimuli, int screenArea){
        double approxArea = Math.sqrt((double)screenArea/numStimuli) / 2;
        radius = (int) Math.floor(approxArea/2);
    }

    @Override
    public double getWidth() {
        return (double)radius*2;
    }
}
