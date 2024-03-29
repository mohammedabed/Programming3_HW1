package EventGUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI1 extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu File, Edit;
    JMenuItem open, close, exit, font, color;
    JTextArea area;

    public GUI1() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        File = new JMenu("File");
        menuBar.add(File);
        open = new JMenuItem("Open");
        open.setMnemonic('O');
        open.addActionListener(this);
        close = new JMenuItem("Close");
        close.setMnemonic('C');
        close.addActionListener(this);
        exit = new JMenuItem("Exit");
        exit.setMnemonic('E');
        exit.addActionListener(this);
        File.add(open);
        File.add(close);
        File.addSeparator();
        File.add(exit);

        Edit = new JMenu("Edit");
        menuBar.add(Edit);
        font = new JMenuItem("Font");
        font.setMnemonic('F');
        font.addActionListener(this);
        color = new JMenuItem("Color");
        color.setMnemonic('C');
        color.addActionListener(this);
        Edit.add(font);
        Edit.add(color);

        area = new JTextArea("DEFAULT TEXT...");
        area.setEditable(false);
        area.setLineWrap(true);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(350, 235));
        add(scroll);

        setTitle("File Processing");
        setSize(365, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new GUI1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Open":
                try {
                    System.out.println("open");
                    JFileChooser chooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter(
                            ".txt", "txt");
                    chooser.setFileFilter(filter);

                    int returnVal = chooser.showOpenDialog(GUI1.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        System.out.println("You chose this file: "
                                + chooser.getSelectedFile().getName());
                    }
                    File selectedFile = chooser.getSelectedFile();
                    if (selectedFile != null) {
                        Scanner in = new Scanner(selectedFile);
                        String s;
                        area.setText("");
                        while (in.hasNextLine()) {
                            area.append(in.nextLine() + "\n");
                        }
                        area.setEditable(true);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GUI1.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "Close":
                System.out.println("close");
                area.setText("DEFAULT TEXT...");
                area.setEditable(false);
                area.setForeground(Color.BLACK);
                area.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
                break;
            case "Exit":
                System.out.println("exit");
                System.exit(0);
                break;
            case "Font":
                System.out.println("font");
                String s = (String) JOptionPane.showInputDialog(
                        null,
                        "Choose Font Size",
                        "Font Size",
                        JOptionPane.INFORMATION_MESSAGE,
                        null, //icon object
                        new String[]{"12", "14", "18", "24", "30", "48", "72"}, //list  items
                        "Red" //defalut selected item in the list
                );
                System.out.println(s);
                if (s != null) {
                    area.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, Integer.parseInt(s)));
                }
                break;
            case "Color":
                System.out.println("color");
                Color selectedColor = JColorChooser.showDialog(GUI1.this, "color", color.getBackground()); //modal
                System.out.println(selectedColor);
                if (selectedColor != null) {
                    area.setForeground(selectedColor);
                }
                break;
            default:
                break;
        }
    }
}
