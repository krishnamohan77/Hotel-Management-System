
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton rooms, newCustomer, department, allEmployee, managerInfo, customers, searchRoom, update, roomStatus, pickup, checkout;
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        //SET BUTTON FOR NEW CUSTOMER
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        
        //BUTTON FOR ROOMS
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        
        //BUTTON FOR DEPARTMENT
        department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        
        //BUTTON FOR ALL EMPLOYEE
        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        
        //BUTTON FOR ALL CUSTOMER INFO
        customers = new JButton("Customer Info");
        customers.setBounds(10, 190, 200, 30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);
        
        
        //BUTTON FOR ALL MANAGER INFO
        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        
        //BUTTON FOR ALL Checkout
        checkout =new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        //BUTTON FOR ALL Pending Status
        update =new JButton("Pending Status");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        
        
        //BUTTON FOR ALL Update Room Status
        roomStatus =new JButton("Update Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        //BUTTON FOR ALL Pickup Service
        pickup =new JButton("Pickup Service");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
        //BUTTON FOR ALL Search Room
        searchRoom =new JButton("Search Room");
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        //BUTTON FOR ALL Logout
//        JButton logout =new JButton("Logout");
//        logout.setBounds(10, 470, 200, 30);
//        logout.setBackground(Color.BLACK);
//        logout.setForeground(Color.WHITE);
//        add(logout);
//        
        
        //set image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);
        
        setBounds(350, 200, 800, 570);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource() == customers){
            setVisible(false);
            new CustonmerInfo();
        }
        else if(ae.getSource() == managerInfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource() == searchRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new UpdateCheckout();
        }
        else if(ae.getSource() == roomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource() == pickup){
            setVisible(false);
            new Pickup();
        }
        else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        }
    }
    
    public static void main(String[] arg){
        new Reception();
    }
}
