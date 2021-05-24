
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tenantbox extends JFrame {

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
					Tenantbox frame = new Tenantbox();
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
	public Tenantbox() {
		setTitle("Tenant Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TenantrightsLabel = new JLabel("Tenant rights");
		TenantrightsLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		TenantrightsLabel.setForeground(Color.RED);
		TenantrightsLabel.setBounds(33, 11, 127, 37);
		contentPane.add(TenantrightsLabel);
		
		JLabel ToptionLabel = new JLabel("PLEASE CHOOSE AN OPTION:");
		ToptionLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		ToptionLabel.setBounds(33, 59, 304, 46);
		contentPane.add(ToptionLabel);
		
		JButton addInvoiceButton = new JButton("Add invoices");
		addInvoiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Invoicesbox invoicesBox = new Invoicesbox();
				invoicesBox.setVisible(true);
			}
		});
		addInvoiceButton.setBackground(new Color(135, 206, 235));
		addInvoiceButton.setFont(new Font("Tahoma", Font.ITALIC, 17));
		addInvoiceButton.setBounds(47, 137, 212, 47);
		contentPane.add(addInvoiceButton);
		
		JButton addWaterButton = new JButton("Add water consumption");
		addWaterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Waterbox waterBox = new Waterbox();
				waterBox.setVisible(true);
			}
		});
		addWaterButton.setFont(new Font("Tahoma", Font.ITALIC, 17));
		addWaterButton.setBackground(new Color(135, 206, 235));
		addWaterButton.setBounds(47, 242, 212, 47);
		contentPane.add(addWaterButton);
		
		JButton addReqButton = new JButton("Add new request");
		addReqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Addrequests addreqBox = new Addrequests();
				addreqBox.setVisible(true);
			}
		});
		addReqButton.setFont(new Font("Tahoma", Font.ITALIC, 17));
		addReqButton.setBackground(new Color(135, 206, 235));
		addReqButton.setBounds(47, 347, 212, 47);
		contentPane.add(addReqButton);
		
		JButton editAptButton = new JButton("Edit apartment");
		editAptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Apartmentbox apartmentBox = new Apartmentbox();
				apartmentBox.setVisible(true);
			}
		});
		editAptButton.setFont(new Font("Tahoma", Font.ITALIC, 17));
		editAptButton.setBackground(new Color(135, 206, 235));
		editAptButton.setBounds(393, 137, 212, 47);
		contentPane.add(editAptButton);
		
		JButton addPayButton = new JButton("Add payment");
		addPayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Addpaybox addpayBox = new Addpaybox();
				addpayBox.setVisible(true);
			}
		});
		addPayButton.setFont(new Font("Tahoma", Font.ITALIC, 17));
		addPayButton.setBackground(new Color(135, 206, 235));
		addPayButton.setBounds(393, 242, 212, 47);
		contentPane.add(addPayButton);
		
		JButton viewButton = new JButton("View details");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ViewdetailsTbox viewdTbox = new ViewdetailsTbox();
				viewdTbox.setVisible(true);
			}
		});
		viewButton.setFont(new Font("Tahoma", Font.ITALIC, 17));
		viewButton.setBackground(new Color(135, 206, 235));
		viewButton.setBounds(393, 347, 212, 47);
		contentPane.add(viewButton);
		
		JButton LogoutButton = new JButton("LOG OUT");
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Loginbox window = new Loginbox();
				window.LoginFrame.setVisible(true);
			}
		});
		LogoutButton.setBackground(new Color(135, 206, 235));
		LogoutButton.setForeground(Color.WHITE);
		LogoutButton.setBounds(280, 424, 100, 34);
		contentPane.add(LogoutButton);
	}
}
