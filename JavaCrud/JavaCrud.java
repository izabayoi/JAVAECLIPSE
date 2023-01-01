import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JavaCrud {

	private JFrame frame;
	private JTextField ID;
	private JTextField Name;
	private JTextField Contact;
	private JTextField Course;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnClear;
	DefaultTableModel model;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCrud window = new JavaCrud();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaCrud() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(30, 83, 58, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(30, 111, 58, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(30, 141, 58, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(30, 173, 58, 17);
		frame.getContentPane().add(lblNewLabel_3);
		
		ID = new JTextField();
		ID.setBounds(89, 81, 201, 21);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		Name = new JTextField();
		Name.setBounds(89, 108, 201, 20);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		Contact = new JTextField();
		Contact.setBounds(89, 141, 201, 20);
		frame.getContentPane().add(Contact);
		Contact.setColumns(10);
		
		Course = new JTextField();
		Course.setBounds(89, 171, 201, 20);
		frame.getContentPane().add(Course);
		Course.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 77, 362, 319);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_1.getSelectedRow();
				ID.setText(model.getValueAt(i, 0).toString());
				Name.setText(model.getValueAt(i, 1).toString());
				Contact.setText(model.getValueAt(i, 2).toString());
				Course.setText(model.getValueAt(i, 3).toString());
			}
		});
		table_1.setBackground(new Color(128, 255, 255));
		model=new DefaultTableModel();
		Object[] column = {"ID","Name","Contact","Course"};
		final Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID.getText().equals("") || Name.getText().equals("") || Contact.getText().equals("") || Course.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill Complete Information");
				}
				else
				{
				row[0]=ID.getText();
				row[1]=Name.getText();
				row[2]=Contact.getText();
				row[3]=Course.getText();
				model.addRow(row);
				
				
				ID.setText("");
				Name.setText("");
				Contact.setText("");
				Course.setText("");
				JOptionPane.showMessageDialog(null,"Saved successfully");
				}
			}
		});
		btnAdd.setBounds(30, 231, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table_1.getSelectedRow();
				if(i>0)
				{	
				model.removeRow(i);
				JOptionPane.showMessageDialog(null,"Deleted successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please Select a Row First");	
				}
			}
		});
		btnDelete.setBounds(30, 274, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table_1.getSelectedRow();
				if(i>0)
				{	
				model.setValueAt(ID.getText(), i, 0);
				model.setValueAt(Name.getText(), i, 1);
				model.setValueAt(Contact.getText(), i, 2);
				model.setValueAt(Course.getText(), i, 3);
				JOptionPane.showMessageDialog(null,"Updated successfully");	
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please Select a Row First");		
				}	
			}
		});
		btnUpdate.setBounds(180, 231, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ID.setText("");
			Name.setText("");
			Contact.setText("");
			Course.setText("");
			
			}
		});
		btnClear.setBounds(180, 274, 89, 23);
		frame.getContentPane().add(btnClear);
		frame.setBounds(100, 100, 722, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
