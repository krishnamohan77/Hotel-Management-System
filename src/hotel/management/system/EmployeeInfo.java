package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;


public class EmployeeInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;

    EmployeeInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        
        //create the column of each data
        //Room Number
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 10, 100, 20);
        l1.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(170, 10, 100, 20);
        l2.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290, 10, 100, 20);
        l3.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(400, 10, 100, 20);
        l4.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540, 10, 100, 20);
        l5.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l5);
        
        JLabel l6 = new JLabel("Phone");
        l6.setBounds(670, 10, 100, 20);
        l6.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(790, 10, 100, 20);
        l7.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l7);
        
        JLabel l8 = new JLabel("Aadhar");
        l8.setBounds(910, 10, 100, 20);
        l8.setFont(new Font("Raleway", Font.BOLD, 13));
        add(l8);
        
        //create table of all the database
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee"); // Removed 'new' keyword
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        //Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,120,30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new EmployeeInfo();
    }
}
