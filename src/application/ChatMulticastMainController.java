package application;

import java.io.IOException;
import java.net.InetAddress;

import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
public class ChatMulticastMainController {
	
	    @FXML
	    private Button btn_Confirmar;

	    @FXML
	    private TextField txtField_NomeDoUsuario;
	    
	    @FXML
	    void btnConfirmarCliked(ActionEvent event) throws IOException {
	    	String nome = txtField_NomeDoUsuario.getText();
	    	if(!txtField_NomeDoUsuario.getText().isEmpty()) {
	    		System.out.println("nome:"+nome);
	    		String ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
	    		Client novoClient = new Client(nome,ipDaMaquina);
	    		Main.listaDeCliente.add(novoClient);

	    		// Load Tela de Usuario
	        	FXMLLoader loader = new FXMLLoader();
	        	loader.setLocation(getClass().getResource("AreaDoUsuario.fxml"));
	        	Parent tableViewParent = loader.load();
		    	Scene tableViewScene = new Scene(tableViewParent,960,540);
		    	
		    	AreaDoUsuarioController controller = loader.getController();
		    	controller.getNomeDoUsuario(nome);
		    	
		    	Stage window = (Stage) btn_Confirmar.getScene().getWindow();
		    	window.setTitle("Chat Multicast");
		    	window.setScene(tableViewScene);
		    	window.show();
	    	}
	    	else 
	    		showMessageDialog(null,"Voce precisa escolher um nome");
	    }
	    
}