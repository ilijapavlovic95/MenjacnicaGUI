package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import menjacnica.Valuta;
import menjacnica.gui.models.MenjacnicaTableModel;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Dimension;
import java.awt.TextArea;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JPanel eastPanel;
	private JButton btnDodajKurs;
	private JButton btnIzbrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JPanel southPanel;
	private static TextArea textAreaStatus;
	private JScrollPane scrollPane;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmIzbrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;


	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				GUIKontroler.ugasiAplikaciju();
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/icons/Mitrovic 800x800.jpg")));
		setTitle("Menja\u010Dnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 716, 450);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getEastPanel(), BorderLayout.EAST);
		contentPane.add(getSouthPanel(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(contentPane);
					String postojeciText = textAreaStatus.getText();
					
					if(!postojeciText.isEmpty()) postojeciText = postojeciText + "\n";
					
					if(returnVal == JFileChooser.APPROVE_OPTION){
						textAreaStatus.setText(postojeciText + "Ucitan fajl: " + fc.getSelectedFile().getAbsolutePath());
					}
				}
			});
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/newFolder.gif")));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showSaveDialog(contentPane);
					String postojeciText = textAreaStatus.getText();
					
					if(!postojeciText.isEmpty()) postojeciText = postojeciText + "\n";
					
					if(returnVal == JFileChooser.APPROVE_OPTION){
						textAreaStatus.setText(postojeciText + "Sacuvan fajl: " + fc.getSelectedFile().getAbsolutePath());
					}
				}
			});
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziAboutDialog();
				}
			});
		}
		return mntmAbout;
	}
	private JPanel getEastPanel() {
		if (eastPanel == null) {
			eastPanel = new JPanel();
			eastPanel.setPreferredSize(new Dimension(120, 10));
			eastPanel.add(getBtnDodajKurs());
			eastPanel.add(getBtnIzbrisiKurs());
			eastPanel.add(getBtnIzvrsiZamenu());
		}
		return eastPanel;
	}
	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriProzorDodajKurs();
				}
			});
			btnDodajKurs.setPreferredSize(new Dimension(113, 23));
		}
		return btnDodajKurs;
	}
	
	private void obrisiKurs(){
		try {
			int index = table.getSelectedRow();
			if(index == -1){
				GUIKontroler.ispisiPorukuOGresciIzboraRedaZaBrisanje();
			}else{
				int opcija = JOptionPane.showConfirmDialog(null,
						"Da li ste sigurni da zelite da izbrisete izabrani kurs?", "Poruka",
						JOptionPane.YES_NO_OPTION);

				if(opcija == JOptionPane.YES_OPTION){
					MenjacnicaTableModel model = (MenjacnicaTableModel) table.getModel();
					Valuta v = model.getValutaByIndex(index);
					GUIKontroler.izbrisiValutu(v);
				}

				String poruka = "Izbrisan je red sa indeksom " + index;
				String postojeciText = textAreaStatus.getText();

				if(!postojeciText.isEmpty()) postojeciText = postojeciText + "\n";

				textAreaStatus.setText(postojeciText + poruka);
			
			}
		} catch (Exception e) {
			GUIKontroler.prikaziDijalogPogresnoBrisanje();
		}
	}

	private JButton getBtnIzbrisiKurs() {
		if (btnIzbrisiKurs == null) {
			btnIzbrisiKurs = new JButton("Izbri\u0161i kurs");
			btnIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					obrisiKurs();
				}
			});
			btnIzbrisiKurs.setPreferredSize(new Dimension(113, 23));
		}
		return btnIzbrisiKurs;
	}

	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvr\u0161i zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriProzorIzvrsiZamenu();
				}
			});
			btnIzvrsiZamenu.setPreferredSize(new Dimension(113, 23));
		}
		return btnIzvrsiZamenu;
	}
	private JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.setPreferredSize(new Dimension(10, 100));
			southPanel.setLayout(new BorderLayout(0, 0));
			southPanel.add(getTextAreaStatus(), BorderLayout.CENTER);
			Border blackline = BorderFactory.createLineBorder(Color.black);
			TitledBorder title = BorderFactory.createTitledBorder(blackline, "STATUS");
			title.setTitleJustification(TitledBorder.LEFT);
			southPanel.setBorder(title);
		}
		return southPanel;
	}
	private TextArea getTextAreaStatus() {
		if (textAreaStatus == null) {
			textAreaStatus = new TextArea();
		}
		return textAreaStatus;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			addPopup(scrollPane, getPopupMenu());
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			MenjacnicaTableModel model = new MenjacnicaTableModel(null);
			table.setModel(model);
		}
		return table;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmIzbrisiKurs());
			popupMenu.add(getMntmIzvrsiZamenu());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriProzorDodajKurs();
				}
			});
		}
		return mntmDodajKurs;
	}
	private JMenuItem getMntmIzbrisiKurs() {
		if (mntmIzbrisiKurs == null) {
			mntmIzbrisiKurs = new JMenuItem("Izbri\u0161i kurs");
			mntmIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					obrisiKurs();
				}
			});
		}
		return mntmIzbrisiKurs;
	}
	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvr\u0161i zamenu");
			mntmIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriProzorIzvrsiZamenu();
				}
			});
		}
		return mntmIzvrsiZamenu;
	}
	
	public static void ispisiNovuKnjigu(String sifra, String naziv, String prodajni, String kupovni, String srednji, String skraceniNaziv){
		String poruka = "Novi kurs - Sifra: " + sifra + "; Naziv: " + naziv + "; Prodajni kurs: " + prodajni + "; Kupovni kurs: " + kupovni + "; Srednji kurs: " + srednji + "; Skraceni naziv: " + skraceniNaziv;
		String postojeciText = textAreaStatus.getText();

		if(!postojeciText.isEmpty()) postojeciText = postojeciText + "\n";

		textAreaStatus.setText(postojeciText + poruka);

	}
	
	public void osveziTabelu(){
		MenjacnicaTableModel model = (MenjacnicaTableModel) table.getModel();
		model.ucitajValute(GUIKontroler.vratiSveValute());
	}

	public static void ispisiZamenu(String valuta, String iznos, String transakcija) {
		String poruka = "Izvrsena zamena - Valuta: " + valuta + "; Iznos: " + iznos + "; Vrsta transakcije: " + transakcija;
		String postojeciText = textAreaStatus.getText();

		if(!postojeciText.isEmpty()) postojeciText = postojeciText + "\n";

		textAreaStatus.setText(postojeciText + poruka);
	}
}
