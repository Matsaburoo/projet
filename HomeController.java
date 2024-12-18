package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
//ORBOT LES BUTTONS HAWKA TSAREF FEHOM
public class HomeController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchtoDeposit(ActionEvent e) throws IOException {
		Parent root=FXMLLoader.load(getClass().getResource("Deposit.fxml"));
		stage=(Stage)((Node)event.getSource().getScene().getWindow());
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoBalance(ActionEvent e) throws IOException{
		Parent root=FXMLLoader.load(getClass().getResource("Balance.fxml"));
		stage=(Stage)((Node)event.getSource().getScene().getWindow());
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchtoWithdraw(ActionEvent e) throws IOException {
		Parent root=FXMLLoader.load(getClass().getResource("Withdraw.fxml"));
		stage=(Stage)((Node)event.getSource().getScene().getWindow());
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoHome(ActionEvent e) throws IOException {
		Parent root=FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage=(Stage)((Node)event.getSource().getScene().getWindow());
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//7OT DEPOSIT WITHDRAW
	public void deposit(int x) {
		
	}
	public void withdraw(int x) {
		
	}
	
}
