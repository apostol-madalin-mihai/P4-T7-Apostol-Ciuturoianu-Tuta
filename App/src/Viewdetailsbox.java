
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

public class Viewdetailsbox extends JFrame {

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
					Viewdetailsbox frame = new Viewdetailsbox();
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
	public Viewdetailsbox() {
		setTitle("View details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 103, 635, 334);
		contentPane.add(scrollPane);
		
		JLabel viewLabel = new JLabel("Press view to view you account details");
		viewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		viewLabel.setBounds(27, 45, 268, 32);
		contentPane.add(viewLabel);
		
		JTextArea detailstextArea = new JTextArea();
		scrollPane.setViewportView(detailstextArea);
		detailstextArea.setForeground(new Color(169, 169, 169));
		detailstextArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		detailstextArea.setText("Here will be desplayed your details...");
		
		JButton viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				detailstextArea.setText("Your Username: Auser\nTenant Username:\n1.Tuser");//modify
			}
		});
		viewButton.setBackground(new Color(176, 196, 222));
		viewButton.setForeground(Color.WHITE);
		viewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewButton.setBounds(338, 45, 119, 32);
		contentPane.add(viewButton);
		
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
