package menjacnica.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JTextField textFieldSifra;
	private JTextField textFieldNaziv;
	private JLabel lblProdajni;
	private JLabel lblKupovni;
	private JTextField textFieldProdajni;
	private JTextField textFieldKupovni;
	private JLabel lblSrednji;
	private JLabel lblSkraceniNaziv;
	private JTextField textFieldSrednji;
	private JTextField textFieldSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(getLblSifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getTextFieldSifra());
		contentPane.add(getTextFieldNaziv());
		contentPane.add(getLblProdajni());
		contentPane.add(getLblKupovni());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_1_1());
		contentPane.add(getLblSrednji());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getTextField_3());
		contentPane.add(getTextField_1_2());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("\u0160ifra");
			lblSifra.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSifra.setPreferredSize(new Dimension(150, 20));
		}
		return lblSifra;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNaziv.setPreferredSize(new Dimension(150, 20));
		}
		return lblNaziv;
	}
	private JTextField getTextFieldSifra() {
		if (textFieldSifra == null) {
			textFieldSifra = new JTextField();
			textFieldSifra.setPreferredSize(new Dimension(150, 20));
		}
		return textFieldSifra;
	}
	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setPreferredSize(new Dimension(150, 20));
		}
		return textFieldNaziv;
	}
	private JLabel getLblProdajni() {
		if (lblProdajni == null) {
			lblProdajni = new JLabel("Prodajni kurs");
			lblProdajni.setPreferredSize(new Dimension(150, 20));
			lblProdajni.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblProdajni;
	}
	private JLabel getLblKupovni() {
		if (lblKupovni == null) {
			lblKupovni = new JLabel("Kupovni kurs");
			lblKupovni.setPreferredSize(new Dimension(150, 20));
			lblKupovni.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblKupovni;
	}
	private JTextField getTextField_2() {
		if (textFieldProdajni == null) {
			textFieldProdajni = new JTextField();
			textFieldProdajni.setPreferredSize(new Dimension(150, 20));
		}
		return textFieldProdajni;
	}
	private JTextField getTextField_1_1() {
		if (textFieldKupovni == null) {
			textFieldKupovni = new JTextField();
			textFieldKupovni.setPreferredSize(new Dimension(150, 20));
		}
		return textFieldKupovni;
	}
	private JLabel getLblSrednji() {
		if (lblSrednji == null) {
			lblSrednji = new JLabel("Srednji kurs");
			lblSrednji.setPreferredSize(new Dimension(150, 20));
			lblSrednji.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblSrednji;
	}
	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skra\u0107eni naziv");
			lblSkraceniNaziv.setPreferredSize(new Dimension(150, 20));
			lblSkraceniNaziv.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblSkraceniNaziv;
	}
	private JTextField getTextField_3() {
		if (textFieldSrednji == null) {
			textFieldSrednji = new JTextField();
			textFieldSrednji.setPreferredSize(new Dimension(150, 20));
		}
		return textFieldSrednji;
	}
	private JTextField getTextField_1_2() {
		if (textFieldSkraceniNaziv == null) {
			textFieldSkraceniNaziv = new JTextField();
			textFieldSkraceniNaziv.setPreferredSize(new Dimension(150, 20));
		}
		return textFieldSkraceniNaziv;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						GUIKontroler.unesiNovuValutu(textFieldSifra.getText(),textFieldNaziv.getText(),
								textFieldProdajni.getText(), textFieldKupovni.getText(), textFieldSrednji.getText(),
								textFieldSkraceniNaziv.getText());
						dispose();
					} catch (NumberFormatException e1) {
						GUIKontroler.prikaziDijalogNumberException();
						return;
					}
					MenjacnicaGUI.ispisiNovuKnjigu(textFieldSifra.getText(),textFieldNaziv.getText(),
							textFieldProdajni.getText(), textFieldKupovni.getText(), textFieldSrednji.getText(),
							textFieldSkraceniNaziv.getText());
				}
			});
			btnDodaj.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnDodaj.setPreferredSize(new Dimension(150, 20));
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOdustani.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnOdustani.setPreferredSize(new Dimension(150, 20));
		}
		return btnOdustani;
	}
}
