package fr.univnantes.m2.InterfaceComposant;

import fr.univnantes.m2.Configuration.Composant;

public class PortInput extends Port {

	public PortInput(Composant c) {
		super(c);
	}
	
	public void receice(Object o){
		notifyObservers(o);
	}
}
