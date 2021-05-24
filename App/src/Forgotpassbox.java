
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Forgotpassbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField npasswordField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgotpassbox frame = new Forgotpassbox();
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
	public Forgotpassbox() {
		setTitle("Forgot your password?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel questionLabel = new JLabel("Safety question");
		questionLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		questionLabel.setBounds(10, 27, 136, 25);
		contentPane.add(questionLabel);
		
		textField = new JTextField();
		textField.setBounds(149, 31, 422, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel ansLabel = new JLabel("Answer");
		ansLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ansLabel.setBounds(47, 84, 99, 25);
		contentPane.add(ansLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 83, 367, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton checkButton = new JButton("Check");
		checkButton.setBackground(new Color(102, 205, 170));
		checkButton.setForeground(Color.WHITE);
		checkButton.setBounds(528, 84, 77, 26);
		contentPane.add(checkButton);
		
		JLabel npassLabel = new JLabel("New password");
		npassLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		npassLabel.setBounds(34, 168, 136, 25);
		contentPane.add(npassLabel);
		
		JLabel cnpassLabel = new JLabel("Confirm new password");
		cnpassLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		cnpassLabel.setBounds(10, 217, 186, 25);
		contentPane.add(cnpassLabel);
		
		npasswordField = new JPasswordField();
		npasswordField.setBounds(206, 169, 158, 26);
		contentPane.add(npasswordField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 219, 156, 25);
		contentPane.add(passwordField);
		
		JButton changepassButton = new JButton("Change password");
		changepassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Password changed");
				setVisible(false);
				Loginbox window = new Loginbox();
				window.LoginFrame.setVisible(true);
			}
		});
		changepassButton.setBackground(new Color(102, 205, 170));
		changepassButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		changepassButton.setBounds(250, 283, 136, 23);
		contentPane.add(changepassButton);
	}
}
