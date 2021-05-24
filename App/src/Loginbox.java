import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class Loginbox {

	public JFrame LoginFrame;
	private JTextField Username_textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginbox window = new Loginbox();
					window.LoginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginbox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LoginFrame = new JFrame();
		LoginFrame.getContentPane().setForeground(SystemColor.inactiveCaption);
		LoginFrame.getContentPane().setBackground(SystemColor.menu);
		LoginFrame.setBackground(SystemColor.window);
		LoginFrame.setTitle("Log in");
		LoginFrame.setBounds(100, 100, 710, 508);
		LoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		LoginFrame.getContentPane().setLayout(null);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		UsernameLabel.setBounds(194, 151, 70, 32);
		LoginFrame.getContentPane().add(UsernameLabel);
		
		Username_textField = new JTextField();
		Username_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Username_textField.setBounds(274, 157, 241, 32);
		LoginFrame.getContentPane().add(Username_textField);
		Username_textField.setColumns(10);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PasswordLabel.setBounds(194, 212, 70, 14);
		LoginFrame.getContentPane().add(PasswordLabel);
		
		JButton LoginButton = new JButton("LOG IN");
		LoginButton.setForeground(Color.WHITE);
		LoginButton.setBackground(new Color(30, 144, 255));
		LoginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		//BEGIN ACTION ON LOG IN BUTTON
		
		LoginButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Username_textField.getText().equals("") || passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}
				else {
					if(e.getSource()==LoginButton)
					{
					  try {
					  String Abauser = Username_textField.getText();
					  String Tuser = Username_textField.getText();
					  RegEx expr = new RegEx();
					  String passpattern = passwordField.getText();
					  String passmatcher = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
					  if(expr.getRes(passpattern,passmatcher)){
						  JOptionPane.showMessageDialog(LoginFrame, "You are sucessfully logged in");
						  if(Abauser.equals("Auser")) {
							  	//ABA Window
							  
							    ABAbox abaBox = new ABAbox();
								abaBox.setVisible(true);
								LoginFrame.setVisible(false);
						  }else if(Tuser.equals("Tuser")) {
							  	//Tenant Window
								
								Tenantbox tenantbox = new Tenantbox();
								tenantbox.setVisible(true);
								LoginFrame.setVisible(false);
						  }
						   
					  }
					}catch(Exception arg0)
					{
						JOptionPane.showMessageDialog(null, "Invalid password");
					}
					}
				
			}
			}
		}); 
		
		
		LoginButton.setBounds(285, 298, 117, 32);
		LoginFrame.getContentPane().add(LoginButton);
		
		JLabel WelcomeLabel = new JLabel(" Welcome!");
		WelcomeLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
		WelcomeLabel.setBounds(286, 39, 89, 23);
		LoginFrame.getContentPane().add(WelcomeLabel);
		
		JLabel lblNewLabel = new JLabel("Please log in to access the ACT application.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(193, 95, 322, 31);
		LoginFrame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(274, 206, 241, 31);
		LoginFrame.getContentPane().add(passwordField);
		
		JLabel signUpLabel = new JLabel("Need an account?");
		signUpLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		signUpLabel.setBounds(228, 365, 117, 20);
		LoginFrame.getContentPane().add(signUpLabel);
		
		JButton signUpButton = new JButton("Sign up");
		signUpButton.setBackground(new Color(230, 230, 250));
		signUpButton.setForeground(new Color(65, 105, 225));
		
		//BEGIN ACTION ON SIGN UP BUTTON
		
		signUpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Registerbox registerBox = new Registerbox();
				registerBox.setVisible(true);
				LoginFrame.setVisible(false);
				
			}
		});
		
		signUpButton.setBounds(346, 366, 89, 23);
		LoginFrame.getContentPane().add(signUpButton);
		
		JButton fpassButton = new JButton("Forgot password?");
		fpassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame.setVisible(false);
				Forgotpassbox fpassBox = new Forgotpassbox();
				fpassBox.setVisible(true);
			}
		});
		fpassButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fpassButton.setHorizontalAlignment(SwingConstants.LEFT);
		fpassButton.setForeground(new Color(0, 191, 255));
		fpassButton.setBackground(new Color(245, 245, 245));
		fpassButton.setBounds(274, 248, 117, 14);
		LoginFrame.getContentPane().add(fpassButton);
	}
}
