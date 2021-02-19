package application;

public class Sala {
	
	int socket;
	String nomeDaSala;
	
	public Sala(String nomeDaSala, int socket) {
		
		this.socket = socket;
		this.nomeDaSala = nomeDaSala;
	}
	
	public int getSala() {
		return socket;
	}
	public void setSala(int socket) {
		this.socket = socket;
	}
	public String getNomeDaSala() {
		return nomeDaSala;
	}
	public void setNomeDaSala(String nomeDaSala) {
		this.nomeDaSala = nomeDaSala;
	}

}
