package fr.univnantes.m2.Connector;

import fr.univnantes.m2.Configuration.EventInConfiguration;

public class SimpleConnector extends Connector{

	public SimpleConnector(String n) {
		super(n);
	}

	@Override
	public void transmit(Object data) {
		notifyObservers(new EventInConfiguration(roleTo, glue(data)));
	}

	public Object glue(Object data){
		return data;
	}
}
