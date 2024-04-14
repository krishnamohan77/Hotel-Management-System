                    //THIS IS THE MAIN HOTEL MANAGEMENT SYSTEM PAGE, HERE WE RUN THE PROJECT
package hotel.management.system;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Font; // Added import for Font
import javax.swing.*;

public  class HotelManagementSystem extends JFrame implements ActionListener{  //ActionListener ->action the button
    
    public HotelManagementSystem() {
        setSize(1366, 565);
        setLocation(100, 100);
        setLayout(null); // means layout created by myself

        // Pass the path of the picture for the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565); // location x, location y, length, breadth
        add(image);
        
        
        // Write any text on the frame using a JLabel
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);

        // Create a button
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE); // Corrected the background color
        next.setBackground(Color.PINK);
        next.addActionListener(this);//click the button and call the event
        next.setFont(new Font("serif", Font.PLAIN,30));
        image.add(next);

        setVisible(true); // by default false
        
        
        //use for text HOTEL MANAGEMENT SYSTEM on frame hide aswellas show 
        while(true){
            text.setVisible(false);//lebal hode for a second and tnen show also for a second
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    //overide the function
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();  //click on next button then open the login page
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
