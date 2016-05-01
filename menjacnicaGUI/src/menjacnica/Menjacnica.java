package menjacnica;

import java.util.LinkedList;

public class Menjacnica {
	private LinkedList<Valuta> valute = new LinkedList<>();

	public LinkedList<Valuta> getValute() {
		return valute;
	}

	public void setValute(LinkedList<Valuta> valute) {
		this.valute = valute;
	}

	public void dodajValutu(Valuta v) {
		valute.add(v);
	}

	public void izbrisiValutu(Valuta v) {
		if(!valute.contains(v) || valute == null)
			throw new RuntimeException("Greska pri brisanju.");
		valute.remove(v);
	}
	
	
}
