package bankingmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.*;

public class SignUpOne extends JFrame implements  ActionListener
 {
    long random;
    JTextField nameTextField,fnameTextField,EMTextField,adTextField,cityTextField,pinTextField,stateTextField;
   JRadioButton male,female,maried,unmaried;
    JDateChooser dateChooser;
   JButton next;

    SignUpOne(){
        setLayout(null);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);


        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000l)-1000l);


        JLabel formno= new JLabel("APPLICATION FORM NUMBER: " +random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(70,20,800,40);
        add(formno);


        JLabel personDetail= new JLabel("Page 1: Personal Details");
        personDetail.setFont(new Font("Raleway",Font.BOLD,22));
        personDetail.setBounds(280,80,500,45);
        add(personDetail);

        JLabel name= new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20 ));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname= new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20 ));
        fname.setBounds(100,190,150,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob= new JLabel("Date OF Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20 ));
        dob.setBounds(100,240,150,30);
        add(dob);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);


        JLabel gender= new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20 ));
        gender.setBounds(100,290,150,30);
        add(gender);

         male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);


         female=new JRadioButton("Female");
        female.setBounds(450,290,70,30);
        female.setBackground(Color.WHITE);
        add(female);
        genderGroup.add(female);


        JLabel email= new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,20 ));
        email.setBounds(100,340,150,30);
        add(email);

        EMTextField=new JTextField();
        EMTextField.setFont(new Font("Raleway",Font.BOLD,14));
        EMTextField.setBounds(300,335,400,30);
        add(EMTextField);

        JLabel marital= new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20 ));
        marital.setBounds(100,390,150,30);
        add(marital);

         maried=new JRadioButton("Married");
        maried.setBounds(300,390,80,30);
        maried.setBackground(Color.WHITE);
        add(maried);

        ButtonGroup marriedGroup=new ButtonGroup();
        marriedGroup.add(maried);


         unmaried=new JRadioButton("Unmarried");
        unmaried.setBounds(450,390,90,30);
        unmaried.setBackground(Color.WHITE);
        add(unmaried);
        marriedGroup.add(unmaried);



        JLabel address= new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20 ));
        address.setBounds(100,440,150,30);
        add(address);

        adTextField=new JTextField();
        adTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adTextField.setBounds(300,435,400,30);
        add(adTextField);

        JLabel city= new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20 ));
        city.setBounds(100,490,150,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state= new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20 ));
        state.setBounds(100,540,150,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode= new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20 ));
        pincode.setBounds(100,590,150,30);
        add(pincode);

        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);



        next=new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,650,80,30);
        next.addActionListener(this);
        add(next);








        setSize(800,800);
        setLocation(350,10);
         setVisible(true);




    }

     @Override
     public void actionPerformed(ActionEvent e) {
             String formno=""+random;
             String name=nameTextField.getText();
             String fname=fnameTextField.getText();
             String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
             String gender=null;
             if (male.isSelected())
             gender="Male";
             else if(female.isSelected())
                 gender="Female";
             String email=EMTextField.getText();
             String marital=null;
             if (maried.isSelected())
                 marital="Married";
             else if (unmaried.isSelected())
                 marital="Unmarried";

             String city=cityTextField.getText();
             String state=stateTextField.getText();
             String address=adTextField.getText();
             String pincode=pinTextField.getText();


         try {
             if (name.equals(""))
                 JOptionPane.showMessageDialog(null, "Name field is required");
             else {
                 Conn c = new Conn();
                 String query = "INSERT INTO signup (formno,Full_Name, Father_Name, DOB, Gender, Email, Marital_status, Address, State, City, PinCode) " +
                         "VALUES ('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" +
                         address + "','" + state + "','" + city + "','" + pincode + "')";
                 c.s.executeUpdate(query);

                 setVisible(false);
               new SignUpTwo(formno).setVisible(true);
             }
         } catch (Exception e1) {
             System.out.println(e1);
         }

     }


    public static void main(String[] args) {
        new SignUpOne();
    }


 }
