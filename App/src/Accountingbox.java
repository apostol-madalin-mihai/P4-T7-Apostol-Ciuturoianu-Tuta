
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accountingbox extends JFrame {

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
					Accountingbox frame = new Accountingbox();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Accountingbox() {
		setTitle("Accounting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox monthcomboBox = new JComboBox();
		monthcomboBox.setBounds(484, 59, 102, 20);
		monthcomboBox.setMaximumRowCount(12);
		monthcomboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March ", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		contentPane.add(monthcomboBox);
		
		JLabel detailsLabel = new JLabel("Please, select the month for which you want to see the details:");
		detailsLabel.setBounds(10, 55, 487, 25);
		detailsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(detailsLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 672, 251);
		contentPane.add(scrollPane);
		
		JTextArea detailsArea = new JTextArea();
		scrollPane.setViewportView(detailsArea);
		detailsArea.setForeground(new Color(204, 204, 204));
		detailsArea.setText("Here will be displayed the details...");
		
		JButton generateButton = new JButton("Generate");
		generateButton.setBounds(164, 97, 102, 25);
		
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailsArea.setText("Income/Expense Report");
			}
		});
		generateButton.setForeground(new Color(255, 255, 255));
		generateButton.setBackground(new Color(204, 0, 0));
		generateButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(generateButton);
		
		JButton amountButton = new JButton("Amount Receivable");
		amountButton.setBounds(10, 200, 155, 34);
		amountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailsArea.setText("Amount Receivable");
			}
		});
		contentPane.add(amountButton);
		
		JButton debtButton = new JButton("Debt(for every apartment)");
		debtButton.setBounds(246, 200, 183, 34);
		debtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailsArea.setText("Debt");
			}
		});
		debtButton.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(debtButton);
		
		JButton outpayButton = new JButton("Outstanding payments");
		outpayButton.setBounds(510, 200, 162, 34);
		outpayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailsArea.setText("Outstanding payments");
			}
		});
		outpayButton.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(outpayButton);
		
		JLabel ieLabel = new JLabel("Income/Expense Report");
		ieLabel.setBounds(10, 102, 144, 14);
		ieLabel.setForeground(new Color(220, 20, 60));
		ieLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(ieLabel);
		
		JLabel payLabel = new JLabel("Payments details:");
		payLabel.setBounds(10, 152, 174, 24);
		payLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(payLabel);
		
		JButton backButton = new JButton("BACK");
		backButton.setBounds(10, 11, 76, 23);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ABAbox abaBox = new ABAbox();
				abaBox.setVisible(true);;
			}
		});
		backButton.setBackground(new Color(255, 165, 0));
		backButton.setForeground(new Color(0, 0, 0));
		contentPane.add(backButton);
		
	}
}
