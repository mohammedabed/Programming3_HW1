package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI4 extends JFrame {

    public GUI4() {

        DefaultListModel<String> deflist = new DefaultListModel<>();
        JList<String> list = new JList<>(deflist);
        list.setPreferredSize(new Dimension(100, 100));
        deflist.addElement("Black");
        deflist.addElement("Blue");
        deflist.addElement("Cyan");
        deflist.addElement("Dark Gray");
        deflist.addElement("Gray");
        JScrollPane slist = new JScrollPane(list);
        slist.setPreferredSize(new Dimension(120, 100));
        add(slist);

        JButton b1 = new JButton("Copy>>>");
        b1.setFocusPainted(false);
        add(b1);

        JTextArea area = new JTextArea();
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

    public static void main(String[] args) {
        new GUI4();
    }
}

