import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class TestingPanel extends JPanel {
    private ArrayList<Shape> shapes;
    private Random ran;
    private int numStimuli;
    private int border;
    private boolean difExists;

    public DrawStrategy typeStrategy;

    public enum Modes {}

    public TestingPanel(int numStimuli){
        ran = new Random();
        shapes = new ArrayList<>();
        this.numStimuli = numStimuli;
        border = 20;
    }

    public void setTypeStrategy(DrawStrategy ds){
        this.typeStrategy = ds;
    }

    public void start(){
        this.difExists = ran.nextInt(2) == 1;
        for (int i = 0; i < (difExists? numStimuli-1 : numStimuli); i++){
            shapes.add(typeStrategy.generateNormal(getPointInBounds()));
        }

        if (difExists){
            shapes.add(typeStrategy.generateDifferent(getPointInBounds()));
        }


    }

    public void stop(){
        shapes.clear();
    }

    public boolean difExists(){
        return difExists;
    }

    private Point getPointInBounds(){
        int x = ran.nextInt(getWidth() - border*2) + border;
        int y = ran.nextInt(getHeight() - border*2) + border;
        return new Point(x,y);
    }


}
