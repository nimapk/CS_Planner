package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import core.User;
import dao.UserDAO;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class MyFrame1 extends JFrame {	
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	
	private UserDAO userDAO;
	private JTextField txtFirstNameReg;	
	private JTextField txtLastNameReg;
	private JTextField txtMajorReg;
	private JTextField txtEmailReg;
	private JTextField txtUsernameReg;
	private JTextField txtPasswordReg;
	private JTextField txtConfirmPasswordReg;
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame1 frame = new MyFrame1();
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
	public MyFrame1() {
		setTitle("Class Schedule App");
				
		
		// create the DAO
		try {
			userDAO = new UserDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}		
		
		setBounds(100, 100, 750, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "name_441751063879600");
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "name_24492968287013");
		panel_1.setLayout(null);
		
		JButton btnGoToLogin = new JButton("Login");
		btnGoToLogin.setBackground(new Color(0, 204, 0));
		btnGoToLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGoToLogin.setBounds(195, 275, 135, 43);
		panel_1.add(btnGoToLogin);
		
		JButton btnGoToRegister = new JButton("Register");
		btnGoToRegister.setBackground(new Color(0, 204, 0));
		btnGoToRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGoToRegister.setBounds(401, 275, 135, 43);
		panel_1.add(btnGoToRegister);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 204, 0));
		panel_7.setBounds(0, 0, 734, 152);
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to Class Planner");
		lblNewLabel_3.setForeground(new Color(204, 0, 0));
		lblNewLabel_3.setFont(new Font("Vivaldi", Font.BOLD, 52));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("\u00A9 powered by Pretty People");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(561, 514, 163, 14);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2, "name_24495828510910");
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(143, 222, 82, 25);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(143, 267, 82, 25);
		panel_2.add(lblNewLabel_1);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(263, 222, 261, 20);
		panel_2.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(263, 270, 261, 20);
		panel_2.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBackground(new Color(0, 204, 0));
		btnLogin.setBounds(237, 318, 89, 23);
		panel_2.add(btnLogin);
		
		JButton btnForgotPassword = new JButton("Forgot password?");
		btnForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnForgotPassword.setBackground(new Color(0, 204, 0));
		btnForgotPassword.setBounds(363, 318, 161, 23);
		panel_2.add(btnForgotPassword);
		
		JPanel login_panel = new JPanel();
		login_panel.setBackground(new Color(255, 204, 0));
		login_panel.setBounds(0, 0, 734, 146);
		panel_2.add(login_panel);
		login_panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 52));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		login_panel.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "name_25078018479884");
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(152, 173, 80, 26);
		panel_3.add(lblNewLabel_2);
		
		txtFirstNameReg = new JTextField();
		txtFirstNameReg.setBounds(273, 176, 278, 20);
		panel_3.add(txtFirstNameReg);
		txtFirstNameReg.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setBounds(152, 204, 64, 26);
		panel_3.add(lblLastName);
		
		txtLastNameReg = new JTextField();
		txtLastNameReg.setColumns(10);
		txtLastNameReg.setBounds(273, 207, 278, 20);
		panel_3.add(txtLastNameReg);
		
		JLabel lblMajor = new JLabel("Major:");
		lblMajor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMajor.setBounds(152, 235, 64, 26);
		panel_3.add(lblMajor);
		
		txtMajorReg = new JTextField();
		txtMajorReg.setColumns(10);
		txtMajorReg.setBounds(273, 238, 278, 20);
		panel_3.add(txtMajorReg);
//////////////////		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(152, 266, 64, 26);
		panel_3.add(lblEmail);
		
		txtEmailReg = new JTextField();
		txtEmailReg.setColumns(10);
		txtEmailReg.setBounds(273, 269, 278, 20);
		panel_3.add(txtEmailReg);
