package application;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaChatController {
	
	private int socket;
	private String nome;
	private static String msg;

    @FXML
    private Label labelTitleChat;

    @FXML
    private TextField textField_MensagemEnviar;

    @FXML
    private Button btn_EnviarMsg;

    @FXML
    private Button btn_SairDaSala;
    
    @FXML
    private static ListView<String> tableView_MsgRecebidas;
    
    
    private static ObservableList<String> msgRecebidasObs = FXCollections.observableArrayList("Bem Vindo ao Chat!");
    
    private static List<String> msgOutRecebidas = new ArrayList<String>();
    
	
	public void getNomeDoChat (String nome) {
		
		labelTitleChat.setText( labelTitleChat.getText() + nome);
		
	}
	
	public void getDatagramSocket(int socket) {
		this.socket = socket;
	}
	
	@FXML
	
	void mandarMsg (ActionEvent event) throws IOException {
		
		
		 String msg = nome+" : "+ textField_MensagemEnviar.getText(); 
		 //TCPClient.conectarClient(msg,"localhost", 7896);
		 //System.out.println("Resp: "+resposta);
		 //tableView_MsgRecebidas.getItems().add(resposta);
		 MulticastPeer.conectarMulticastPeer(msg, "228.5.6.7");
		 //tableView_MsgRecebidas.getItems().add(msg);
		 
		
	}	

	@FXML
    void sairDoChat (ActionEvent event) throws IOException {
    	
    	Parent tableViewParent3 = FXMLLoader.load(getClass().getResource("AreaDoUsuario.fxml"));
    	Scene tableViewScene3 = new Scene(tableViewParent3,960,540);
    	Stage window = (Stage) btn_SairDaSala.getScene().getWindow();
    	window.setScene(tableViewScene3);
    	window.setTitle("Chat Multicast");
    	window.show();

    }
	
	public void getNomeDoUsuario(String nome) {
		this.nome = nome;
		
	}
	
	
	public static void getMsgRecebidas (String mensagem) 
	{
    	System.out.println("Recebi aqui! " + mensagem );
    	TelaChatController.msg = mensagem;
    	
    	//tableView_MsgRecebidas.getItems().add(mensagem);
		//TelaChatController.msgOutRecebidas.add(mensagem);
		//msgRecebidasObs.addAll(msgOutRecebidas);
		//adicionarNaTable();
	}
	
	
	public static void adicionarNaTable() {
		tableView_MsgRecebidas.getItems().addAll(msgOutRecebidas);
	}
	
	 @FXML
	 public void initialize() throws IOException {
		 

	    	
	 }
	
	
	
}
