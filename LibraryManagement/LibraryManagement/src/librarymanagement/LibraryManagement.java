
    package librarymanagement;

    import java.io.IOException;
    import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.input.MouseEvent;
    import javafx.scene.layout.StackPane;
    import javafx.stage.Stage;
    import javafx.stage.StageStyle;


    public class LibraryManagement extends Application {
        private double x= 0;
        private double y= 0;

        @Override
        public void start(Stage stage) throws IOException {

            try {

                 Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

            Scene scene = new Scene(root);
            root.setOnMousePressed((MouseEvent event)->{
                x = event.getSceneX();
                y = event.getSceneY();  

            });

             root.setOnMouseDragged((MouseEvent event)->{
               stage.setX(event.getScreenX() -x);
               stage.setY(event.getScreenY() -y);



            });

            stage.initStyle(StageStyle.TRANSPARENT);

            stage.setScene(scene);
            stage.show();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        public static void main(String[] args) {
            launch(args);
        }

    }
