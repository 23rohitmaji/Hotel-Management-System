package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname, tfemail, tfphone, tfage, tfsalary, tfaadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    AddEmployee(){
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee");
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        heading.setBounds(150, 0, 200, 40);
        add(heading);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 50, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 50, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 100, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 100, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 150, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 150, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 150, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 200, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);
        
        String str[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 200, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 250, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 250, 150, 30);
        add(tfsalary);
        
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 300, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 300, 150, 30);
        add(tfphone);
        
        
        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60, 350, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 350, 150, 30);
        add(tfemail);
        
        JLabel lblaadhar = new JLabel("AADHAR");
        lblaadhar.setBounds(60, 400, 120, 30);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 400, 150, 30);
        add(tfaadhar);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 450, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(360, 200, 850, 540);
        setVisible(true);
    }
    
    //@Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();
        
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        } 
        else if(rbfemale.isSelected()){
            gender = "Female";
        }
        
        //VALIDATIONS -> EMAIL ETC ETC....
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "NAme should not be empty");
            return;
        }
        
        
        String job = (String) cbjob.getSelectedItem();
        
        try{
            Conn conn= new Conn();
            
            String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"','"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
         
            conn.s.executeUpdate(query); 
            
            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
         
            setVisible(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new AddEmployee();
    } 

}
