package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import core.User;
import dao.UserDAO;
import core.Course;
import dao.CourseDAO;
import core.JComboBoxDecorator;
import core.UpcomingCourse;//abc10
import core.Question;
import dao.QuestionDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.MouseWheelEvent;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


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
    private JComboBox comboBoxQuestions;
    private JTextField userAnswer;

    private UserDAO userDAO;
    private int userId;
    private CourseDAO aCourseDAO = null;
    private QuestionDao questionDAO = null;
    private List<Question> questions = null;

    private List<Course> courses = null;
    private List<UpcomingCourse> upcourses = null;//abc10
    private JTextField txtThisTabBy;

    private Map<String, Course> courses_map = null;
    private JTable tableNewCourses;
    /////////////////////////////////====================================================================For the Display class plan===========
    int number_of_years = 3;			// this should be store the number of years
    private int mYear = 2020;
    private Vector<JScrollPane> scrollpanelVec = new Vector<JScrollPane>();		//this vector size == number of years , each element will display all planing classes for each year	

    //============================Images============================
    private BufferedImage topCover;
    private ImageIcon backward_icon = new ImageIcon("images/leftbutton.png");
    private ImageIcon forward_icon = new ImageIcon("images/rightbutton.png");

    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JTextField txtThisWillDisplay;
    private JTable table;//abc10
    

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

        //==================set images for covers ===========
        try {
            topCover = ImageIO.read(new File("images/p1cover.jpg"));

        } catch (Exception e) {
        }

        // create the DAO
        try {
            userDAO = new UserDAO();
            //init question connection and get all questions
            questionDAO = new QuestionDao();
            questions = questionDAO.getAllQuestions();
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

        JButton btnGoToRegister = new JButton("Register");
        btnGoToRegister.setBounds(394, 295, 190, 57);
        panel_1.add(btnGoToRegister);
        btnGoToRegister.setBackground(new Color(0, 204, 0));
        btnGoToRegister.setFont(new Font("Tahoma", Font.BOLD, 20));

        JButton btnGoToLogin = new JButton("Login");
        btnGoToLogin.setBounds(147, 294, 190, 57);
        panel_1.add(btnGoToLogin);
        btnGoToLogin.setBackground(new Color(0, 204, 0));
        btnGoToLogin.setFont(new Font("Tahoma", Font.BOLD, 20));

        JLabel lblNewLabel_5 = new JLabel("\u00A9 powered by Pretty People");
        lblNewLabel_5.setBounds(523, 519, 201, 20);
        panel_1.add(lblNewLabel_5);
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel lblNewLabel_7 = new JLabel(new ImageIcon(topCover));
        lblNewLabel_7.setBounds(10, 160, 714, 368);
        panel_1.add(lblNewLabel_7);

        JPanel login_jpanel = new JPanel();
        login_jpanel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        login_jpanel.setBackground(Color.WHITE);
        panel.add(login_jpanel, "name_24495828510910");
        login_jpanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setBackground(new Color(0, 0, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(143, 222, 82, 25);
        login_jpanel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Password:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setBounds(143, 267, 82, 25);
        login_jpanel.add(lblNewLabel_1);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(263, 222, 261, 20);
        login_jpanel.add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(263, 270, 261, 20);
        login_jpanel.add(passwordTextField);
        passwordTextField.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnLogin.setBackground(new Color(0, 204, 0));
        btnLogin.setBounds(237, 318, 89, 23);
        login_jpanel.add(btnLogin);

        JButton btnForgotPassword = new JButton("Forgot password?");

        btnForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnForgotPassword.setBackground(new Color(0, 204, 0));
        btnForgotPassword.setBounds(363, 318, 161, 23);
        login_jpanel.add(btnForgotPassword);

        JPanel login_panel = new JPanel();
        login_panel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        login_panel.setBackground(new Color(255, 204, 0));
        login_panel.setBounds(0, 0, 734, 146);
        login_jpanel.add(login_panel);
        login_panel.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_4 = new JLabel("Login");
        lblNewLabel_4.setForeground(new Color(204, 0, 0));
        lblNewLabel_4.setFont(new Font("Vivaldi", Font.BOLD, 52));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        login_panel.add(lblNewLabel_4, BorderLayout.CENTER);

        JPanel reset_password_jpanel = new JPanel();
        panel.add(reset_password_jpanel, "name_3377635213700");
        reset_password_jpanel.setLayout(null);
        reset_password_jpanel.setBorder(new LineBorder(new Color(0, 102, 0), 2));

        JLabel label_1 = new JLabel("First Name:");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_1.setBounds(152, 173, 80, 26);
        reset_password_jpanel.add(label_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(273, 176, 278, 20);
        reset_password_jpanel.add(textField);

        JLabel label_2 = new JLabel("Last Name:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_2.setBounds(152, 204, 64, 26);
        reset_password_jpanel.add(label_2);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(273, 207, 278, 20);
        reset_password_jpanel.add(textField_1);

        JLabel label_3 = new JLabel("Major:");
        label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_3.setBounds(152, 235, 64, 26);
        reset_password_jpanel.add(label_3);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(273, 238, 278, 20);
        reset_password_jpanel.add(textField_2);

        JLabel label_4 = new JLabel("Email");
        label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_4.setBounds(152, 266, 64, 26);
        reset_password_jpanel.add(label_4);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(273, 269, 278, 20);
        reset_password_jpanel.add(textField_3);

        JLabel label_5 = new JLabel("Username:");
        label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_5.setBounds(152, 299, 64, 26);
        reset_password_jpanel.add(label_5);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(273, 302, 278, 20);
        reset_password_jpanel.add(textField_4);

        JLabel label_6 = new JLabel("Password:");
        label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_6.setBounds(152, 330, 64, 26);
        reset_password_jpanel.add(label_6);

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(273, 333, 278, 20);
        reset_password_jpanel.add(passwordField);

        passwordField_1 = new JPasswordField();
        passwordField_1.setColumns(10);
        passwordField_1.setBounds(273, 364, 278, 20);
        reset_password_jpanel.add(passwordField_1);

        JLabel label_7 = new JLabel("Confirm Password:");
        label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_7.setBounds(152, 361, 111, 26);
        reset_password_jpanel.add(label_7);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnReset.setBackground(new Color(0, 204, 0));
        btnReset.setBounds(462, 395, 89, 23);
        reset_password_jpanel.add(btnReset);

        JPanel panel_26 = new JPanel();
        panel_26.setForeground(Color.WHITE);
        panel_26.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel_26.setBackground(new Color(255, 204, 0));
        panel_26.setBounds(0, 0, 734, 151);
        reset_password_jpanel.add(panel_26);
        panel_26.setLayout(new BorderLayout(0, 0));

        JLabel lblResetPassword = new JLabel("Reset Password");
        lblResetPassword.setForeground(new Color(204, 0, 0));
        lblResetPassword.setFont(new Font("Vivaldi", Font.BOLD, 52));
        lblResetPassword.setHorizontalAlignment(SwingConstants.CENTER);
        panel_26.add(lblResetPassword, BorderLayout.CENTER);

        JPanel register_jpanel = new JPanel();
        register_jpanel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel.add(register_jpanel, "name_25078018479884");
        register_jpanel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("First Name:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setBounds(152, 173, 80, 26);
        register_jpanel.add(lblNewLabel_2);

        txtFirstNameReg = new JTextField();
        txtFirstNameReg.setBounds(273, 176, 278, 20);
        register_jpanel.add(txtFirstNameReg);
        txtFirstNameReg.setColumns(10);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblLastName.setBounds(152, 204, 64, 26);
        register_jpanel.add(lblLastName);

        txtLastNameReg = new JTextField();
        txtLastNameReg.setColumns(10);
        txtLastNameReg.setBounds(273, 207, 278, 20);
        register_jpanel.add(txtLastNameReg);

        JLabel lblMajor = new JLabel("Major:");
        lblMajor.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblMajor.setBounds(152, 235, 64, 26);
        register_jpanel.add(lblMajor);

        txtMajorReg = new JTextField();
        txtMajorReg.setColumns(10);
        txtMajorReg.setBounds(273, 238, 278, 20);
        register_jpanel.add(txtMajorReg);
//////////////////		
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEmail.setBounds(152, 266, 64, 26);
        register_jpanel.add(lblEmail);

        txtEmailReg = new JTextField();
        txtEmailReg.setColumns(10);
        txtEmailReg.setBounds(273, 269, 278, 20);
        register_jpanel.add(txtEmailReg);
////////		
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblUsername.setBounds(152, 299, 64, 26);
        register_jpanel.add(lblUsername);

        txtUsernameReg = new JTextField();
        txtUsernameReg.setColumns(10);
        txtUsernameReg.setBounds(273, 302, 278, 20);
        register_jpanel.add(txtUsernameReg);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPassword.setBounds(152, 330, 64, 26);
        register_jpanel.add(lblPassword);

        txtPasswordReg = new JPasswordField();
        txtPasswordReg.setColumns(10);
        txtPasswordReg.setBounds(273, 333, 278, 20);
        register_jpanel.add(txtPasswordReg);

        txtConfirmPasswordReg = new JPasswordField();
        txtConfirmPasswordReg.setColumns(10);
        txtConfirmPasswordReg.setBounds(273, 364, 278, 20);
        register_jpanel.add(txtConfirmPasswordReg);

        JLabel lblConfirmPassword = new JLabel("Confirm Password:");
        lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblConfirmPassword.setBounds(152, 361, 111, 26);
        register_jpanel.add(lblConfirmPassword);

        comboBoxQuestions = new JComboBox();
        comboBoxQuestions.setBounds(273, 395, 278, 20);
        register_jpanel.add(comboBoxQuestions);

        //add questions
        if (questions != null) {
            for (Question item : questions) {
                comboBoxQuestions.addItem(item);
            }
        }

        JLabel lblQuestions = new JLabel("Questions:");
        lblQuestions.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblQuestions.setBounds(152, 395, 111, 26);
        register_jpanel.add(lblQuestions);

        userAnswer = new JTextField();
        userAnswer.setColumns(10);
        userAnswer.setBounds(273, 426, 278, 20);
        register_jpanel.add(userAnswer);

        JLabel lblAnswer = new JLabel("Answer:");
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblAnswer.setBounds(152, 426, 111, 26);
        register_jpanel.add(lblAnswer);

        JButton btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRegister.setBackground(new Color(0, 204, 0));
        btnRegister.setBounds(462, 457, 89, 23);
        register_jpanel.add(btnRegister);

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel_8.setBackground(new Color(255, 204, 0));
        panel_8.setForeground(Color.WHITE);
        panel_8.setBounds(0, 0, 734, 151);
        register_jpanel.add(panel_8);
        panel_8.setLayout(new BorderLayout(0, 0));

        JLabel lblRegister = new JLabel("Register");
        lblRegister.setForeground(new Color(204, 0, 0));
        lblRegister.setFont(new Font("Vivaldi", Font.BOLD, 52));
        lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
        panel_8.add(lblRegister, BorderLayout.CENTER);

        //panel 4 properties
        JPanel main_jpanel = new JPanel();
        main_jpanel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel.add(main_jpanel, "name_26037072067628");
        main_jpanel.setLayout(null);

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel_9.setBackground(new Color(255, 204, 0));
        panel_9.setBounds(0, 0, 734, 131);
        main_jpanel.add(panel_9);
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
        main_jpanel.add(panel_10);
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
        main_jpanel.add(panel_11);
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
        main_jpanel.add(panel_12);
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
        main_jpanel.add(panel_13);
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
        main_jpanel.add(panel_14);
        panel_14.setLayout(new BorderLayout(0, 0));

        JTextPane txtpnKeepUpWith = new JTextPane();
        txtpnKeepUpWith.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtpnKeepUpWith.setText("Keep up with your plan. Your school classes have not changed. ");
        panel_14.add(txtpnKeepUpWith, BorderLayout.CENTER);

        JPanel panel_23 = new JPanel();
        panel_23.setToolTipText("Make plan for your upcoming semesters");
        panel_23.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 102, 0), null));
        panel_23.setBounds(126, 391, 484, 37);
        main_jpanel.add(panel_23);
        panel_23.setLayout(new BorderLayout(0, 0));

        JLabel lblGraduationDate_1 = new JLabel(" \u2666 Class Planner");
        lblGraduationDate_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_23.add(lblGraduationDate_1, BorderLayout.WEST);

        JButton btnGo_4 = new JButton("Go");

        btnGo_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_23.add(btnGo_4, BorderLayout.EAST);

        JPanel gpa_jpanel = new JPanel();
        gpa_jpanel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        gpa_jpanel.setForeground(new Color(204, 0, 0));
        panel.add(gpa_jpanel, "name_615154751431400");
        gpa_jpanel.setLayout(null);

        JPanel panel_15 = new JPanel();
        panel_15.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel_15.setBackground(new Color(255, 204, 0));
        panel_15.setBounds(0, 0, 734, 133);
        gpa_jpanel.add(panel_15);
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
        gpa_jpanel.add(panel_16);
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
                if (source == btnBack) {
                    panel.removeAll();
                    panel.add(main_jpanel);
                    panel.repaint();
                    panel.revalidate();
                }
            }
        });

        btnBack.setBorder(new LineBorder(new Color(0, 102, 0)));
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnBack.setBounds(273, 414, 197, 50);
        gpa_jpanel.add(btnBack);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCalculate.setBorder(new LineBorder(new Color(0, 102, 0)));
        btnCalculate.setBounds(273, 203, 197, 50);
        gpa_jpanel.add(btnCalculate);

        JPanel input_class_jpanel = new JPanel();
        input_class_jpanel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel.add(input_class_jpanel, "name_615163967191000");
        input_class_jpanel.setLayout(null);

        JComboBox comboBoxCourses = new JComboBox();
        comboBoxCourses.setBounds(66, 298, 400, 20);
        input_class_jpanel.add(comboBoxCourses);

        JLabel lblCourseWarning = new JLabel("Choose the classes which you have taken");
        lblCourseWarning.setHorizontalAlignment(SwingConstants.CENTER);
        lblCourseWarning.setBounds(66, 258, 398, 14);
        input_class_jpanel.add(lblCourseWarning);

        JButton btnCourseAdd = new JButton("Add");
        btnCourseAdd.setToolTipText("Add your taken classes to database");
        btnCourseAdd.setBounds(596, 297, 89, 23);
        input_class_jpanel.add(btnCourseAdd);

        JLabel lblCourseAdd = new JLabel("Grade");
        lblCourseAdd.setHorizontalAlignment(SwingConstants.CENTER);
        lblCourseAdd.setBounds(502, 258, 62, 14);
        input_class_jpanel.add(lblCourseAdd);

        String[] listGrades = {"", "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};
        JComboBox comboBoxGrade = new JComboBox(listGrades);
        comboBoxGrade.setToolTipText("Input the grade that you got for the selected class");
        comboBoxGrade.setBounds(502, 298, 62, 20);
        //JComboBoxDecorator.decorate(comboBoxGrade, true); 
        input_class_jpanel.add(comboBoxGrade);

        JPanel panel_18 = new JPanel();
        panel_18.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel_18.setBackground(new Color(255, 204, 0));
        panel_18.setBounds(0, 0, 734, 135);
        input_class_jpanel.add(panel_18);
        panel_18.setLayout(new BorderLayout(0, 0));

        JLabel lblClassPlanner_1 = new JLabel("Input Your Classes");
        lblClassPlanner_1.setForeground(new Color(204, 0, 0));
        lblClassPlanner_1.setFont(new Font("Vivaldi", Font.BOLD, 52));
        lblClassPlanner_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_18.add(lblClassPlanner_1, BorderLayout.CENTER);

        JLabel lblAddClass = new JLabel("Add Class");
        lblAddClass.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddClass.setBounds(596, 258, 89, 14);
        input_class_jpanel.add(lblAddClass);
        //==========================================================================Here Plan			
        JButton btnBack_2 = new JButton("Back");
        btnBack_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(main_jpanel);
                panel.repaint();
                panel.revalidate();
            }
        });
        btnBack_2.setBounds(596, 382, 89, 23);
        input_class_jpanel.add(btnBack_2);

        JPanel total_units_jpanel = new JPanel();
        total_units_jpanel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel.add(total_units_jpanel, "name_1830898570700");
        total_units_jpanel.setLayout(null);

        JPanel panel_19 = new JPanel();
        panel_19.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel_19.setBackground(new Color(255, 204, 0));
        panel_19.setBounds(0, 0, 734, 135);
        total_units_jpanel.add(panel_19);
        panel_19.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_6 = new JLabel("Total Units");
        lblNewLabel_6.setForeground(new Color(204, 0, 0));
        lblNewLabel_6.setFont(new Font("Vivaldi", Font.BOLD, 52));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        panel_19.add(lblNewLabel_6, BorderLayout.CENTER);

        JPanel class_planner_jpanel = new JPanel();
        class_planner_jpanel.setLayout(null);
        class_planner_jpanel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel.add(class_planner_jpanel, "name_274757212246000");

        txtThisTabBy = new JTextField();
        txtThisTabBy.setHorizontalAlignment(SwingConstants.CENTER);
        txtThisTabBy.setText("This tab, by clicking the button it will tell you how any unit that you have taken");
        txtThisTabBy.setBounds(59, 171, 607, 192);
        total_units_jpanel.add(txtThisTabBy);
        txtThisTabBy.setColumns(10);

        btnGo_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == btnGo_3) {
                    panel.removeAll();
                    panel.add(total_units_jpanel);
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

                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnGetTotalUnits.setBounds(164, 387, 124, 23);
        total_units_jpanel.add(btnGetTotalUnits);

        JButton btnBack_1 = new JButton("Back");
        btnBack_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(main_jpanel);
                panel.repaint();
                panel.revalidate();
            }
        });
        btnGoToLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel.removeAll();
                panel.add(login_jpanel);
                panel.repaint();
                panel.revalidate();

            }
        });

        btnBack_1.setBounds(498, 387, 89, 23);
        total_units_jpanel.add(btnBack_1);

        JPanel graduation_date_jpanel = new JPanel();
        graduation_date_jpanel.setLayout(null);
        graduation_date_jpanel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel.add(graduation_date_jpanel, "name_3874032161200");

        JPanel panel_28 = new JPanel();
        panel_28.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel_28.setBackground(new Color(255, 204, 0));
        panel_28.setBounds(0, 0, 734, 135);
        graduation_date_jpanel.add(panel_28);
        panel_28.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_8 = new JLabel("Graduation Date");
        lblNewLabel_8.setForeground(new Color(204, 0, 0));
        lblNewLabel_8.setFont(new Font("Vivaldi", Font.BOLD, 52));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        panel_28.add(lblNewLabel_8, BorderLayout.CENTER);

        txtThisWillDisplay = new JTextField();
        txtThisWillDisplay.setText("THis will display the graduation date");
        txtThisWillDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        txtThisWillDisplay.setColumns(10);
        txtThisWillDisplay.setBounds(59, 171, 607, 192);
        graduation_date_jpanel.add(txtThisWillDisplay);

        JButton button_1 = new JButton("Back");

        button_1.setBounds(321, 394, 89, 23);
        graduation_date_jpanel.add(button_1);

        JPanel result_plan_jpanel = new JPanel();
        result_plan_jpanel.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel.add(result_plan_jpanel, "name_3158997082800");
        result_plan_jpanel.setLayout(null);

        JPanel panel_21 = new JPanel();
        panel_21.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel_21.setBackground(new Color(255, 204, 0));
        panel_21.setBounds(0, 0, 734, 135);
        result_plan_jpanel.add(panel_21);
        panel_21.setLayout(new BorderLayout(0, 0));

        JLabel lblYourPlan = new JLabel("Your Plan");
        lblYourPlan.setForeground(new Color(204, 0, 0));
        lblYourPlan.setFont(new Font("Vivaldi", Font.BOLD, 52));
        lblYourPlan.setHorizontalAlignment(SwingConstants.CENTER);
        panel_21.add(lblYourPlan, BorderLayout.CENTER);

        JButton btnBack_3 = new JButton("Back");
        btnBack_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(main_jpanel);
                panel.repaint();
                panel.revalidate();
            }
        });
        btnBack_3.setBounds(595, 499, 89, 29);
        result_plan_jpanel.add(btnBack_3);

        JButton btnForward = new JButton("");
        btnForward.setToolTipText("View the next year plan");
        btnForward.setIcon(forward_icon);
        btnForward.setBounds(366, 499, 89, 29);
        result_plan_jpanel.add(btnForward);

        JButton btnBackward = new JButton("");
        btnBackward.setToolTipText("View the previous year plan");
        btnBackward.setIcon(backward_icon);
        btnBackward.setBounds(263, 499, 89, 29);
        result_plan_jpanel.add(btnBackward);
        
		//abc10
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 146, 714, 346);
		result_plan_jpanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPlanYear = new JLabel("Year (int)");
		lblPlanYear.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlanYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanYear.setBounds(311, 0, 92, 24);
		panel_2.add(lblPlanYear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 28, 714, 318);
		panel_2.add(scrollPane);
		
		//abc104 deleted
		
		
		JTextArea textAreaShowPlan = new JTextArea();						//text from Kiet		
