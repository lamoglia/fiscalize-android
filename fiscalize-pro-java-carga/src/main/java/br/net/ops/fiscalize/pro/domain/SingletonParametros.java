package br.net.ops.fiscalize.pro.domain;

public class SingletonParametros {

	private String caminhoLog;
	
	private static SingletonParametros singleton = new SingletonParametros();
	
	private SingletonParametros() {
		caminhoLog = null;
	}
	   
	public static SingletonParametros getInstance() {
		return singleton;
	}

	public String getCaminhoLog() {
		return caminhoLog;
	}

	public void setCaminhoLog(String caminhoLog) {
		this.caminhoLog = caminhoLog;
	}
	
}
