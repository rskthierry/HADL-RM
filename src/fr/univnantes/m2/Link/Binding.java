package fr.univnantes.m2.Link;

import fr.univnantes.m2.InterfaceComposant.Port;

public abstract class Binding {
	protected Port portComp, portConf;

	public Port getPortComposant() {
		return portComp;
	}

	public Port getPortConfiguration() {
		return portConf;
	}
}