///////////////////////////////////////////////////////////////////		/////////////////
/*
		for(int i = 0; i < number_of_years; i++)
		{
			JScrollPane scrollPane = new JScrollPane();	//create jscroll for each year
			scrollPane.setBounds(32, 158, 671, 317);
			scrollpanelVec.add(i, scrollPane);			//add to the vector in order to access easily 
		}
		
	
         */
        //	panel_20.add(scrollpanelVec.elementAt(0));	//add the year jscroll to the result panel

////////////////////////////////////////////////////////////////////////////////////////		
        JLabel lblSemester = new JLabel("Semester");
        lblSemester.setHorizontalAlignment(SwingConstants.CENTER);
        lblSemester.setBounds(456, 391, 89, 23);
        class_planner_jpanel.add(lblSemester);

        JPanel panel_25 = new JPanel();
        panel_25.setBorder(new LineBorder(new Color(0, 102, 0), 2));
        panel_25.setBackground(new Color(255, 204, 0));
        panel_25.setBounds(0, 0, 734, 135);
        class_planner_jpanel.add(panel_25);
        panel_25.setLayout(new BorderLayout(0, 0));

        JLabel lblClassPlanner_2 = new JLabel("Class Planner");
        lblClassPlanner_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblClassPlanner_2.setForeground(new Color(204, 0, 0));
        lblClassPlanner_2.setFont(new Font("Vivaldi", Font.BOLD, 52));
        panel_25.add(lblClassPlanner_2, BorderLayout.CENTER);

		//abc10
		JButton btnUpCourseAdd = new JButton("Add");
		btnUpCourseAdd.setToolTipText("Add your untaken class to database.");
		btnUpCourseAdd.setBounds(307, 493, 89, 23);
		class_planner_jpanel.add(btnUpCourseAdd);

        JButton button_4 = new JButton("Back");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(main_jpanel);
                panel.repaint();
                panel.revalidate();
            }
        });
        button_4.setBounds(63, 493, 89, 23);
        class_planner_jpanel.add(button_4);

        //abc10
        JButton button_5 = new JButton("Here Your Plan");
        button_5.setBounds(527, 493, 147, 23);
        class_planner_jpanel.add(button_5);

        JLabel lblYear = new JLabel("Year");
        lblYear.setHorizontalAlignment(SwingConstants.CENTER);
        lblYear.setBounds(585, 391, 89, 23);
        class_planner_jpanel.add(lblYear);

        JComboBox comboBoxNewCourses = new JComboBox();
        comboBoxNewCourses.setBounds(63, 425, 373, 20);
        class_planner_jpanel.add(comboBoxNewCourses);

        String[] listSemesters = {"", "Spring", "Summer", "Fall", "Winter"};
        JComboBox comboBoxSemester = new JComboBox(listSemesters);
        comboBoxSemester.setBounds(456, 425, 89, 20);
        //JComboBoxDecorator.decorate(comboBoxSemester, true); 
        class_planner_jpanel.add(comboBoxSemester);

        String[] listYears = {"", "2020", "2021", "2022", "2023", "2024"};
        JComboBox comboBoxYear = new JComboBox(listYears);
        comboBoxYear.setBounds(585, 425, 90, 20);
        //JComboBoxDecorator.decorate(comboBoxYear, true); 
        class_planner_jpanel.add(comboBoxYear);

        JLabel lblPrerequisiteCourses = new JLabel("This course has no prerequisites!");
        //lblPrerequisiteCourses.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrerequisiteCourses.setBounds(63, 456, 373, 20);
        class_planner_jpanel.add(lblPrerequisiteCourses);

        JLabel lblClassesThatYou = new JLabel("Classes that you want to take");
        lblClassesThatYou.setHorizontalAlignment(SwingConstants.CENTER);
        lblClassesThatYou.setBounds(63, 391, 373, 23);
        class_planner_jpanel.add(lblClassesThatYou);

        JScrollPane scrollPanelNewCourses = new JScrollPane();
        scrollPanelNewCourses.setBounds(63, 157, 611, 223);
        class_planner_jpanel.add(scrollPanelNewCourses);

        //abc10
        tableNewCourses = new JTable();
        scrollPanelNewCourses.setViewportView(tableNewCourses);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == mntmExit) //exit program
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
                if (source == mntmHome) {
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
                if (source == btnGo_1) {
                    panel.removeAll();
                    panel.add(gpa_jpanel);
                    panel.repaint();
                    panel.revalidate();
                }

            }
        });
        btnGo_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == btnGo_2) {
                    panel.removeAll();
                    panel.add(graduation_date_jpanel);
                    panel.repaint();
                    panel.revalidate();
                }
            }
        });
        btnGoToRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(register_jpanel);
                panel.repaint();
                panel.revalidate();
            }
        });
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(main_jpanel);
                panel.repaint();
                panel.revalidate();
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
                        passedGrades = userDAO.searchGradeUserPassed(userId);

                        double total_units = 0;
                        double total_score = 0;

                        for (int i = 0; i < passedCourses.size(); i++) {
                            String course = passedCourses.get(i);
                            String grade = passedGrades.get(i);
                            Course course_item = courses_map.get(course);
                            if (course_item == null) {
                                continue;
                            }
                            int units = course_item.getUnits();
                            total_units += units;
                            total_score += units * userDAO.getScoreFromGrade(grade);
                        }
                        double GPA = 0.0;
                        if (total_units == 0 || total_score == 0) {
                            GPA = 0;
                        } else {
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
	        //abc11
	        btnBackward.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	mYear--;
      				panel.removeAll();
      				panel.add(result_plan_jpanel);
      				
    				//table setting
      				Object tTable[][] = new Object[][] {
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null}
  					};  					
  					//push data
  					List<String> addedUpcomingCourses = null;	  					  						
  					lblPlanYear.setText(Integer.toString(mYear));
  					int[] coorX= {0,0,0,0};
  					try
  					{
  						addedUpcomingCourses = aCourseDAO.searchCoursesInSemester(userId, mYear);
  	                } catch (Exception exc) {
  	                    JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
  	                }				
  					for (String tempString : addedUpcomingCourses) {
  						String[] cells = tempString.split(" - ");	//cells[0] : course's name, cells[1]: semester
  						if (cells[1].compareTo("Spring")==0)
  						{
  							tTable[coorX[0]][0] = cells[0];
  							coorX[0]++;
  						}
  						if (cells[1].compareTo("Summer")==0)
  						{
  							tTable[coorX[1]][1] = cells[0];
  							coorX[1]++;
  						}  						
  						if (cells[1].compareTo("Fall")==0)
  						{
  							tTable[coorX[2]][2] = cells[0];
  							coorX[2]++;
  						} 
  						if (cells[1].compareTo("Winter")==0)
  						{
  							tTable[coorX[3]][3] = cells[0];
  							coorX[3]++;
  						} 
  											
  					}  					  					
      				String tSemester[] = new String[] {"Spring", "Summer", "Fall", "Winter"};
      				table = new JTable();
      				table.setModel(new DefaultTableModel(tTable,tSemester) 
      					{
          					Class[] columnTypes = new Class[] {
          						Object.class, String.class, String.class, Object.class
          					};
          					public Class getColumnClass(int columnIndex) {
          						return columnTypes[columnIndex];
          					}
          				});      			
      				table.getColumnModel().getColumn(0).setPreferredWidth(160);
      				table.getColumnModel().getColumn(1).setPreferredWidth(182);
      				table.getColumnModel().getColumn(2).setPreferredWidth(173);
      				table.getColumnModel().getColumn(3).setPreferredWidth(169);
      				scrollPane.setViewportView(table);    				    				

      				panel.repaint();
      				panel.revalidate();		            	
	            }
	        });       
	        btnForward.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		mYear++;
      				panel.removeAll();
      				panel.add(result_plan_jpanel);
      				
    				//table setting
      				Object tTable[][] = new Object[][] {
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null}
  					};  					
  					//push data
  					List<String> addedUpcomingCourses = null;	  					  						
  					lblPlanYear.setText(Integer.toString(mYear));
  					int[] coorX= {0,0,0,0};
  					try
  					{
  						addedUpcomingCourses = aCourseDAO.searchCoursesInSemester(userId, mYear);
  	                } catch (Exception exc) {
  	                    JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
  	                }				
  					for (String tempString : addedUpcomingCourses) {
  						String[] cells = tempString.split(" - ");	//cells[0] : course's name, cells[1]: semester
  						if (cells[1].compareTo("Spring")==0)
  						{
  							tTable[coorX[0]][0] = cells[0];
  							coorX[0]++;
  						}
  						if (cells[1].compareTo("Summer")==0)
  						{
  							tTable[coorX[1]][1] = cells[0];
  							coorX[1]++;
  						}  						
  						if (cells[1].compareTo("Fall")==0)
  						{
  							tTable[coorX[2]][2] = cells[0];
  							coorX[2]++;
  						} 
  						if (cells[1].compareTo("Winter")==0)
  						{
  							tTable[coorX[3]][3] = cells[0];
  							coorX[3]++;
  						} 
  											
  					}  					  					
      				String tSemester[] = new String[] {"Spring", "Summer", "Fall", "Winter"};
      				table = new JTable();
      				table.setModel(new DefaultTableModel(tTable,tSemester) 
      					{
          					Class[] columnTypes = new Class[] {
          						Object.class, String.class, String.class, Object.class
          					};
          					public Class getColumnClass(int columnIndex) {
          						return columnTypes[columnIndex];
          					}
          				});      			
      				table.getColumnModel().getColumn(0).setPreferredWidth(160);
      				table.getColumnModel().getColumn(1).setPreferredWidth(182);
      				table.getColumnModel().getColumn(2).setPreferredWidth(173);
      				table.getColumnModel().getColumn(3).setPreferredWidth(169);
      				scrollPane.setViewportView(table);    				    				

      				panel.repaint();
      				panel.revalidate();		        		
	        	}
	        });	        
        
      		//abc11
      		button_5.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {      				      			
      				panel.removeAll();
      				panel.add(result_plan_jpanel);
      				
    				//table setting
      				Object tTable[][] = new Object[][] {
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null},
  						{null, null, null, null}
  					};  					
  					//push data
  					List<String> addedUpcomingCourses = null;	  					  						
  					lblPlanYear.setText(Integer.toString(mYear));
  					int[] coorX= {0,0,0,0};
  					try
  					{
  						addedUpcomingCourses = aCourseDAO.searchCoursesInSemester(userId, mYear);
  	                } catch (Exception exc) {
  	                    JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
  	                }				
  					for (String tempString : addedUpcomingCourses) {
  						String[] cells = tempString.split(" - ");	//cells[0] : course's name, cells[1]: semester
  						if (cells[1].compareTo("Spring")==0)
  						{
  							tTable[coorX[0]][0] = cells[0];
  							coorX[0]++;
  						}
  						if (cells[1].compareTo("Summer")==0)
  						{
  							tTable[coorX[1]][1] = cells[0];
  							coorX[1]++;
  						}  						
  						if (cells[1].compareTo("Fall")==0)
  						{
  							tTable[coorX[2]][2] = cells[0];
  							coorX[2]++;
  						} 
  						if (cells[1].compareTo("Winter")==0)
  						{
  							tTable[coorX[3]][3] = cells[0];
  							coorX[3]++;
  						} 
  											
  					}  					  					
      				String tSemester[] = new String[] {"Spring", "Summer", "Fall", "Winter"};
      				table = new JTable();
      				table.setModel(new DefaultTableModel(tTable,tSemester) 
      					{
          					Class[] columnTypes = new Class[] {
          						Object.class, String.class, String.class, Object.class
          					};
          					public Class getColumnClass(int columnIndex) {
          						return columnTypes[columnIndex];
          					}
          				});      			
      				table.getColumnModel().getColumn(0).setPreferredWidth(160);
      				table.getColumnModel().getColumn(1).setPreferredWidth(182);
      				table.getColumnModel().getColumn(2).setPreferredWidth(173);
      				table.getColumnModel().getColumn(3).setPreferredWidth(169);
      				scrollPane.setViewportView(table);    				    				

      				panel.repaint();
      				panel.revalidate();	
