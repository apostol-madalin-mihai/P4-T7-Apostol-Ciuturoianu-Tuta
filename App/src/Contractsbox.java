
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
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class Contractsbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cntextField;
	private JTextField otextField;
	private JTextField bdtextField;
	private JTextField edtextField;
	DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contractsbox frame = new Contractsbox();
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
	public Contractsbox() {
		setTitle("Add/Edit Contracts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 740, 494);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 51, 436, 432);
		panel.add(scrollPane);
		
		JTextArea dtextArea = new JTextArea();
		dtextArea.setBounds(117, 216, 155, 111);
		dtextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		dtextArea.setWrapStyleWord(true);
		dtextArea.setLineWrap(true);
		panel.add(dtextArea);
		
		table = new JTable();
		
//
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				cntextField.setText(model.getValueAt(i, 0).toString());
				otextField.setText(model.getValueAt(i, 1).toString());
				bdtextField.setText(model.getValueAt(i, 2).toString());
				edtextField.setText(model.getValueAt(i, 3).toString());
				dtextArea.setText(model.getValueAt(i, 4).toString());
			}
		});
		
		//Contracts table
		
		model = new DefaultTableModel();
		Object[] collumn = {"Company Name", "Owner", "Begin Date", "End Date", "Details"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(collumn);
		table.setModel(model);
		table.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(table);
		
		JLabel nameLabel = new JLabel("Company name");
		nameLabel.setBounds(22, 88, 106, 21);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(nameLabel);
		
		cntextField = new JTextField();
		cntextField.setBounds(117, 89, 155, 20);
		cntextField.setColumns(10);
		panel.add(cntextField);
		
		JLabel ownerLabel = new JLabel("Owner");
		ownerLabel.setBounds(49, 120, 79, 21);
		ownerLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(ownerLabel);
		
		otextField = new JTextField();
		otextField.setBounds(117, 120, 155, 20);
		otextField.setColumns(10);
		panel.add(otextField);
		
		JLabel lblBeginDate = new JLabel("Begin Date");
		lblBeginDate.setBounds(49, 152, 79, 21);
		lblBeginDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblBeginDate);
		
		bdtextField = new JTextField();
		bdtextField.setBounds(117, 152, 86, 20);
		bdtextField.setColumns(10);
		panel.add(bdtextField);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(49, 184, 79, 21);
		lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblEndDate);
		
		edtextField = new JTextField();
		edtextField.setBounds(117, 185, 86, 20);
		edtextField.setColumns(10);
		panel.add(edtextField);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(49, 215, 79, 21);
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblDetails);
		
		JButton insertButton = new JButton("Insert");
		
		//BEGIN INSERT BUTTON ACTION
		
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cntextField.getText().equals("") || otextField.getText().equals("") || bdtextField.getText().equals("") || edtextField.getText().equals("") || dtextArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}else {
						row[0] = cntextField.getText();
						row[1] = otextField.getText();
						row[2] = bdtextField.getText();
						row[3] = edtextField.getText();
						row[4] = dtextArea.getText();
						model.addRow(row);
							
						//start new row with data cleared
						cntextField.setText("");
						otextField.setText("");
						bdtextField.setText("");
						edtextField.setText("");
						dtextArea.setText("");
						JOptionPane.showMessageDialog(null, "Saved Successfully");
				}
			}
		});
		insertButton.setBounds(49, 378, 89, 23);
		insertButton.setForeground(Color.WHITE);
		insertButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		insertButton.setBackground(new Color(100, 149, 237));
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
		deleteButton.setBounds(167, 379, 89, 23);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		deleteButton.setBackground(new Color(100, 149, 237));
		panel.add(deleteButton);
		
		JButton editButton = new JButton("Edit");
		
		//BEGIN EDIT BUTTON ACTION
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.setValueAt(cntextField.getText(), i, 0);
				model.setValueAt(otextField.getText(), i, 1);
				model.setValueAt(bdtextField.getText(), i, 2);
				model.setValueAt(edtextField.getText(), i, 3);
				model.setValueAt(dtextArea.getText(), i, 4);
			}
		});
		editButton.setBounds(49, 422, 89, 23);
		editButton.setForeground(Color.WHITE);
		editButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		editButton.setBackground(new Color(100, 149, 237));
		panel.add(editButton);
		
		JButton clrButton = new JButton("Clear");
		
		//BEGIN CLEAR BUTTON ACTION
		
		clrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cntextField.setText("");
				otextField.setText("");
				bdtextField.setText("");
				edtextField.setText("");
				dtextArea.setText("");
			}
		});
		clrButton.setBounds(167, 423, 89, 23);
		clrButton.setForeground(Color.WHITE);
		clrButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		clrButton.setBackground(new Color(100, 149, 237));
		panel.add(clrButton);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ABAbox abaBox = new ABAbox();
				abaBox.setVisible(true);
			}
		});
		backButton.setBackground(new Color(255, 165, 0));
		backButton.setBounds(10, 11, 72, 23);
		panel.add(backButton);
		
		
	}
}
