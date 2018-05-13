package DocumentModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


@SuppressWarnings("serial")
public class DocumentModel extends JFrame {

    private StyledDocument doc;
    private JTextPane textpane;

    public DocumentModel() {

        setTitle("Document Model");

        JToolBar toolbar = new JToolBar();

        ImageIcon bold = new ImageIcon(getClass().getResource("/res/bold.png"));
        ImageIcon italic = new ImageIcon(getClass().getResource("/res/italic.png"));
        ImageIcon strike = new ImageIcon(getClass().getResource("/res/strike.png"));
        ImageIcon underline = new ImageIcon(getClass().getResource("/res/underline.png"));

        JButton boldb = new JButton(bold);
        JButton italb = new JButton(italic);
        JButton strib = new JButton(strike);
        JButton undeb = new JButton(underline);

        toolbar.add(boldb);
        toolbar.add(italb);
        toolbar.add(strib);
        toolbar.add(undeb);

        add(toolbar, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane pane = new JScrollPane();
        textpane = new JTextPane(); 
        textpane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        doc = textpane.getStyledDocument();

        Style style = textpane.addStyle("Bold", null);
        StyleConstants.setBold(style, true);

        style = textpane.addStyle("Italic", null);
        StyleConstants.setItalic(style, true);

        style = textpane.addStyle("Underline", null);
        StyleConstants.setUnderline(style, true);

        style = textpane.addStyle("Strike", null);
        StyleConstants.setStrikeThrough(style, true);


        boldb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                doc.setCharacterAttributes(textpane.getSelectionStart(), 
                    textpane.getSelectionEnd() - textpane.getSelectionStart(),
                    textpane.getStyle("Bold"), false);
            }
        });

        italb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                doc.setCharacterAttributes(textpane.getSelectionStart(), 
                    textpane.getSelectionEnd() - textpane.getSelectionStart(),
                    textpane.getStyle("Italic"), false);
            }

        });

        strib.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                doc.setCharacterAttributes(textpane.getSelectionStart(), 
                    textpane.getSelectionEnd() - textpane.getSelectionStart(),
                    textpane.getStyle("Strike"), false);
            }

        });

        undeb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                doc.setCharacterAttributes(textpane.getSelectionStart(), 
                    textpane.getSelectionEnd() - textpane.getSelectionStart(),
                    textpane.getStyle("Underline"), false);
            }
        });

        pane.getViewport().add(textpane);
        panel.add(pane);

        add(panel);

        setSize(new Dimension(380, 320));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DocumentModel();
    }
}