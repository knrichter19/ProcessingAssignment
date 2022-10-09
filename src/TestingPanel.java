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

    private int width;
    private int height;

    public DrawStrategy typeStrategy;

    public enum Modes {}

    public TestingPanel(){
        setBackground(Color.lightGray);
        width = 500;
        height = 500;
        setPreferredSize(new Dimension(width, height));
        ran = new Random();
        shapes = new ArrayList<>();
        border = 5;
    }

    public void setTypeStrategy(DrawStrategy ds){
        this.typeStrategy = ds;
    }

    public void start(){
        System.out.println("Starting panel");
        this.difExists = ran.nextInt(2) == 1;
        System.out.println(numStimuli);
        for (int i = 0; i < (difExists? numStimuli-1 : numStimuli); i++){
            shapes.add(typeStrategy.generateNormal(getPointInBounds()));
            System.out.println("Adding normal obj");
        }

        if (difExists){
            shapes.add(typeStrategy.generateDifferent(getPointInBounds()));
            System.out.println("Adding dif obj");
        }
        repaint();
    }

    public void stop(){
        System.out.println("Stoppint panel");
        shapes.clear();
        repaint();
    }

    public boolean difExists(){
        return difExists;
    }

    private Point getPointInBounds(){
        int x = ran.nextInt(width - border*2) + border;
        int y = ran.nextInt(height - border*2) + border;
        return new Point(x,y);
    }

    public void setNumStimuli(int numStimuli){
        this.numStimuli = numStimuli;
    }

    @Override
    protected synchronized void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Shape s: shapes){
            s.paint(g);
        }
        repaint();
    }
}
