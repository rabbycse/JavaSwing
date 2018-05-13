package AnonymousInnerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class AnonymousInnerClassExample extends JFrame {


    public AnonymousInnerClassExample() {

        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(40, 50, 80, 25);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        panel.add(closeButton);
        add(panel);

        setTitle("Anonymous inner class");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                AnonymousInnerClassExample ex =
                        new AnonymousInnerClassExample();
                ex.setVisible(true);
            }
        });
    }
}
