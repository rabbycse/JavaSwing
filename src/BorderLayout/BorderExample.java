package BorderLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class BorderExample extends JFrame {


    public BorderExample() {

        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel(new BorderLayout());
        JPanel top = new JPanel();

        top.setBackground(Color.gray);
        top.setPreferredSize(new Dimension(250, 150));
        panel.add(top);

        panel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        add(panel);

        pack();

        setTitle("Border Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                BorderExample ex = new BorderExample();
                ex.setVisible(true);
            }
        });
    }
}
