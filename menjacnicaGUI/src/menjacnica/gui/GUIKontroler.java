package menjacnica.gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import menjacnica.Menjacnica;
import menjacnica.Valuta;

public class GUIKontroler {
	
	private static MenjacnicaGUI glavniProzor;
	private static Menjacnica menjacnica = new Menjacnica();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(glavniProzor.getContentPane(), "Da li zelite da izadjete iz programa?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_CANCEL_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void prikaziAboutDialog(){
		JOptionPane.showMessageDialog(glavniProzor, "Autor: Ilija Pavlovic\nVerzija: 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void unesiNovuValutu(String sifra, String naziv, String prodajni, String kupovni, String srednji, String skraceniNaziv) {
		Valuta v = new Valuta();
		v.setSifra(sifra);
		v.setNaziv(naziv);
		v.setProdajni(Double.parseDouble(prodajni));
		v.setKupovni(Double.parseDouble(kupovni));
		v.setSrednji(Double.parseDouble(srednji));
		v.setSkraceniNaziv(skraceniNaziv);
		menjacnica.dodajValutu(v);
		glavniProzor.osveziTabelu();
	}
	
	public static LinkedList<Valuta> vratiSveValute(){
		return menjacnica.getValute();
	}

	public static void otvoriProzorDodajKurs() {
		DodajKursGUI noviProzorDK = new DodajKursGUI();
		noviProzorDK.setVisible(true);
		noviProzorDK.setLocationRelativeTo(null);
	}

}
