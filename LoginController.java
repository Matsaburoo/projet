package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
  
    @FXML
    private Button changepass_back;

    @FXML
    private PasswordField changepass_confirmpass;

    @FXML
    private AnchorPane changepass_form;

    @FXML
    private PasswordField changepass_pass;

    @FXML
    private Button changepass_proceed;

    @FXML
    private TextField forgot_answer;

    @FXML
    private Button forgot_back;

    @FXML
    private AnchorPane forgot_form;

    @FXML
    private Button forgot_proceed;

    @FXML
    private ComboBox<String> forgot_select;

    @FXML
    private TextField forgot_user;

    @FXML
    private Button login_btn;

    @FXML
    private Button login_createacc;

    @FXML
    private Hyperlink login_forgotpass;

    @FXML
    private AnchorPane login_form;

    @FXML
    private PasswordField login_pass;

    @FXML
    private CheckBox login_showpass;

    @FXML
    private TextField login_user;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField signup_answer;

    @FXML
    private Button signup_btn;

    @FXML
    private TextField signup_email;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private Button signup_loginacc;

    @FXML
    private PasswordField signup_pass;

    @FXML
    private PasswordField signup_passconfirm;

    @FXML
    private ComboBox<String> signup_select;

    @FXML
    private TextField signup_user;
   // verify if username is availabe or no //
    boolean verifyUser(String username) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("login.txt"));
        String line = reader.readLine();
        

        while (line!=null) {
            String[] textArray = line.split(" ");
                 
                if (username.equals(textArray[0])) {
                    reader.close(); 
                    return true;
                
            }
            line = reader.readLine();
        }

        reader.close();
        return false;
    }
    
    boolean verifyquestion(String username) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("login.txt"));
        String line = reader.readLine();
        

        while (line!=null) {
            String[] textArray = line.split(" ");
                 
                if (username.equals(textArray[0])) {
                    reader.close(); 
                    return true;
                
            }
            line = reader.readLine();
        }

        reader.close();
        return false;
    }
    public void signupbtn(ActionEvent e) throws IOException {
    	if (e.getSource() == signup_btn) {
    		String email=signup_email.getText();
    		String user=signup_user.getText();
    		String pass=signup_pass.getText();
    		String passconfirm=signup_passconfirm.getText();
    		String selectquestion=signup_select.getValue();
    		String signupanswer=signup_answer.getText();
    		if(email.isEmpty() || user.isEmpty() || pass.isEmpty() || passconfirm.isEmpty() || signupanswer.isEmpty() || selectquestion == null) {
    			Alert alert=new Alert(AlertType.ERROR);
    			alert.setHeaderText("");
    			alert.setContentText("all filds are required");
    			alert.setTitle("Password ERROR");
    			alert.showAndWait();
    		}
    		else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$")) {
	    		    Alert alert = new Alert(AlertType.ERROR);
	    		    alert.setHeaderText("");
	    		    alert.setContentText("Invalid email format.");
	    		    alert.setTitle("Input Error");
	    		    alert.showAndWait();
    			} 
    			
    		
    		else if(!pass.equals(passconfirm)) {
    			Alert alert=new Alert(AlertType.ERROR);
    			alert.setHeaderText("");
    			alert.setContentText("ERROR! Passwords must match");
    			alert.setTitle("Password ERROR");
    			alert.showAndWait();
    		}
    		else if(pass.length()<8) {
    			Alert alert=new Alert(AlertType.ERROR);
    			alert.setHeaderText("");
    			alert.setContentText("ERROR! Passwords must be at least 8 caracters");
    			alert.setTitle("Password ERROR");
    			alert.showAndWait();
    		}
    		else if(verifyUser(user)) {
    			Alert alert=new Alert(AlertType.ERROR);
    			alert.setHeaderText("");
    			alert.setContentText("ERROR! username exist");
    			alert.setTitle("Password ERROR");
    			alert.showAndWait();
    		}
    		else {
    		String userContent=user+" "+pass+" "+email+" "+selectquestion+" "+signupanswer;
    		writeToFile(userContent);
    		}}
    	
    		
    		
    	}
    	
    
    //function to set values to both boxcombos//
    public void initialize() {
     
        ObservableList<String> securityQuestions = FXCollections.observableArrayList(
        	"What was the name of your first childhood pet?",
        	"In which city did your parents meet?",
        	"What is your favorite childhood vacation destination?",
        	"What was the name of your first school teacher?", 
        	"What is your favorite book from childhood?",
        	"What was the make and model of your first car?"
        );
        ObservableList<String> securityQuestions2 = FXCollections.observableArrayList(
        		"What was the name of your first childhood pet?",
            	"In which city did your parents meet?",
            	"What is your favorite childhood vacation destination?",
            	"What was the name of your first school teacher?", 
            	"What is your favorite book from childhood?",
            	"What was the make and model of your first car?"
            );
        
        forgot_select.setItems(securityQuestions2);
        signup_select.setItems(securityQuestions);
    }
    //function to adduser details in the file//
    public void writeToFile(String content) {
        try {
        	BufferedWriter write = new BufferedWriter(new FileWriter("login.txt",true)); 
            write.write(content);
            write.newLine();
            write.close();  
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    // Action method for creating an account
    public void createacc(ActionEvent e) {
        if (e.getSource() == login_createacc) {
            login_form.setVisible(false);
            signup_form.setVisible(true);
        }
    }

    // Action method for forgot password
    public void forgotpass(ActionEvent e) {
        if (e.getSource() == login_forgotpass) {
            login_form.setVisible(false);
            forgot_form.setVisible(true);
            
        }
    }

    // Action method for changing password
    public void changepass(ActionEvent e) throws IOException {
    	
        if (e.getSource() == forgot_proceed) {
        	
        	String forgotuser=forgot_user.getText();
        	String forgotselect=forgot_select.getValue();
        	String forgotanswer=forgot_answer.getText();
        	if(forgotuser.isEmpty()||forgotselect==null||forgotanswer.isEmpty()) {
        		Alert alert=new Alert(AlertType.ERROR);
        		alert.setContentText(" ALL FIELDS ARE REQUIRED ");
        		alert.setHeaderText("");
        		alert.setTitle("FIELD ERROR");
        		alert.showAndWait();
        	}
        	else if(!verifyUser(forgotuser)) {
        		Alert alert=new Alert(AlertType.ERROR);
        		alert.setContentText(" USER DOSENT MATCH");
        		alert.setHeaderText("");
        		alert.setTitle("USER ERROR");
        		alert.showAndWait();
        		
        	}
        	else {
        		forgot_form.setVisible(false);
                changepass_form.setVisible(true);
        	}
            
        }
    }

    // Action method for logging into an account
    public void loginAccount(ActionEvent e) {
        if (e.getSource() == signup_loginacc) {
            signup_form.setVisible(false);
            login_form.setVisible(true);
        }
    }
    
    boolean verifyUserInfos(String username, String password) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("login.txt"));
        String line = reader.readLine();
        

        while (line!=null) {
            String[] textArray = line.split(" ");
                 
                if (username.equals(textArray[0]) && password.equals(textArray[1])) {
                    reader.close(); 
                    return true;
                
            }
            line = reader.readLine();
        }

        reader.close();
        return false;
    }

 
    
    //function to verify if user in  the data base or no//
    public void loginbtn(ActionEvent e) throws IOException {
    	if (e.getSource()==login_btn) {
    		String labeltext=login_user.getText();
    		String passwordtext=login_pass.getText();
    		boolean a= verifyUserInfos(labeltext,passwordtext);
    		if (a==true) {
    			Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Login Information");
                alert.setHeaderText(""); 
                alert.setContentText("welcome"+" "+labeltext);
                Image icon = new Image("pic.jpg");
                Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
                alertStage.getIcons().add(icon);
                alert.showAndWait();
    			
    		}
    		else {
    			
        		Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Login Information");
                alert.setHeaderText(""); 
                alert.setContentText("please checkout yourpassword/username");
                Image icon = new Image("pic.jpg");
                Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
                alertStage.getIcons().add(icon);
                alert.showAndWait();
    		}
           

            
    	}
    }
    // Action method for going back from forgot password
    public void forgotback(ActionEvent e) {
        if (e.getSource() == forgot_back) {
            forgot_form.setVisible(false);
            login_form.setVisible(true);
        }
    }

    // Action method for going back from change password
    public void changepassback(ActionEvent e) {
        if (e.getSource() == changepass_back) {
            changepass_form.setVisible(false);
            forgot_form.setVisible(true);
        }
    }
}
