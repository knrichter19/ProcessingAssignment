import java.awt.*;

public interface DrawStrategy {
    Shape generateNormal(Point p);

    Shape generateDifferent(Point p);

    String getDifferentName();
}
