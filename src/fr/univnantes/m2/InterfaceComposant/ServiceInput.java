package fr.univnantes.m2.InterfaceComposant;

import java.util.Observable;
import java.util.Observer;

import fr.univnantes.m2.Configuration.Composant;

public class ServiceInput extends Service implements Observer{

	public ServiceInput(String n, Composant c) {
		super(n, c);
	}

	public void usePort(PortInput p){
		p.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		exec(arg);
	}

	@Override
	public void exec(Object o) {
		System.out.println(name+ " has been called with :"+o );
	}

}
