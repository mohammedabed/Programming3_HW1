package EventGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GUI3 extends JFrame {

    JLabel label1, label2, label3;
    JTextField field;
    JButton button;
    Random r;
    int random;

    public GUI3() {
        r = new Random();
        random = r.nextInt(1000);
        System.out.println(random);
        label1 = new JLabel("I have number between 1 and 1000");
        add(label1);
        label2 = new JLabel("Can you guess my number?");
        add(label2);
        label3 = new JLabel("Please enter your first guess");
        Font font = new Font(Font.SERIF, Font.BOLD, 15);
        label3.setFont(font);
        add(label3);
        field = new JTextField(5);
        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if (e.getKeyCode() == 10) {
                    try {
                        String text = field.getText();
                        int num = Integer.parseInt(text);
                        if (num > 1000 || num < 1) {
                            throw new Exception();
                        } else {
                            if (num == random) {
                                label3.setText("Correct  ! *... you win ...*");
                                field.setEditable(false);
                                label3.setForeground(Color.BLUE);
                            } else if (num > random) {
                                label3.setText("Too High, Try a lower number");
                                label3.setForeground(Color.RED);
                            } else if (num < random) {
                                label3.setText("Too Low, Try a higher number");
                                label3.setForeground(Color.RED);
                            }
                        }
                    } catch (Exception ex) {
                        label3.setText("ERROR, Enter Valid Number !!!");
                        label3.setForeground(Color.YELLOW);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        add(field);
        button = new JButton("New Game");
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                field.setText("");
                label3.setText("Please enter your first guess");
                label3.setForeground(Color.BLACK);
                field.setEditable(true);
                random = r.nextInt(1000);
                System.out.println(random);
            }
        });
        add(button);

        setTitle("Guessing Game");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.MAGENTA);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new GUI3();
    }
}
