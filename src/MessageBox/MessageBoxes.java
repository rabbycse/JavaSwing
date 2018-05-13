package MessageBox;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class MessageBoxes extends JFrame {

    private JPanel panel;

    public MessageBoxes() {

        initUI();
    }

    public final void initUI() {

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JButton error = new JButton("Error");
        JButton warning = new JButton("Warning");
        JButton question = new JButton("Question");
        JButton information = new JButton("Information");

        error.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(panel, "Could not open file",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        warning.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(panel, "A deprecated call",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        question.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(panel, "Are you sure to quit?",
                        "Question", JOptionPane.QUESTION_MESSAGE);
            }
        });

        information.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(panel, "Download completed",
                        "Question", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(error);
        panel.add(warning);
        panel.add(question);
        panel.add(information);

        add(panel);

        setTitle("Message Boxes");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MessageBoxes mb = new MessageBoxes();
                mb.setVisible(true);
            }
        });
    }
}