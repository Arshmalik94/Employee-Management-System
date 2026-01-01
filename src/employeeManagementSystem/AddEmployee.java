package employeeManagementSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import java.util.Random;

public class AddEmployee  extends JFrame implements ActionListener
{
	Random ran = new Random();
	int num =ran.nextInt(999999);
	
	JButton add,back;
	
	JTextField nameField,fnameField,salaryField,addressField,phoneField,
	emailField,aadharField,DesignationField;
	
	JDateChooser dcdob;
	JLabel lblempId;
	
	JComboBox educationField;
	
	AddEmployee()
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Employee Detail");
		heading.setBounds(300,30,500,50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,30));
		add(heading);
		
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50,150,150,30);
		labelname.setFont(new Font("serif",Font.PLAIN,20));
		add(labelname);
		
		nameField = new JTextField();
		nameField.setBounds(200,150,150,30);
		add(nameField);
		
		JLabel fname = new JLabel("Father's Name");
		fname.setBounds(400,150,150,30);
		fname.setFont(new Font("serif",Font.PLAIN,20));
		add(fname);
		
		fnameField = new JTextField();
		fnameField.setBounds(600,150,150,30);
		add(fnameField);
		
		JLabel ldob = new JLabel("Date of Birth");
		ldob.setBounds(50,200,150,30);
		ldob.setFont(new Font("serif",Font.PLAIN,20));
		add(ldob);
		
		dcdob = new JDateChooser();
		dcdob.setBounds(200,200,150,30);
		add(dcdob);
		
		JLabel labelsalary = new JLabel("Salary");
		labelsalary.setBounds(400,200,150,30);
		labelsalary.setFont(new Font("serif",Font.PLAIN,20));
		add(labelsalary);
		
		salaryField = new JTextField();
		salaryField.setBounds(600,200,150,30);
		add(salaryField);
		
		
		JLabel labeladdress = new JLabel("Address");
		labeladdress.setBounds(50,250,150,30);
		labeladdress.setFont(new Font("serif",Font.PLAIN,20));
		add(labeladdress);
		
		addressField = new JTextField();
		addressField.setBounds(200,250,150,30);
		add(addressField);
		
		
		JLabel labelphone = new JLabel("Phone");
		labelphone.setBounds(400,250,150,30);
		labelphone.setFont(new Font("serif",Font.PLAIN,20));
		add(labelphone);
		
		phoneField = new JTextField();
		phoneField.setBounds(600,250,150,30);
		add(phoneField);
		
		
		JLabel labelamail = new JLabel("Email");
		labelamail.setBounds(50,300,150,30);
		labelamail.setFont(new Font("serif",Font.PLAIN,20));
		add(labelamail);
		
		emailField = new JTextField();
		emailField.setBounds(200,300,150,30);
		add(emailField);
		
		
		JLabel labeleducation = new JLabel("Highest Education");
		labeleducation.setBounds(400,300,150,30);
		labeleducation.setFont(new Font("serif",Font.PLAIN,20));
		add(labeleducation);
		
		String courses[] = {"Select","BBA","BCA","BA","BSC","B.COM","BTech","MBA","MCA","MTech","MSC","PHD"};
		educationField = new JComboBox(courses);
		educationField.setBounds(600,300,150,30);
		educationField.setBackground(Color.WHITE);
		add(educationField);
		
		JLabel labelDesignation = new JLabel("Designation");
		labelDesignation.setBounds(50,350,150,30);
		labelDesignation.setFont(new Font("serif",Font.PLAIN,20));
		add(labelDesignation);
		
		DesignationField = new JTextField();
		DesignationField.setBounds(200,350,150,30);
		add(DesignationField);
		
		
		JLabel labelAadhar = new JLabel("Aadhar Number");
		labelAadhar.setBounds(400,350,150,30);
		labelAadhar.setFont(new Font("serif",Font.PLAIN,20));
		add(labelAadhar);
		
		aadharField = new JTextField();
		aadharField.setBounds(600,350,150,30);
		add(aadharField);
		
		
		JLabel labelempId = new JLabel("Employee Id");
		labelempId.setBounds(50,400,150,30);
		labelempId.setFont(new Font("serif",Font.PLAIN,20));
		add(labelempId);
		
		lblempId = new JLabel(""+num);
		lblempId.setBounds(200,400,150,30);
		lblempId.setFont(new Font("serif",Font.PLAIN,20));
		add(lblempId);
		
		
		add = new JButton("Add Details");
		add.setBounds(250 , 550, 150, 40);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.addActionListener(this);
		add(add);
		
		
		back = new JButton("Back");
		back.setBounds(450 , 550, 150, 40);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		setSize(900,700);
		setLocation(300,50);
		setVisible(true);
	}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == add)
			{
				String name   =nameField.getText();
				String fname  =fnameField.getText();
				String dob =((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
				String salary =salaryField.getText();
				String address =addressField.getText();
				String phone =phoneField.getText();
				String email =emailField.getText();
				String education = (String) educationField.getSelectedItem();
				String aadhar =aadharField.getText();
				String Designation =DesignationField.getText();
				String empid  =lblempId.getText();
				
				try
				{
					Conn conn = new Conn ();
					String query = "insert into employee values ('"+name+"','"+fname+"','"+dob+"','"+salary+"',"
							+ "'"+address+"','"+phone+"','"+email+"','"+education+"','"+Designation+"','"+aadhar+"','"+empid+"')";
					
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Details added Successfully");
					setVisible(false);
					new Home();
					
					
				} 
					catch (Exception e) 
						{
							e.printStackTrace();
						}
				
			}
			else
			{
				setVisible(false);
				new Home();
			}
		}
	
	
	public static void main(String[] args)
	{
		new AddEmployee();
	}

}
