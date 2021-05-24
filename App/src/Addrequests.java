
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Addrequests extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField natextField;
	private JTextField aptextField;
	private JTextField bdtextField;
	private String comboString;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addrequests frame = new Addrequests();
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
	public Addrequests() {
		setTitle("Add requests");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 734, 469);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane tabscrollPane = new JScrollPane();
		tabscrollPane.setBounds(257, 47, 467, 411);
		panel.add(tabscrollPane);
		
		JScrollPane detscrollPane = new JScrollPane();
		detscrollPane.setBounds(78, 268, 155, 124);
		panel.add(detscrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Repair", "Intervention"}));
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(78, 206, 87, 20);
		panel.add(comboBox);
		
		JTextArea detailsArea = new JTextArea();
		detscrollPane.setViewportView(detailsArea);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				idtextField.setText(model.getValueAt(i, 0).toString());
				natextField.setText(model.getValueAt(i, 1).toString());
				aptextField.setText(model.getValueAt(i, 2).toString());
				comboBox.setToolTipText(model.getValueAt(i, 3).toString());
				bdtextField.setText(model.getValueAt(i, 4).toString());
				detailsArea.setText(model.getValueAt(i, 5).toString());
			}
		});
		
		//Requests table
		
				model = new DefaultTableModel();
				Object[] collumn = {"ID", "Name", "Apartament", "Type", "Date", "Details"};
				Object[] row = new Object[6];
				model.setColumnIdentifiers(collumn);
				table.setModel(model);
		table.setBackground(new Color(240, 248, 255));
		tabscrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Create new request");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(10, 66, 155, 32);
		panel.add(label);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Tenantbox tenantBox = new Tenantbox();
				tenantBox.setVisible(true);
			}
		});
		backButton.setBackground(new Color(255, 165, 0));
		backButton.setBounds(10, 11, 79, 23);
		panel.add(backButton);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		idLabel.setBounds(34, 109, 25, 21);
		panel.add(idLabel);
		
		idtextField = new JTextField();
		idtextField.setColumns(10);
		idtextField.setBounds(78, 110, 43, 20);
		panel.add(idtextField);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(19, 140, 49, 21);
		panel.add(lblName);
		
		natextField = new JTextField();
		natextField.setColumns(10);
		natextField.setBounds(78, 141, 155, 20);
		panel.add(natextField);
		
		JLabel apLabel = new JLabel("Apartment");
		apLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		apLabel.setBounds(10, 173, 79, 21);
		panel.add(apLabel);
		
		aptextField = new JTextField();
		aptextField.setColumns(10);
		aptextField.setBounds(78, 173, 86, 20);
		panel.add(aptextField);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblType.setBounds(19, 205, 49, 21);
		panel.add(lblType);
		
		JLabel lblBeginDate = new JLabel("Date");
		lblBeginDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBeginDate.setBounds(19, 236, 43, 21);
		panel.add(lblBeginDate);
		
		bdtextField = new JTextField();
		bdtextField.setColumns(10);
		bdtextField.setBounds(78, 237, 86, 20);
		panel.add(bdtextField);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDetails.setBounds(19, 269, 58, 21);
		panel.add(lblDetails);
		
		JButton addButton = new JButton("ADD");
		
		//BEGIN INSERT BUTTON ACTION
		
		comboString = "";
		
	    addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(idtextField.getText().equals("") || natextField.getText().equals("") ||aptextField.getText().equals("") || comboBox.equals(comboString) || bdtextField.getText().equals("") || detailsArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}else {
						row[0] = idtextField.getText();
						row[1] = natextField.getText();
						row[2] = aptextField.getText();
						row[3] = comboBox.getSelectedItem();
						row[4] = bdtextField.getText();
						row[5] = detailsArea.getText();
						model.addRow(row);
									
						//start new row with data cleared
						idtextField.setText("");
						natextField.setText("");
						aptextField.setText("");
						comboBox.setToolTipText("");
						bdtextField.setText("");
						detailsArea.setText("");
						JOptionPane.showMessageDialog(null, "Saved Successfully");
				}
			}
		});
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		addButton.setBackground(new Color(100, 149, 237));
		addButton.setBounds(64, 419, 79, 32);
		panel.add(addButton);
		
	}
}
