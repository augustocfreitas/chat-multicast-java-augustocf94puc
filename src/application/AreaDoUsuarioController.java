package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AreaDoUsuarioController {
	
	
    @FXML
    private Button btn_EscolherSala;

    @FXML
    private Button btn_Sair;

    @FXML
    private ListView<?> listView_SalaDisponiveis;

    @FXML
    private TextField textField_NomeCriarSala;

    @FXML
    private Button btn_CriarSala;
    
    
    void btnVoltar(ActionEvent event) throws IOException {
    	
    	Parent tableViewParent1 = FXMLLoader.load(getClass().getResource("ChatMulticastMain.fxml"));
    	Scene tableViewScene1 = new Scene(tableViewParent1,960,540);
    	Stage window = (Stage) btn_Sair.getScene().getWindow();
    	window.setScene(tableViewScene1);
    	window.show();

    }

}
