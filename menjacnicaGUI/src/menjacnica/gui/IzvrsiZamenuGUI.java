package menjacnica.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovniKurs;
	private JLabel lblProdajniKurs;
	private JTextField textFieldKupovni;
	private JTextField textFieldProdajni;
	private JComboBox<String> comboBoxValuta;
	private JLabel lblIznos;
	private JSlider slider;
	private JTextField textFieldIznos;
	private JLabel lblVrstaTransakcije;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		setResizable(false);
		setTitle("Izvr\u0161i zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][grow][grow][][grow]", "[][][][][][][][][][][][]"));
		contentPane.add(getLblKupovniKurs(), "cell 0 0");
		contentPane.add(getLblProdajniKurs(), "cell 6 0");
		contentPane.add(getTextFieldKupovni(), "cell 0 1,growx");
		contentPane.add(getComboBoxValuta(), "cell 2 1 3 1,growx");
		contentPane.add(getTextFieldProdajni(), "cell 6 1,growx");
		contentPane.add(getLblIznos(), "cell 0 3 3 1");
		contentPane.add(getLblVrstaTransakcije(), "cell 4 3 3 1");
		contentPane.add(getTextFieldIznos(), "cell 0 4 3 1,growx");
		contentPane.add(getSlider(), "cell 0 8 7 1");
		contentPane.add(getRdbtnKupovina(), "cell 4 4 3 1");
		contentPane.add(getRdbtnProdaja(), "cell 4 5 3 1");
		contentPane.add(getBtnIzvrsiZamenu(), "cell 0 11 2 1");
		contentPane.add(getBtnOdustani(), "cell 5 11 2 1");
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return lblKupovniKurs;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return lblProdajniKurs;
	}
	private JTextField getTextFieldKupovni() {
		if (textFieldKupovni == null) {
			textFieldKupovni = new JTextField();
			textFieldKupovni.setEditable(false);
			textFieldKupovni.setColumns(10);
		}
		return textFieldKupovni;
	}
	private JTextField getTextFieldProdajni() {
		if (textFieldProdajni == null) {
			textFieldProdajni = new JTextField();
			textFieldProdajni.setEditable(false);
			textFieldProdajni.setColumns(10);
		}
		return textFieldProdajni;
	}
	
	private JComboBox<String> getComboBoxValuta() {
		if (comboBoxValuta == null) {
			comboBoxValuta = new JComboBox<String>();
			comboBoxValuta.setModel(new DefaultComboBoxModel<String>(new String[] {"EUR", "USD", "CHF"}));
		}
		return comboBoxValuta;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return lblIznos;
	}
	private JTextField getTextFieldIznos() {
		if (textFieldIznos == null) {
			textFieldIznos = new JTextField();
			textFieldIznos.setColumns(10);
			
		}
		return textFieldIznos;
	}
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
		}
		return lblVrstaTransakcije;
	}
	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina",true);
		}
		return rdbtnKupovina;
	}
	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja",false);
			groupRadioButtons();
		}
		return rdbtnProdaja;
	}
	
	private void groupRadioButtons(){
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnKupovina);
		group.add(rdbtnProdaja);
	}
	
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int sliderValue = slider.getValue();
					String sliderString = String.valueOf(sliderValue);
					textFieldIznos.setText(sliderString);
				}
			});
			slider.setPreferredSize(new Dimension(400, 26));
			slider.setPaintLabels(true);
			slider.setMinorTickSpacing(5);
			slider.setMajorTickSpacing(10);
		}
		return slider;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvr\u0161i zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String transakcija;
					if(rdbtnKupovina.isSelected()) transakcija = rdbtnKupovina.getText();
					else transakcija = rdbtnProdaja.getText();
					
					MenjacnicaGUI.ispisiZamenu((String) comboBoxValuta.getSelectedItem(),textFieldIznos.getText(),transakcija);
					
					dispose();
				}
			});
			btnIzvrsiZamenu.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnIzvrsiZamenu.setPreferredSize(new Dimension(170, 23));
		}
		return btnIzvrsiZamenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnOdustani.setPreferredSize(new Dimension(170, 23));
		}
		return btnOdustani;
	}
}