//      				
      				
      			}
      		});
      		//abc10
      		btnUpCourseAdd.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
      				//abc101
      				String sCurrentItem = comboBoxNewCourses.getSelectedItem().toString();
      				String sSemester = comboBoxSemester.getSelectedItem().toString();
      				String sYear = comboBoxYear.getSelectedItem().toString();
      				
      				///String[] aCnum = sCurrentItem.split(" - ");
      				int currentIndex = comboBoxNewCourses .getSelectedIndex();
      				lblPrerequisiteCourses.setText(""); //do later	
      				if (sCurrentItem == "" || sSemester == "" || sYear == "") {
      					JOptionPane.showMessageDialog(MyFrame1.this,  "Course, Semester, or Year cannot be blank!", "Error", JOptionPane.ERROR_MESSAGE);
      				}
      				else {					
      					try {
      						
      						aCourseDAO.addUpcomingCourseToUser(userId, sCurrentItem, sSemester, Integer.parseInt(sYear)); 			
      						// show success message
      						JOptionPane.showMessageDialog(MyFrame1.this,
      								"Course added succesfully.",
      								"Course Added",
      								JOptionPane.INFORMATION_MESSAGE);
      						
      						//Refresh courses
//      						comboBoxNewCourses.removeAllItems();
//      						List<String> passedCourses = null;
//      						passedCourses = userDAO.searchCoursesUserPassed(userId);					
//      						comboBoxNewCourses.addItem("");
//      						for (Course tempCourse : courses) {
//      							if (passedCourses.contains(tempCourse.getCno())) {
//      								comboBoxNewCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle() + " >> (Passed)");
//      								
//      							}
//      							else
//      							{
//      								comboBoxNewCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle());
//      							}
//      						}						
      						if (courses == null)	//Don't load any course into the list so far
      							courses = aCourseDAO.getAllCourses();					
      						List<String> passedCourses = null;
      						List<String> addedUpcomingCourses = null;
      						passedCourses = userDAO.searchCoursesUserPassed(userId);
      						addedUpcomingCourses = aCourseDAO.searchCoursesUserAdded(userId);
      						comboBoxNewCourses.removeAllItems();
      						comboBoxNewCourses.addItem("");
      						for (Course tempCourse : courses) {
      							if (passedCourses.contains(tempCourse.getCno())|| addedUpcomingCourses.contains(tempCourse.getCno())) {
      								// dont' do any thing or add with notice "passed"
      								//comboBoxNewCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle() + " >> (Passed)");								
      							}
      							else
      							{
      								comboBoxNewCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle());
      							}
      						}
      						
      						//abc103
      						//RELOAD TABLE
      						try {
      							upcourses = aCourseDAO.getAllUpcomingCourses(userId);
      						} catch (Exception exc) {					
      							JOptionPane.showMessageDialog(MyFrame1.this,  "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
      						}					
      						NewCoursesTableModel newCoursesModel = new NewCoursesTableModel(upcourses);
      						tableNewCourses.setModel(newCoursesModel);
      						// set columns widths
      						TableColumnModel tcm = tableNewCourses.getColumnModel();
      					      tcm.getColumn(0).setPreferredWidth(400);  
      					      tcm.getColumn(1).setPreferredWidth(30);  
      					      tcm.getColumn(2).setPreferredWidth(30);  
      						
      						//SET DEFAULT comboBoxes						
      						comboBoxNewCourses.setSelectedIndex(0);
      						comboBoxSemester.setSelectedIndex(0);
      						comboBoxYear.setSelectedIndex(0);
      						//JComboBoxDecorator.decorate(comboBoxCourses, true); //update list 
      						
      						
      						
      						//comboBoxCourses.removeItemAt(currentIndex);
      						//comboBoxCourses.insertItemAt(sCurrentItem + " >> (Passed)", currentIndex);

      						
      						panel.repaint();
      						panel.revalidate();
      						
      					}
      					catch (Exception exc) {
      						JOptionPane.showMessageDialog(MyFrame1.this,  "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
      					}
      				}				
      			}
      		});

        //===============actionPerformed=============each panel has 1 Actionperformed=====================
        btnGo_4.addActionListener(new ActionListener() {		/////////////////////////////=======================
            public void actionPerformed(ActionEvent e) {//abc2
                Object source = e.getSource();
                if (source == btnGo_4) {
                    panel.removeAll();
                    panel.add(class_planner_jpanel);

                    // create the DAO
                    try {
                        aCourseDAO = new CourseDAO();
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        //List<Course> courses = null; //already declared public
                        if (courses == null) //Don't load any course into the list so far
                        {
                            courses = aCourseDAO.getAllCourses();
                        }
                        List<String> passedCourses = null;
						List<String> addedUpcomingCourses = null;	//abc10
						addedUpcomingCourses = aCourseDAO.searchCoursesUserAdded(userId);//abc10
						
                        passedCourses = userDAO.searchCoursesUserPassed(userId);
                        comboBoxNewCourses.removeAllItems();
                        comboBoxNewCourses.addItem("");
                        for (Course tempCourse : courses) {
                        	if (passedCourses.contains(tempCourse.getCno()) || addedUpcomingCourses.contains(tempCourse.getCno())) {
                                // dont' do any thing or add with notice "passed"
                                //comboBoxNewCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle() + " >> (Passed)");								
                            } else {
                                comboBoxNewCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle());
                            }
                        }

                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    //JComboBoxDecorator.decorate(comboBoxNewCourses, true); 					

                    //create the model and update the "table" => change to NewCourses table later

					//abc103					
					try {
						upcourses = aCourseDAO.getAllUpcomingCourses(userId);
					} catch (Exception exc) {					
						JOptionPane.showMessageDialog(MyFrame1.this,  "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
					}					
					NewCoursesTableModel newCoursesModel = new NewCoursesTableModel(upcourses);
					tableNewCourses.setModel(newCoursesModel);
					//abc10 set columns widths
					TableColumnModel tcm = tableNewCourses.getColumnModel();
				      tcm.getColumn(0).setPreferredWidth(400);  
				      tcm.getColumn(1).setPreferredWidth(30);  
				      tcm.getColumn(2).setPreferredWidth(30);  

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
                    JOptionPane.showMessageDialog(MyFrame1.this, "Course or Grade cannot be blank!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
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

                            } else {
                                comboBoxCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle());
                            }
                        }
                        comboBoxGrade.setSelectedIndex(0);
                        //JComboBoxDecorator.decorate(comboBoxCourses, true); //update list 

                        //comboBoxCourses.removeItemAt(currentIndex);
                        //comboBoxCourses.insertItemAt(sCurrentItem + " >> (Passed)", currentIndex);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
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
                panel.add(input_class_jpanel);
//abc1							
                //CourseDAO aCourseDAO = null;
                // create the DAO
                try {
                    aCourseDAO = new CourseDAO();
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    //List<Course> courses = null;
                    if (courses == null) {
                        courses = aCourseDAO.getAllCourses();
                    }
                    List<String> passedCourses = null;
                    passedCourses = userDAO.searchCoursesUserPassed(userId);
                    comboBoxCourses.removeAllItems();
                    comboBoxCourses.addItem("");
                    for (Course tempCourse : courses) {
                        if (passedCourses.contains(tempCourse.getCno())) {
                            comboBoxCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle() + " >> (Passed)");

                        } else {
                            comboBoxCourses.addItem(tempCourse.getCno() + " - " + tempCourse.getCtitle());
                        }
                    }

                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(MyFrame1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
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
                String answer = userAnswer.getText();

                int questionID = 0;
                Question question_item = (Question) comboBoxQuestions.getSelectedItem();
                if (question_item != null) {
                    questionID = question_item.getId();
                }
                //check username
                List<User> users = null;
                if (username != null && username.trim().length() > 0) {
                    try {
                        users = userDAO.searchUsers(username);
                        if (!users.isEmpty()) {
                            JOptionPane.showMessageDialog(MyFrame1.this, "This username was used by other people.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(MyFrame1.this, "Please input username", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //check email
                //check password				
                if (password == null || !password.equals(repassword)) {
                    JOptionPane.showMessageDialog(MyFrame1.this, "The two passwords didn't match or empty", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (question_item != null) {
                        if (answer == null || answer.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(MyFrame1.this, "Please answer security question !", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    User tempUser = new User(firstname, lastname, major, email, username, password, questionID, answer);

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
        btnLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String username = usernameTextField.getText();
                String password = passwordTextField.getText();
                List<User> users = null;

                if (username != null && username.trim().length() > 0) {
                    try {
                        users = userDAO.searchUsers(username);
                        //if exists + same password, go to panel_4, else > wrong password or username does not exist
                        if (users.isEmpty() || !users.get(0).getPassword().contentEquals(password)) {
                            if (users.isEmpty()) {
                                JOptionPane.showMessageDialog(MyFrame1.this, "Wrong username.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            } else if (!users.get(0).getPassword().contentEquals(password)) {
                                JOptionPane.showMessageDialog(MyFrame1.this, "Wrong password.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            } else {
                                JOptionPane.showMessageDialog(MyFrame1.this, "Wrong username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                        } else {
                            panel.removeAll();
                            panel.add(main_jpanel);
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
        btnForgotPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                List<User> users = null;

                if (username != null && username.trim().length() > 0) {
                    try {
                        users = userDAO.searchUsers(username);
                        //if exists + same password, go to panel_4, else > wrong password or username does not exist
                        if (users.isEmpty()) {
                            JOptionPane.showMessageDialog(MyFrame1.this, "Wrong username.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;

                        }
                        int questionID = users.get(0).getQuestionID();
                        String user_question = users.get(0).getQuestion();
                        if(user_question == null || user_question.trim().isEmpty()){
                            JOptionPane.showMessageDialog(MyFrame1.this, "You don't have security question !", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        String question = "";
                        if(questions == null || questions.isEmpty()){
                            JOptionPane.showMessageDialog(MyFrame1.this, "Fail to load security_questions !", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        for(Question item : questions){
                            if(questionID == item.getId()){
                                question = item.getQuestion();
                                break;
                            }
                        }
                        if(question == null || question.trim().isEmpty()){
                            JOptionPane.showMessageDialog(MyFrame1.this, "Can not find security question !", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        String answer = JOptionPane.showInputDialog(question);
                        if(answer == null || answer.trim().isEmpty()){
                            JOptionPane.showMessageDialog(MyFrame1.this, "Please answer to this question !", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if(answer.equalsIgnoreCase(user_question)){
                            JOptionPane.showMessageDialog(MyFrame1.this, "Your password is " + users.get(0).getPassword() + ".\nPlease login again !", "Success", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }else{
                            JOptionPane.showMessageDialog(MyFrame1.this, "Wrong answer !", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(MyFrame1.this, "Please input usrename !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
                
    }    
}
