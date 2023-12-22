package bankingmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,signin,register;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE....ATM!!!!");
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        getContentPane().setBackground(Color.white);

        JLabel text=new JLabel("WELCOME TO ATM!!");
        text.setFont(new Font("Osward",Font.BOLD,20));
        text.setBounds(200,40,220,40);
        add(text);

        JLabel cardno=new JLabel("ENTER YOUR CARD NUMBER:");
        cardno.setFont(new Font("Raleway",Font.BOLD,16));
        cardno.setBounds(90,150,420,40);
        add(cardno);

        cardTextField= new JTextField();
        cardTextField.setBounds(350,150,250,40);
        add(cardTextField);


        JLabel pin=new JLabel("ENTER YOUR PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(90,220,420,40);
        add(pin);

        pinTextField= new JPasswordField();
        pinTextField.setBounds(350,225,250,40);
        add(pinTextField);


        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        add(login);
        login.addActionListener(this);

        signin=new JButton("CLEAR");
        signin.setBounds(420,300,100,30);
        add(signin);
        signin.addActionListener(this);

        register=new JButton("NEW USER?");
        register.setBounds(320,340,200,30);
        add(register);
        register.addActionListener(this);





        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getSource()==signin)
     {
         cardTextField.setText("");
         pinTextField.setText("");
     } else if (e.getSource()==login)
     {
        Conn con=new Conn();
        String cardnumber=cardTextField.getText();
        String pinnumber=pinTextField.getText();
         String query = "SELECT * FROM login WHERE Card_Number='" + cardnumber + "' AND PIN='" + pinnumber + "'";
            try {
                ResultSet rs=con.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect PIN or Card Number ");
                }
            }catch (Exception e1){

            }


     } else if (e.getSource()==register) {
         setVisible(false);
         new SignUpOne().setVisible(true);

     }


    }
    public static void main(String[] args) {
        new Login();
    }


}
