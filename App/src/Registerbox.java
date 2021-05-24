
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Registerbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fname_textField;
	private JTextField lname_textField;
	private JTextField email_textField;
	private JPasswordField passwordField;
	private JPasswordField cpasswordField;
	private JTextField phtextField;
	private JTextField quetextField;
	private JTextField anstextField;

	// ******
	private List<Administrator> list_obj_administrator = new ArrayList<Administrator>();
   private List<Tenant> list_obj_tenant = new ArrayList<Tenant>();
   private List<Apartment> list_obj_apartment = new ArrayList<Apartment>();
   private List<AccountApproval> list_obj_approval = new ArrayList<AccountApproval>();
   private List<Contract> list_obj_contract = new ArrayList<Contract>();
   private List<Employee> list_obj_employee = new ArrayList<Employee>();
   private List<Invoice> list_obj_invoice = new ArrayList<Invoice>();
   private List<Payment> list_obj_payment = new ArrayList<Payment>();
   private List<Request> list_obj_request = new ArrayList<Request>();
   private List<WaterConsumption> list_obj_water = new ArrayList<WaterConsumption>();
   private List<Register>list_obj_register = new ArrayList<Register>();
   // ******
	
	// ******
	private int pk_id_register;
	private String l_first_name;
	private String l_last_name;
   private String l_phone_number;
   private String l_email;
   private String l_password;
   private String l_safety_question;
   private String l_safety_answer;
   private boolean l_is_approved;
   // ******
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registerbox frame = new Registerbox();
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
	public Registerbox() {
	   
	   DatabaseController obj_db = new DatabaseController(list_obj_administrator, list_obj_tenant,
	         list_obj_apartment, list_obj_approval, list_obj_contract, list_obj_employee,
	         list_obj_invoice, list_obj_payment, list_obj_request, list_obj_water, list_obj_register );
	   
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel registerLabel = new JLabel("Register your account");
		registerLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
		registerLabel.setBounds(247, 29, 195, 27);
		contentPane.add(registerLabel);
		
		JLabel fNameLabel = new JLabel("First name");
		fNameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		fNameLabel.setBounds(159, 85, 78, 25);
		contentPane.add(fNameLabel);
		
		fname_textField = new JTextField();
		fname_textField.setBounds(247, 83, 169, 27);
		contentPane.add(fname_textField);
		fname_textField.setColumns(10);
		
		JLabel lNameLabel = new JLabel("Last name");
		lNameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lNameLabel.setBounds(159, 128, 78, 25);
		contentPane.add(lNameLabel);
		
		lname_textField = new JTextField();
		lname_textField.setBounds(247, 129, 169, 27);
		contentPane.add(lname_textField);
		lname_textField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		emailLabel.setBounds(179, 172, 58, 25);
		contentPane.add(emailLabel);
		
		email_textField = new JTextField();
		email_textField.setBounds(247, 173, 169, 27);
		contentPane.add(email_textField);
		email_textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(247, 222, 169, 27);
		contentPane.add(passwordField);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		PasswordLabel.setBounds(159, 222, 78, 25);
		contentPane.add(PasswordLabel);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblConfirmPassword.setBounds(101, 262, 137, 25);
		contentPane.add(lblConfirmPassword);
		
		cpasswordField = new JPasswordField();
		cpasswordField.setBounds(247, 263, 169, 27);
		contentPane.add(cpasswordField);
		
		JLabel PhoneNumberLabel = new JLabel("Phone number");
		PhoneNumberLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		PhoneNumberLabel.setBounds(122, 314, 115, 24);
		contentPane.add(PhoneNumberLabel);
		
		phtextField = new JTextField();
		phtextField.setBounds(247, 314, 169, 27);
		contentPane.add(phtextField);
		phtextField.setColumns(10);
		
		JLabel intrebareLabel = new JLabel("Safety question");
		intrebareLabel.setForeground(new Color(60, 179, 113));
		intrebareLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		intrebareLabel.setBounds(122, 361, 115, 24);
		contentPane.add(intrebareLabel);
		
		JButton singUpButton = new JButton("SIGN UP");
		singUpButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(fname_textField.getText().equals("") || lname_textField.getText().equals("") || email_textField.getText().equals("") || passwordField.getText().equals("") || cpasswordField.getText().equals("") || phtextField.getText().equals("") || quetextField.getText().equals("") || anstextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}
				else {
					if(e.getSource()==singUpButton)
					{
					  try {
					     pk_id_register = 0;
					     l_first_name = fname_textField.getText();
					     l_last_name = lname_textField.getText();
					     l_phone_number = phtextField.getText();
					     l_email = email_textField.getText();
					     l_password = passwordField.getText();
					     l_safety_question = quetextField.getText();
					     l_safety_answer = anstextField.getText();
					     l_is_approved = false;
					     
					     Register temp_reg = new Register(pk_id_register,l_first_name,l_last_name,l_phone_number,l_email,
					           l_password,l_safety_question,l_safety_answer,l_is_approved);
					     obj_db.addDatabaseRegister(temp_reg);
					     
					  RegEx expr = new RegEx();
					  String passpattern = passwordField.getText();
					  String passmatcher = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
					  String pattern = email_textField.getText();
					  String matcher = "^(.+)@(.+)$";
					  if(expr.getRes(pattern,matcher) && expr.getRes(passpattern,passmatcher)){
						  JOptionPane.showMessageDialog(null, "Registration Complete");
						   setVisible(false);
							Loginbox window = new Loginbox();
							window.LoginFrame.setVisible(true);
					  }
					} catch(Exception arg0) {
						JOptionPane.showMessageDialog(null, "Invalid email or password");
					}
					}
					
				}
				
			}
		});
		singUpButton.setForeground(Color.WHITE);
		singUpButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		singUpButton.setBackground(new Color(30, 144, 255));
		singUpButton.setBounds(270, 456, 117, 32);
		contentPane.add(singUpButton);
		
		quetextField = new JTextField();
		quetextField.setBounds(245, 362, 171, 27);
		contentPane.add(quetextField);
		quetextField.setColumns(10);
		
		JLabel ansLabel = new JLabel("Answer");
		ansLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		ansLabel.setBounds(158, 406, 78, 25);
		contentPane.add(ansLabel);
		
		anstextField = new JTextField();
		anstextField.setBounds(247, 406, 171, 26);
		contentPane.add(anstextField);
		anstextField.setColumns(10);
	}

}

