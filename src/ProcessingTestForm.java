import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingTestForm extends JFrame {
    protected JPanel formPanel;
    private JPanel displayPanel;
    private JButton startButton;
    private TestingPanel testPanel;
    private Timer timer;

    private String subjectName;


    JFrame frame;

    String writeFile;

    private DrawStrategy strategy;

    private int numStimuli;

    private int numMilis;
    private int correctStreak;

    public ProcessingTestForm(){
        numMilis = 150;
        correctStreak = 0;
        writeFile = "ProcessingResults.txt";

        ProcessingTestForm f = this;

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runTest(numMilis);

            }
        });

        testPanel = new TestingPanel();
        displayPanel.setPreferredSize(new Dimension(500,500));
        displayPanel.add(testPanel);
    }

    public void setFrame(JFrame f){
        this.frame = f;
    }

    public void setSubjectName(String s){
        this.subjectName = s;
    }


    // returns true if correctly answered, false if not
    private void runTest(int numMilis){
        testPanel.setTypeStrategy(strategy);
        System.out.println("Running test");
        testPanel.start();
        System.out.println("Here");


        timer = new Timer(numMilis, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("in timer");
                testPanel.stop();
                timer.stop();
                boolean difExists = testPanel.difExists();
                int input = JOptionPane.showConfirmDialog(null,
                        "Was there a " + strategy.getDifferentName(), "Select an Option...", JOptionPane.YES_NO_OPTION);
                addToScore(((difExists && input == JOptionPane.YES_OPTION) || (!difExists && input == JOptionPane.NO_OPTION)));
            }
        });

        timer.start();

    }

    private void addToScore(boolean correct){
        System.out.println("Adding to score");
        if (correct){
            correctStreak++;
        } else {
            correctStreak = 0;
            numMilis += 25;
        }

        System.out.println(correctStreak);

        if (correctStreak == 10){
            recordWin();
            showResults();
        }
    }

    private void recordWin(){
        System.out.println("you win");
    }

    private void showResults(){

    }

    public DrawStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(DrawStrategy strategy) {
        this.strategy = strategy;
    }

    public int getNumStimuli() {
        return numStimuli;
    }

    public void setNumStimuli(int numStimuli) {
        this.numStimuli = numStimuli;
        testPanel.setNumStimuli(numStimuli);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProcessingTestForm");
        frame.setContentPane(new ProcessingTestForm().formPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
