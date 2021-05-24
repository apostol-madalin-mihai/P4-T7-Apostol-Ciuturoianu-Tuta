
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Addpaybox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField uitextField;
	private JTextField tntextField;
	private JTextField amtextField;
	private JTextField bdtextField;
	private JTextField aptextField;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addpaybox frame = new Addpaybox();
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
	public Addpaybox() {
		setTitle("Add payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(0, 0, 694, 469);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 56, 396, 402);
		panel.add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				uitextField.setText(model.getValueAt(i, 0).toString());
				tntextField.setText(model.getValueAt(i, 1).toString());
				amtextField.setText(model.getValueAt(i, 2).toString());
				bdtextField.setText(model.getValueAt(i, 3).toString());
				aptextField.setText(model.getValueAt(i, 4).toString());
			}
		});
		
		//Payments table
		
		model = new DefaultTableModel();
		Object[] collumn = {"Utility ID", "Titular name", "Amount", "Date", "Apartment"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(collumn);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Tenantbox tenantBox = new Tenantbox();
				tenantBox.setVisible(true);
			}
		});
		backButton.setBackground(new Color(255, 165, 0));
		backButton.setForeground(new Color(0, 0, 0));
		backButton.setBounds(10, 11, 79, 23);
		panel.add(backButton);
		
		JLabel lblUtilityId = new JLabel("Utility ID");
		lblUtilityId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUtilityId.setBounds(39, 104, 79, 21);
		panel.add(lblUtilityId);
		
		uitextField = new JTextField();
		uitextField.setColumns(10);
		uitextField.setBounds(107, 105, 86, 20);
		panel.add(uitextField);
		
		JLabel lblTitularName = new JLabel("Titular Name");
		lblTitularName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTitularName.setBounds(18, 135, 79, 21);
		panel.add(lblTitularName);
		
		tntextField = new JTextField();
		tntextField.setColumns(10);
		tntextField.setBounds(107, 136, 155, 20);
		panel.add(tntextField);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmount.setBounds(39, 168, 79, 21);
		panel.add(lblAmount);
		
		amtextField = new JTextField();
		amtextField.setColumns(10);
		amtextField.setBounds(107, 168, 86, 20);
		panel.add(amtextField);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(39, 200, 79, 21);
		panel.add(lblDate);
		
		bdtextField = new JTextField();
		bdtextField.setColumns(10);
		bdtextField.setBounds(107, 201, 86, 20);
		panel.add(bdtextField);
		
		JLabel lblApartment = new JLabel("Apartment");
		lblApartment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApartment.setBounds(18, 234, 79, 21);
		panel.add(lblApartment);
		
		aptextField = new JTextField();
		aptextField.setColumns(10);
		aptextField.setBounds(107, 235, 86, 20);
		panel.add(aptextField);
		
		JButton addpayButton = new JButton(" ADD PAYMENT");
		
		//BEGIN ADD PAYMENT BUTTON ACTION
		
				
		addpayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(uitextField.getText().equals("") || tntextField.getText().equals("") ||amtextField.getText().equals("") || bdtextField.getText().equals("") || aptextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}else {
						row[0] = uitextField.getText();
						row[1] = tntextField.getText();
						row[2] = amtextField.getText();
						row[3] = bdtextField.getText();
						row[4] = aptextField.getText();
						model.addRow(row);
											
						//start new row with data cleared
						uitextField.setText("");
						tntextField.setText("");
						amtextField.setText("");
						bdtextField.setText("");
						aptextField.setText("");
						JOptionPane.showMessageDialog(null, "Saved Successfully");
				}
			}
		});
		
		addpayButton.setForeground(Color.WHITE);
		addpayButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		addpayButton.setBackground(new Color(100, 149, 237));
		addpayButton.setBounds(77, 358, 140, 32);
		panel.add(addpayButton);
	}
}
