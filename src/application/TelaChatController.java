package application;


import java.io.IOException;
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
	
	int socket;
	String nome;

    @FXML
    private Label labelTitleChat;

    @FXML
    private TextField textField_MensagemEnviar;

    @FXML
    private Button btn_EnviarMsg;

    @FXML
    private Button btn_SairDaSala;
    
    @FXML
    private ListView<String> tableView_MsgRecebidas;
	
	public void getNomeDoChat (String nome) {
		
		labelTitleChat.setText( labelTitleChat.getText() + nome);
		
	}
	
	public void getDatagramSocket(int socket) {
		this.socket = socket;
	}
	
	@FXML
	
	void mandarMsg (ActionEvent event) throws IOException {
		
		
		 String msg = nome+" : "+ textField_MensagemEnviar.getText(); 
		 String resposta = TCPClient.conectarClient(msg,"localhost", 7896);
		 //System.out.println("Resp: "+resposta);
		 tableView_MsgRecebidas.getItems().add(resposta);

		 
		
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
	
	 @FXML
	 public void initialize() throws IOException {
		 
		 
	 }
	
	
	
}
