package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {
        JCheckBox box1 = new JCheckBox("Snap to Grid");
        JCheckBox box2 = new JCheckBox("Show Grid");
        JPanel panel1 = new JPanel(new GridLayout(2, 1, 0, 0));
        panel1.add(box1);
        panel1.add(box2);
        add(panel1);

        JLabel x = new JLabel("X:");
        JTextField text1 = new JTextField(3);
        JLabel y = new JLabel("Y:");
        JTextField text2 = new JTextField(3);
        JPanel panel2 = new JPanel(new GridLayout(2, 2, 0, 10));
        panel2.add(x);
        panel2.add(text1);
        panel2.add(y);
        panel2.add(text2);
        add(panel2);

        JButton b1 = new JButton("OK");
        b1.setFocusPainted(false);
        JButton b2 = new JButton("Cancel");
        b2.setFocusPainted(false);
        JButton b3 = new JButton("Help");
        b3.setFocusPainted(false);
        JPanel panel3 = new JPanel(new GridLayout(3, 1, 0, 10));
        panel3.add(b1);
        panel3.add(b2);
        panel3.add(b3);
        add(panel3);

        setTitle("Align");
        Dimension d = new Dimension(300, 150);
        setSize(d);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
