package spiel;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spiel extends JFrame implements ActionListener {

	private JButton startenButton;
	private JButton einstellung;
	private JButton info;
	private JButton endeButton;
	
	private Karte karte1;

	public static void main(String[] args) {

		Spiel frame = new Spiel("Menü");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zum Schliessen
																// des Buttons
		frame.setSize(400, 400); // Groesse des Fensters
		frame.setLayout(null);
		frame.setVisible(true); // Fenster sichtbar machen

	}

	public Spiel(String title) {
		super(title);
		startenButton = new JButton("Spiel starten"); // Unser Menue wird
														// geschlossen und das
														// Spiel wird gestartet
		startenButton.setBounds(120, 100, 160, 40);
		startenButton.addActionListener(this);
		add(startenButton);

		// einstellung = new JButton("Einstellungen");
		// einstellung.setBounds(120, 120, 160, 40);
		// einstellung.addActionListener(this);
		// add(einstellung);

		// info = new JButton("Credits");
		// info.setBounds(120, 200, 160, 40);
		// info.addActionListener(this);
		// add(info);
		karte1 = new Karte();
		generiereKarte1();
		endeButton = new JButton("Ende");
		endeButton.setBounds(120, 200, 160, 40);
		endeButton.addActionListener(this);
		add(endeButton);

	}

	public  void fensterAnzeigen() {
//		JFrame fenster = new JFrame();
//		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		fenster.setSize(1000, 500);
//		fenster.setVisible(true);
		StdDraw.setCanvasSize(1000, 500);
		StdDraw.show();
		
		zeichneKarte(karte1);
	}

	// public static void auswahl() {

	// }

	private static void zeichneKarte(Karte karte) {
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.filledRectangle(0, 0, 500, 250);
		StdDraw.setXscale(0, 1000);
		StdDraw.setYscale(0, 500);
		
		for(Tuple<Integer, Integer> koordinate : karte.holeFelder().keySet()) {
			Integer feldTyp = karte.holeFeld(koordinate);
			Integer x = (koordinate.x * 50) - 25;
			Integer y = koordinate.y * 50;
			switch (feldTyp) {
				case 0:
					StdDraw.picture(x, y, 
							"C:\\Users\\Vlada\\Dropbox\\Programmieren\\Workspace\\Game\\data\\brick.png", 50, 50);
				break;
				case 1:
					// Hier Code zum Malen des Freilandes schreiben
				break;
				case 2:
					
				break;	
			}
			System.out.println("Koordinate (" + koordinate.x + "," + koordinate.y + ") " + karte.holeFeld(koordinate));
		}
		
	}
	
	private void generiereKarte1() {
		karte1.feldHinzufuegen(new Tuple<Integer, Integer>(0,0), Karte.MAUER);
		karte1.feldHinzufuegen(new Tuple<Integer, Integer>(1,0), Karte.MAUER);
		karte1.feldHinzufuegen(new Tuple<Integer, Integer>(2,0), Karte.MAUER);
		karte1.feldHinzufuegen(new Tuple<Integer, Integer>(3,0), Karte.MAUER);
		karte1.feldHinzufuegen(new Tuple<Integer, Integer>(4,0), Karte.MAUER);
		karte1.feldHinzufuegen(new Tuple<Integer, Integer>(5,0), Karte.MAUER);
		karte1.feldHinzufuegen(new Tuple<Integer, Integer>(0,1), Karte.FREILAND);
		karte1.feldHinzufuegen(new Tuple<Integer, Integer>(1,1), Karte.FREILAND);
		karte1.feldHinzufuegen(new Tuple<Integer, Integer>(2,1), Karte.GEGNER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == startenButton) {
			fensterAnzeigen();
		}

		// if (e.getSource() == info) {
		// Object[] options = { "OK"};
		// JOptionPane.showOptionDialog(null,"Programmiert von Vlada !",
		// "Information",
		// JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);

		// }

		// if (e.getSource() == einstellung) {

		// auswahl();

		// }

		if (e.getSource() == endeButton) {
			System.exit(0);

		}

	}
}
