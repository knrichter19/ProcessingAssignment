import java.awt.*;

public interface DrawStrategy {
    Shape generateNormal(Point p);

    Shape generateDifferent(Point p);

    String getDifferentName();

    String getStrategyName();

    void calculateAndSetSize(int numStimuli, int screenArea);

    double getWidth();
}
