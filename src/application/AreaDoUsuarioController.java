package application;

import static javax.swing.JOptionPane.showMessageDialog;

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
    private ListView<String> listView_SalaDisponiveis;

    @FXML
    private TextField textField_NomeCriarSala;

    @FXML
    private Button btn_CriarSala;
    
  
    
    @FXML
    void criarSala (ActionEvent event) throws IOException {
    	
    	String nomeDaSala = textField_NomeCriarSala.getText();
    	int socket =  (int) ((Math.random() * ( 8888 - 3000 )) + 3000);
    	
    	if (!textField_NomeCriarSala.getText().isEmpty()){
    		Sala novaSala = new Sala(nomeDaSala,socket);
    		Main.listaDeSala.add(novaSala);
    		System.out.println("Nome da Sala: "+nomeDaSala+ "Socket"+socket);
    		showMessageDialog(null,"Sala Criada com sucesso!");
    		carregarList(event);
    		System.out.println("2");
    	}
    	else
    		showMessageDialog(null,"Escolha o nome da sala!");
    		System.out.println("1");
    	
    }
    
    @FXML
    void carregarList (ActionEvent event) throws IOException {
    	listView_SalaDisponiveis.getItems().clear();
    	for (int i=0; i<Main.listaDeSala.size(); i++) {
    		listView_SalaDisponiveis.getItems().add(Main.listaDeSala.get(i).getNomeDaSala());
    	}
    	
    }
    
    @FXML
    void voltar (ActionEvent event) throws IOException {
    	
    	Parent tableViewParent1 = FXMLLoader.load(getClass().getResource("ChatMulticastMain.fxml"));
    	Scene tableViewScene1 = new Scene(tableViewParent1,960,540);
    	Stage window = (Stage) btn_Sair.getScene().getWindow();
    	window.setScene(tableViewScene1);
    	window.show();

    }

}
