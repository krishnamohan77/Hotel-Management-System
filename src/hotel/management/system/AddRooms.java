
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    //declare globally for access the abstract class
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox typecombo, availablecombo, cleancombo;
    
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        //for heading AddRoom
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahuma", Font.BOLD, 18));
        heading.setBounds(200, 20, 200, 30);
        add(heading);
        
        //for room number
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahuma", Font.PLAIN, 18));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 120, 30);
        add(tfroom);
        
        
        //for available or not
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahuma", Font.PLAIN, 18));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);
        
        String availableOptions [] = {"Available", "Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.WHITE);        
        add( availablecombo);
        
        //For claean or dirty
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahuma", Font.PLAIN, 18));
        lblclean.setBounds(60,180,150,30);
        add(lblclean);
        
        String cleanOptions [] = {"Clean", "Dirty"};
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);        
        add( cleancombo);
        
        
        //set prince of rooms
        JLabel lblprince = new JLabel("Price");
        lblprince.setFont(new Font("Tahuma", Font.PLAIN, 18));
        lblprince.setBounds(60,230,120,30);
        add(lblprince);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
        //bed types
        JLabel lbltype = new JLabel("Bed Types");
        lbltype.setFont(new Font("Tahuma", Font.PLAIN, 18));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);
        
        String typeOptions [] = {"Single Bed", "Double Bed"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200, 280, 150, 30);
        typecombo.setBackground(Color.WHITE);        
        add( typecombo);
        
        //Button for add Room and cancle
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        //set image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        
        
        setBounds(330, 200, 940, 470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
//      
           
            if(ae.getSource() == add){
                String roomnumber = tfroom.getText();
                String availability = (String)availablecombo.getSelectedItem();
                String status = (String)cleancombo.getSelectedItem();
                String price  = tfprice.getText();
                String type = (String) typecombo.getSelectedItem();
                
                if(roomnumber.equals("")){
                    JOptionPane.showMessageDialog(null, "Room Number should not be empty");
                    return;
                }
                
                if(price.equals("")){
                    JOptionPane.showMessageDialog(null, "Price should not be empty");
                    return;
                }
               
                 try{
                    Conn conn = new Conn();
                    String str = "INSERT INTO room values( '"+roomnumber+"', '"+availability+"', '"+status+"','"+price+"', '"+type+"')";
                    conn.s.executeUpdate(str);
                    
                    JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                    setVisible(false);
               
                }
                catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else {
                this.setVisible(false);
            }
        }

    public static void main(String[] arg){
        new AddRooms();
    }
}
    


