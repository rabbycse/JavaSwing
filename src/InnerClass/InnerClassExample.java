package InnerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class InnerClassExample extends JFrame {

    public InnerClassExample() {

        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(40, 50, 80, 25);

        ButtonCloseListener listener = new ButtonCloseListener();
        closeButton.addActionListener(listener);

        panel.add(closeButton);
        add(panel);

        setTitle("Inner class example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class ButtonCloseListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                InnerClassExample ex = new InnerClassExample();
                ex.setVisible(true);
            }
        });
    }
}