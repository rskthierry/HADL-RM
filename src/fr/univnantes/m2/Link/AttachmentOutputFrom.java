package fr.univnantes.m2.Link;

import fr.univnantes.m2.Connector.RoleFrom;
import fr.univnantes.m2.InterfaceComposant.PortOutput;

public class AttachmentOutputFrom extends Attachment {
	public AttachmentOutputFrom(PortOutput p, RoleFrom r) {
		port=p;
		role=r;
	}
}
