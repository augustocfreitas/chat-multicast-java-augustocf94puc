package application;
	
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	
	public static List<Client> listaDeCliente = new ArrayList<Client>();
	public static List<Sala> listaDeSala = new ArrayList<Sala>();
	public static DatagramSocket aSocket = null;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ChatMulticastMain.fxml"));
			Scene scene = new Scene(root,960,540);
			primaryStage.setTitle("Chat Multicast");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
