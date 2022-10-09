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
                DrawStrategy s = null;
                ProcessingTestForm pt = new ProcessingTestForm();
                switch(stimCombo.getSelectedItem().toString()){
                    case "Shape":
                        pt.setStrategy(new ShapeStrategy());
                        break;
                    case "Color":
                        pt.setStrategy(new ColorStrategy());
                        break;
                    case "Combo":
                        pt.setStrategy(new ComboStrategy());
                }

                if ((int)numSpinner.getValue() <= 0){
                    // add error popup
                    return;
                }

                if (nameField.getText().length() == 0){
                    // add error popup
                    return;
                }

                pt.setNumStimuli((int)numSpinner.getValue());
                pt.setSubjectName(nameField.getText());
                JFrame frame = new JFrame("ProcessingTestForm");
                frame.setContentPane(pt.formPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
