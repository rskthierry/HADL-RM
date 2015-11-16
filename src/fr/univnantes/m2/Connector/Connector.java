package fr.univnantes.m2.Connector;

import java.util.Observable;

public abstract class Connector extends Observable {
	protected RoleFrom roleFrom;
	protected RoleTo roleTo;
	
	public Connector(RoleFrom rf, RoleTo rt){
		roleFrom=rf;
		roleTo=rt;
	}

	public RoleFrom getRoleFrom() {
		return roleFrom;
	}

	public abstract void transmit(Object data);
}
