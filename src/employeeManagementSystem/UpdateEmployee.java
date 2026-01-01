package employeeManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateEmployee  extends JFrame implements ActionListener
{	
	JButton add,back;
	
	JTextField tfeducation,fnameField,salaryField,addressField,phoneField,
	emailField,aadharField,DesignationField;
	JLabel lblempId;
	String empId;
	
	UpdateEmployee(String empId)
	{
		this.empId = empId;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Update Employee Detail");
		heading.setBounds(300,30,500,50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,30));
		add(heading);
		
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50,150,150,30);
		labelname.setFont(new Font("serif",Font.PLAIN,20));
		add(labelname);
		
		JLabel lblname = new JLabel();
		lblname.setBounds(200,150,150,30);
		add(lblname);
		
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
		
		JLabel lbldob = new JLabel();
		lbldob.setBounds(200,200,150,30);
		add(lbldob);
		
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
		
		tfeducation = new JTextField();
		tfeducation.setBounds(600,300,150,30);
		tfeducation.setBackground(Color.WHITE);
		add(tfeducation);
		
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
		
		JLabel lblaadhar = new JLabel();
		lblaadhar.setBounds(600,350,150,30);
		add(lblaadhar);
		
		
		JLabel labelempId = new JLabel("Employee Id");
		labelempId.setBounds(50,400,150,30);
		labelempId.setFont(new Font("serif",Font.PLAIN,20));
		add(labelempId);
		
		lblempId = new JLabel();
		lblempId.setBounds(200,400,150,30);
		lblempId.setFont(new Font("serif",Font.PLAIN,20));
		add(lblempId);
		
		try
		{
			Conn c = new Conn();
			String query = "Select * from employee where empId = '"+empId+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next())
			{
				lblname.setText(rs.getString("name"));
				fnameField.setText(rs.getString("fname"));
				lbldob.setText(rs.getString("dob"));
				salaryField.setText(rs.getString("salary"));
				addressField.setText(rs.getString("address"));
				phoneField.setText(rs.getString("phone"));
				emailField.setText(rs.getString("email"));
				tfeducation.setText(rs.getString("education"));
				DesignationField.setText(rs.getString("designation"));
				lblaadhar.setText(rs.getString("aadhar"));
				lblempId.setText(rs.getString("empId"));
				
				
			}
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		add = new JButton("Update Details");
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
				String fname  =fnameField.getText();
				String salary =salaryField.getText();
				String address =addressField.getText();
				String phone =phoneField.getText();
				String email =emailField.getText();
				String education = tfeducation.getText();
				String Designation =DesignationField.getText();
				
				try
				{
					Conn conn = new Conn ();
					String query = "update employee set fname = '"+fname+"',salary ='"+salary+"',address = '"+address+"',phone ='"+phone+"',email ='"+email+"',education ='"+education+"',designation ='"+Designation+"' where empId = '"+empId+"'";
					
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Details Updated Successfully");
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
		new UpdateEmployee("");
	}

}
