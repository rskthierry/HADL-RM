package fr.univnantes.m2.Configuration;

public class EventInConfiguration {
	private Object src;
	private Object arg;
	
	public EventInConfiguration(Object src, Object arg){
		this.src=src;
		this.arg=arg;
	}
	
	public Object getSrc() {
		return src;
	}

	public Object getArg() {
		return arg;
	}
	
	public String toString(){
		return "src: "+src+", arg: "+arg;
	}
}
