
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheckout extends JFrame implements ActionListener{
    
    Choice ccustomer;
    TextField tfroom, tfname, tfcheckin, tfpaid, tfpending;
    JButton check, update, back;
    
    UpdateCheckout(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        //text for Update Status
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font ("Tahoma", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 20);
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
        lblroom.setBounds(30, 120, 150, 20);
        add(lblroom);
        
        tfroom = new TextField();
        tfroom.setBounds(200, 120, 150, 20);
        add(tfroom);
        
        //Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 150, 20);
        add(lblname);
        
        tfname = new TextField();
        tfname.setBounds(200, 160, 150, 20);
        add(tfname);
        
        //Checkin Time
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 200, 150, 20);
        add(lblcheckin);
        
        tfcheckin = new TextField();
        tfcheckin.setBounds(200, 200, 150, 20);
        add(tfcheckin);
        
        
        //Amount Paid
        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setBounds(30, 240, 150, 20);
        add(lblpaid);
        
        tfpaid = new TextField();
        tfpaid.setBounds(200, 240, 150, 20);
        add(tfpaid);
        
        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(30, 280, 150, 20);
        add(lblpending);
        
        tfpending = new TextField();
        tfpending.setBounds(200, 280, 150, 20);
        add(tfpending);
        
        
        //Button fo check
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 340, 100, 30);
        check.addActionListener(this);
        add(check);
        
        //Button for update
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 340, 100, 30);
        update.addActionListener(this);
        add(update);
        
        //button for back
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 340, 100, 30);
        back.addActionListener(this);
        add(back);
        
        
        //set Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 550,300);
        add(image);
        
        setBounds(300, 200, 980, 500);
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
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposite"));
                }     
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+ amountPaid);
                }
            }catch(Exception e){
                    e.printStackTrace();
                }
        }else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposite = tfpaid.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"', name= '"+name+"', checkintime = '"+checkin+"', deposite = '"+deposite+"' where number = '"+number+"'");
                
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
           new UpdateCheckout();

    }
}
