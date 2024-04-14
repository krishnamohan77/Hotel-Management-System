package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;


public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;

    Room() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // set image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        
        //create the column of each data
        //Room Number
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10, 10, 100, 20);
        l1.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(120, 10, 100, 20);
        l2.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(230, 10, 100, 20);
        l3.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(320, 10, 100, 20);
        l4.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(420, 10, 100, 20);
        l5.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l5);
        
        //create table of all the database
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room"); // Removed 'new' keyword
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        //Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1050, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Room();
    }
}
