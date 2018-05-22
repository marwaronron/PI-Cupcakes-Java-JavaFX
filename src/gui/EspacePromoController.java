/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Produit;
import entities.Promotion;
import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import service.PatisserieService;
import service.ProduitService;
import service.PromotionService;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class EspacePromoController implements Initializable {

    @FXML
    private AnchorPane anco;
    @FXML
    private ImageView acceuil;
    @FXML
    private ImageView logout;
    @FXML
    private Text username;
    @FXML
    private ComboBox<Produit> produits;
    @FXML
    private TextField pourcentage;
    @FXML
    private Button btn;
    ProduitService PS = new ProduitService();
 ObservableList<Produit> lesPatisseries = FXCollections.observableArrayList(PS.DisplayAll());
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        produits.setItems( lesPatisseries);
    }    

    @FXML
    private void Acceuil(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceResponsable.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
PromotionService PS2 = new PromotionService();
    @FXML
    private void addPromo(ActionEvent event) {
        Promotion rc= new Promotion();
        ProduitService Ps= new ProduitService();
       rc.setProduit_id( produits.getValue());
       rc.setPourcentage(Integer.valueOf(pourcentage.getText()));
      
       
       if(Integer.valueOf(pourcentage.getText())<=100 && Integer.valueOf(pourcentage.getText())>0 && produits.getValue()!=null){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Promotion ajoutée! Merci");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
              PS2.add(rc); 
       
            } 
       }else{
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Veuillez remplir tous les champs correctement");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
            
       
            }   
       }
    }
    
}
