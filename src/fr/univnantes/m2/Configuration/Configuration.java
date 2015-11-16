package fr.univnantes.m2.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import fr.univnantes.m2.Connector.Connector;
import fr.univnantes.m2.Connector.RoleTo;
import fr.univnantes.m2.InterfaceComposant.PortInput;
import fr.univnantes.m2.InterfaceComposant.PortOutput;
import fr.univnantes.m2.Link.Attachment;
import fr.univnantes.m2.Link.Binding;

public class Configuration extends Composant implements Observer{
	
	List<Composant> composants;
	List<Connector> connectors;
	List<Attachment> attachments;
	List<Binding> bindings;	
	
	public Configuration(String n) {
		super(n);
		composants = new ArrayList<>();
		connectors = new ArrayList<>();
		attachments = new ArrayList<>();
		bindings = new ArrayList<>();
	}

	public void addComposant(Composant c){
		composants.add(c);
	}
	
	public void addConnector(Connector c){
		connectors.add(c);
	}
	
	public void addAttachment(Attachment a){
		attachments.add(a);
	}
	
	public void addBinding(Binding b){
		//TODO verify b
		bindings.add(b);
	}
	
	public void update(Observable o, Object arg) {
		super.update(o, arg);
		
		EventInConfiguration ev = (EventInConfiguration)arg;
		if (ev.getSrc() instanceof PortOutput){
			PortOutput p = (PortOutput) (ev.getSrc());
			for (Attachment att : attachments){
				if (att.getPort().equals(p.getName())){
					for (Connector connec : connectors){
						if (connec.getRoleFrom().getName().equals(att.getRole())){
							connec.transmit(ev.getArg());
						}
					}
				}	
			}
		}
		else if (ev.getSrc() instanceof RoleTo){
			RoleTo r = (RoleTo) (ev.getSrc());
			for (Attachment a : attachments){
				if (a.getRole().equals(r.getName())){
					for (Composant comp : composants){
						PortInput p = (PortInput) (comp.getPortByName(a.getPort()));
						if (p!=null)
							p.receice(ev.getArg());
					}
				}	
			}
		}
	}
}
