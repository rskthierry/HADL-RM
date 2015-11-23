package fr.univnantes.m2.Connector;

public class RoleFrom extends Role{
	
	private Connector connector;

	public RoleFrom(Connector c,String n) {
		super(n);
		connector = c;
	}

	public void receive(Object data){
		connector.transmit(data);
	}
}
