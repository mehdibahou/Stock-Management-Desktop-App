package JAVAPROJET;

import java.io.Serializable;

public class Produit implements Serializable{

   
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public String Id;
   public String NomProd;
   public String Prix;
   public String Fournisseur;
   public String Quantite;
   public String Vendu;
   
   
   
   public Produit(String Id, String NomProd, String Prix,String Quantite, String Fournisseur, String Vendu) {
	   
       this.Id = Id;
       this.NomProd = NomProd;
       this.Prix = Prix;
       this.Quantite = Quantite;
       this.Fournisseur = Fournisseur;
       this.Vendu = Vendu;
   }


   public Produit() {
	// TODO Auto-generated constructor stub
}


public String getId() {
       return Id;
   }

   public void setId(String Id) {
       this.Id = Id;
   }

   public String getNomProd() {
       return NomProd;
   }

   public void setNomProd(String NomProd) {
       this.NomProd = NomProd;
   }

   public String getPrix() {
       return Prix;
   }

   public void setPrix(String Prix) {
       this.Prix = Prix;
   }

   public String getQuantite() {
       return Quantite;
   }

   public void setQuantite(String Quantite) {
       this.Quantite = Quantite;
   }

   public String getFournisseur() {
       return Fournisseur;
   }

   public void setFournisseur(String Fournisseur) {
       this.Fournisseur = Fournisseur;
   }
   public String getVendu() {
       return Vendu;
   }

   public void setVendu(String Vendu) {
       this.Vendu = Vendu;
   }
   

}