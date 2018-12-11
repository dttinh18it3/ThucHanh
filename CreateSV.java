package test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class CreateSV extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfclass;
	Connection conn;
	Statement stmt;

	/**
	 * Launch the application.
	 */
	
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/qlsv", "root", "");
			System.out.println("Connect Sucess");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateSV frame = new CreateSV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		new CreateSV();
	}

	/**
	 * Create the frame.
	 */
	public CreateSV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.RED);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(23, 38, 45, 24);
		contentPane.add(lblId);
		
		tfID = new JTextField();
		tfID.setBounds(112, 41, 199, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.RED);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(22, 86, 46, 14);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(112, 80, 199, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblclass = new JLabel("Class");
		lblclass.setForeground(Color.RED);
		lblclass.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblclass.setBounds(23, 126, 66, 14);
		contentPane.add(lblclass);
		
		tfclass = new JTextField();
		tfclass.setBounds(112, 120, 199, 20);
		contentPane.add(tfclass);
		tfclass.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub
					try {
						connectDB();
						stmt = conn.createStatement();
						int n = stmt.executeUpdate("Insert into sinhvien values('"+tfID.getText()+"','"+tfName.getText()+"')");
						if(n>0) JOptionPane.showMessageDialog(null, "Success");
						else JOptionPane.showMessageDialog(null, "Fail");
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					
				}
			});	
				
			
		btnCreate.setForeground(Color.RED);
		btnCreate.setBounds(207, 193, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.RED);
		btnBack.setBounds(97, 193, 89, 23);
		contentPane.add(btnBack);
	}

}
