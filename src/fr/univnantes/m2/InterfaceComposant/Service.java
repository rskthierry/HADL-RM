package fr.univnantes.m2.InterfaceComposant;

import fr.univnantes.m2.Configuration.Composant;

public abstract class Service extends InterfaceComposant{

	public Service(Composant c) {
		super(c);
	}

	public abstract void exec(Object o);
}
