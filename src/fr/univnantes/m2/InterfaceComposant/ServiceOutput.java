package fr.univnantes.m2.InterfaceComposant;

import java.util.ArrayList;
import java.util.List;

import fr.univnantes.m2.Configuration.Composant;

public class ServiceOutput extends Service{

	protected List<PortOutput> portOutput;
	
	public ServiceOutput(String n, Composant c) {
		super(n, c);
		portOutput = new ArrayList<>();
	}
	
	public void usePort(PortOutput po){
		portOutput.add(po);
	}

	@Override
	public void exec(Object o){
		System.out.println(name+ " has been called with :"+o );
		send(o);
	}
	
	protected void send(Object o){
		for (PortOutput p: portOutput){
			p.send(o);
		}
	}

}
