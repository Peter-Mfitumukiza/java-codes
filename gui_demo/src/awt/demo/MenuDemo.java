package awt.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuDemo extends JFrame {
    public static void main(String[] args) {
        new MenuDemo();
    }
    public MenuDemo(){
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Home");
        JMenu m2 = new JMenu("Resources");
        JMenu subM1 = new JMenu("Explore");
        JMenuItem mit1 = new JMenuItem("Item 1");
        JMenuItem mit2 = new JMenuItem("Item 2");
        JMenuItem smit1 = new JMenuItem("Sub item 1");
        JMenuItem smit2 = new JMenuItem("Sub item 2");

//        Adding components
        subM1.add(smit1);
        subM1.add(smit2);
        m1.add(subM1);
        m1.add(mit1);
        m1.add(mit2);
        mb.add(m1);
        mb.add(m2);
        this.add(mb);
        this.setBounds(850, 10, 500, 400);
        this.setVisible(true);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
//        Image icon
        ImageIcon icon = new ImageIcon("C:\\Users\\mfite\\IdeaProjects\\gui_demo\\src\\awt\\demo\\pexels-luizclas-556669.jpg");
        Image image = icon.getImage().getScaledInstance(30, 30, 1);
        m1.setIcon(new ImageIcon(image));

        mit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f2 = new JFrame("New window");
                f2.setBounds(100,100,300,250);
                f2.setVisible(true);
            }
        });
    }
}
