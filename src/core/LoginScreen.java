package core;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import static javafx.scene.text.Font.font;

import JAVAPROJET.TableauProduit;

public class LoginScreen {
	public static String connectedUser = null;
	
    public static Scene loginScreen(){
        HBox hbox1 = new HBox(150);
        VBox vbox1 = new VBox(20);
        VBox vbox2 = new VBox(20);
        

        vbox2.setPrefWidth(250);
        hbox1.setAlignment(Pos.CENTER);
        vbox1.setAlignment(Pos.CENTER);
        vbox2.setAlignment(Pos.CENTER);
        TextField usr1 = new TextField();
        usr1.setPrefWidth(250);
        PasswordField pass1 = new PasswordField();
        pass1.setPrefWidth(250);
        usr1.setPromptText("email");
        pass1.setPromptText("Mot de passe");
        Label label1 = new Label("  Mon Gestionnaire");
        label1.setFont(font("Roboto",FontWeight.BOLD,33));
        label1.setOpacity(1);
        Label label2 = new Label("Se connecter:");
        label2.setAlignment(Pos.CENTER_LEFT);
        Button login = new Button("Se connecter");
        login.setFont(font("Arial", FontWeight.BOLD,13));
        label2.setFont(font("Arial",FontWeight.BOLD,25));
        label2.setTextFill(Color.WHITE);
        Button creercpt = new Button("créer un compte");
        creercpt.setOnAction(e -> HelloFx.getStage().setScene(CreateAccScreen.createAccScreen()));
        creercpt.setFont(font("Arial", FontWeight.BOLD,13));
        HBox choices = new HBox(30);
        choices.getChildren().addAll(creercpt,login);
        Hyperlink forgot = new Hyperlink("Mot de passe oublié?");
        forgot.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(label2,usr1,pass1,choices,forgot);
     
        vbox1.getChildren().add(label1);
        hbox1.getChildren().addAll(vbox1, vbox2);
        Image img = new Image("https://images5.alphacoders.com/719/thumb-1920-719840.png");
        BackgroundImage bimg =  new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1.3,1,true,true,false,false));
        vbox2.setBackground(new Background(new BackgroundFill(Color.rgb(25,25,25), null, new Insets(165, -20, 175, -20))));
        vbox2.setOpacity(0.85);
        Background bck = new Background(bimg);
        hbox1.setBackground(bck);
        forgot.setOnAction(e -> HelloFx.getStage().setScene(ForgotScreen.forgotScreen()));
        login.setOnAction(e -> {
            if(UserBase.checkCredentials(new User(usr1.getText(), pass1.getText()))){
            	TableauProduit.loadData();
                HelloFx.getStage().setScene(Menu.menu1());
                
                
        } else {
                Label err = new Label("email ou mdp incorrect!");
                err.setAlignment(Pos.CENTER);
                err.setTextFill(Color.RED);
                vbox2.getChildren().add(err);
        }
        });
        Scene scene1 = new Scene(hbox1,800,600);
        return scene1;
    }
}
