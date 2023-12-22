package bankingmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class PinChange extends JFrame {
    String pinchange;
    PinChange(String pinchange){
        this.pinchange=pinchange;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);



    }


    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
