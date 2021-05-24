
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Employeesbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField fntextField;
	private JTextField lntextField;
	private JTextField etextField;
	private JTextField satextField;
	private JTable table;
	DefaultTableModel model;
	private JTextField octextField;
	private JTextField phtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employeesbox frame = new Employeesbox();
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
	public Employeesbox() {
		setTitle("Add/Edit Employees");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 869, 492);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		idLabel.setBounds(51, 111, 79, 21);
		panel.add(idLabel);
		
		JLabel fNameLabel = new JLabel("First Name");
		fNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fNameLabel.setBounds(51, 143, 79, 21);
		panel.add(fNameLabel);
		
		JLabel lNameLabel = new JLabel("Last Name");
		lNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lNameLabel.setBounds(51, 175, 79, 21);
		panel.add(lNameLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailLabel.setBounds(51, 270, 79, 21);
		panel.add(emailLabel);
		
		JLabel phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		phoneLabel.setBounds(51, 302, 79, 21);
		panel.add(phoneLabel);
		
		idtextField = new JTextField();
		idtextField.setBounds(119, 112, 86, 20);
		panel.add(idtextField);
		idtextField.setColumns(10);
		
		fntextField = new JTextField();
		fntextField.setColumns(10);
		fntextField.setBounds(119, 143, 86, 20);
		panel.add(fntextField);
		
		lntextField = new JTextField();
		lntextField.setColumns(10);
		lntextField.setBounds(119, 175, 86, 20);
		panel.add(lntextField);
		
		etextField = new JTextField();
		etextField.setColumns(10);
		etextField.setBounds(119, 271, 155, 20);
		panel.add(etextField);
		
		satextField = new JTextField();
		satextField.setColumns(10);
		satextField.setBounds(119, 239, 86, 20);
		panel.add(satextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 60, 562, 421);
		panel.add(scrollPane);
		
		table = new JTable();
		
		//
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				idtextField.setText(model.getValueAt(i, 0).toString());
				fntextField.setText(model.getValueAt(i, 1).toString());
				lntextField.setText(model.getValueAt(i, 2).toString());
				octextField.setText(model.getValueAt(i, 3).toString());
				satextField.setText(model.getValueAt(i, 4).toString());
				etextField.setText(model.getValueAt(i, 5).toString());
				phtextField.setText(model.getValueAt(i, 6).toString());
			}
		});
		table.setBackground(new Color(240, 248, 255));
		
		//Employees table
		
		model = new DefaultTableModel();
		Object[] collumn = {"ID", "First name", "Last name","Occupation", "Salary", "Email", "Phone"};
		Object[] row = new Object[7];
		model.setColumnIdentifiers(collumn);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		JButton insertButton = new JButton("Insert");
		
		//BEGIN INSERT BUTTON ACTION
		
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(idtextField.getText().equals("") || fntextField.getText().equals("") || lntextField.getText().equals("") || octextField.getText().equals("") || phtextField.getText().equals("") || etextField.getText().equals("") || satextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}else {
					row[0] = idtextField.getText();
					row[1] = fntextField.getText();
					row[2] = lntextField.getText();
					row[3] = octextField.getText();
					row[4] = satextField.getText();
					row[5] = etextField.getText();
					row[6] = phtextField.getText();
					model.addRow(row);
					
					//start new row with data cleared
					idtextField.setText("");
					fntextField.setText("");
					lntextField.setText("");
					octextField.setText("");
					satextField.setText("");
					etextField.setText("");
					phtextField.setText("");
					JOptionPane.showMessageDialog(null, "Saved Successfully");
				}
			}
		});
		
		insertButton.setBackground(new Color(100, 149, 237));
		insertButton.setForeground(Color.WHITE);
		insertButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		insertButton.setBounds(49, 350, 89, 23);
		panel.add(insertButton);
		
		JButton editButton = new JButton("Edit");
		
		//BEGIN EDIT BUTTON ACTION
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.setValueAt(idtextField.getText(), i, 0);
				model.setValueAt(fntextField.getText(), i, 1);
				model.setValueAt(lntextField.getText(), i, 2);
				model.setValueAt(octextField.getText(), i, 3);
				model.setValueAt(satextField.getText(), i, 4);
				model.setValueAt(etextField.getText(), i, 5);
				model.setValueAt(phtextField.getText(), i, 6);
			}
		});
		editButton.setBackground(new Color(100, 149, 237));
		editButton.setForeground(Color.WHITE);
		editButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		editButton.setBounds(49, 394, 89, 23);
		panel.add(editButton);
		
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
		
		deleteButton.setBackground(new Color(100, 149, 237));
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		deleteButton.setBounds(167, 351, 89, 23);
		panel.add(deleteButton);
		
		JButton btnClear = new JButton("Clear");
		
		//BEGIN CLEAR BUTTON ACTION
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idtextField.setText("");
				fntextField.setText("");
				lntextField.setText("");
				octextField.setText("");
				satextField.setText("");
				etextField.setText("");
				phtextField.setText("");
			}
		});
		btnClear.setBackground(new Color(100, 149, 237));
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(167, 395, 89, 23);
		panel.add(btnClear);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ABAbox abaBox = new ABAbox();
				abaBox.setVisible(true);
			}
		});
		backButton.setBackground(new Color(255, 165, 0));
		backButton.setBounds(10, 11, 71, 23);
		panel.add(backButton);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOccupation.setBounds(37, 207, 79, 21);
		panel.add(lblOccupation);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalary.setBounds(51, 238, 79, 21);
		panel.add(lblSalary);
		
		octextField = new JTextField();
		octextField.setBounds(119, 207, 86, 20);
		panel.add(octextField);
		octextField.setColumns(10);
		
		phtextField = new JTextField();
		phtextField.setText("");
		phtextField.setBounds(119, 303, 86, 20);
		panel.add(phtextField);
		phtextField.setColumns(10);
	}
}
