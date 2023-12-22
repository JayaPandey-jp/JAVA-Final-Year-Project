package bankingmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUpTwo extends JFrame implements  ActionListener
{
    JTextField panTextField,adharTextField;
    JRadioButton yescitizen,nocitizen,yesAccount,noAccount;

    JComboBox religion,Category,Income,occupation,education;
    JButton next;
    String formno;

    SignUpTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        setTitle("New Account Application Form");

        JLabel additionalDetail= new JLabel("Page 2: Additional Details");
        additionalDetail.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetail.setBounds(280,80,500,45);
        add(additionalDetail);

        JLabel name= new JLabel("Religion: ");
        name.setFont(new Font("Raleway",Font.BOLD,20 ));
        name.setBounds(100,140,100,30);
        add(name);

        String valreligion[]={"NONE","Majority","Minority","Others"};
        religion=new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);




        JLabel fname= new JLabel("Category: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20 ));
        fname.setBounds(100,190,150,30);
        add(fname);

        String catagory[]={"NONE","GEN","OBC","ST","SC","Others"};
        Category=new JComboBox(catagory);
        Category.setBounds(300,190,400,30);
        Category.setBackground(Color.WHITE);
        add(Category);



        JLabel dob= new JLabel("Income: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20 ));
        dob.setBounds(100,240,150,30);
        add(dob);

        String valIncome[]={"NONE","50000-100000","<2,00,000","< 3,00,000","<4,00,000","Upto 10,00,000"};
         Income=new JComboBox(valIncome);
        Income.setBounds(300,240,400,30);
        Income.setBackground(Color.WHITE);
        add(Income);





        JLabel educational= new JLabel("Educational");
        educational.setFont(new Font("Raleway",Font.BOLD,20 ));
        educational.setBounds(100,290,150,30);
        add(educational);


        JLabel educational2= new JLabel("Qualification: ");
        educational2.setFont(new Font("Raleway",Font.BOLD,20 ));
        educational2.setBounds(100,313,150,30);
        add(educational2);

        String valEducation[]={"NONE","Non-Graduate","Graduate","< Post-Graduate","Doctorate","Others"};
         education=new JComboBox(valEducation);
        education.setBounds(300,300,400,30);
        education.setBackground(Color.WHITE);
        add(education);



        JLabel marital= new JLabel("Occupation ");
        marital.setFont(new Font("Raleway",Font.BOLD,20 ));
        marital.setBounds(100,350,150,30);
        add(marital);

        String valOccupation[]={"NONE","Intern","Employee","Business Man","Service Man","Others"};
        occupation=new JComboBox(valOccupation);
        occupation.setBounds(300,350,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);




        JLabel pannumber= new JLabel("PAN Number: ");
        pannumber.setFont(new Font("Raleway",Font.BOLD,20 ));
        pannumber.setBounds(100,440,150,30);
        add(pannumber);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,435,400,30);
        add(panTextField);

        JLabel Adharno= new JLabel("Adhar Number: ");
        Adharno.setFont(new Font("Raleway",Font.BOLD,20 ));
        Adharno.setBounds(100,490,150,30);
        add(Adharno);

        adharTextField=new JTextField();
        adharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adharTextField.setBounds(300,490,400,30);
        add(adharTextField);

        JLabel citizen= new JLabel("Senior Citizen: ");
        citizen.setFont(new Font("Raleway",Font.BOLD,20 ));
        citizen.setBounds(100,540,150,30);
        add(citizen);

        yescitizen=new JRadioButton("YES");
        yescitizen.setBounds(300,530,80,30);
        yescitizen.setBackground(Color.WHITE);
        add(yescitizen);

        ButtonGroup citizengroup=new ButtonGroup();
        citizengroup.add(yescitizen);


        nocitizen=new JRadioButton("NO");
        nocitizen.setBounds(450,530,90,30);
        nocitizen.setBackground(Color.WHITE);
        add(nocitizen);
        citizengroup.add(nocitizen);



        JLabel existAccount= new JLabel("Existing Account: ");
        existAccount.setFont(new Font("Raleway",Font.BOLD,20 ));
        existAccount.setBounds(100,590,200,30);
        add(existAccount);

        yesAccount=new JRadioButton("YES");
        yesAccount.setBounds(300,590,80,30);
        yesAccount.setBackground(Color.WHITE);
        add(yesAccount);

        ButtonGroup existgroup=new ButtonGroup();
        existgroup.add(yesAccount);

        noAccount=new JRadioButton("NO");
        noAccount.setBounds(450,590,90,30);
        noAccount.setBackground(Color.WHITE);
        add(noAccount);
        existgroup.add(noAccount);

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

        String sreligion = (String) religion.getSelectedItem();
        String scatagory = (String) Category.getSelectedItem();
        String sincome = (String) Income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();


        String Citizen = null;
        if (yescitizen.isSelected())
            Citizen = "YES";
        else if (nocitizen.isSelected())
            Citizen = "NO";
        String existAccount = null;
        if (yesAccount.isSelected())
            existAccount = "YES";
        else if (noAccount.isSelected())
            existAccount = "NO";


        String pancard = panTextField.getText();
        String adhar = adharTextField.getText();


        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo values('" + formno + "','" + sreligion + "','" + scatagory + "','" + sincome + "','" + seducation + "'," +
                    "'" + soccupation + "','" + pancard + "'," + "'" + adhar + "','" + Citizen + "','" + existAccount + "')";
            c.s.executeUpdate(query);

            setVisible(false);
           SignUpThree s1= new SignUpThree(formno);
           s1.setVisible(true);

        }  catch (Exception e1) {
            System.out.println(e1);
        }


    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }


}

