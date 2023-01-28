package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



public class HelloFx extends Application {
    private static Stage window;
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("Mon Gestionnaire");
        Scene scene1 = LoginScreen.loginScreen();

        window.setScene(scene1);
        window.show();
    }
    public static Stage getStage(){
        return window;
    }
    public static void main(String[] args) {
    	try {
            UserBase.loadSession();
        } catch (Exception e) {
            System.out.println("error loading previous session");
        }
    	
       
        launch();
        UserBase.saveSession();
    }
}