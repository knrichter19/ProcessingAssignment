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

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProcessingTestMasterForm");
        frame.setContentPane(new ProcessingTestStart().formPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ProcessingTestStart() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int)numSpinner.getValue() <= 0){
                    // add error popup
                    return;
                }

                if (nameField.getText().length() == 0){
                    // add error popup
                    return;
                }
                ProcessingTestForm pt = new ProcessingTestForm();
                int numStimuli = (int) numSpinner.getValue();
                switch (stimCombo.getSelectedItem().toString()) {
                    case "Shape" -> pt.setStrategy(new ShapeStrategy(numStimuli, (500 * 500)));
                    case "Color" -> pt.setStrategy(new ColorStrategy(numStimuli, (500 * 500)));
                    case "Combo" -> pt.setStrategy(new ComboStrategy(numStimuli, (500 * 500)));
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
