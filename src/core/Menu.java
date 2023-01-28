package core;



import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import static javafx.scene.text.Font.font;



import JAVAPROJET.Produit;
import JAVAPROJET.TableauProduit;


public class Menu {
    public static Scene menu1(){
        VBox layout1 = new VBox(50);
        layout1.setAlignment(Pos.TOP_CENTER);
        VBox bpane1 = new VBox(50);
        
        
        
       
        
        

        Image img = new Image("https://images5.alphacoders.com/719/thumb-1920-719840.png");
        BackgroundImage bimg =  new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1.3,1,true,true,false,false));
        Background bck = new Background(bimg);
        
        layout1.setBackground(bck);
        
        bpane1.getChildren().add(Ajouterprod());
        bpane1.getChildren().add(TableauProduit.Tableauproduit());
        
        
        
        layout1.getChildren().add(bpane1);
        
        
        Scene scene = new Scene(layout1,800,600);
        return scene;
    }
    public static HBox Ajouterprod() {
    	
    	VBox vbox1 = new VBox(20);
        HBox hbox1 = new HBox(20);
        vbox1.setAlignment(Pos.CENTER);
        hbox1.setAlignment(Pos.CENTER);
        
        
        
        Button ajt = new Button("Ajouter");
        ajt.setFont(font("Arial", FontWeight.BOLD,13));
        TextField nom = new TextField();
        TextField prix = new TextField();
        TextField qte = new TextField();
        TextField frn = new TextField();
        nom.setPrefWidth(200);
        prix.setPrefWidth(200);
        qte.setPrefWidth(200);
        frn.setPrefWidth(200);
        nom.setPromptText("Nom du porduit");
        prix.setPromptText("Prix en DH");
        qte.setPromptText("Quantite");
        frn.setPromptText("Fournisseur");
        Label creer = new Label("Nouveau produit:");
        
        creer.setTextFill(Color.WHITE);
        creer.setFont(font("Arial",FontWeight.BOLD,21));
        vbox1.getChildren().addAll(creer,nom,prix,qte,frn,ajt);
        hbox1.getChildren().addAll(vbox1,Modifierprod(),Supprimer());
        ajt.setOnAction(e -> {
        	
        	Object[] f = TableauProduit.obsProductlist.toArray();
        	if (f.length != 0) {
        	String b = ((Produit) f[f.length - 1]).getId();
        	String a = Integer.toString(Integer.valueOf(b)+1);
        	Produit Prod = new Produit(a, nom.getText(), prix.getText(),qte.getText(), frn.getText(),"0");
        	TableauProduit.obsProductlist.add(Prod);
        	UserBase.users.get(UserBase.connected).userData.add(Prod);
        	TableauProduit.obsProductnames.add(Prod.getNomProd());
        	}
        	else {
        	Produit Prod = new Produit("0", nom.getText(), prix.getText(),qte.getText(), frn.getText(),"0");
        	TableauProduit.obsProductlist.add(Prod);
        	UserBase.users.get(UserBase.connected).userData.add(Prod);
        	TableauProduit.obsProductnames.add(Prod.getNomProd());
        	};
            }
        );
        
        return hbox1;
    	
    	
    	
    	
    }
    
    
    
    
    
   
    public static HBox Modifierprod() {
    	
    	VBox vbox1 = new VBox(20);
        HBox hbox1 = new HBox(20);
        HBox hboxc = new HBox(20);
        vbox1.setAlignment(Pos.CENTER);
        hbox1.setAlignment(Pos.CENTER);
        
        
        
        Button mdf = new Button("Modifier");
        mdf.setFont(font("Arial", FontWeight.BOLD,13));
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.setPrefWidth(200);
        

        comboBox.setItems(TableauProduit.obsProductnames);
        comboBox.getSelectionModel().select(1);
        CheckBox checkBox1 = new CheckBox("P");
        CheckBox checkBox2 = new CheckBox("F");
        CheckBox checkBox3 = new CheckBox("Q");
        checkBox1.setFont(font("Arial", FontWeight.BOLD,13));
        checkBox1.setTextFill(Color.WHITE);
        checkBox2.setFont(font("Arial", FontWeight.BOLD,13));
        checkBox2.setTextFill(Color.WHITE);
        checkBox3.setFont(font("Arial", FontWeight.BOLD,13));
        checkBox3.setTextFill(Color.WHITE);
        
        
        
        
        
        

        hboxc.getChildren().addAll(checkBox1,checkBox2,checkBox3);
        hboxc.setPrefWidth(200);
        
        
        TextField prix = new TextField();
        TextField qte = new TextField();
        TextField frn = new TextField();
        
        prix.setPrefWidth(200);
        qte.setPrefWidth(200);
        frn.setPrefWidth(200);
        
        prix.setPromptText("Prix en DH");
        qte.setPromptText("Quantite");
        frn.setPromptText("Fournisseur");
        Label creer = new Label("Modifier produit:");
        
        creer.setTextFill(Color.WHITE);
        creer.setFont(font("Arial",FontWeight.BOLD,21));
        vbox1.getChildren().addAll(creer,comboBox,hboxc,prix,qte,frn,mdf);
        hbox1.getChildren().addAll(vbox1);
        prix.setVisible(false);
        qte.setVisible(false);
        frn.setVisible(false);
        checkBox1.setOnAction(e -> {
        	if (checkBox1.isSelected()) {
        		prix.setVisible(true);
        	}
        	else {
        		prix.setVisible(false);
        	}
            }
        );
        checkBox2.setOnAction(e -> {
        	if (checkBox2.isSelected()) {
        		frn.setVisible(true);
        	}
        	else {
        		frn.setVisible(false);
        	}
            }
        );
        checkBox3.setOnAction(e -> {
        	if (checkBox3.isSelected()) {
        		qte.setVisible(true);
        	}
        	else {
        		qte.setVisible(false);
        	}
            }
        );
        mdf.setOnAction(e -> {
        	try {
        		  
        		
        	
        	for (int i = 0 ; i <= TableauProduit.obsProductlist.size() ; i++) {
        		Produit p = TableauProduit.obsProductlist.get(i);
        		if(p.getNomProd() == comboBox.getValue() ) {
        			Produit o = new Produit();
        			o.setId(p.getId());
        			o.setNomProd(p.getNomProd());
        			o.setVendu(p.getVendu());
        			
        			
        			if (checkBox1.isSelected()) {
        				o.setPrix(prix.getText());
        				
        			}
        			else { 
        				o.setPrix(p.getPrix());
        			}
        			if (checkBox2.isSelected()) {
        				o.setFournisseur(frn.getText());
        			}
        			else {
        				o.setFournisseur(p.getFournisseur());
        			}
        			if (checkBox3.isSelected()) {
        				o.setQuantite(qte.getText());
        			}
        			else {
        				o.setQuantite(p.getQuantite());
        			}
        			TableauProduit.obsProductlist.set(i, o);
        			UserBase.users.get(UserBase.connected).userData.set(i, o);
        		}
        		
        		
        	}
        	}
        	catch(Exception e1) {
        		  
        		}
        	System.out.println("Something went wrong.");
            }
        );
        
        return hbox1;
    	
    	
    	
    	
    }
    
    
    
    
    public static HBox Supprimer() {
    	
    	VBox vbox1 = new VBox(20);
        HBox hbox1 = new HBox(20);
        
        vbox1.setAlignment(Pos.CENTER);
        hbox1.setAlignment(Pos.CENTER);
        
        
        Button mdf = new Button("supprimer");
        mdf.setFont(font("Arial", FontWeight.BOLD,13));
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.setPrefWidth(200);
        

        comboBox.setItems(TableauProduit.obsProductnames);
        comboBox.getSelectionModel().select(1);
      
       
        Label creer = new Label("Supprimer produit:");
        creer.setTextFill(Color.WHITE);
        creer.setFont(font("Arial",FontWeight.BOLD,21));
        vbox1.getChildren().addAll(creer,comboBox,mdf);
        hbox1.getChildren().addAll(vbox1);
        
        mdf.setOnAction(e -> {
        	try {
        		  
        		
        	
        	for (int i = 0 ; i <= TableauProduit.obsProductlist.size() ; i++) {
        		Produit p = TableauProduit.obsProductlist.get(i);
        		if(p.getNomProd() == comboBox.getValue() ) {
        			
        			
        			
        			UserBase.users.get(UserBase.connected).userData.remove(p);
        			TableauProduit.obsProductlist.remove(p);
        			TableauProduit.obsProductnames.remove(p.getNomProd());
        		}
        		
        		
        	}
        	}
        	catch(Exception e1) {
        		
        		}
        	
            }
        );
        
        return hbox1;
    	
    	
    	
    	
    }
    
    
    
    
    
    
    
}
