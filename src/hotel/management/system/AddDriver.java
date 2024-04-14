package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    JButton add, cancel;
    JTextField tfname, tfcompany, tfage, tfmodel, tflocation;
    JComboBox<String> genderCombo, availableCombo;

    AddDriver() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading: Add Drivers
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(200, 10, 200, 30);
        add(heading);

        // Name
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblName.setBounds(60, 70, 120, 30);
        add(lblName);

        tfname = new JTextField();
        tfname.setBounds(200, 80, 120, 30);
        add(tfname);

        // Age
        JLabel lblAge = new JLabel("Age");
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAge.setBounds(60, 110, 120, 30);
        add(lblAge);

        tfage = new JTextField();
        tfage.setBounds(200, 110, 120, 30);
        add(tfage);

        // Gender
        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblGender.setBounds(60, 150, 120, 30);
        add(lblGender);

        String[] genderOptions = {"Male", "Female"};
        genderCombo = new JComboBox<>(genderOptions);
        genderCombo.setBounds(200, 150, 150, 30);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);

        // Car Company
        JLabel lblCompany = new JLabel("Car Company");
        lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCompany.setBounds(60, 190, 120, 30);
        add(lblCompany);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);

        // Car Model
        JLabel lblModel = new JLabel("Car Model");
        lblModel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblModel.setBounds(60, 230, 120, 30);
        add(lblModel);

        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);

        // Driver availability
        JLabel lblAvailable = new JLabel("Available");
        lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAvailable.setBounds(60, 270, 120, 30);
        add(lblAvailable);

        String[] availableOptions = {"Available", "Busy"};
        availableCombo = new JComboBox<>(availableOptions);
        availableCombo.setBounds(200, 270, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        // Location where the driver is located
        JLabel lblLocation = new JLabel("Location");
        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLocation.setBounds(60, 310, 120, 30);
        add(lblLocation);

        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);

        // Buttons for adding a driver and canceling
        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        // Set an image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setBounds(300, 200, 980, 470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
//      
           
            if(ae.getSource() == add){
                String name = tfname.getText();
                String age = tfage.getText();
                String gender = (String) genderCombo.getSelectedItem();
                String company = tfcompany.getText();
                String brand = tfmodel.getText();
                String available = (String) availableCombo.getSelectedItem();
                String location = tflocation.getText();
                    //this is for you cannot left empty
                    if(name.equals("")){
                        JOptionPane.showMessageDialog(null, "Name should not be empty");
                        return;
                    }
                    if(age.equals("")){
                        JOptionPane.showMessageDialog(null, "Age should not be empty");
                        return;
                    }
                    if(company.equals("")){
                        JOptionPane.showMessageDialog(null, "Car Company should not be empty");
                        return;
                    }
                    if(brand.equals("")){
                        JOptionPane.showMessageDialog(null, "Car Model should not be empty");
                        return;
                    }
                    if(location.equals("")){
                        JOptionPane.showMessageDialog(null, "Location should not be empty");
                        return;
                    }
                 try{
                    Conn conn = new Conn();
                    String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"', '"+location+"')";
                    conn.s.executeUpdate(str);
                    
                    JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
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
        new AddDriver();
    }
}
    


