/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package librarymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.StageStyle;


public class LoginController implements Initializable {
    
     @FXML
    private Button close;

    @FXML
    private Button minimize;
    
      @FXML
    private Button login_btn;
    
      @FXML
    private TextField studentNumber;

    @FXML
    private PasswordField password;
    
    @FXML
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    

    @FXML
    void login(ActionEvent event) {
        
        String sql = "SELECT * FROM student WHERE studentNumber= ? and password=?";
        
        connect = Database.connectDB();
        
        try {
            prepare = connect.prepareStatement(sql);
            
            prepare.setString(1, studentNumber.getText());
            prepare.setString(2, password.getText() );
            
            result = prepare.executeQuery();
            
            Alert alert;
            
            if(studentNumber.getText().isEmpty() || password.getText().isEmpty()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Admin message");
                    alert.setHeaderText(null);
                    alert.setContentText("S'il vous plaît remplissez tous les champs");
                    alert.showAndWait();
               
            }else{
                if(result.next()){
                    
                    GetData.studentNumber = studentNumber.getText();
                    
                   // GetData.path = result.getString("image");
                    
                    
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Admin message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();
                    
                    // HIDE de login form
                    login_btn.getScene().getWindow().hide();
                    
                    // for Dashboard
                    
                    Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                    
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.initStyle(StageStyle.UNDECORATED);
                    
                   stage.setScene(scene);
                   stage.show();
                    
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Admin message");
                    alert.setTitle(null);
                    alert.setContentText("Wrong username or password.");
                    alert.showAndWait();
                    
                }
                    
            }
            
            
            
        } catch (Exception e) {
        }
        

    }
    
    // ONLY Number Allowed
    
    public void numberOnly(KeyEvent event){
        if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
            event.consume();
            studentNumber.setStyle("-fx-border-color: #e04040");
        }else{
            studentNumber.setStyle("-fx-border-color: #fff");
        }
        
    }
    
      @FXML
    void minimize(ActionEvent event) {
        Stage stage = (Stage)minimize.getScene().getWindow();
        stage.setIconified(true);

    }
    
    
    @FXML
    
    public void exit(){
        System.exit(0);
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
