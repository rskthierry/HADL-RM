package fr.univnantes.m2.InterfaceComposant;

import java.util.ArrayList;
import java.util.List;

import fr.univnantes.m2.Configuration.Composant;

public class ServiceOutput extends Service{

	protected List<PortOutput> portOutput;
	
	public ServiceOutput(Composant c) {
		super(c);
		portOutput = new ArrayList<>();
	}

	@Override
	public void exec(Object o){
		send(o);
	}
	
	protected void send(Object o){
		for (PortOutput p: portOutput){
			p.send(o);
		}
	}

}
