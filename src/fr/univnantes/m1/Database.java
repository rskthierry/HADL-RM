package fr.univnantes.m1;

import fr.univnantes.m2.Configuration.Composant;
import fr.univnantes.m2.InterfaceComposant.PortInput;
import fr.univnantes.m2.InterfaceComposant.PortOutput;
import fr.univnantes.m2.InterfaceComposant.ServiceInput;
import fr.univnantes.m2.InterfaceComposant.ServiceOutput;

public class Database extends Composant {

	public Database() {
		super("Database");
		
		ServiceInput si1 = new ServiceInput("query_DSR", this);
		PortInput pi1 = new PortInput("query_DPR", this);
		si1.usePort(pi1);
		
		ServiceOutput so1 = new ServiceOutput("query_DSF", this);
		PortOutput po1 = new PortOutput("query_DPF", this);
		so1.usePort(po1);
		
		interfaceComposants.add(pi1);
		interfaceComposants.add(si1);
		interfaceComposants.add(so1);
		interfaceComposants.add(po1);
		
		ServiceInput si2 = new ServiceInput("security_managementSR", this);
		PortInput pi2 = new PortInput("security_managementPR", this);
		si1.usePort(pi2);
		
		ServiceOutput so2 = new ServiceOutput("security_managementSF", this);
		PortOutput po2 = new PortOutput("security_managementPF", this);
		so1.usePort(po2);
		
		interfaceComposants.add(pi2);
		interfaceComposants.add(si2);
		interfaceComposants.add(so2);
		interfaceComposants.add(po2);
	}

}
