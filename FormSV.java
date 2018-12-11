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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.JSeparator;

public class FormSV extends JFrame {

	private JPanel contentPane;
	private JTextField tfSearch;
	Connection conn;
	Statement stmt;

	/**
	 * Launch the application.
	 */
	
	//tao ham connect DB
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =DriverManager.getConnection("jdbc:mysql://localhost/qlsv", "root", "root");
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
					FormSV frame = new FormSV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormSV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 464);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.infoText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(30, 24, 51, 17);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSearch.setForeground(Color.RED);
		contentPane.add(lblSearch);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(89, 21, 400, 20);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Research");
		btnSearch.setBounds(499, 21, 89, 23);
		btnSearch.setForeground(Color.RED);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnSearch);
		
		JButton btnNew = new JButton("Create new");
		btnNew.setBounds(598, 22, 107, 23);
		btnNew.setForeground(Color.RED);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateSV obj1 = new CreateSV();
				obj1.setVisible(true);
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(btnNew);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(30, 90, 46, 14);
		lblResult.setForeground(Color.RED);
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblResult);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 75, 712, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 75, 1, 340);
		contentPane.add(separator_1);
	}
}
