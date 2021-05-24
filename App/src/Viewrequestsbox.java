
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Viewrequestsbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewrequestsbox frame = new Viewrequestsbox();
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
	public Viewrequestsbox() {
		setTitle("View requests");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Here will be desplayed the requests from all tenants:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 95, 404, 36);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 674, 318);
		contentPane.add(scrollPane);
		
		JTextArea requestsArea = new JTextArea();
		requestsArea.setForeground(new Color(211, 211, 211));
		requestsArea.setText("Here will be desplayed the requests...");
		scrollPane.setViewportView(requestsArea);
		
		JButton interventionButton = new JButton("Intervention");
		interventionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestsArea.setText("Intervention Requests");
			}
		});
		interventionButton.setBackground(new Color(176, 196, 222));
		interventionButton.setForeground(new Color(255, 255, 255));
		interventionButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		interventionButton.setBounds(112, 47, 115, 36);
		contentPane.add(interventionButton);
		
		JButton repairButton = new JButton("Repair");
		repairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestsArea.setText("Repair Requests:\n41; Baciu Andreea; 4; Repair; 12/05/21; Este nevoie de o reparatie la apartament 4 etaj 2");
			}
		});
		repairButton.setForeground(new Color(255, 255, 255));
		repairButton.setBackground(new Color(176, 196, 222));
		repairButton.setBounds(340, 48, 114, 36);
		contentPane.add(repairButton);
		
		JButton accountButton = new JButton("Account");
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestsArea.setText("Account Requests");
			}
		});
		accountButton.setForeground(new Color(255, 255, 255));
		accountButton.setBackground(new Color(176, 196, 222));
		accountButton.setBounds(547, 48, 114, 36);
		contentPane.add(accountButton);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ABAbox abaBox = new ABAbox();
				abaBox.setVisible(true);
			}
		});
		backButton.setBackground(new Color(255, 165, 0));
		backButton.setBounds(10, 11, 77, 23);
		contentPane.add(backButton);
	}

}
