package fr.univnantes.m2.Connector;

import java.util.Observable;

import fr.univnantes.m2.Configuration.Configuration;

public abstract class Connector extends Observable {
	protected String name;
	protected RoleFrom roleFrom;
	protected RoleTo roleTo;
	protected Configuration configuration;
	
	public Connector(String n){
		name=n;
		roleFrom=new RoleFrom(this, n+"_roleFrom");
		roleTo=new RoleTo(n+"_roleTo");
	}
	
	public void setConfiguration(Configuration c){
		if (configuration!=null)
			configuration.removeConnector(this);
		configuration=c;
		deleteObservers();
		addObserver(c);
	}

	public RoleFrom getRoleFrom() {
		return roleFrom;
	}
	
	public RoleTo getRoleTo() {
		return roleTo;
	}

	public abstract void transmit(Object data);
}
