package ListModels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


@SuppressWarnings({"serial","unchecked","rawtypes"})
public class List extends JFrame {

    private DefaultListModel model;
    private JList list;

    public List() {

        setTitle("JList models");

        model = new DefaultListModel();
        model.addElement("Amelie");
        model.addElement("Aguirre, der Zorn Gottes");
        model.addElement("Fargo");
        model.addElement("Exorcist");
        model.addElement("Schindler list");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        leftPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        list = new JList(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        list.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                  int index = list.locationToIndex(e.getPoint());
                  Object item = model.getElementAt(index);
                  String text = JOptionPane.showInputDialog("Rename item", item);
                  String newitem = null;
                  if (text != null) 
                     newitem = text.trim();
                  else 
                     return;

                  if (!newitem.isEmpty()) {
                    model.remove(index);
                    model.add(index, newitem);
                    ListSelectionModel selmodel = list.getSelectionModel();
                    selmodel.setLeadSelectionIndex(index);
                  }
                }
            }

        });

        JScrollPane pane = new JScrollPane();
        pane.getViewport().add(list);  
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        leftPanel.add(pane);

        JButton removeall = new JButton("Remove All");
        JButton add = new JButton("Add");
        add.setMaximumSize(removeall.getMaximumSize());
        JButton rename = new JButton("Rename");
        rename.setMaximumSize(removeall.getMaximumSize());
        JButton delete = new JButton("Delete");
        delete.setMaximumSize(removeall.getMaximumSize());

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = JOptionPane.showInputDialog("Add a new item");
                String item = null;

                if (text != null) 
                    item = text.trim();
                else 
                    return;

                if (!item.isEmpty())
                    model.addElement(item);
            }
        });

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ListSelectionModel selmodel = list.getSelectionModel();
                int index = selmodel.getMinSelectionIndex();
                if (index >= 0)
                    model.remove(index);
            }

        });

        rename.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ListSelectionModel selmodel = list.getSelectionModel();
                int index = selmodel.getMinSelectionIndex();
                if (index == -1) return;
                Object item = model.getElementAt(index);
                String text = JOptionPane.showInputDialog("Rename item", item);
                String newitem = null;

                if (text != null) {
                    newitem = text.trim();
                } else
                    return;

                if (!newitem.isEmpty()) {
                    model.remove(index);
                    model.add(index, newitem);
                }
            }
        });

        removeall.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    model.clear();
                }
        });

        rightPanel.add(add);
        rightPanel.add(Box.createRigidArea(new Dimension(0,4)));
        rightPanel.add(rename);
        rightPanel.add(Box.createRigidArea(new Dimension(0,4)));
        rightPanel.add(delete);
        rightPanel.add(Box.createRigidArea(new Dimension(0,4)));
        rightPanel.add(removeall);

        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

        panel.add(leftPanel);
        panel.add(rightPanel);

        add(panel);

        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new List();
    }
}