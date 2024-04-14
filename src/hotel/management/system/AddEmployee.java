package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname, tfemail, tfphone, tfage, tfsalary, tfaadhar;
    JRadioButton rbmale, rbfmale, rbothers;
    JButton submit;
    JComboBox cbjob;
    
     
    AddEmployee() {
        setLayout(null);
        
        //create a name and field for it
        JLabel ib1name = new JLabel("NAME");
        ib1name.setBounds(60,30,120,30);
        ib1name.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(ib1name);
        
        tfname = new JTextField();
        tfname.setBounds(200, 30,150, 30);
        add(tfname);
        
        //create age
        JLabel ib1age = new JLabel("AGE");
        ib1age.setBounds(60,80,120,30);
        ib1age.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(ib1age);
        
        tfage = new JTextField();
        tfage.setBounds(200, 80,150, 30);
        add(tfage);
        
        //create gender  and radio button
        JLabel ib1gender = new JLabel("GENDER");
        ib1gender.setBounds(60,130,120,30);
        ib1gender.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(ib1gender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfmale = new JRadioButton("Female");  
        rbfmale.setBounds(275, 130, 70, 30);
        rbfmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfmale.setBackground(Color.WHITE);
        add(rbfmale);
        
        rbothers = new JRadioButton("Others");  
        rbothers.setBounds(350, 130, 70, 30);
        rbothers.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbothers.setBackground(Color.WHITE);
        add(rbothers);
        
        ButtonGroup bg = new ButtonGroup();//This is for select one either male or female
        bg.add(rbmale);
        bg.add(rbfmale);
        bg.add(rbothers);
        
        
        //create JOB  and DROPDOWN
        JLabel ib1job = new JLabel("JOB");
        ib1job.setBounds(60,180,120,30);
        ib1job.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(ib1job);
        
        
        String str [] = {"Front Desk Clerke", "Porters","Housekepping","Kitchen Staff", "Room Service", "Chefs","Waiter/Waitress","Manager","Accontant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);        
        add( cbjob);
        
        //SALARY
        JLabel ib1salary = new JLabel("SALARY");
        ib1salary.setBounds(60,230,120,30);
        ib1salary.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(ib1salary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230,150, 30);
        add(tfsalary);
        
        
        //create PHONE  
        JLabel ib1phone = new JLabel("PHONE");
        ib1phone.setBounds(60,280,120,30);
        ib1phone.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(ib1phone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 280,150, 30);
        add(tfphone);
        
        
        //create EMAIL
        JLabel ib1email = new JLabel("EMAIL");
        ib1email.setBounds(60,330,120,30);
        ib1email.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(ib1email);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 330,150, 30);
        add(tfemail);
        
        //create AADHAR
        JLabel ib1aadhar = new JLabel("AADHAR");
        ib1aadhar.setBounds(60,380,120,30);
        ib1aadhar.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(ib1aadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 380,150, 30);
        add(tfaadhar);
        
        //create SUBMIT BUTTON
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        //set image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
         
        getContentPane().setBackground(Color.WHITE); // Corrected 'color.WHITE' to 'Color.WHITE'
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }
       public void actionPerformed(ActionEvent ae) {
           String name = tfname.getText();
           String age = tfage.getText();
           String salary = tfsalary.getText();
           String email = tfemail.getText();
           String phone = tfphone.getText();
           String aadhar = tfaadhar.getText();
          
           String gender = null;
           
           
           //this is for you cannot left empty
           if(name.equals("")){
               JOptionPane.showMessageDialog(null, "NAME should not be empty");
               return;
           }
           if(age.equals("")){
               JOptionPane.showMessageDialog(null, "AGE should not be empty");
               return;
           }
           if(salary.equals("")){
               JOptionPane.showMessageDialog(null, "SALARY should not be empty");
               return;
           }
           if(phone.equals("")){
               JOptionPane.showMessageDialog(null, "PHONE should not be empty");
               return;
           }
           if(email.equals("")){
               JOptionPane.showMessageDialog(null, "EMAIL should not be empty");
               return;
           }
           if(aadhar.equals("")){
               JOptionPane.showMessageDialog(null, "AADHAR should not be empty");
               return;
           }
           

           
           
           //this is for select only one button
           if(rbmale.isSelected()){
               gender = "Male";
           }else if(rbfmale.isSelected()){
               gender = "Female";
           }else if(rbothers.isSelected()){
               gender = "Others";
           }
           
          String job = (String) cbjob.getSelectedItem();
           
          try{
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"',  '"+age+"',  '"+gender+"',  '"+job+"',  '"+salary+"',  '"+phone+"',  '"+email+"',  '"+aadhar+"')";
           
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            
            setVisible(false);
          }
           catch(Exception e){
                   e.printStackTrace();
                   JOptionPane.showMessageDialog(null,"Employee is already exist");
           }
       }    

    public static void main(String[] args) {
        new AddEmployee();
    }
}
