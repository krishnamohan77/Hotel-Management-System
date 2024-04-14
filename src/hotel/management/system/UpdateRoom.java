
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice ccustomer;
    TextField tfroom, tfavailable, tfstatus, tfpaid, tfpending;
    JButton check, update, back;
    
    UpdateRoom(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        //text for Update Status
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font ("Tahoma", Font.PLAIN, 20));
        text.setBounds(30, 20, 250, 30);
        text.setForeground(Color.RED);
        add(text);
        
        
        //customer id
        JLabel lblid = new JLabel("Customer id");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);
        //this is for customer id show from database
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
            
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        //Room
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 20);
        add(lblroom);
        
        tfroom = new TextField();
        tfroom.setBounds(200, 130, 150, 25);
        add(tfroom);
        
        //Availability
        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(30, 180, 100, 20);
        add(lblavailable);
        
        tfavailable = new TextField();
        tfavailable.setBounds(200, 180, 150, 25);
        add(tfavailable);
        
        //Cleaning Status
        JLabel lblstatus = new JLabel("Cleaning Status");
        lblstatus.setBounds(30, 230, 100, 20);
        add(lblstatus);
        
        tfstatus = new TextField();
        tfstatus.setBounds(200, 230, 150, 25);
        add(tfstatus);
        
        
        
        //Button fo check
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 300, 100, 30);
        check.addActionListener(this);
        add(check);
        
        //Button for update
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 300, 100, 30);
        update.addActionListener(this);
        add(update);
        
        //button for back
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 300, 100, 30);
        back.addActionListener(this);
        add(back);
        
        
        //set Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);
        
        setBounds(300, 200, 980, 450);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                   
                }     
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                    
                }
            }catch(Exception e){
                    e.printStackTrace();
                }
        }else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status= '"+status+"' where roomnumber ='"+room+"'");
                
                JOptionPane.showMessageDialog(null, "Data updated Successfully");
                
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == back){
                setVisible(false);
                new Reception();
        }
    }
        
    
    
    public static void main(String[] arg){
           new UpdateRoom();

    }
}
