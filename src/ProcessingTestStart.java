import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingTestStart {
    private JTextField nameField;
    private JSpinner numSpinner;
    private JComboBox stimCombo;
    private JButton startButton;
    private JLabel nameLabel;
    private JLabel numLabel;
    private JLabel stimuliLabel;
    private JPanel formPanel;

    private int screenWidth;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProcessingTestMasterForm");
        frame.setContentPane(new ProcessingTestStart().formPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ProcessingTestStart() {
        screenWidth = 1000;
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int)numSpinner.getValue() <= 0){
                    JOptionPane.showMessageDialog(formPanel, "Please choose a positive number of stimuli");
                    return;
                }

                if (nameField.getText().length() == 0){
                    JOptionPane.showMessageDialog(formPanel, "Please enter your name");
                    return;
                }
                ProcessingTestForm pt = new ProcessingTestForm();
                int numStimuli = (int) numSpinner.getValue();
                switch (stimCombo.getSelectedItem().toString()) {
                    case "Shape" -> pt.setStrategy(new ShapeStrategy(numStimuli, (screenWidth * screenWidth)));
                    case "Color" -> pt.setStrategy(new ColorStrategy(numStimuli, (screenWidth * screenWidth)));
                    case "Combo" -> pt.setStrategy(new ComboStrategy(numStimuli, (screenWidth * screenWidth)));
                    case "Orientation" -> pt.setStrategy(new OrientationStrategy(numStimuli, (screenWidth*screenWidth)));
                }

                pt.setNumStimuli((int)numSpinner.getValue());
                pt.setSubjectName(nameField.getText());
                JFrame frame = new JFrame("ProcessingTestForm");
                pt.setFrame(frame);
                frame.setContentPane(pt.formPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