////////		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(152, 299, 64, 26);
		panel_3.add(lblUsername);
		
		txtUsernameReg = new JTextField();
		txtUsernameReg.setColumns(10);
		txtUsernameReg.setBounds(273, 302, 278, 20);
		panel_3.add(txtUsernameReg);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(152, 330, 64, 26);
		panel_3.add(lblPassword);
		
		txtPasswordReg = new JTextField();
		txtPasswordReg.setColumns(10);
		txtPasswordReg.setBounds(273, 333, 278, 20);
		panel_3.add(txtPasswordReg);
		
		txtConfirmPasswordReg = new JTextField();
		txtConfirmPasswordReg.setColumns(10);
		txtConfirmPasswordReg.setBounds(273, 364, 278, 20);
		panel_3.add(txtConfirmPasswordReg);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConfirmPassword.setBounds(152, 361, 111, 26);
		panel_3.add(lblConfirmPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegister.setBackground(new Color(0, 204, 0));
		btnRegister.setBounds(462, 395, 89, 23);
		panel_3.add(btnRegister);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 204, 0));
		panel_8.setForeground(Color.WHITE);
		panel_8.setBounds(0, 0, 734, 151);
		panel_3.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 52));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblRegister, BorderLayout.CENTER);
	
		//panel 4 properties
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, "name_26037072067628");
		panel_4.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome, name of the user");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(220, 58, 378, 26);
		panel_4.add(lblWelcome);
		
		JButton btnClassPlanner = new JButton("Class Planner");
		btnClassPlanner.setBounds(80, 108, 134, 23);
		panel_4.add(btnClassPlanner);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9, "name_4791728452251");
		panel_9.setLayout(null);
		
		String[] listCourses = {"CPSC 120 - Introduction to Programming","CPSC 121 - Object-Oriented Programming", "CPSC 131 - Data Structures"};
		JComboBox comboBoxCourses = new JComboBox(listCourses);
		AutoCompleteDecorator.decorate(comboBoxCourses);
		comboBoxCourses.setBounds(72, 47, 185, 20);
		panel_9.add(comboBoxCourses);
		
		JLabel lblCourseWarning = new JLabel("");
		lblCourseWarning.setBounds(72, 103, 199, 14);
		panel_9.add(lblCourseWarning);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setHorizontalAlignment(SwingConstants.LEFT);
		mnFile.add(mntmExit);
		
		JMenu mnSelect = new JMenu("Select");
		menuBar.add(mnSelect);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.setHorizontalAlignment(SwingConstants.LEFT);
		mnSelect.add(mntmHome);
		
		//===============actionPerformed=============each panel has 1 Action performed=====================	
		
		comboBoxCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCourseWarning.setText("You chose index: " + comboBoxCourses.getSelectedIndex());
				//lblCourseWarning.setText("You chose item: " + comboBoxCourses.getSelectedItem());
			}
		});		
		
		btnClassPlanner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.add(panel_9);
				panel.repaint();
				panel.revalidate();
			}
		});		

		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source == mntmExit)	//exit program
				{
					System.exit(0);
				}
			}
		});		
		
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source == mntmHome)
				{
					panel.removeAll();
					panel.add(panel_1);
					panel.repaint();
					panel.revalidate();
				}
			}
		});		
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname = txtFirstNameReg.getText();
				String lastname = txtLastNameReg.getText();
				String major = txtMajorReg.getText();
				String email = txtEmailReg.getText();	
				String username = txtUsernameReg.getText();
				String password = txtPasswordReg.getText();
				String repassword = txtConfirmPasswordReg.getText();
				
				//check username
				List<User> users = null;				
				if (username != null && username.trim().length() > 0) {
					try {
						users = userDAO.searchUsers(username);						
						if (!users.isEmpty()){						
							JOptionPane.showMessageDialog(MyFrame1.this, "This username was used by other people.", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
				else
				{
					JOptionPane.showMessageDialog(MyFrame1.this, "Please input username", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//check email
				//check password				
				if (password == null || !password.equals(repassword) ) {
					JOptionPane.showMessageDialog(MyFrame1.this, "The two passwords didn't match or empty", "Error", JOptionPane.ERROR_MESSAGE);					
				}
				else {					
					User tempUser = new User(firstname, lastname, email, major, username, password);
					
					try {
						// save to the database
						userDAO.addUser(tempUser);
						
						// show success message
						JOptionPane.showMessageDialog(MyFrame1.this,
								"User added succesfully.",
								"User Added",
								JOptionPane.INFORMATION_MESSAGE);
						// empty all textbox in register panel
						txtFirstNameReg.setText("");
						txtLastNameReg.setText("");
						txtMajorReg.setText("");
						txtEmailReg.setText("");	
						txtUsernameReg.setText("");
						txtPasswordReg.setText("");
						txtConfirmPasswordReg.setText("");						
						// return first page
						panel.removeAll();
						panel.add(panel_1);
						panel.repaint();
						panel.revalidate();					
					} catch (Exception exc) {
						JOptionPane.showMessageDialog(
								MyFrame1.this,
								"Error adding user: "
										+ exc.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}	
				}
				
			}
		});		
		
	
		btnGoToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.add(panel_2);
				panel.repaint();
				panel.revalidate();
				
			}
		});	
		btnGoToRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panel_3);
				panel.repaint();
				panel.revalidate();				
			}
		});	
		btnLogin.addActionListener(new ActionListener() {
		
		
			public void actionPerformed(ActionEvent e) {
								
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				List<User> users = null;
				
				if (username != null && username.trim().length() > 0) {
					try {
						users = userDAO.searchUsers(username);
						//if exists + same password, go to panel_4, else > wrong password or username does not exist
						if (users.isEmpty() || !users.get(0).getPassword().contentEquals(password)){						
						//if (users.isEmpty()){
							JOptionPane.showMessageDialog(MyFrame1.this, "Wrong username or password.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							// empty all textbox in register panel
							usernameTextField.setText("");
							passwordTextField.setText("");	
							
							// go to pane_4
							panel.removeAll();
							panel.add(panel_4);
							lblWelcome.setText("Welcome " + users.get(0).getFirstName() + "!");																				

// ADD YOUR NEW CODE HERE (panel_4)								
							
							panel.repaint();
							panel.revalidate();												
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(MyFrame1.this, "Please input usrename and password", "Error", JOptionPane.ERROR_MESSAGE);
				}					
								
			}
		});		
		
	}
}
