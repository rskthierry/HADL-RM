package fr.univnantes.m2.Link;

import fr.univnantes.m2.Connector.RoleTo;
import fr.univnantes.m2.InterfaceComposant.PortInput;

public class AttachmentToInput extends Attachment{
	public AttachmentToInput(PortInput p, RoleTo r) {
		port=p.getName();
		role=r.getName();
	}
}
