
package librarymanagement;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;



/**
 * FXML Controller class
 *
 * @author bahsi
 */
public class DashboardController implements Initializable {
    
    @FXML
    private Button availableBooks_btn;

    @FXML
    private AnchorPane availableBooks_forms;

    @FXML
    private ImageView availableBooks_imageView;

    @FXML
    private TableView<AvailableBooks> availableBooks_tableView;

    @FXML
    private Label avalaibleBooks_title;

    @FXML
    private Circle circle_image;

    @FXML
    private TableColumn<AvailableBooks, String> col_ab_Bookstype;

    @FXML
    private TableColumn<AvailableBooks, String> col_ab_author;

    @FXML
    private TableColumn<AvailableBooks, String> col_ab_bookstitle;

    @FXML
    private TableColumn<AvailableBooks, Date> col_ab_publishedDate;

    @FXML
    private Button issueBooks_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private Button returnBooks_btn;

    @FXML
    private Button save_btn;

    @FXML
    private Button savedBooks_btn;

    @FXML
    private Label studentNumber_label;

    @FXML
    private Button take_btn;
    
      @FXML
    private Button minimize;
      
        @FXML
    private Button close;
        
         @FXML
    private Button arrow_btn;
         
          @FXML
    private Button bars_btn;
          
           @FXML
    private AnchorPane nav_form;
           
           @FXML
    private AnchorPane mainCenter_form;
           
            @FXML
    private Button halNav_takeBtn;

    @FXML
    private Button halfNav_availableBtn;

    @FXML
    private Button halfNav_returnBtn;

    @FXML
    private Button halfNav_saveBtn;
    
    @FXML
    private Circle smallCircleImage;
    
      @FXML
    private AnchorPane halfNav_form;
      
      @FXML
    private AnchorPane savedBook_form;
    
       @FXML
    private AnchorPane returnBook_form;
       
       
    @FXML
    private Label currentform_label;
    
    
    @FXML
    private TextField take_BookTitle;

  //  @FXML
    //private Label take_StudentNumber;
    
    @FXML
    
    private TextField take_StudentNumber;

    @FXML
    private Label take_authorLabel;
    
      @FXML
    private FontAwesomeIcon edit_icon;
      
      @FXML
    private Button edit_btn;
   

    
    

    @FXML
    private Button take_clearBtn;

    @FXML
    private Label take_dateLabel;

    @FXML
    private TextField take_firstname;

    @FXML
    private ComboBox<?> take_gender;

    @FXML
    private Label take_genreLabel;

    @FXML
    private ImageView take_imageView;

    @FXML
    private Label take_issuedDate;

    @FXML
    private TextField take_lastname;

    @FXML
    private Button take_takeBtn;

    @FXML
    private Label take_titleLabel;
   
    
      @FXML
    private TableColumn<ReturnBook, String> return_BookTitle;

    @FXML
    private TableColumn<ReturnBook, String> return_BookType;

    @FXML
    private TableColumn<ReturnBook, String> return_author;

    @FXML
    private Button return_button;

    @FXML
    private ImageView return_imageView;

    @FXML
    private TableColumn<ReturnBook, Date> return_issueDate;

    @FXML
    private TableView<ReturnBook> return_tableView;
    
    
     @FXML
    private TableColumn<saveBook, String> col_saveAuthor;

    @FXML
    private TableColumn<saveBook, String> col_saveGenre;

    @FXML
    private TableColumn<saveBook, Date> col_savePublishedDate;

    @FXML
    private TableView<saveBook> col_saveTableView;

    @FXML
    private TableColumn<saveBook, String> col_saveTitle;
    
    @FXML
    private ImageView save_imageView;
    
    @FXML
    private Button unsaveBtn;
    
    
   
      
           
           
          
        
          
    public void sliderArrow(){
        
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(.5));
        slide.setNode(nav_form);
   
