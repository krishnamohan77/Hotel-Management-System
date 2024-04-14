//this page for checkin and admin
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    public Dashboard() {
        setBounds(0, 0, 1600, 1000);
        setLayout(null);

        // Set the image on the frame
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1600, 1000);
        add(image);

        // Write text on the frame using a JLabel with HTML formatting
        JLabel textS = new JLabel("INDIA'S FINEST HOTEL COLLECTION");
        textS.setBounds(60, 180, 1000, 90);
        textS.setForeground(Color.WHITE); // Set text color to white
        textS.setFont(new Font("Tahoma", Font.PLAIN, 20));
        image.add(textS);
        
        JLabel text = new JLabel("Grand Horizon");
        text.setBounds(60, 240, 1000, 90);
        text.setForeground(Color.WHITE); // Set text color to white
        text.setFont(new Font("serif", Font.PLAIN, 70));
        image.add(text);
        
        JLabel text2 = new JLabel("LUXURY");
        text2.setBounds(60, 340, 1000, 90);
        text2.setForeground(Color.WHITE); // Set text color to white
        text2.setFont(new Font("serif", Font.PLAIN, 70));
        image.add(text2);
        
        JLabel text3 = new JLabel("HOTEL");
        text3.setBounds(60, 440, 1000, 90);
        text3.setForeground(Color.WHITE); // Set text color to white
        text3.setFont(new Font("serif", Font.PLAIN, 70));
        image.add(text3);
        
        
        // ...

        // Create Menu
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);

        // HOTEL MANAGEMENT
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        // For ADMIN
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        JMenuItem addRoom = new JMenuItem("ADD ROOMs");
        addRoom.addActionListener(this);
        admin.add(addRoom);
        
        JMenuItem addDriver = new JMenuItem("ADD DRIVER");
        addDriver.addActionListener(this);
        admin.add(addDriver);

        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
             new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMs")){
             new AddRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVER")) {
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }
    }


    public static void main(String[] args) {
         new Dashboard();
    }
}
