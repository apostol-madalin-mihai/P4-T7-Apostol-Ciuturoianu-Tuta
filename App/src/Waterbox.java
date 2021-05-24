
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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Waterbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField titextField;
	private JTextField cotextField;
	private JTextField amtextField;
	private JTextField ddtextField;
	DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Waterbox frame = new Waterbox();
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
	public Waterbox() {
		setTitle("Add Water Consumption");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 725, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(262, 40, 453, 449);
		panel.add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				idtextField.setText(model.getValueAt(i, 0).toString());
				titextField.setText(model.getValueAt(i, 1).toString());
				cotextField.setText(model.getValueAt(i, 2).toString());
				amtextField.setText(model.getValueAt(i, 3).toString());
				ddtextField.setText(model.getValueAt(i, 4).toString());
			}
		});
		
		//Water Consumption table
		
		model = new DefaultTableModel();
		Object[] collumn = {"ID", "Titular", "Consumption", "Amount", "Due date"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(collumn);
		table.setModel(model);
		table.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(table);
		
		JLabel idlabel = new JLabel("ID");
		idlabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		idlabel.setBounds(53, 78, 25, 21);
		panel.add(idlabel);
		
		idtextField = new JTextField();
		idtextField.setColumns(10);
		idtextField.setBounds(97, 79, 86, 20);
		panel.add(idtextField);
		
		JLabel titularLabel = new JLabel("Titular");
		titularLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		titularLabel.setBounds(29, 110, 79, 21);
		panel.add(titularLabel);
		
		titextField = new JTextField();
		titextField.setColumns(10);
		titextField.setBounds(97, 110, 155, 20);
		panel.add(titextField);
		
		JLabel lblConsumption = new JLabel("Consumption");
		lblConsumption.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConsumption.setBounds(10, 141, 79, 21);
		panel.add(lblConsumption);
		
		cotextField = new JTextField();
		cotextField.setColumns(10);
		cotextField.setBounds(97, 142, 86, 20);
		panel.add(cotextField);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmount.setBounds(29, 174, 79, 21);
		panel.add(lblAmount);
		
		amtextField = new JTextField();
		amtextField.setColumns(10);
		amtextField.setBounds(97, 175, 86, 20);
		panel.add(amtextField);
		
		JLabel lblDueDate = new JLabel("Due date");
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDueDate.setBounds(29, 205, 79, 21);
		panel.add(lblDueDate);
		
		ddtextField = new JTextField();
		ddtextField.setColumns(10);
		ddtextField.setBounds(97, 206, 86, 20);
		panel.add(ddtextField);
		
		JButton insertButton = new JButton("Insert");
		
		//BEGIN INSERT BUTTON ACTION
		
	    insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(idtextField.getText().equals("") || titextField.getText().equals("") || cotextField.getText().equals("") || amtextField.getText().equals("") || ddtextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}else {
						row[0] = idtextField.getText();
						row[1] = titextField.getText();
						row[2] = cotextField.getText();
						row[3] = amtextField.getText();
						row[4] = ddtextField.getText();
						model.addRow(row);
								
						//start new row with data cleared
						idtextField.setText("");
						titextField.setText("");
						cotextField.setText("");
						amtextField.setText("");
						ddtextField.setText("");
						JOptionPane.showMessageDialog(null, "Saved Successfully");
					}
				}
		});
		insertButton.setForeground(Color.WHITE);
		insertButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		insertButton.setBackground(new Color(100, 149, 237));
		insertButton.setBounds(29, 306, 89, 23);
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
		deleteButton.setBounds(147, 307, 89, 23);
		panel.add(deleteButton);
		
		JButton editButton = new JButton("Edit");
		
		//BEGIN EDIT BUTTON ACTION
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.setValueAt(idtextField.getText(), i, 0);
				model.setValueAt(titextField.getText(), i, 1);
				model.setValueAt(cotextField.getText(), i, 2);
				model.setValueAt(amtextField.getText(), i, 3);
				model.setValueAt(ddtextField.getText(), i, 4);
					}
		});
		editButton.setForeground(Color.WHITE);
		editButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		editButton.setBackground(new Color(100, 149, 237));
		editButton.setBounds(29, 350, 89, 23);
		panel.add(editButton);
		
		JButton clrButton = new JButton("Clear");
		
		//BEGIN CLEAR BUTTON ACTION
		
		clrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idtextField.setText("");
				titextField.setText("");
				cotextField.setText("");
				amtextField.setText("");
				ddtextField.setText("");
			}
		});		
		clrButton.setForeground(Color.WHITE);
		clrButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		clrButton.setBackground(new Color(100, 149, 237));
		clrButton.setBounds(147, 351, 89, 23);
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
