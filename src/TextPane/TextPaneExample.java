package TextPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class TextPaneExample extends JFrame {

    public TextPaneExample() {

        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane pane = new JScrollPane();
        JTextPane textpane = new JTextPane();

        textpane.setContentType("text/html");
        textpane.setEditable(false);

//        String cd = System.getProperty("user.dir") + "/";

        try {
//            textpane.setPage("File:///" + cd + "html.html");
        	textpane.setPage(getClass().getResource("/res/html.html"));
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }

        textpane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        pane.getViewport().add(textpane);
        panel.add(pane);

        add(panel);

        setTitle("JTextPane");
        setSize(new Dimension(380, 320));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                TextPaneExample ex = new TextPaneExample();
                ex.setVisible(true);
            }
        });
    }
}
