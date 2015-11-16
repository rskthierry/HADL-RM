package fr.univnantes.m2.InterfaceComposant;

import fr.univnantes.m2.Configuration.Composant;

public class PortOutput extends Port{

	public PortOutput(Composant c) {
		super(c);
	}

	public void send(Object o){
		notifyObservers(o);
	}
}
