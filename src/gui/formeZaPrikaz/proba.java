package gui.formeZaPrikaz;

package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

import javax.swing.table.DefaultTableModel;

import atributi.ZanrKnjige;
import biblioteka.Biblioteka;
import gui.formeZaDodavanje.ZanroviForma;
import main.BibliotekaMain;



public class ZanroviProzor extends JFrame {

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable zanroviTabela;
	
	private Biblioteka biblioteka;
	
	public ZanroviProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Zanrovi");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		//initActions();
	} 
	
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("///C:/Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("///C:/Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("///C:/Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/slike/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[] {"Oznaka", "Opis", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniZanrovi().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniZanrovi().size(); i++) {
			ZanrKnjige zanr = biblioteka.sviNeobrisaniZanrovi().get(i);
			sadrzaj[i][0] = zanr.getOznaka();
			sadrzaj[i][1] = zanr.getOpis();
			sadrzaj[i][2] = zanr.isObrisan();
		
	
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		zanroviTabela = new JTable(tableModel);
		
		zanroviTabela.setRowSelectionAllowed(true);
		zanroviTabela.setColumnSelectionAllowed(false);
		zanroviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		zanroviTabela.setDefaultEditor(Object.class, null);
		zanroviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(zanroviTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	/*private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zanroviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String zanrId = tableModel.getValueAt(red, 0).toString();
					ZanrKnjige zanr = biblioteka.pronadjiZanr(zanrId);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete disk?", 
							zanrId + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						zanr.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiZanrove(BibliotekaMain.ZANROVI_FAJL);
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanroviForma df = new ZanroviForma(biblioteka, null);
				df.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zanroviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String zanrID = tableModel.getValueAt(red, 0).toString();
					ZanrKnjige zanr = biblioteka.pronadjiZanr(zanrID);
					ZanroviForma df = new ZanroviForma(biblioteka, zanr);
					df.setVisible(true);
				}
			}
		});
	}*/
}


package gui.formeZaDodavanje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import atributi.ZanrKnjige;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import biblioteka.Biblioteka;

import gui.LoginProzor;
import net.miginfocom.swing.MigLayout;


public class ZanroviForma extends JFrame {

	private JLabel lbId = new JLabel ("Oznaka");
	private JTextField txtId = new JTextField(25);
	private JLabel lbOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(25);
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JTextField txtObrisan = new JTextField(25);
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private ZanrKnjige zanr;
	private Biblioteka biblioteka;
	
	public ZanroviForma(Biblioteka biblioteka, ZanrKnjige zanr) {
		
		this.biblioteka = biblioteka;
		this.zanr = zanr;
		if(zanr == null) {
			setTitle("Dodavanje knjige :");
		}else {
			setTitle("Izmena podataka knjige [" + zanr.getOznaka() + "]");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450,420);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(zanr != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		
		add(lbId);
		add(txtId);
		add(lbOpis);
		add(txtOpis);
		add(lbObrisan);
		add(txtObrisan);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	
	
	private void initAction() {
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanroviForma.this.dispose();
				ZanroviForma.this.setVisible(false);
			}
		});
		
	}
	
	
	
	private void popuniPolja() {
		
		txtId.setText(String.valueOf(zanr.getOznaka()));
		txtOpis.setText(zanr.getOpis());
		txtObrisan.setText(String.valueOf(zanr.isObrisan()));
		
	}
	
}


