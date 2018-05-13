package ToggleButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class ToggleButtonExample extends JDialog
        implements ActionListener {

    private JToggleButton redButton;
    private JToggleButton greenButton;
    private JToggleButton blueButton;
    private JPanel display;

    public ToggleButtonExample() {

        initUI();
    }

    public final void initUI() {

        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        redButton = new JToggleButton("red");
        redButton.addActionListener(this);

        greenButton = new JToggleButton("green");
        greenButton.addActionListener(this);

        blueButton = new JToggleButton("blue");
        blueButton.addActionListener(this);

        blueButton.setMaximumSize(greenButton.getMaximumSize());
        redButton.setMaximumSize(greenButton.getMaximumSize());

        leftPanel.add(redButton);
        leftPanel.add(Box.createRigidArea(new Dimension(25, 7)));
        leftPanel.add(greenButton
                );
        leftPanel.add(Box.createRigidArea(new Dimension(25, 7)));
        leftPanel.add(blueButton);


        bottom.add(leftPanel);
        bottom.add(Box.createRigidArea(new Dimension(20, 0)));

        display = new JPanel();
        display.setPreferredSize(new Dimension(110, 110));
        display.setBorder(LineBorder.createGrayLineBorder());
        display.setBackground(Color.black);

        bottom.add(display);
        add(bottom);

        pack();
        
        setTitle("JToggleButton");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        Color color = display.getBackground();
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        if (e.getActionCommand().equals("red")) {
            if (red == 0) {
                red = 255;
            } else {
                red = 0;
            }
        }

        if (e.getActionCommand().equals("green")) {
            if (green == 0) {
                green = 255;
            } else {
                green = 0;
            }
        }

        if (e.getActionCommand().equals("blue")) {
            if (blue == 0) {
                blue = 255;
            } else {
                blue = 0;
            }
        }

        Color setCol = new Color(red, green, blue);
        display.setBackground(setCol);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                ToggleButtonExample ex = new ToggleButtonExample();
                ex.setVisible(true);
            }
        });
    }
}
