package spiel;

import java.util.Map;
import java.util.HashMap;

public class Karte {
	public static final Integer MAUER = 0;
	public static final Integer FREILAND = 1;
	public static final Integer GEGNER = 2;
	
	 
	private Map<Tuple<Integer, Integer>, Integer> Felder;
	
	
	public Karte() {
		Felder = new HashMap<Tuple<Integer, Integer>, Integer>();
	}
	
	public void feldHinzufuegen(Tuple koordinate, Integer wert) {
		Felder.put(koordinate, wert);
	}
	
	public Integer holeFeld(Tuple koordinate) {
		return Felder.get(koordinate);
	}
	
	public Map< Tuple<Integer, Integer>, Integer>  holeFelder() {
		return Felder;
	}
}
