package bankingmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastcash, ministatement,pinchange, balanceCheck,exit;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
       setLayout(null);

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,700,700);
         add(image);

         JLabel text=new JLabel("Please Select your Transaction");
         text.setBounds(170,230,700,35);
         text.setForeground(Color.WHITE);
         image.add(text);

         deposit=new JButton("DEPOSIT");
         deposit.setBounds(125,330,120,15);
         deposit.addActionListener(this);
         image.add(deposit);

        withdrawl=new JButton("Cash Withdrawal");
        withdrawl.setBounds(280,330,120,15);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(125,355,120,15);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(280,355,120,15);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Pin Change");
        pinchange.setBounds(125,380,120,15);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceCheck=new JButton("Balance Check");
        balanceCheck.setBounds(280,380,120,15);
        balanceCheck.addActionListener(this);
        image.add(balanceCheck);



        exit=new JButton("Exit");
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
        if (e.getSource()==exit)
            System.exit(0);
        else if (e.getSource()==deposit) {
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        } else if (e.getSource()==withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (e.getSource()==fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);

        }

    }
    public static void main(String[] args) {
        new Transaction("");
    }


}
