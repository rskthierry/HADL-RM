package fr.univnantes.m2.InterfaceComposant;

import java.util.Observable;

import fr.univnantes.m2.Configuration.Composant;

public abstract class InterfaceComposant extends Observable{
	protected String name;
	
	public String getName() {
		return name;
	}

	public InterfaceComposant(Composant c){
		addObserver(c);
	}
	
	// TODO: add visibility
}
