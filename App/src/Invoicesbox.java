
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Invoicesbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField titextField;
	private JTextField aptextField;
	private JTextField cotextField;
	DefaultTableModel model;
	private JTable table;
	private JTextField ditextField;
	private JTextField ddtextField;
	private JTextField amtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoicesbox frame = new Invoicesbox();
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
	public Invoicesbox() {
		setTitle("Add Invoices");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 848, 502);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		idLabel.setBounds(78, 74, 25, 21);
		panel.add(idLabel);
		
		idtextField = new JTextField();
		idtextField.setColumns(10);
		idtextField.setBounds(122, 75, 86, 20);
		panel.add(idtextField);
		
		JLabel lblTitular = new JLabel("Titular");
		lblTitular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTitular.setBounds(54, 106, 79, 21);
		panel.add(lblTitular);
		
		titextField = new JTextField();
		titextField.setColumns(10);
		titextField.setBounds(122, 106, 155, 20);
		panel.add(titextField);
		
		JLabel lblApartment = new JLabel("Apartment");
		lblApartment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApartment.setBounds(54, 138, 79, 21);
		panel.add(lblApartment);
		
		aptextField = new JTextField();
		aptextField.setColumns(10);
		aptextField.setBounds(122, 138, 86, 20);
		panel.add(aptextField);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCompany.setBounds(54, 170, 79, 21);
		panel.add(lblCompany);
		
		cotextField = new JTextField();
		cotextField.setColumns(10);
		cotextField.setBounds(122, 171, 155, 20);
		panel.add(cotextField);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmount.setBounds(54, 201, 79, 21);
		panel.add(lblAmount);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 54, 551, 437);
		panel.add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				idtextField.setText(model.getValueAt(i, 0).toString());
				titextField.setText(model.getValueAt(i, 1).toString());
				aptextField.setText(model.getValueAt(i, 2).toString());
				cotextField.setText(model.getValueAt(i, 3).toString());
				amtextField.setText(model.getValueAt(i, 4).toString());
				ditextField.setText(model.getValueAt(i, 5).toString());
				ddtextField.setText(model.getValueAt(i, 6).toString());
			}
		});
		
		//Invoices table
		
		model = new DefaultTableModel();
		Object[] collumn = {"ID", "Titular", "Apartment", "Company", "Amount", "Date of issue", "Due date"};
		Object[] row = new Object[7];
		model.setColumnIdentifiers(collumn);
		table.setModel(model);
		table.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblDueDate = new JLabel("Due date");
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDueDate.setBounds(54, 264, 79, 21);
		panel.add(lblDueDate);
		
		JLabel lblDateOfIssue = new JLabel("Date of issue");
		lblDateOfIssue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfIssue.setBounds(34, 233, 79, 21);
		panel.add(lblDateOfIssue);
		
		ditextField = new JTextField();
		ditextField.setBounds(122, 233, 86, 20);
		panel.add(ditextField);
		ditextField.setColumns(10);
		
		ddtextField = new JTextField();
		ddtextField.setColumns(10);
		ddtextField.setBounds(122, 265, 86, 20);
		panel.add(ddtextField);
		
		amtextField = new JTextField();
		amtextField.setColumns(10);
		amtextField.setBounds(122, 202, 86, 20);
		panel.add(amtextField);
		
		JButton insertButton = new JButton("Insert");
		
		//BEGIN INSERT BUTTON ACTION
		
	    insertButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(idtextField.getText().equals("") || titextField.getText().equals("") ||aptextField.getText().equals("") || cotextField.getText().equals("") || amtextField.getText().equals("") || ditextField.getText().equals("") || ddtextField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
					}else {
							row[0] = idtextField.getText();
							row[1] = titextField.getText();
							row[2] = aptextField.getText();
							row[3] = cotextField.getText();
							row[4] = amtextField.getText();
							row[5] = ditextField.getText();
							row[6] = ddtextField.getText();
							model.addRow(row);
									
							//start new row with data cleared
							idtextField.setText("");
							titextField.setText("");
							cotextField.setText("");
							aptextField.setText("");
							amtextField.setText("");
							ditextField.setText("");
							ddtextField.setText("");
							JOptionPane.showMessageDialog(null, "Saved Successfully");
					}
				}
		});
		insertButton.setForeground(Color.WHITE);
		insertButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		insertButton.setBackground(new Color(100, 149, 237));
		insertButton.setBounds(34, 367, 89, 23);
		panel.add(insertButton);
		
		JButton deleteButton = new JButton("Delete");
		
		//BEGIN DELETE BUTTON ACTION
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
				}else {
					JOptionPane.showMessageDialog(null, "Please Select A Row First");
				}
								
			}
		});
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		deleteButton.setBackground(new Color(100, 149, 237));
		deleteButton.setBounds(152, 368, 89, 23);
		panel.add(deleteButton);
		
		JButton editButton = new JButton("Edit");
		
		//BEGIN EDIT BUTTON ACTION
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.setValueAt(idtextField.getText(), i, 0);
				model.setValueAt(titextField.getText(), i, 1);
				model.setValueAt(aptextField.getText(), i, 2);
				model.setValueAt(cotextField.getText(), i, 3);
				model.setValueAt(amtextField.getText(), i, 4);
				model.setValueAt(ditextField.getText(), i, 5);
				model.setValueAt(ddtextField.getText(), i, 6);
					}
		});
		editButton.setForeground(Color.WHITE);
		editButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		editButton.setBackground(new Color(100, 149, 237));
		editButton.setBounds(34, 411, 89, 23);
		panel.add(editButton);
		
		JButton clrButton = new JButton("Clear");
		
		//BEGIN CLEAR BUTTON ACTION
		
		clrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idtextField.setText("");
				titextField.setText("");
				aptextField.setText("");
				cotextField.setText("");
				amtextField.setText("");
				ditextField.setText("");
				ddtextField.setText("");
			}
		});		
		clrButton.setForeground(Color.WHITE);
		clrButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		clrButton.setBackground(new Color(100, 149, 237));
		clrButton.setBounds(152, 412, 89, 23);
		panel.add(clrButton);
		
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
	}
}
