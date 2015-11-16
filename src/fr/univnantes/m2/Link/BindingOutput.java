package fr.univnantes.m2.Link;

import fr.univnantes.m2.InterfaceComposant.PortOutput;

public class BindingOutput extends Binding{
	public BindingOutput(PortOutput pcomp, PortOutput pconf){
		portComp=pcomp.getName();
		portConf=pconf.getName();
	}
}
