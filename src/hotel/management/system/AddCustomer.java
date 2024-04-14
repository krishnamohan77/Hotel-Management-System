
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumber, tfname, tfcountry, tfdeposite;
    JRadioButton rmale, rfemale;
    Choice croom;
    JButton add, back;
    JLabel checkintime;
    
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Write any text on the frame using a JLabel
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);
        
        
        //COMBOBOX FOR ID
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 300, 20);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblid);

        String[] Options = {"Aadhar Card", "Password", "Pan Card"};
        comboid = new JComboBox<>(Options);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        
        //FOR NUMBER
        JLabel lblnumber = new JLabel("ID NUMBER");
        lblnumber.setBounds(35, 120, 300, 20);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
        
        //For NAME
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(35, 160, 300, 20);
        lblname.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        //For Gender  
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(35, 200, 300, 20);
        lblgender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(200,200,60,25);
        rmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");  
        rfemale.setBounds(270,200,100,25);
        rfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();//This is for select one either male or female
        bg.add(rmale);
        bg.add(rfemale);
        
        
        //Country
        JLabel lblcountry = new JLabel("COUNTRY");
        lblcountry.setBounds(35, 240, 300, 20);
        lblcountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        //Available Room Number
        JLabel lblroom = new JLabel("ROOM NUMBER");
        lblroom.setBounds(35, 280, 170, 20);
        lblroom.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblroom);
        
        croom = new Choice();
        
        try{
            Conn conn = new Conn();
            String query = "Select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);  //show all the room available from database
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        croom.setBounds(200,280,150,25);
        add(croom);
        
        //Checkin Time
        JLabel lbltime = new JLabel("CHECKIN TIME");
        lbltime.setBounds(35, 320, 150, 20);
        lbltime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbltime);
        
        Date date = new Date();
        
        checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 320, 150, 25);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(checkintime);
        
        //Deposite
        JLabel lbldeposite = new JLabel("DEPOSITE");
        lbldeposite.setBounds(35, 360, 300, 20);
        lbldeposite.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbldeposite);
        
        tfdeposite = new JTextField();
        tfdeposite.setBounds(200,360,150,25);
        add(tfdeposite);
        
        
        //Button for ADD
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add(add);
        
        //Button for Back
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);
        
        
        //set image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);
        
        
        
        //this is for Frame size
        setBounds(330, 200, 800, 550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposite = tfdeposite.getText();
            
            //query for database
            try{
                String query = "INSERT INTO customer values( '"+id+"', '"+number+"', '"+name+"','"+gender+"', '"+country+"', '"+room+"', '"+time+"', '"+deposite+"')";
               
                //update the table room
                String query2 = "update room set availability  = 'occupied' where roomnumber = '"+room+"'";
                
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Costumer added Succesfully");
                
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
              
        }
        
        else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[]arg){
        new AddCustomer();
    }
}