        slide.setToX(-215);
        
        
        
        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(.5));
        
        slide1.setNode(mainCenter_form);
        //mainCenter_form.setMinWidth(508);
        slide1.setToX(-215+68); 
        
     
        
        TranslateTransition slide2 = new TranslateTransition();
        slide2.setDuration(Duration.seconds(.5));
        slide2.setNode(halfNav_form);
        slide2.setToX(0);
        
       
        
        slide.setOnFinished((ActionEvent event) ->{
            arrow_btn.setVisible(false);
            bars_btn.setVisible(true);
        });
        
        slide2.play();
        slide1.play();
        slide.play();
    }
    
    public void sliderBars(){
        TranslateTransition slide = new TranslateTransition();
        
        slide.setDuration(Duration.seconds(.5));
        slide.setNode(nav_form);
        slide.setToX(0);
        
         TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(.5));
        
        slide1.setNode(mainCenter_form);
        
        //mainCenter_form.setMinWidth(508);
        slide1.setToX(0);
        
        
         TranslateTransition slide2 = new TranslateTransition();
        slide2.setDuration(Duration.seconds(.5));
        slide2.setNode(halfNav_form);
        slide2.setToX(-68);
        
        slide.setOnFinished((ActionEvent event) ->{
            arrow_btn.setVisible(true);
            bars_btn.setVisible(false);
            
        });
        
        slide2.play();
        slide1.play();
        slide.play();
        
    }
    
    @FXML
    private AnchorPane issue_form;
    
    private Image image;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement stmt;
    private ResultSet result;
    
    private String comboBox[] = {"Male","Female"};
    
    public void gender(){
        
        List<String> combo = new ArrayList<>();
        
        
        
        for(String data: comboBox){
            combo.add(data);
        }
        
       ObservableList list = FXCollections.observableList(combo);
       
       take_gender.setItems(list);
         
    }
    
    public void takeBook(){
        
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "INSERT INTO take values(?,?,?,?,?,?,?,?,?,?)";
        
        connect = Database.connectDB();
        
        try {
            Alert alert;
            
            if (take_StudentNumber.getText().isEmpty() || take_lastname.getText().isEmpty() || take_firstname.getText().isEmpty() || take_gender.getSelectionModel().isEmpty()){
                
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin message");
                alert.setHeaderText(null);
                alert.setContentText("S'il vous plaît completez les détails de l'etudiant");
                alert.showAndWait();
            }
            
            else if(take_titleLabel.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin message");
                alert.setHeaderText(null);
                alert.setContentText("S'il vous plaît indiquez le livre que vous voulez predre");
                alert.showAndWait();
            }
            
            else{
                
                prepare = connect.prepareStatement(sql);
                
                prepare.setString(1, take_StudentNumber.getText());
                prepare.setString(2, take_firstname.getText());
                prepare.setString(3, take_lastname.getText());
                prepare.setString(4, (String)take_gender.getSelectionModel().getSelectedItem());
                prepare.setString(5, take_titleLabel.getText());
                prepare.setString(6,take_authorLabel.getText());
                prepare.setString(7, take_genreLabel.getText());
                
                prepare.setString(8, GetData.path);
                prepare.setDate(9, sqlDate);
                
                String check = "Not return";
                
                prepare.setString(10, check);
                
                prepare.executeUpdate();
                
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("LE livre est pris avec succes!!");
                alert.showAndWait();
                
            
            }
            
            clearTakeData();
            
           
        } catch (Exception e) {
        }
        
    }
    
    
    
    public void findBook(ActionEvent ib){
        
        
       clearFindData();
       String sql = "SELECT * FROM book WHERE bookTitle = '"+take_BookTitle.getText().trim()+"'";
       connect = Database.connectDB();
       
      
      
        try {
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            
            boolean check = false;
            
            Alert alert;
            
            
            if(take_BookTitle.getText().trim().isEmpty()){
                
                System.out.println("le champs est vide");
         
                alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("Admin message");
                alert.setHeaderText(null);
                alert.setContentText("S'il vout plaît Selectionné le livre");
                alert.showAndWait();
            }
           
            
            else{
                while(result.next()){
                    
                    System.out.println(result);
                    
                    take_titleLabel.setText(result.getString("bookTitle"));
                    take_authorLabel.setText(result.getString("author"));
                    take_genreLabel.setText(result.getString("bookType"));
                    take_dateLabel.setText(result.getString("date"));
                    
                    GetData.path = result.getString("image");
                    String uri = "file:"+GetData.path;
                    
                    image = new Image(uri,133,124, false, true);
                    take_imageView.setImage(image);
                    
                    check = true;
                    
                }
                
                if(!check){
                    
                    take_titleLabel.setText("Book is not available !");
                    
                }
            }
            
           
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            
        }
      
        
    }
    
   // public void studentNumberLabel(){
        
       // take_StudentNumber.setText(GetData.studentNumber);
   // }
    
    public void clearTakeData(){
        take_StudentNumber.setText("");
        take_firstname.setText("");
        take_lastname.setText("");
        
        
        take_BookTitle.setText("");
        take_titleLabel.setText("");
        take_authorLabel.setText("");
        take_genreLabel.setText("");
        take_dateLabel.setText("");
        take_imageView.setImage(null);
    }
    
    public void clearFindData(){
        
        take_titleLabel.setText("N/A");
        take_authorLabel.setText("N/A");
        take_genreLabel.setText("N/A");
        take_dateLabel.setText("N/A");
        take_imageView.setImage(null);
        
    }
    
    public void displayData(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        take_issuedDate.setText(date);
        
    }
  
    
    public ObservableList<ReturnBook> returnBookData(){
        
        ObservableList<ReturnBook> listReturnBook = FXCollections.observableArrayList();
        
        String check = "Not return";
        
        String sql = "SELECT * FROM take WHERE checkReturn = '"+check+"' and studentNumber = '" + GetData.studentNumber+"'";
        
        connect = Database.connectDB();
        
        try {
            ReturnBook rbooks;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                
               rbooks = new ReturnBook(result.getString("bookTitle"), result.getString("author"), result.getString("bookType"), result.getString("image"), result.getDate("date"));
               
                
               listReturnBook.add(rbooks);
            }
            
            
            
        } catch (Exception e) {
        }
        
        return listReturnBook;  
        
    }
    
    
    public void returnBooks(){
        String sql = "UPDATE take SET checkReturn = 'Returned' WHERE bookTitle = '"+GetData.takeBookTitle+ "'";
        
        connect = Database.connectDB();
        
        Alert alert;
        
        
        try {
            
            if (return_imageView.getImage() == null){
                
                alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("Admin message");
                alert.setHeaderText(null);
                alert.setContentText("S'il vous plaît selectionnez le livre que vous souhaitez retourner");
                alert.showAndWait();
            }else{
                
                stmt = connect.createStatement();
                stmt.executeUpdate(sql);
                
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin message");
                alert.setHeaderText(null);
                alert.setContentText("Retourné avec succes");
                alert.showAndWait();
                
                showReturnBooks();
                
                return_imageView.setImage(null);
                
            }
            
           
             
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
    private ObservableList<ReturnBook> returnData;
    
    public void showReturnBooks(){
        
        returnData = returnBookData();
        
        return_BookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        return_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        return_BookType.setCellValueFactory(new PropertyValueFactory<>("genre"));
        return_issueDate.setCellValueFactory(new PropertyValueFactory<>("genre"));
        return_issueDate.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        return_tableView.setItems(returnData);      
    }
    
    public void selectReturnBook(){
        
        ReturnBook rbook = return_tableView.getSelectionModel().getSelectedItem();
        int num = return_tableView.getSelectionModel().getFocusedIndex();
        
        if((num-1) < -1){
            return;
        }
        
        String uri = "file:"+rbook.getImage();
        image = new Image(uri, 180,174,false, true);
        return_imageView.setImage(image);
        
        GetData.takeBookTitle = rbook.getTitle();
        
    }
   
    ObservableList<AvailableBooks> dataList(){
        
        ObservableList<AvailableBooks> listBooks = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM book";
        
        connect = Database.connectDB();
        
        try {
            AvailableBooks abooks;
            prepare = connect.prepareStatement(sql);
            
           result= prepare.executeQuery();
           
           while(result.next()){
               
               abooks = new AvailableBooks(result.getString("bookTitle"), result.getString("author"), result.getString("bookType"), result.getString("image"), result.getDate("date"));
               
               listBooks.add(abooks);
           }
           
        } catch (Exception e) {
        }
        
        return listBooks;
        
        
    }
    
    // Enregister un livre
    
    public ObservableList<saveBook> savaBooksData(){
        
        ObservableList<saveBook> listsaveData = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM save ";
        
        connect = Database.connectDB();
        try {
            
            saveBook sBook;
            
            prepare = connect.prepareStatement(sql);
            
            result = prepare.executeQuery();
            
            while(result.next()){
                sBook = new saveBook(result.getString("bookTitle"), result.getString("author"), result.getString("bookType"),
                        result.getString("image"), result.getDate("date"));
                
                
                listsaveData.add(sBook);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listsaveData;
        
        
    }
    
    private ObservableList<saveBook> sBookList;
    
    public void showSavedBooks(){
        
        sBookList = savaBooksData();
        
        col_saveTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_saveAuthor.setCellValueFactory(new PropertyValueFactory<>("author") );
        col_saveGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_savePublishedDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        col_saveTableView.setItems(sBookList);
          
        
    }
    
    public void selectSavedBooks(){
        
        saveBook sBook = col_saveTableView.getSelectionModel().getSelectedItem();
       
        int num = col_saveTableView.getSelectionModel().getFocusedIndex();
        
        if ((num-1) < -1){
            return;
        }
        
        String uri = "file:" + sBook.getImage();
        
        image = new Image(uri, 142, 145, false, true);
        
        save_imageView.setImage(image);
        
        GetData.savedImage = sBook.getImage();
        GetData.savedTitle = sBook.getTitle();
        
        
        
    }
    
    public void saveBooks(){
        
        String sql = "INSERT INTO save VALUES(?,?,?,?,?,?)";
        
        connect = Database.connectDB();
        
        try {
            
            Alert alert;
            if(avalaibleBooks_title.getText().isEmpty()){
                
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin message");
                alert.setHeaderText(null);
                alert.setContentText("S'il vous plaît selectionnez le livre");
                alert.showAndWait();
                
            }else{
                
                prepare = connect.prepareStatement(sql);

                prepare.setString(1, GetData.studentNumber);
                prepare.setString(2, GetData.savedTitle);
                prepare.setString(3, GetData.savedAuthor);
                prepare.setString(4, GetData.savedGenre);
                prepare.setString(5, GetData.savedImage);
                prepare.setDate(6, new java.sql.Date(GetData.savedDate.getTime()));


                prepare.executeUpdate();
                
                
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Saved.");
                alert.showAndWait();
                
                showSavedBooks();
                
            }
            
            
        
        } catch (Exception e) {
        }
        
    }
    
    public void unsaveBooks(){
        
        String sql = "DELETE FROM save WHERE bookTitle ='"+ GetData.savedTitle + "'" + "and studentNumber= '"+ GetData.studentNumber +"'";
                
        connect = Database.connectDB();
        
        try {
            
            Alert alert;
            
            
            
            if (save_imageView.getImage() == null){
                
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin message");
                alert.setHeaderText(null);
                alert.setContentText("S'il vous plaît selectionné le livre que vous voulez retirer");
                alert.showAndWait();
                
         
            }else{
                
                stmt = connect.createStatement();

                stmt.executeUpdate(sql);  
                
                alert = new Alert(Alert.AlertType.INFORMATION);
                
                alert.setTitle("Admin message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully unsave");
                alert.showAndWait();
                
                showSavedBooks();
                
                save_imageView.setImage(null);
                
                
            
            }
            
            
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        
    }
    
    // Pour voir les données des livres
    
    private ObservableList<AvailableBooks> listBook;
    
    public void showAvailableBooks(){
        
        listBook = dataList();
        
        col_ab_bookstitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        
        col_ab_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_ab_Bookstype.setCellValueFactory(new PropertyValueFactory<>("genre") );
        col_ab_publishedDate.setCellValueFactory(new PropertyValueFactory<>("date") );
        
        
        availableBooks_tableView.setItems(listBook);
      
    }
    
    public void selectAvailableBook(){
        
        AvailableBooks bookData = availableBooks_tableView.getSelectionModel().getSelectedItem();
        
        int num = availableBooks_tableView.getSelectionModel().getFocusedIndex();
        
        if((num-1)< -1)
            return;
        
        avalaibleBooks_title.setText(bookData.getTitle());
        
        // Cette ligne est requise pour afficher l'image
        
        String uri = "file:"+ bookData.getImage();
        image = new Image(uri, 146,149, false, true);
        availableBooks_imageView.setImage(image);
        
        GetData.takeBookTitle = bookData.getTitle();
        
        GetData.savedTitle = bookData.getTitle();
        GetData.savedAuthor = bookData.getAuthor();
        GetData.savedGenre  = bookData.getGenre();
        GetData.savedImage = bookData.getImage();
        GetData.savedDate = bookData.getDate();
        
        
        
        
        
    }
    
    public void abTakeButton(ActionEvent event){
        
        if(event.getSource() == take_btn){
            
         issue_form.setVisible(true);
          availableBooks_forms.setVisible(false);
          savedBook_form.setVisible(false);
          returnBook_form.setVisible(false);
            
            issueBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            availableBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            returnBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            savedBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            halNav_takeBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            halfNav_availableBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_returnBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_saveBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            currentform_label.setText("Issue Books");
           
             
        }
       
        
    }
    
    
    public void studentNumber(){
        
        studentNumber_label.setText(GetData.studentNumber);
    }
    
    public void insertImage(){
        
        FileChooser open = new FileChooser();
        
        open.setTitle("Image File");
        
        open.getExtensionFilters().add(new ExtensionFilter("Image file", "*png", "*jpg" ));
    
        Stage stage = (Stage)nav_form.getScene().getWindow();
        
        File file = open.showOpenDialog(stage);
        
        if (file != null){
            
            image = new Image(file.toURI().toString(), 102, 90, false ,true);
            circle_image.setFill(new ImagePattern(image));
            smallCircleImage.setFill(new ImagePattern(image));
            
            GetData.path = file.getAbsolutePath();
            
            changeProfile();
            
           
        }
       
    }
    
    public void changeProfile(){
        
        String uri = GetData.path;
        uri = uri.replace("\\", "\\\\");
        
        
        String sql = "UPDATE student SET image='+"+ uri +"'WHERE studentNumber = '"+ GetData.studentNumber +"'";
        
        connect = Database.connectDB();
        
        
        try {
            stmt = connect.createStatement();
            
            stmt.executeUpdate(sql);
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    public void showProfile(){
        
        String uri ="file:"+ GetData.path;
        
        // image = new Image(uri, 102, 90, false ,true);
           // circle_image.setFill(new ImagePattern(image));
          //  smallCircleImage.setFill(new ImagePattern(image));
        
        
    }
    
    public void desingInsertImage(){
        edit_btn.setVisible(false);
        
        
      circle_image.setOnMouseEntered((MouseEvent event)->{
          
          edit_btn.setVisible(true);
          
     
      });
      
      circle_image.setOnMouseExited((MouseEvent event)->{
          
          edit_btn.setVisible(false);
          
      });
      
      edit_btn.setOnMouseEntered((MouseEvent event)->{
          
          edit_btn.setVisible(true);
          edit_icon.setFill(Color.valueOf("#fff"));
          
          
      });
      
      edit_btn.setOnMousePressed((MouseEvent event)->{
          
          edit_btn.setVisible(true);
          edit_icon.setFill(Color.RED);
          
      });
      
      edit_btn.setOnMouseExited((MouseEvent event)->{
          
          edit_btn.setVisible(false);
          
      });
        
    }
    

    
    public void sideNavButtonDesign(ActionEvent event){
        
        if(event.getSource() == halfNav_availableBtn){
            
            issue_form.setVisible(false);
         availableBooks_forms.setVisible(true);
          savedBook_form.setVisible(false);
          returnBook_form.setVisible(false);
           
            
            availableBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            issueBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            returnBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            savedBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            halfNav_availableBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            halNav_takeBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_returnBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_saveBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            currentform_label.setText("Available Books");
            
        }else if (event.getSource() == halNav_takeBtn){
            
          issue_form.setVisible(true);
          availableBooks_forms.setVisible(false);
          savedBook_form.setVisible(false);
          returnBook_form.setVisible(false);
            
             issueBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            availableBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            returnBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            savedBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            halNav_takeBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            halfNav_availableBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_returnBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_saveBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            currentform_label.setText("Issue Books");
            
        }else if (event.getSource() == halfNav_returnBtn){
            
              issue_form.setVisible(false);
          availableBooks_forms.setVisible(false);
          savedBook_form.setVisible(false);
          returnBook_form.setVisible(true);
            
             returnBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            availableBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            issueBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            savedBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
             halfNav_returnBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            halfNav_availableBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halNav_takeBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_saveBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            currentform_label.setText("Return Books");
            
            showReturnBooks();
            
        }else if (event.getSource() == halfNav_saveBtn){
            
             issue_form.setVisible(false);
          availableBooks_forms.setVisible(false);
          savedBook_form.setVisible(true);
          returnBook_form.setVisible(false);
            
            
            
            savedBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            availableBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            issueBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            returnBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            halfNav_saveBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            halfNav_availableBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halNav_takeBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_returnBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            currentform_label.setText("Saved Books");
            
        }
        
        
    }
    
    public void navButtonDesign(ActionEvent event){
        
        if(event.getSource() == availableBooks_btn ){
            
          issue_form.setVisible(false);
         availableBooks_forms.setVisible(true);
          savedBook_form.setVisible(false);
          returnBook_form.setVisible(false);
           
            
            availableBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            issueBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            returnBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            savedBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            halfNav_availableBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            halNav_takeBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_returnBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_saveBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            currentform_label.setText("Available Books");
        }else if (event.getSource() == issueBooks_btn) {
            
          issue_form.setVisible(true);
          availableBooks_forms.setVisible(false);
          savedBook_form.setVisible(false);
          returnBook_form.setVisible(false);
            
             issueBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            availableBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            returnBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            savedBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            halNav_takeBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            halfNav_availableBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_returnBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_saveBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            currentform_label.setText("Issue Books");
            
        } else if (event.getSource() == returnBooks_btn){
            
            
          issue_form.setVisible(false);
          availableBooks_forms.setVisible(false);
          savedBook_form.setVisible(false);
          returnBook_form.setVisible(true);
            
             returnBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            availableBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            issueBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            savedBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
             halfNav_returnBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            halfNav_availableBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halNav_takeBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_saveBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            currentform_label.setText("Return Books");
            
            showReturnBooks();
            
        }else if (event.getSource() == savedBooks_btn){
            
            issue_form.setVisible(false);
          availableBooks_forms.setVisible(false);
          savedBook_form.setVisible(true);
          returnBook_form.setVisible(false);
            
            
            
            savedBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            availableBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            issueBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            returnBooks_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            halfNav_saveBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #46589a,#4278a7);");
            halfNav_availableBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halNav_takeBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            halfNav_returnBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #344375,#3a6389);");
            
            currentform_label.setText("Saved Books");
            
            showSavedBooks();
            
        }
    }
    
    
    
    private double x = 0;
    private double y = 0;
    
    public void logout(ActionEvent event){
        
        try {
              if(event.getSource()== logout_btn){
            
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            
            root.setOnMousePressed((MouseEvent e) -> {
                x = e.getSceneX();
                y = e.getSceneY();
                
            });
            
             root.setOnMouseDragged((MouseEvent e) -> {
                 
                 stage.setX(e.getSceneX() - x);
                 stage.setY(e.getScreenY() - y);
                 
            });
            
            
            
            
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            
            logout_btn.getScene().getWindow().hide();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }
    
    public void exit(){
        System.exit(0);
    }
    
    
    public void minimize(){
        
        Stage stage = (Stage)minimize.getScene().getWindow();
        
        stage.setIconified(true);
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        showProfile();
        
        desingInsertImage();
        
        // TO SHOW THE AVAILABLE BOOK
      //  studentNumberLabel();
        showAvailableBooks();
        studentNumber();
        gender();
        displayData();
        showReturnBooks();
        showSavedBooks();
        
        
        
        
       
        
        
    }    
    
}
