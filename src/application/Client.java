package application;


public class Client {
	
	String nome;
	String ip;
	
	Client(String nome, String ip){
		
		this.nome = nome;
		this.ip = ip;
		
	}

	public Client() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
}
