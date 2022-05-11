package awt.demo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class Layout extends Frame {
    Label status;
    TextField input;
    public static void main(String[] args) throws Exception{
        new Layout();
    }

    public Layout(){
        this.setBounds(850, 10, 500, 400);
        this.setVisible(true);
        this.setLayout(new GridLayout(3,1));
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel3.setBackground(Color.GREEN);

        Label label1 = new Label("Hi there, Enter something in the field below.");
        panel1.add(label1);

        Label label2 = new Label("Text Field: ");
        panel2.add(label2);

        status = new Label("Status: ");
        panel3.add(status);

        input = new TextField(10);
        panel2.add(input);
        Button button1 = new Button("Submit");
        panel2.add(button1);
        button1.addActionListener(new ButtonClickHandler());
        button1.setActionCommand("SEND");

        Button button2 = new Button("Clear");
        panel2.add(button2);
        button2.addActionListener( new ButtonClickHandler());
        button2.setActionCommand("CLEAR");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window closed.");
                dispose();
            }
        });

    }

    class ButtonClickHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("SEND")){
                System.out.println(input.getText());
                status.setText(input.getText());
            }else if(e.getActionCommand().equals("CLEAR")){
                input.setText(" ");
            }
        }
    }
}
