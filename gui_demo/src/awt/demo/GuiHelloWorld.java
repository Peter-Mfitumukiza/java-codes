package awt.demo;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class GuiHelloWorld  extends Frame {
    public static void main(String[] args) throws Exception{
        new GuiHelloWorld();
    }

    public GuiHelloWorld(){
        this.setBounds(850, 10, 500, 400);
        this.setVisible(true);
        this.setLayout(null);
        this.setTitle("Companion");
        this.setBackground(Color.LIGHT_GRAY);
        Label label = new Label("Hello World");
        label.setBounds(360, 20, 130, 40);
        label.setBackground(Color.WHITE);
        this.add(label);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                label.setText("Closing....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Window closed.");
                dispose();
            }
        });

    }
}
