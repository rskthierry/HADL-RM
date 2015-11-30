package fr.univnantes.m1.data;

public abstract class Data {
	private DataType dataType;
	private String idSender;

	public Data(DataType dt, String idS){
		dataType=dt;
		idSender=idS;
	}

	public DataType getDataType() {
		return dataType;
	}
	
	public String getIdSender() {
		return idSender;
	}
}
