
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel lblroom , lblroomnumber, lblcheckin, lblcheckintime, lblcheckouttime;
    JButton checkout, back;
    Checkout(){
     
        getContentPane().setBackground(Color.WHITE);     
        setLayout(null);
        
        //Checkout
        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setFont(new Font("Tahoma",Font.PLAIN, 20));
        text.setForeground(Color.BLUE);
        add(text);
        
        //Choice Customer Id
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);
        
       
        
        //Room Number
        lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);
        
        //Room Number
        lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150,180,100,30);
        add(lblcheckintime);
        
        
        //Room Number
        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        Date date = new Date();
        
        lblcheckouttime = new JLabel("" +date);
        lblcheckouttime.setBounds(150,230,100,30);
        add(lblcheckouttime);
        
        
        
        //Submit Button
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);
        
        //Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);
        
         try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        // Set an image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310, 80, 20, 20);
        add(tick);
        
        // Set an image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250);
        add(image);
        
        
        
        setBounds(300, 200,800,400);
        setVisible(true);
        
        
    }
    
    @Override   
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout) {
            String query1 = "DELETE FROM customer WHERE number = '" + ccustomer.getSelectedItem() + "'";
            String query2 = "UPDATE room SET availability = 'Available' WHERE roomnumber = '" + lblroomnumber.getText() + "'";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Checkout done");

                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] arg){
        new Checkout();
    }
}
