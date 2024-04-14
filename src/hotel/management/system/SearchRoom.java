package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;


public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back, submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahome", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);
        
        //ComboBox for Bed Tupe
        JLabel lblbed  = new JLabel("Bed Type");
        lblbed.setBounds(50, 100, 100, 20);
        lblbed.setFont(new Font("Raleway", Font.BOLD, 13));
        add(lblbed);
        
        String[] Options = {"Single Bed", "Double Bed"};
        bedType = new JComboBox<>(Options);
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        //CheckBox for search available
        available = new JCheckBox("Only display Available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.WHITE);
        add(available);
        
        
        //create the column of each data
        //Room Number
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(20, 170, 130, 20);
        l1.setFont(new Font("Raleway", Font.BOLD, 15));
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(260, 170, 130, 20);
        l2.setFont(new Font("Raleway", Font.BOLD, 15));
        add(l2);
        
        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(410, 170, 130, 20);
        l3.setFont(new Font("Raleway", Font.BOLD, 15));
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(610, 170, 130, 20);
        l4.setFont(new Font("Raleway", Font.BOLD, 15));
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(800, 170, 130, 20);
        l5.setFont(new Font("Raleway", Font.BOLD, 15));
        add(l5);
        
        //create table of all the database
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room"); // Removed 'new' keyword
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Submit Button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,120,30);
        submit.addActionListener(this);
        add(submit);
        
        //Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,520,120,30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                String query1 = "select * from room where bed_type = '" + bedType.getSelectedItem() + "'";
                String query2 = "select * from room where availability ='Available' AND bed_type= '" + bedType.getSelectedItem() + "'";

                Conn conn = new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);

                }else{
                    rs = conn.s.executeQuery(query1);
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
