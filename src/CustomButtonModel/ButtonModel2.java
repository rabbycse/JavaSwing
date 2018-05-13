package CustomButtonModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ButtonModel2 extends JFrame {

    private JButton ok;
    private JLabel enabled;
    private JLabel pressed;
    private JLabel armed;

    public ButtonModel2() {

        setTitle("ButtonModel");

        JPanel panel = new JPanel();
        panel.setLayout(null);

        ok = new JButton("ok");
        JCheckBox cb = new JCheckBox("Enabled", true);

        ok.setBounds(40, 30, 80, 25);

        cb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ok.isEnabled())
                    ok.setEnabled(false);
                else 
                    ok.setEnabled(true);
            }
        });

        cb.setBounds(180, 30, 100, 25);

        enabled = new JLabel("Enabled: true");
        enabled.setBounds(40, 90, 90, 25);
        pressed = new JLabel("Pressed: false");
        pressed.setBounds(40, 120, 90, 25);
        armed  = new JLabel("Armed: false");
        armed.setBounds(40, 150, 90, 25);

        ButtonModel model = new DefaultButtonModel() {
            public void setEnabled(boolean b) {
                if (b)
                    enabled.setText("Enabled: true");
                else 
                    enabled.setText("Enabled: false");

                super.setEnabled(b);
            }

            public void setArmed(boolean b) {
                if (b)
                    armed.setText("Armed: true");
                else
                    armed.setText("Armed: false");

                super.setArmed(b);
            }

            public void setPressed(boolean b) {
                if (b)
                    pressed.setText("Pressed: true");
                else 
                    pressed.setText("Pressed: false");

                super.setPressed(b);
            }

        };

        ok.setModel(model);

        panel.add(ok);
        panel.add(cb);
        panel.add(enabled);
        panel.add(pressed);
        panel.add(armed);

        add(panel);

        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonModel2();
    }
}
