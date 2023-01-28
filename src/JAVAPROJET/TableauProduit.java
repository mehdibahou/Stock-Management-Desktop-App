package JAVAPROJET;







import java.util.ArrayList;
import java.util.Iterator;


import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
public class TableauProduit  {
	
	
	

	public static ObservableList<Produit> obsProductlist = FXCollections.observableArrayList();
	
	public static ObservableList<String> obsProductnames = FXCollections.observableArrayList();
	
	public static ArrayList<Produit> userData = new ArrayList<>();
	

	public static void loadData() {
		Iterator<Produit> it = userData.iterator();
		while(it.hasNext()) {
			Produit prod = it.next();
			obsProductlist.add(prod);
        	obsProductnames.add(prod.getNomProd());
		}
	}

	
 
    @SuppressWarnings("unchecked")
  public static BorderPane Tableauproduit() {
	  BorderPane root = new BorderPane();
      TableView<Produit> table = new TableView<Produit>();

     
      TableColumn<Produit, String> Id //
              = new TableColumn<Produit, String>("Id");

     
      TableColumn<Produit, String> NomProd//
              = new TableColumn<Produit, String>("Produit");

     

      
      TableColumn<Produit, String> Prix //
              = new TableColumn<Produit, String>("Prix");

      TableColumn<Produit, String> Quantite //
              = new TableColumn<Produit, String>("Quantite");

     
      

      
      TableColumn<Produit, String>Fournisseur //
              = new TableColumn<Produit, String>("Fournisseur");


      TableColumn<Produit, String> Vendu//
      = new TableColumn<Produit, String>("Vendu");
      
      Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
      NomProd.setCellValueFactory(new PropertyValueFactory<>("NomProd"));
      Prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
      Quantite.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
      Fournisseur.setCellValueFactory(new PropertyValueFactory<>("Fournisseur"));
      Vendu.setCellValueFactory(new PropertyValueFactory<>("Vendu"));
      
      
      
     
      table.setItems(obsProductlist);

      table.getColumns().addAll(Id,NomProd, Prix,Quantite, Fournisseur, Vendu);
      table.prefHeight(200);
      table.prefWidth(100);
      StackPane tab = new StackPane();
      tab.getChildren().add(table);
      tab.setPadding(new Insets(10, 160, 10, 160));
      tab.prefWidth(100);
      root.setCenter(tab);
      root.setPrefHeight(200);
      return root ;
      
      
  }
    

}