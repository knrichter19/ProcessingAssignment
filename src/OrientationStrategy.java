import java.awt.*;

public class OrientationStrategy implements DrawStrategy{

    int width;

    public OrientationStrategy(int numStimuli, int screenArea){
        calculateAndSetSize(numStimuli, screenArea);
    }
    @Override
    public Shape generateNormal(Point p) {
        return new Triangle(p, width, true);
    }

    @Override
    public Shape generateDifferent(Point p) {
        return new Triangle(p, width, false);
    }

    @Override
    public String getDifferentName() {
        return "downwards triangle";
    }

    @Override
    public String getStrategyName() {
        return "Orientation";
    }

    @Override
    public void calculateAndSetSize(int numStimuli, int screenArea) {
        this.width = (int)Math.floor(Math.sqrt((double)screenArea/numStimuli) / 2);
    }

    @Override
    public double getWidth() {
        return width;
    }
}
