/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectcrm;

import com.sun.tools.javac.Main;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class Projectcrm extends Application {
//    private Stage primaryStage;
//    private AnchorPane rootLayout;
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        this.primaryStage = primaryStage;
//        this.primaryStage.setTitle("");
//        showPro();
//        showCate();
//    }
//    public void showPro() throws IOException{
//        try{
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(Main.class.getResource("/fxml/FormUI.fxml"));
//        rootLayout = (AnchorPane) loader.load();
//        Scene scene = new Scene(rootLayout);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//    public void showCate(){
//        try {
//         FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(Main.class.getResource("/fxml/categorypro.fxml"));
//        AnchorPane categoryProOperationsView = (AnchorPane)loader.load();
////        rootLayout.setCenter(categoryProOperationsView);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/categoryPro.fxml")); 
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FormUI.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
