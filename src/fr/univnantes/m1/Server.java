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
		
		ConnectionManager cm =  new ConnectionManager();
		addComposant(cm);
		
		SimpleConnector sc1 = new SimpleConnector("SQL_QueryA");
		SimpleConnector sc2 = new SimpleConnector("SQL_QueryB");
		addConnector(sc1);
		addConnector(sc2);
		
		addAttachment(new AttachmentToInput((PortInput) cm.getPortByName("dbQueryPR"), sc1.getRoleTo()));
		addAttachment(new AttachmentOutputFrom((PortOutput) cm.getPortByName("query_DPF"), sc1.getRoleFrom()));
		
		addAttachment(new AttachmentOutputFrom((PortOutput) cm.getPortByName("dbQueryPF"), sc2.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) cm.getPortByName("query_DPR"), sc2.getRoleTo()));
		
		Database db = new Database();
		addComposant(db);
		
		SimpleConnector sc3 = new SimpleConnector("SecurityQueryA");
		SimpleConnector sc4 = new SimpleConnector("SecurityQueryB");
		addConnector(sc3);
		addConnector(sc4);
		
		addAttachment(new AttachmentOutputFrom((PortOutput) cm.getPortByName("security_managementPF"), sc3.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) cm.getPortByName("check_queryPR"), sc3.getRoleTo()));
		
		addAttachment(new AttachmentOutputFrom((PortOutput) cm.getPortByName("check_queryPF"), sc4.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) cm.getPortByName("security_managementPR"), sc4.getRoleTo()));
		
		SecurityManager sm = new SecurityManager();
		addComposant(sm);
		
		SimpleConnector sc5 = new SimpleConnector("ClearanceRequestA");
		SimpleConnector sc6 = new SimpleConnector("ClearanceRequestB");
		addConnector(sc5);
		addConnector(sc6);
		
		addAttachment(new AttachmentOutputFrom((PortOutput) cm.getPortByName("security_authPF"), sc5.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) cm.getPortByName("security_checkPR"), sc5.getRoleTo()));
		
		addAttachment(new AttachmentOutputFrom((PortOutput) cm.getPortByName("check_queryPF"), sc6.getRoleFrom()));
		addAttachment(new AttachmentToInput((PortInput) cm.getPortByName("security_authPR"), sc6.getRoleTo()));
	}

}
