package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    Department() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


//        JLabel l1 = new JLabel("Department");
//        l1.setBounds(180, 10, 100, 20);
//        l1.setFont(new Font("Raleway", Font.BOLD, 13));
//        add(l1);
        
        
//        JLabel l2 = new JLabel("Budget");
//        l2.setBounds(370, 10, 100, 20);
//        l2.setFont(new Font("Raleway", Font.BOLD, 13));
//        add(l2);
        
        // Create the JTable and a scroll pane to hold it
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 50, 700, 350);
        add(scrollPane);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(280, 400, 120, 30);
        back.addActionListener(this);
        add(back);

        setBounds(400, 200, 700, 480);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Department();
    }
}
