package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "name_24492968287013");
		panel_1.setLayout(null);
		
		JButton btnGoToLogin = new JButton("Login");
		btnGoToLogin.setBounds(10, 11, 89, 23);
		panel_1.add(btnGoToLogin);
		
		JButton btnGoToRegister = new JButton("Register");
		btnGoToRegister.setBounds(131, 11, 89, 23);
		panel_1.add(btnGoToRegister);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "name_24495828510910");
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(22, 11, 64, 25);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(22, 68, 64, 25);
		panel_2.add(lblNewLabel_1);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(106, 13, 318, 20);
		panel_2.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(106, 70, 318, 20);
		panel_2.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(22, 147, 89, 23);
		panel_2.add(btnLogin);
		
		JButton btnForgotPassword = new JButton("Forgot password?");
		btnForgotPassword.setBounds(157, 147, 267, 23);
		panel_2.add(btnForgotPassword);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "name_25078018479884");
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(26, 11, 64, 26);
		panel_3.add(lblNewLabel_2);
		
		txtFirstNameReg = new JTextField();
		txtFirstNameReg.setBounds(122, 11, 302, 20);
		panel_3.add(txtFirstNameReg);
		txtFirstNameReg.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(26, 41, 64, 26);
		panel_3.add(lblLastName);
		
		txtLastNameReg = new JTextField();
		txtLastNameReg.setColumns(10);
		txtLastNameReg.setBounds(122, 41, 302, 20);
		panel_3.add(txtLastNameReg);
		
		JLabel lblMajor = new JLabel("Major");
		lblMajor.setBounds(26, 71, 64, 26);
		panel_3.add(lblMajor);
		
		txtMajorReg = new JTextField();
		txtMajorReg.setColumns(10);
		txtMajorReg.setBounds(122, 71, 302, 20);
		panel_3.add(txtMajorReg);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(26, 101, 64, 26);
		panel_3.add(lblEmail);
		
		txtEmailReg = new JTextField();
		txtEmailReg.setColumns(10);
		txtEmailReg.setBounds(122, 101, 302, 20);
		panel_3.add(txtEmailReg);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(26, 131, 64, 26);
		panel_3.add(lblUsername);
		
		txtUsernameReg = new JTextField();
		txtUsernameReg.setColumns(10);
		txtUsernameReg.setBounds(122, 131, 302, 20);
		panel_3.add(txtUsernameReg);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(26, 161, 64, 26);
		panel_3.add(lblPassword);
		
		txtPasswordReg = new JTextField();
		txtPasswordReg.setColumns(10);
		txtPasswordReg.setBounds(122, 161, 302, 20);
		panel_3.add(txtPasswordReg);
		
		txtConfirmPasswordReg = new JTextField();
		txtConfirmPasswordReg.setColumns(10);
		txtConfirmPasswordReg.setBounds(122, 191, 302, 20);
		panel_3.add(txtConfirmPasswordReg);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(26, 191, 94, 26);
		panel_3.add(lblConfirmPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(122, 228, 89, 23);
		panel_3.add(btnRegister);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, "name_26037072067628");
		panel_4.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome, name of the user");
		lblWelcome.setBounds(28, 11, 378, 26);
		panel_4.add(lblWelcome);
		
		JLabel lblNewLabel_3 = new JLabel("ADD YOUR NEWCODE HERE");
		lblNewLabel_3.setBounds(28, 61, 358, 14);
		panel_4.add(lblNewLabel_3);

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
					User tempUser = new User(firstname, lastname, major, email, username, password);
					
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
