package fr.univnantes.m2.Link;

import fr.univnantes.m2.InterfaceComposant.PortInput;

public class BindingInput extends Binding{
	public BindingInput(PortInput pcomp, PortInput pconf){
		portComp=pcomp;
		portConf=pconf;
	}
}
