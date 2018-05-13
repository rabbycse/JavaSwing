package MultipleListeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;


@SuppressWarnings("serial")
public class MultipleListeners extends JFrame {

    private JLabel statusbar;
    private JSpinner spinner;
    private static int count = 0;

    public MultipleListeners() {

        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel();
        statusbar = new JLabel("0");

        statusbar.setBorder(BorderFactory.createEtchedBorder(
                EtchedBorder.RAISED));

        panel.setLayout(null);

        JButton add = new JButton("+");
        add.setBounds(40, 30, 80, 25);
        add.addActionListener(new ButtonListener1());
        add.addActionListener(new ButtonListener2());

        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        SpinnerModel yearModel = new SpinnerNumberModel(currentYear,
                currentYear - 100,
                currentYear + 100,
                1);

        spinner = new JSpinner(yearModel);
        spinner.setEditor(new JSpinner.NumberEditor(spinner, "#"));

        spinner.setBounds(190, 30, 80, 25);

        panel.add(add);
        panel.add(spinner);

        add(panel);
        add(statusbar, BorderLayout.SOUTH);

        setTitle("Multiple Listeners");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class ButtonListener1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Integer val = (Integer) spinner.getValue();
            spinner.setValue(++val);
        }
    }

    class ButtonListener2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            statusbar.setText(Integer.toString(++count));
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MultipleListeners ml = new MultipleListeners();
                ml.setVisible(true);
            }
        });
    }
}
