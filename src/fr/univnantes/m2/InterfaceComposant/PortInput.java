package fr.univnantes.m2.InterfaceComposant;

import fr.univnantes.m2.Configuration.Composant;

public class PortInput extends Port {

	public PortInput(String n, Composant c) {
		super(n, c);
	}
	
	public void receice(Object o){
		System.out.println(name+ " has been called with :"+o );
		setChanged();
		notifyObservers(o);
	}
}
