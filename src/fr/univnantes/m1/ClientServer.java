package fr.univnantes.m1;

import fr.univnantes.m2.Configuration.Configuration;
import fr.univnantes.m2.Connector.SimpleConnector;
import fr.univnantes.m2.InterfaceComposant.PortInput;
import fr.univnantes.m2.InterfaceComposant.PortOutput;
import fr.univnantes.m2.Link.AttachmentOutputFrom;
import fr.univnantes.m2.Link.AttachmentToInput;
import fr.univnantes.m2.Link.BindingInput;
import fr.univnantes.m2.Link.BindingOutput;

public class ClientServer extends Configuration{

	public ClientServer() {
		super("ClientServer");
		
		//Composants
		Client cl =  new Client();
		addComposant(cl);
		
		Server s = new Server();
		addComposant(s);
		
		//Connectors
		SimpleConnector sc1 = new SimpleConnector("RPC_Response",this);
		SimpleConnector sc2 = new SimpleConnector("RPC_Request",this);
		
		addConnector(sc1);
		addConnector(sc2);
		
		//Attachments
		addAttachment(new AttachmentToInput((PortInput) cl.getPortByName("ReceiveResponsePort"), sc1.getRoleTo()));
		addAttachment(new AttachmentOutputFrom((PortOutput) s.getPortByName("SendResponsePort"), sc1.getRoleFrom()));
		
		addAttachment(new AttachmentOutputFrom((PortOutput) cl.getPortByName("SendRequestPort"), sc2.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) s.getPortByName("ReceiveRequestPort"), sc2.getRoleTo()));
		
		addBinding(new BindingInput((PortInput) s.getPortByName("ExternalSocketPR"), (PortInput) s.getPortByName("ReceiveRequestPort")));
		addBinding(new BindingOutput((PortOutput) s.getPortByName("SendResponsePort"), (PortOutput) s.getPortByName("ExternalSocketPF")));
	}

}
