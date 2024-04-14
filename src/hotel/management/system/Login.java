
                //this is login for admin only

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Create username label
        JLabel user = new JLabel("Username");
        user.setBounds(90, 20, 100, 30);
        user.setFont(new Font("serif", Font.PLAIN, 20));
        add(user);

        // Create box for username
        username = new JTextField();
        username.setBounds(190, 20, 150, 30);
        username.setFont(new Font("serif", Font.PLAIN, 20));
        add(username);

        // Create password label
        JLabel pass = new JLabel("Password");   //for password in ....
        pass.setBounds(90, 70, 100, 30);
        pass.setFont(new Font("serif", Font.PLAIN, 20));
        add(pass);

        // Create box for password
        password = new JPasswordField();  // Use JPasswordField for passwords
        password.setBounds(190, 70, 150, 30);
        password.setFont(new Font("serif", Font.PLAIN, 20));
        add(password);

        // Create Login button
        login = new JButton("Login");
        login.setBounds(90, 150, 120, 30);
        login.setFont(new Font("serif", Font.PLAIN, 20));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change button color when the mouse enters
                login.setBackground(Color.WHITE);
                login.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restore button color when the mouse exits
                login.setBackground(Color.BLACK);
                login.setForeground(Color.WHITE);
            }
        });

        // Create a cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 150, 120, 30);
        cancel.setFont(new Font("serif", Font.PLAIN, 20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this); // Corrected the action listener
        add(cancel);

        // Add a mouse listener to the cancel button for hover effect
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change button color when the mouse enters
                cancel.setBackground(Color.WHITE);
                cancel.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restore button color when the mouse exits
                cancel.setBackground(Color.BLACK);
                cancel.setForeground(Color.WHITE);
            }
        });

        // Set frame image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setBounds(500, 200, 600, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == login) {
                String user = username.getText();
                String pass = password.getText();

                // Create query
                try {
                    Conn c = new Conn();

                    String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";

                    ResultSet rs = c.s.executeQuery(query);  //execute use for read or match the value in database

                    if (rs.next()) {
                        setVisible(false);
                        new Dashboard();  //if login match the database then open dashboard
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                        setVisible(true);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (ae.getSource() == cancel) {
                setVisible(false);
            }
}


    public static void main(String[] args) {
        new Login();
    }
}
