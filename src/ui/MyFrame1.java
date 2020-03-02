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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import core.User;
import dao.UserDAO;
import core.Course;
import dao.CourseDAO;
import core.JComboBoxDecorator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JTable;

public class MyFrame1 extends JFrame {	
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
		
	private JTextField txtFirstNameReg;	
	private JTextField txtLastNameReg;
	private JTextField txtMajorReg;
	private JTextField txtEmailReg;
	private JTextField txtUsernameReg;
	private JPasswordField txtPasswordReg;
	private JPasswordField txtConfirmPasswordReg;
		
	private UserDAO userDAO;	
	private int userId;
	private CourseDAO aCourseDAO = null;
	private List<Course> courses = null;		
	private JTextField txtThisTabBy;

    private Map<String, Course> courses_map = null;
    private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame1 frame = new MyFrame1();
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);		//Center the Frame
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
		setTitle("Student Tool App");
				
		
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
		panel_1.setBorder(new LineBorder(new Color(0, 102, 0), 2));
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
		panel_7.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel_7.setBackground(new Color(255, 204, 0));
		panel_7.setBounds(0, 0, 734, 152);
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to Student Tool");
		lblNewLabel_3.setForeground(new Color(204, 0, 0));
		lblNewLabel_3.setFont(new Font("Vivaldi", Font.BOLD, 52));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("\u00A9 powered by Pretty People");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(561, 514, 163, 14);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 102, 0), 2));
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
		
		passwordTextField = new JPasswordField();
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
		login_panel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		login_panel.setBackground(new Color(255, 204, 0));
		login_panel.setBounds(0, 0, 734, 146);
		panel_2.add(login_panel);
		login_panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setForeground(new Color(204, 0, 0));
		lblNewLabel_4.setFont(new Font("Vivaldi", Font.BOLD, 52));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		login_panel.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 102, 0), 2));
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
		
		txtPasswordReg = new JPasswordField();
		txtPasswordReg.setColumns(10);
		txtPasswordReg.setBounds(273, 333, 278, 20);
		panel_3.add(txtPasswordReg);
		
		txtConfirmPasswordReg = new JPasswordField();
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
		panel_8.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel_8.setBackground(new Color(255, 204, 0));
		panel_8.setForeground(Color.WHITE);
		panel_8.setBounds(0, 0, 734, 151);
		panel_3.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(new Color(204, 0, 0));
		lblRegister.setFont(new Font("Vivaldi", Font.BOLD, 52));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblRegister, BorderLayout.CENTER);
	
		//panel 4 properties
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel.add(panel_4, "name_26037072067628");
		panel_4.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel_9.setBackground(new Color(255, 204, 0));
		panel_9.setBounds(0, 0, 734, 131);
		panel_4.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWelcome = new JLabel("Welcome, name of the user");
		lblWelcome.setForeground(new Color(204, 0, 0));
		lblWelcome.setFont(new Font("Vivaldi", Font.BOLD, 52));
		panel_9.add(lblWelcome, BorderLayout.CENTER);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setToolTipText("Input all the classes that you have taken. ");
		panel_10.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 102, 0), null));
		panel_10.setBounds(126, 160, 484, 37);
		panel_4.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblClassPlanner = new JLabel(" \u2666 Input Your Classes");
		lblClassPlanner.setToolTipText("");
		lblClassPlanner.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_10.add(lblClassPlanner, BorderLayout.WEST);
		
		JButton btnGo = new JButton("Go");
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_10.add(btnGo, BorderLayout.EAST);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 102, 0), null));
		panel_11.setBounds(126, 217, 484, 37);
		panel_4.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGpaCalculator = new JLabel(" \u2666 GPA Calculator");
		lblGpaCalculator.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_11.add(lblGpaCalculator, BorderLayout.WEST);
		
		//=========================go to the GPA Calculator panel,
	
		JButton btnGo_1 = new JButton("Go");
		btnGo_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	
		panel_11.add(btnGo_1, BorderLayout.EAST);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 102, 0), null));
		panel_12.setBounds(126, 274, 484, 37);
		panel_4.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGraduationDate = new JLabel(" \u2666 Graduation Date");
		lblGraduationDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_12.add(lblGraduationDate, BorderLayout.WEST);
		
		JButton btnGo_2 = new JButton("Go");
		btnGo_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_12.add(btnGo_2, BorderLayout.EAST);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 102, 0), null));
		panel_13.setBounds(126, 331, 484, 37);
		panel_4.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTotalUnits = new JLabel(" \u2666 Total Units");
		lblTotalUnits.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_13.add(lblTotalUnits, BorderLayout.WEST);
		
		JButton btnGo_3 = new JButton("Go");
		btnGo_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_13.add(btnGo_3, BorderLayout.EAST);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 102, 0), null));
		panel_14.setBounds(126, 456, 484, 60);
		panel_4.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnKeepUpWith = new JTextPane();
		txtpnKeepUpWith.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnKeepUpWith.setText("Keep up with your plan. Your school classes have not changed. ");
		panel_14.add(txtpnKeepUpWith, BorderLayout.CENTER);
		
		JPanel panel_23 = new JPanel();
		panel_23.setToolTipText("Make plan for your upcoming semesters");
		panel_23.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 102, 0), null));
		panel_23.setBounds(126, 391, 484, 37);
		panel_4.add(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGraduationDate_1 = new JLabel(" \u2666 Class Planner");
		lblGraduationDate_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_23.add(lblGraduationDate_1, BorderLayout.WEST);
		
		JButton btnGo_4 = new JButton("Go");
		
		btnGo_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_23.add(btnGo_4, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel_5.setForeground(new Color(204, 0, 0));
		panel.add(panel_5, "name_615154751431400");
		panel_5.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel_15.setBackground(new Color(255, 204, 0));
		panel_15.setBounds(0, 0, 734, 133);
		panel_5.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGpaCalculator_1 = new JLabel("GPA Calculator");
		lblGpaCalculator_1.setForeground(new Color(204, 0, 0));
		lblGpaCalculator_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGpaCalculator_1.setFont(new Font("Vivaldi", Font.BOLD, 52));
		panel_15.add(lblGpaCalculator_1, BorderLayout.CENTER);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(204, 204, 255));
		panel_16.setBorder(new LineBorder(new Color(0, 102, 0)));
		panel_16.setBounds(273, 312, 197, 50);
		panel_5.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		JLabel lblYourGpa = new JLabel("   Your GPA:");
		panel_16.add(lblYourGpa, BorderLayout.CENTER);
		lblYourGpa.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label = new JLabel(" 0.0   ");
		panel_16.add(label, BorderLayout.EAST);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source == btnBack)
				{
					panel.removeAll();
					panel.add(panel_4);
					panel.repaint();
					panel.revalidate();
				}
			}
		});
		
		btnBack.setBorder(new LineBorder(new Color(0, 102, 0)));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(273, 414, 197, 50);
		panel_5.add(btnBack);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCalculate.setBorder(new LineBorder(new Color(0, 102, 0)));
		btnCalculate.setBounds(273, 203, 197, 50);
		panel_5.add(btnCalculate);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel.add(panel_6, "name_615163967191000");
		panel_6.setLayout(null);
		
		JComboBox comboBoxCourses = new JComboBox();				
		comboBoxCourses.setBounds(66, 298, 400, 20);
		panel_6.add(comboBoxCourses);
		
		JLabel lblCourseWarning = new JLabel("Choose the classes which you have taken");
		lblCourseWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseWarning.setBounds(66, 258, 398, 14);
		panel_6.add(lblCourseWarning);		
		
		JButton btnCourseAdd = new JButton("Add");
		btnCourseAdd.setToolTipText("Add your taken classes to database");
		btnCourseAdd.setBounds(596, 297, 89, 23);
		panel_6.add(btnCourseAdd);
		
		JLabel lblCourseAdd = new JLabel("Grade");
		lblCourseAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseAdd.setBounds(502, 258, 62, 14);
		panel_6.add(lblCourseAdd);
		
		String[] listGrades = {"","A+","A","A-","B+","B","B-","C+","C","C-","D","F"};
		JComboBox comboBoxGrade = new JComboBox(listGrades);
		comboBoxGrade.setToolTipText("Input the grade that you got for the selected class");
		comboBoxGrade.setBounds(502, 298, 62, 20);
		//JComboBoxDecorator.decorate(comboBoxGrade, true); 
		panel_6.add(comboBoxGrade);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel_18.setBackground(new Color(255, 204, 0));
		panel_18.setBounds(0, 0, 734, 135);
		panel_6.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JLabel lblClassPlanner_1 = new JLabel("Input Your Classes");
		lblClassPlanner_1.setForeground(new Color(204, 0, 0));
		lblClassPlanner_1.setFont(new Font("Vivaldi", Font.BOLD, 52));
		lblClassPlanner_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_18.add(lblClassPlanner_1, BorderLayout.CENTER);
		
		JLabel lblAddClass = new JLabel("Add Class");
		lblAddClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddClass.setBounds(596, 258, 89, 14);
		panel_6.add(lblAddClass);
		//==========================================================================Here Plan			
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.add(panel_4);
					panel.repaint();
					panel.revalidate();					
			}
		});
		btnBack_2.setBounds(596, 382, 89, 23);
		panel_6.add(btnBack_2);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel.add(panel_17, "name_1830898570700");
		panel_17.setLayout(null);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel_19.setBackground(new Color(255, 204, 0));
		panel_19.setBounds(0, 0, 734, 135);
		panel_17.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Total Units");
		lblNewLabel_6.setForeground(new Color(204, 0, 0));
		lblNewLabel_6.setFont(new Font("Vivaldi", Font.BOLD, 52));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblNewLabel_6, BorderLayout.CENTER);
		
		JPanel panel_24 = new JPanel();
		panel_24.setLayout(null);
		panel_24.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel.add(panel_24, "name_274757212246000");
		
		txtThisTabBy = new JTextField();
		txtThisTabBy.setHorizontalAlignment(SwingConstants.CENTER);
		txtThisTabBy.setText("This tab, by clicking the button it will tell you how any unit that you have taken");
		txtThisTabBy.setBounds(59, 171, 607, 192);
		panel_17.add(txtThisTabBy);
		txtThisTabBy.setColumns(10);
		
		btnGo_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source == btnGo_3)
				{
					panel.removeAll();
					panel.add(panel_17);
					panel.repaint();
					panel.revalidate();
				}
				
			}
		});
		
		JButton btnGetTotalUnits = new JButton("Get Total Units");
		btnGetTotalUnits.setToolTipText("Get your total units that you earned so far.");
		btnGetTotalUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int aTotalUnits;
					
					aTotalUnits = userDAO.calculateTotalUnits(userId);
					
					txtThisTabBy.setText(Integer.toString(aTotalUnits));
					
					txtThisTabBy.setFont(new Font("Tahoma", Font.BOLD, 45));
					
				}
				catch (Exception exc) {
                    JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		btnGetTotalUnits.setBounds(164, 387, 124, 23);
		panel_17.add(btnGetTotalUnits);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.add(panel_4);
					panel.repaint();
					panel.revalidate();				
			}
		});

		btnBack_1.setBounds(498, 387, 89, 23);
		panel_17.add(btnBack_1);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel.add(panel_20, "name_3158997082800");
		panel_20.setLayout(null);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel_21.setBackground(new Color(255, 204, 0));
		panel_21.setBounds(0, 0, 734, 135);
		panel_20.add(panel_21);
		panel_21.setLayout(new BorderLayout(0, 0));
		
		JLabel lblYourPlan = new JLabel("Your Plan");
		lblYourPlan.setForeground(new Color(204, 0, 0));
		lblYourPlan.setFont(new Font("Vivaldi", Font.BOLD, 52));
		lblYourPlan.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblYourPlan, BorderLayout.CENTER);
		
		JPanel panel_22 = new JPanel();
		
		panel_22.setBounds(33, 157, 665, 306);
		panel_20.add(panel_22);
		panel_22.setLayout(null);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.add(panel_4);
					panel.repaint();
					panel.revalidate();			
			}
		});
		btnBack_3.setBounds(597, 486, 89, 23);
		panel_20.add(btnBack_3);
		
		JButton btnForward = new JButton("Forward");
		btnForward.setBounds(361, 486, 89, 23);
		panel_20.add(btnForward);
		
		JButton btnBackward = new JButton("Backward");
		btnBackward.setBounds(270, 486, 89, 23);
		panel_20.add(btnBackward);
		
	
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester.setBounds(470, 158, 89, 23);
		panel_24.add(lblSemester);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBorder(new LineBorder(new Color(0, 102, 0), 2));
		panel_25.setBackground(new Color(255, 204, 0));
		panel_25.setBounds(0, 0, 734, 135);
		panel_24.add(panel_25);
		panel_25.setLayout(new BorderLayout(0, 0));
		
				
		
		JLabel lblClassPlanner_2 = new JLabel("Class Planner");
		lblClassPlanner_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassPlanner_2.setForeground(new Color(204, 0, 0));
		lblClassPlanner_2.setFont(new Font("Vivaldi", Font.BOLD, 52));
		panel_25.add(lblClassPlanner_2, BorderLayout.CENTER);
		
		JButton button_2 = new JButton("Add");
		button_2.setToolTipText("Add your untaken class to database.");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(585, 239, 89, 23);
		panel_24.add(button_2);
		
		JButton button_4 = new JButton("Back");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
					panel.removeAll();
					panel.add(panel_4);
					panel.repaint();
					panel.revalidate();								
			}
		});
		button_4.setBounds(470, 493, 89, 23);
		panel_24.add(button_4);
		
		JButton button_5 = new JButton("Here Your Plan");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panel_20);
				panel.repaint();
				panel.revalidate();	
				
			}
		});
		button_5.setBounds(172, 493, 147, 23);
		panel_24.add(button_5);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(585, 158, 89, 23);
		panel_24.add(lblYear);
		
		JComboBox comboBoxNewCourses = new JComboBox();				
		comboBoxNewCourses.setBounds(63, 209, 373, 20);
		panel_24.add(comboBoxNewCourses);
		

		String[] listSemesters = {"","Spring","Summer","Fall","Winter"};
		JComboBox comboBoxSemester = new JComboBox(listSemesters);		
		comboBoxSemester.setBounds(470, 209, 89, 20);
		//JComboBoxDecorator.decorate(comboBoxSemester, true); 
		panel_24.add(comboBoxSemester);		
		
		String[] listYears = {"","2020","2021","2022","2023","2024"};
		JComboBox comboBoxYear = new JComboBox(listYears);		
		comboBoxYear.setBounds(584, 209, 90, 20);
		//JComboBoxDecorator.decorate(comboBoxYear, true); 
		panel_24.add(comboBoxYear);			
		
	
		JLabel lblPrerequisiteCourses = new JLabel("This course has no prerequisites!");
		//lblPrerequisiteCourses.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrerequisiteCourses.setBounds(63, 240, 373, 20);
		panel_24.add(lblPrerequisiteCourses);		
		
		
		JLabel lblClassesThatYou = new JLabel("Classes that you want to take");
		lblClassesThatYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassesThatYou.setBounds(63, 162, 373, 23);
		panel_24.add(lblClassesThatYou);
		
		JScrollPane scrollPanelNewCourses = new JScrollPane();
		scrollPanelNewCourses.setBounds(63, 273, 611, 216);
		panel_24.add(scrollPanelNewCourses);
		
		table = new JTable();
		scrollPanelNewCourses.setViewportView(table);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source == mntmExit)	//exit program
				{
					System.exit(0);
				}
			}
		});
		mntmExit.setHorizontalAlignment(SwingConstants.LEFT);
		mnFile.add(mntmExit);
		
		JMenu mnSelect = new JMenu("Select");
		menuBar.add(mnSelect);
		
		JMenuItem mntmHome = new JMenuItem("LogOut");
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
		btnGo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source == btnGo_1)
				{
					panel.removeAll();
					panel.add(panel_5);
					panel.repaint();
					panel.revalidate();
				}
				
			}
		});
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == btnCalculate) {
                    try {
                        aCourseDAO = new CourseDAO();
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        courses_map = aCourseDAO.getAllCoursesAsMap();
                        List<String> passedCourses = null;
                        List<String> passedGrades = null;
                        passedCourses = userDAO.searchCoursesUserPassed(userId);
                        passedGrades  = userDAO.searchGradeUserPassed(userId);
                        
                        double total_units = 0;
                        double total_score = 0;
                        
                        for(int i = 0; i < passedCourses.size(); i++){
                            String course = passedCourses.get(i);
                            String grade = passedGrades.get(i);
                            Course course_item = courses_map.get(course);
                            if(course_item == null) continue;
                            int units = course_item.getUnits();
                            total_units += units;
                            total_score += units * userDAO.getScoreFromGrade(grade);
                        }
                        double GPA = 0.0;
                        if(total_units == 0 || total_score == 0){
                            GPA = 0;
                        }else{
                            GPA = total_score / total_units;
                        }
                        
                        label.setText(String.format("  " + "%.1f", GPA) + "   ");
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
		});
		mntmHome.setHorizontalAlignment(SwingConstants.LEFT);
		mnSelect.add(mntmHome);
		
		//===============actionPerformed=============each panel has 1 Actionperformed=====================
		
		btnGo_4.addActionListener(new ActionListener() {		/////////////////////////////=======================
			public void actionPerformed(ActionEvent e) {//abc2
				Object source = e.getSource();
				if(source == btnGo_4)
				{
					panel.removeAll();
					panel.add(panel_24);
					
					// create the DAO
					try {
						aCourseDAO = new CourseDAO();
					} catch (Exception exc) {					
						JOptionPane.showMessageDialog(MyFrame1.this,  "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
					}
					try {				
						//List<Course> courses = null; //already declared public
						if (courses == null)	//Don't load any course into the list so far
							courses = aCourseDAO.getAllCourses();					
						List<String> passedCourses = null;
						passedCourses = userDAO.searchCoursesUserPassed(userId);
						comboBoxNewCourses.removeAllItems();
						comboBoxNewCourses.addItem("");
						for (Course tempCourse : courses) {
							if (passedCourses.contains(tempCourse.getCno())) {
								// dont' do any thing or add with notice "passed"
								//comboBoxNewCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle() + " >> (Passed)");								
							}
							else
							{
								comboBoxNewCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle());
							}
						}
						
					}
					catch (Exception exc) {
						JOptionPane.showMessageDialog(MyFrame1.this,  "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
					}				
					//JComboBoxDecorator.decorate(comboBoxNewCourses, true); 					
						
					//create the model and update the "table" => change to NewCourses table later
					NewCoursesTableModel model = new NewCoursesTableModel(courses);
					table.setModel(model);
					
					panel.repaint();
					panel.revalidate();
				}
			}
		});
		
		btnCourseAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//abc3
				String sCurrentItem = comboBoxCourses.getSelectedItem().toString();
				String[] aCnum = sCurrentItem.split(" - ");
				int currentIndex = comboBoxCourses.getSelectedIndex();
				//lblCourseWarning.setText("You chose course: " + aCnum[0]);	
				if (aCnum[0] == "" || comboBoxGrade.getSelectedItem().toString() == "") {
					JOptionPane.showMessageDialog(MyFrame1.this,  "Course or Grade cannot be blank!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {					
					try {
						
						userDAO.addCourseToUser(userId, aCnum[0], comboBoxGrade.getSelectedItem().toString());					
						// show success message
						JOptionPane.showMessageDialog(MyFrame1.this,
								"Course added succesfully.",
								"Course Added",
								JOptionPane.INFORMATION_MESSAGE);
						
						//Refresh courses
						comboBoxCourses.removeAllItems();
						//List<Course> courses = null;
						//courses = aCourseDAO.getAllCourses();
						List<String> passedCourses = null;
						passedCourses = userDAO.searchCoursesUserPassed(userId);					
						comboBoxCourses.addItem("");
						for (Course tempCourse : courses) {
							if (passedCourses.contains(tempCourse.getCno())) {
								comboBoxCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle() + " >> (Passed)");
								
							}
							else
							{
								comboBoxCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle());
							}
						}
						comboBoxGrade.setSelectedIndex(0);
						//JComboBoxDecorator.decorate(comboBoxCourses, true); //update list 
						
						
						
						//comboBoxCourses.removeItemAt(currentIndex);
						//comboBoxCourses.insertItemAt(sCurrentItem + " >> (Passed)", currentIndex);

						
						
						
					}
					catch (Exception exc) {
						JOptionPane.showMessageDialog(MyFrame1.this,  "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		
		comboBoxCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Do it later ?? disable add button if no course is selected or selected course is passed				
//				if (comboBoxCourses.getSelectedIndex() == 0 ) {									
//				}					
//				lblCourseWarning.setText("You chose index: " + comboBoxCourses.getSelectedIndex());
				
				
			}
		});		
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.add(panel_6);
//abc1							
				//CourseDAO aCourseDAO = null;
				// create the DAO
				try {
					aCourseDAO = new CourseDAO();
				} catch (Exception exc) {					
					JOptionPane.showMessageDialog(MyFrame1.this,  "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {				
					//List<Course> courses = null;
					if (courses == null)
						courses = aCourseDAO.getAllCourses();					
					List<String> passedCourses = null;
					passedCourses = userDAO.searchCoursesUserPassed(userId);
					comboBoxCourses.removeAllItems();
					comboBoxCourses.addItem("");
					for (Course tempCourse : courses) {
						if (passedCourses.contains(tempCourse.getCno())) {
							comboBoxCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle() + " >> (Passed)");
							
						}
						else
						{
							comboBoxCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle());
						}
					}
					
				}
				catch (Exception exc) {
					JOptionPane.showMessageDialog(MyFrame1.this,  "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
				}				
				//JComboBoxDecorator.decorate(comboBoxCourses, true); 
				panel.repaint();
				panel.revalidate();				
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
							userId = users.get(0).getID();
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
