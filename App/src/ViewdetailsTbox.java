
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewdetailsTbox extends JFrame {

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
					ViewdetailsTbox frame = new ViewdetailsTbox();
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
	public ViewdetailsTbox() {
		setTitle("View details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Tenantbox tenantBox = new Tenantbox();
				tenantBox.setVisible(true);
			}
		});
		backButton.setBackground(new Color(255, 165, 0));
		backButton.setBounds(10, 11, 77, 23);
		contentPane.add(backButton);
		
		JLabel viewLabel = new JLabel("Press view to view you account details");
		viewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		viewLabel.setBounds(28, 57, 268, 32);
		contentPane.add(viewLabel);
		
		JTextArea detailstextArea = new JTextArea();
		detailstextArea.setText("Here will be desplayed your details...");
		detailstextArea.setForeground(new Color(169, 169, 169));
		detailstextArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		detailstextArea.setBounds(27, 126, 633, 332);
		contentPane.add(detailstextArea);
		
		JButton viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailstextArea.setText("Username: Tuser\n Payments:\n 61; Sandu Viorel; 545; 19/01/21; 11");//modify
			}
		});
		viewButton.setForeground(Color.WHITE);
		viewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewButton.setBackground(new Color(176, 196, 222));
		viewButton.setBounds(338, 57, 119, 32);
		contentPane.add(viewButton);
		
		
	}
}
