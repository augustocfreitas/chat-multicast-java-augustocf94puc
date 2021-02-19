package application;

import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChatMulticastMainController {
	
	    @FXML
	    private Button btn_Confirmar;

	    @FXML
	    private TextField txtField_NomeDoUsuario;
	    
	    @FXML
	    void btnConfirmarCliked(ActionEvent event) throws IOException {
	    	
	    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("AreaDoUsuario.fxml"));
	    	Scene tableViewScene = new Scene(tableViewParent,960,540);
	    	Stage window = (Stage) btn_Confirmar.getScene().getWindow();
	    	window.setScene(tableViewScene);
	    	window.show();

	    }
	    
	 
}