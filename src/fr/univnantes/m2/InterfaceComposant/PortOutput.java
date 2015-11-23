package fr.univnantes.m2.InterfaceComposant;

import fr.univnantes.m2.Configuration.Composant;

public class PortOutput extends Port{

	public PortOutput(String n, Composant c) {
		super(n, c);
	}

	public void send(Object o){
		System.out.println(name+ " has been called with :"+o );
		setChanged();
		notifyObservers(o);
	}
}
