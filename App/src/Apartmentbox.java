
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

public class Apartmentbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nrtextField;
	private JTextField otextField;
	private JTextField ftextField;
	private JTextField nortextField;
	private JTextField noptextField;
	DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apartmentbox frame = new Apartmentbox();
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
	public Apartmentbox() {
		setTitle("Edit apartment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 792, 469);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 40, 483, 418);
		panel.add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				nrtextField.setText(model.getValueAt(i, 0).toString());
				otextField.setText(model.getValueAt(i, 1).toString());
				ftextField.setText(model.getValueAt(i, 2).toString());
				nortextField.setText(model.getValueAt(i, 3).toString());
				noptextField.setText(model.getValueAt(i, 4).toString());
			}
		});
		
		//Contracts table
		
		model = new DefaultTableModel();
		Object[] collumn = {"Number", "Owner", "Floor", "Number of rooms", "Number of people"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(collumn);
		table.setModel(model);
		table.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumber.setBounds(63, 59, 48, 21);
		panel.add(lblNumber);
		
		nrtextField = new JTextField();
		nrtextField.setColumns(10);
		nrtextField.setBounds(126, 60, 43, 20);
		panel.add(nrtextField);
		
		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOwner.setBounds(66, 90, 48, 21);
		panel.add(lblOwner);
		
		otextField = new JTextField();
		otextField.setColumns(10);
		otextField.setBounds(126, 91, 155, 20);
		panel.add(otextField);
		
		JLabel lblFloor = new JLabel("Floor");
		lblFloor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFloor.setBounds(76, 123, 35, 21);
		panel.add(lblFloor);
		
		ftextField = new JTextField();
		ftextField.setColumns(10);
		ftextField.setBounds(126, 124, 43, 20);
		panel.add(ftextField);
		
		JLabel lblNumberOfRooms = new JLabel("Number of rooms");
		lblNumberOfRooms.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfRooms.setBounds(16, 155, 100, 21);
		panel.add(lblNumberOfRooms);
		
		nortextField = new JTextField();
		nortextField.setColumns(10);
		nortextField.setBounds(126, 156, 43, 20);
		panel.add(nortextField);
		
		JLabel lblNumberOfPeople = new JLabel("Number of people");
		lblNumberOfPeople.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfPeople.setBounds(16, 186, 112, 21);
		panel.add(lblNumberOfPeople);
		
		noptextField = new JTextField();
		noptextField.setBounds(126, 187, 43, 20);
		panel.add(noptextField);
		noptextField.setColumns(10);
		
		JButton insertButton = new JButton("Insert");
		
		//BEGIN INSERT BUTTON ACTION
		
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nrtextField.getText().equals("") || otextField.getText().equals("") || ftextField.getText().equals("") || nortextField.getText().equals("") || noptextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}else {
						row[0] = nrtextField.getText();
						row[1] = otextField.getText();
						row[2] = ftextField.getText();
						row[3] = nortextField.getText();
						row[4] = noptextField.getText();
						model.addRow(row);
									
						//start new row with data cleared
						nrtextField.setText("");
						otextField.setText("");
						ftextField.setText("");
						nortextField.setText("");
						noptextField.setText("");
						JOptionPane.showMessageDialog(null, "Saved Successfully");					
				}
			}
		});
		insertButton.setForeground(Color.WHITE);
		insertButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		insertButton.setBackground(new Color(100, 149, 237));
		insertButton.setBounds(36, 298, 89, 23);
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
		deleteButton.setBounds(154, 299, 89, 23);
		panel.add(deleteButton);
		
		JButton editButton = new JButton("Edit");
		
		//BEGIN EDIT BUTTON ACTION
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.setValueAt(nrtextField.getText(), i, 0);
				model.setValueAt(otextField.getText(), i, 1);
				model.setValueAt(ftextField.getText(), i, 2);
				model.setValueAt(nortextField.getText(), i, 3);
				model.setValueAt(noptextField.getText(), i, 4);
			}
		});
		editButton.setForeground(Color.WHITE);
		editButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		editButton.setBackground(new Color(100, 149, 237));
		editButton.setBounds(36, 342, 89, 23);
		panel.add(editButton);
		
		JButton clrButton = new JButton("Clear");
		
		//BEGIN CLEAR BUTTON ACTION
		
		clrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nrtextField.setText("");
				otextField.setText("");
				ftextField.setText("");
				nortextField.setText("");
				noptextField.setText("");
			}
		});
		clrButton.setForeground(Color.WHITE);
		clrButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		clrButton.setBackground(new Color(100, 149, 237));
		clrButton.setBounds(154, 343, 89, 23);
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
		backButton.setBounds(16, 11, 73, 23);
		panel.add(backButton);

	}

}
