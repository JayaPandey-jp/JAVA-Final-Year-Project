package bankingmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    SignUpThree(String formno) {
        this.formno=formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        setSize(800, 780);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        JLabel type = new JLabel(" Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100, 80, 200, 60);
        add(type);

        r1 = new JRadioButton("Saving Account ");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        r1.setBounds(100, 120, 200, 50);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account ");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        r2.setBounds(100, 160, 200, 50);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account ");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        r3.setBounds(400, 120, 200, 50);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit  Account ");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        r4.setBounds(400, 160, 200, 50);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100, 200, 500, 60);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXX-1234");
        number.setFont(new Font("Raleway", Font.BOLD, 18));
        number.setBounds(400, 200, 500, 60);
        add(number);

        JLabel labelnumber = new JLabel("Your Sixteen Digit Card Number");
        labelnumber.setFont(new Font("Raleway", Font.BOLD, 12));
        labelnumber.setBounds(100, 225, 500, 60);
        add(labelnumber);


        JLabel pin = new JLabel("PIN Number: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100, 270, 500, 60);
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pinnumber.setBounds(400, 270, 500, 60);
        add(pinnumber);

        JLabel labelpinnumber = new JLabel("Your Four Digit PIN Number");
        labelpinnumber.setFont(new Font("Raleway", Font.BOLD, 12));
        labelpinnumber.setBounds(100, 295, 500, 60);
        add(labelpinnumber);

        JLabel servicerequired = new JLabel("Services Required: ");
        servicerequired.setFont(new Font("Raleway", Font.BOLD, 20));
        servicerequired.setBounds(100, 350, 500, 60);
        add(servicerequired);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        c1.setBackground(Color.white);
        c1.setBounds(100, 400, 200, 40);
        add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Raleway", Font.BOLD, 15));
        c2.setBackground(Color.white);
        c2.setBounds(300, 400, 200, 40);
        add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway", Font.BOLD, 15));
        c3.setBackground(Color.white);
        c3.setBounds(100, 450, 200, 40);
        add(c3);

        c4 = new JCheckBox("EMAIL && SMS ALERT");
        c4.setFont(new Font("Raleway", Font.BOLD, 15));
        c4.setBackground(Color.white);
        c4.setBounds(300, 450, 200, 40);
        add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("Raleway", Font.BOLD, 15));
        c5.setBackground(Color.white);
        c5.setBounds(100, 500, 200, 40);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setFont(new Font("Raleway", Font.BOLD, 15));
        c6.setBackground(Color.white);
        c6.setBounds(300, 500, 200, 40);
        add(c6);

        c7 = new JCheckBox("ABOVE ALL DETAILS ARE GIVEN TRUE AS PER MY KNOWLEDGE");
        c7.setFont(new Font("Raleway", Font.ITALIC, 12));
        c7.setBackground(Color.white);
        c7.setBounds(100, 530, 400, 40);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(600, 600, 80, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(700, 600, 80, 30);
        cancel.addActionListener(this);
        add(cancel);


    }



        @Override
        public void actionPerformed(ActionEvent e1) {
            if (e1.getSource()==submit)
            {
                String accounttype=null;
                if (r1.isSelected())
                accounttype="Saving Account";
                else if (r2.isSelected())
                accounttype="Fixed Account";
                else if (r3.isSelected())
                accounttype="Current Account";
                else if (r4.isSelected())
                accounttype="Recurring Deposit  Account";

                Random random=new Random();
                String cardnumber=" "+Math.abs((random.nextLong()%9000000L)+504093000000l);

                String pinnumber=" "+Math.abs((random.nextLong()%9000)+1000l);

                String facility="";
                if (c1.isSelected())
                    facility=facility+"ATM CARD";
                else if (c2.isSelected()) {
                    facility=facility+"INTERNET BANKING";
                } else if (c3.isSelected()) {
                    facility=facility+"MOBILE BANKING";
                } else if (c4.isSelected()) {
                    facility=facility+"EMAIL && SMS ALERT";
                } else if (c5.isSelected()) {
                    facility=facility+"CHEQUE BOOK";
                } else if (c6.isSelected()) {
                    facility=facility+"E-STATEMENT";
                }

                try{
                    if (accounttype.equals(" ")){
                        JOptionPane.showMessageDialog(null,"AccountType is Required");
                    }else {
                        Conn con=new Conn();
                        String query1="insert into signupthree values('" + formno + "','" + accounttype + "','" + cardnumber + "'," +
                                "'" + pinnumber + "','" + facility + "')";

                        String query2="insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";

                        con.s.executeUpdate(query1);
                        con.s.executeUpdate(query2);


                        JOptionPane.showMessageDialog(null,"CARD NUMBER: "+cardnumber+ "\nPIN NUMBER: "+pinnumber);
                            setVisible(false);
                            new Deposite(pinnumber).setVisible(true);
                    }
                }catch (Exception e){
                    System.out.println(e);
                }



            } else if (e1.getSource()==cancel) {
                setVisible(false);
                new Login().setVisible(true);
            }
        }




    public static void main(String[] args) {
        new SignUpThree("");
    }


}
