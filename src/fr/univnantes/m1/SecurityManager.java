package fr.univnantes.m1;

import fr.univnantes.m2.Configuration.Composant;
import fr.univnantes.m2.InterfaceComposant.PortInput;
import fr.univnantes.m2.InterfaceComposant.PortOutput;
import fr.univnantes.m2.InterfaceComposant.ServiceInput;
import fr.univnantes.m2.InterfaceComposant.ServiceOutput;

public class SecurityManager extends Composant{

	public SecurityManager() {
		super("SecurityManager");
		
		ServiceInput si1 = new ServiceInput("security_authSR", this);
		PortInput pi1 = new PortInput("security_authPR", this);
		si1.usePort(pi1);
		
		ServiceOutput so1 = new ServiceOutput("security_authSF", this);
		PortOutput po1 = new PortOutput("security_authPF", this);
		so1.usePort(po1);
		
		interfaceComposants.add(pi1);
		interfaceComposants.add(si1);
		interfaceComposants.add(so1);
		interfaceComposants.add(po1);
		
		ServiceInput si2 = new ServiceInput("check_querySR", this);
		PortInput pi2 = new PortInput("check_queryPR", this);
		si1.usePort(pi2);
		
		ServiceOutput so2 = new ServiceOutput("check_querySF", this);
		PortOutput po2 = new PortOutput("check_queryPF", this);
		so1.usePort(po2);
		
		interfaceComposants.add(pi2);
		interfaceComposants.add(si2);
		interfaceComposants.add(so2);
		interfaceComposants.add(po2);
	}

}
