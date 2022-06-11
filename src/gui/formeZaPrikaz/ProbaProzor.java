package gui.formeZaPrikaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProbaProzor {

	private JFrame frame;
	private JTextField oznaka;
	private JTextField opis;
	private JTextField obrisan;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProbaProzor window = new ProbaProzor();
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
	public ProbaProzor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 804, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 790, 616);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Oznaka");
		lblNewLabel.setBounds(71, 128, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Opis");
		lblNewLabel_1.setBounds(71, 173, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Obrisan");
		lblNewLabel_2.setBounds(71, 215, 45, 13);
		panel.add(lblNewLabel_2);
		
		oznaka = new JTextField();
		oznaka.setBounds(161, 125, 131, 19);
		panel.add(oznaka);
		oznaka.setColumns(10);
		
		opis = new JTextField();
		opis.setColumns(10);
		opis.setBounds(161, 170, 131, 19);
		panel.add(opis);
		
		obrisan = new JTextField();
		obrisan.setColumns(10);
		obrisan.setBounds(161, 212, 131, 19);
		panel.add(obrisan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(302, 71, 430, 475);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				oznaka.setText(model.getValueAt(i, 0).toString());
				opis.setText(model.getValueAt(i, 1).toString());
				obrisan.setText(model.getValueAt(i, 2).toString());
				
				
			}
		});
		table.setBackground(new Color(240, 248, 255));
		model = new DefaultTableModel();
		Object [] column = {"Oznaka", "Opis", "Obrisan"};
		Object [] row = new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(oznaka.getText().equals("") || opis.getText().equals("") || obrisan.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Molimo popunite sva polja");
				}
				else 
				{
				
				row[0] = oznaka.getText();
				row[1] = opis.getText();
				row[2] = obrisan.getText();
				
				model.addRow(row);
				
				oznaka.setText("");
				opis.setText("");
				obrisan.setText("");
				JOptionPane.showMessageDialog(null, "Uspešno dodato");
				}}
		});
		btnNewButton.setBounds(71, 298, 96, 38);
		panel.add(btnNewButton);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();
				if(i>= 0)
				{
				model.setValueAt(oznaka.getText(), i, 0);
				model.setValueAt(opis.getText(), i, 1);
				model.setValueAt(obrisan.getText(), i, 2);
				JOptionPane.showMessageDialog(null, "Uspešno izmenjeno");
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Molimo izaberite red");
				}
				
			}
		});
		btnIzmeni.setBounds(196, 298, 96, 38);
		panel.add(btnIzmeni);
		
		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();
				if(i >= 0)
				{	
				model.removeRow(i);
				JOptionPane.showMessageDialog(null, "Uspešno izbrisano");
			}
				else
				{
					JOptionPane.showMessageDialog(null, "Molimo izaberite polje");}
				}
		});
		btnIzbrisi.setBounds(71, 368, 96, 38);
		panel.add(btnIzbrisi);
		
		JButton btnOcisti = new JButton("Ocisti");
		btnOcisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			oznaka.setText("");
			opis.setText("");
			obrisan.setText("");
			}
		});
		btnOcisti.setBounds(196, 368, 96, 38);
		panel.add(btnOcisti);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
