package fr.univnantes.m2.Link;

import fr.univnantes.m2.Connector.Role;
import fr.univnantes.m2.InterfaceComposant.Port;

public abstract class Attachment extends Link{
	protected Port port;
	protected Role role;

	public Port getPort() {
		return port;
	}

	public Role getRole() {
		return role;
	}
	
	public String toString(){
		return "port: "+port.getName() + ", role "+role.getName();
	}
}
