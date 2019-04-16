package EventGUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

;

public class GUI2 extends JFrame {

    JList<String> list;
    JButton b1;
    JTextArea area;

    public GUI2() {
        DefaultListModel<String> dlist = new DefaultListModel<>();
        list = new JList<>(dlist);
        list.setPreferredSize(new Dimension(100, 100));
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!list.isSelectionEmpty()){
                    area.setText("");
                }
            }
        });
        dlist.addElement("Black");
        dlist.addElement("Blue");
        dlist.addElement("Cyan");
        dlist.addElement("Dark Gray");
        dlist.addElement("Gray");
        JScrollPane slist = new JScrollPane(list);
        slist.setPreferredSize(new Dimension(120, 100));
        add(slist);

        b1 = new JButton("Copy>>>");
        b1.setFocusPainted(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> Select = list.getSelectedValuesList();
                System.out.println(Select.size());
                for (String item : Select) {
                    area.setText(area.getText() + item + "\n");
                }
            }
        });
        add(b1);

        area = new JTextArea();
        area.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(90, 90));
        add(scroll);

        setTitle("Multiple Selection Lists");
        setSize(500, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new GUI2();
    }
}
