package fr.univnantes.m2.Configuration;

public abstract class Property {
	protected String property;
	
	public Property(String p){
		property=p;
	}
	
	public String getProperty(){
		return property;
	}
}
