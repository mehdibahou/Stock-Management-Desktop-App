package core;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import static javafx.scene.text.Font.font;

public class ForgotScreen {
    public static Scene forgotScreen(){
        HBox layout2 = new HBox(150);
        VBox vbox1 = new VBox(20);
        layout2.setAlignment(Pos.CENTER);
        vbox1.setAlignment(Pos.CENTER);
        Label label1 = new Label("  Mon Gestionnaire");
        label1.setFont(font("Roboto", FontWeight.BOLD,33));
        Button createAcc = new Button("envoyer");
        createAcc.setFont(font("Arial", FontWeight.BOLD,13));
        TextField usr = new TextField();
        usr.setPrefWidth(200);
        usr.setPromptText("email");
        Button back = new Button("back");
        back.setFont(font("Arial",FontWeight.BOLD,15));
        Pane backpane = new Pane();
        backpane.getChildren().add(back);
        back.setAlignment(Pos.CENTER_LEFT);
        back.setOnAction(e -> HelloFx.getStage().setScene(LoginScreen.loginScreen()));
        vbox1.getChildren().addAll(backpane,usr,createAcc);
        vbox1.setBackground(new Background(new BackgroundFill(Color.rgb(25,25,25), null, new Insets(120, -20, 140, -20))));
        vbox1.setOpacity(0.85);
        layout2.getChildren().addAll(label1,vbox1);
        Image img = new Image("https://images5.alphacoders.com/719/thumb-1920-719840.png");
        BackgroundImage bimg =  new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1.3,1,true,true,false,false));
        vbox1.setBackground(new Background(new BackgroundFill(Color.rgb(25,25,25), null, new Insets(155, -30, 150, -30))));
        vbox1.setOpacity(0.85);
        Background bck = new Background(bimg);
        layout2.setBackground(bck);
        createAcc.setOnAction(e -> {
            if(UserBase.userExists(usr.getText())){
                String pwd = UserBase.findUser(usr.getText()).getPassword();
                Label msg = new Label("votre mot de passe est: " + pwd);
                msg.setFont(font("Arial",FontWeight.BOLD,15));
                msg.setTextFill(Color.WHITE);
                vbox1.getChildren().add(msg);
            }
            else{
                Label msg = new Label("utilisateur inexistant! " );
                msg.setFont(font("Arial",FontWeight.BOLD,15));
                msg.setTextFill(Color.RED);
                vbox1.getChildren().add(msg);
            }
        });
        Scene scene = new Scene(layout2,800,600);
        return scene;
    }
}
