package bankingmanagementsystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
public class FastCash extends  JFrame implements ActionListener{
    JTextField amount;
    JButton fasttag,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        JLabel text=new JLabel("Enter The Amount For Fast Tag.");
        text.setBounds(160,230,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);

        amount= new JTextField();
        amount.setBounds(135,270,250,15);
        amount.addActionListener(this);
        image.add(amount);

        fasttag=new JButton("Fast Tag");
        fasttag.setBounds(280,380,120,15);
        fasttag.addActionListener(this);
        image.add(fasttag);

        exit=new JButton("BACK");
        exit.setBounds(280,405,120,15);
        exit.addActionListener(this);
        image.add(exit);

        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== fasttag){
            String number=amount.getText();
            Date date=new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the Amount u want to Withdraw");
            }else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank value('" + pinnumber + "','" + date + "','Fast Tag','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+number+ " Withdraw Successfully For Fast Tag");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }catch (Exception e2){
                    e2.printStackTrace();
                }

            }
        }
        else if (e.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new FastCash(" ");
    }


}
