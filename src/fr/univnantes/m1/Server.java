package fr.univnantes.m1;

import fr.univnantes.m2.Configuration.Configuration;
import fr.univnantes.m2.Connector.SimpleConnector;
import fr.univnantes.m2.InterfaceComposant.PortInput;
import fr.univnantes.m2.InterfaceComposant.PortOutput;
import fr.univnantes.m2.InterfaceComposant.ServiceInput;
import fr.univnantes.m2.InterfaceComposant.ServiceOutput;
import fr.univnantes.m2.Link.AttachmentOutputFrom;
import fr.univnantes.m2.Link.AttachmentToInput;

public class Server extends Configuration{

	public Server() {
		super("Server");
		
		//Ports and Services
		ServiceInput si = new ServiceInput("ReceiveRequestService", this);
		PortInput pi = new PortInput("ReceiveRequestPort", this);
		
		si.usePort(pi);
		interfaceComposants.add(pi);
		interfaceComposants.add(si);
		
		ServiceOutput so = new ServiceOutput("SendResponseService", this);
		PortOutput po = new PortOutput("SendResponsePort", this);
		so.usePort(po);
		
		interfaceComposants.add(so);
		interfaceComposants.add(po);
		
		//Composants
		ConnectionManager cm =  new ConnectionManager();
		addComposant(cm);
		
		Database db = new Database();
		addComposant(db);
		
		SecurityManager sm = new SecurityManager();
		addComposant(sm);
		
		//Connectors
		SimpleConnector sc1 = new SimpleConnector("SQL_QueryA",this);
		SimpleConnector sc2 = new SimpleConnector("SQL_QueryB",this);
		SimpleConnector sc3 = new SimpleConnector("SecurityQueryA",this);
		SimpleConnector sc4 = new SimpleConnector("SecurityQueryB",this);
		SimpleConnector sc5 = new SimpleConnector("ClearanceRequestA",this);
		SimpleConnector sc6 = new SimpleConnector("ClearanceRequestB",this);
		
		addConnector(sc1);
		addConnector(sc2);
		addConnector(sc3);
		addConnector(sc4);
		addConnector(sc5);
		addConnector(sc6);
		
		//Attachments
		addAttachment(new AttachmentToInput((PortInput) cm.getPortByName("dbQueryPR"), sc1.getRoleTo()));
		addAttachment(new AttachmentOutputFrom((PortOutput) db.getPortByName("query_DPF"), sc1.getRoleFrom()));
		
		addAttachment(new AttachmentOutputFrom((PortOutput) cm.getPortByName("dbQueryPF"), sc2.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) db.getPortByName("query_DPR"), sc2.getRoleTo()));
		
		addAttachment(new AttachmentOutputFrom((PortOutput) db.getPortByName("security_managementPF"), sc3.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) sm.getPortByName("check_queryPR"), sc3.getRoleTo()));
		
		addAttachment(new AttachmentOutputFrom((PortOutput) sm.getPortByName("check_queryPF"), sc4.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) db.getPortByName("security_managementPR"), sc4.getRoleTo()));
		
		addAttachment(new AttachmentOutputFrom((PortOutput) sm.getPortByName("security_authPF"), sc5.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) cm.getPortByName("security_checkPR"), sc5.getRoleTo()));
		
		addAttachment(new AttachmentOutputFrom((PortOutput) cm.getPortByName("security_checkPF"), sc6.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) sm.getPortByName("security_authPR"), sc6.getRoleTo()));
	}

}
