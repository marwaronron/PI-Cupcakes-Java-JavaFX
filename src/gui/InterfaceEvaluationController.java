/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Evaluation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static jdk.nashorn.internal.runtime.JSType.toInteger;
import service.EvaluationService;
import service.PatisserieService;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceEvaluationController implements Initializable {

    @FXML
    private AnchorPane anco;
    @FXML
    private ImageView CHome;
    @FXML
    private ImageView CclientIcon;
    @FXML
    private ImageView CrecetteIcon;
    @FXML
    private ImageView CPatisserieIcon;
    @FXML
    private ImageView CShopIcon;
    @FXML
    private ImageView CPromoIcon;
    @FXML
    private ImageView CReclamationIcon;
    @FXML
    private ImageView CEvaluationIcon;
    @FXML
    private ImageView CPanierIcon;
    @FXML
    private ImageView CLogoutIcon;
    @FXML
    private VBox CBoxHome;
    @FXML
    private ImageView CHomeIcon;
    @FXML
    private Text LabelHome;
    @FXML
    private VBox CBoxClient;
    @FXML
    private Text LabelClient;
    @FXML
    private VBox CBoxRecette;
    @FXML
    private Text LabelRecette;
    @FXML
    private VBox CBoxPatisserie;
    @FXML
    private VBox CBoxShop;
    @FXML
    private VBox CBoxPromo;
    @FXML
    private VBox CBoxReclamation;
    @FXML
    private VBox CBoxEvaluation;
    @FXML
    private VBox CBoxPanier;
    @FXML
    private VBox ChangeItGirls;
    @FXML
    private ImageView close;
    @FXML
    private ComboBox<String> patis;
    @FXML
    private TextField mail;
    @FXML
    private Button btn;
    @FXML
    private TextField local;
    @FXML
    private TextField service;
    @FXML
    private TextField prix;
    @FXML
    private TextField produits;
    @FXML
    private TextField decor;
ObservableList<String> lesPatisseries = FXCollections.observableArrayList("DELICIOUS","Patisserie Tasty");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          patis.setItems(lesPatisseries);
    }    

   @FXML
    private void GoToHome(MouseEvent event) throws SQLException, IOException{
         
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToClientProfile(MouseEvent event) throws SQLException, IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClientProfile.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToRecettes(MouseEvent event) throws SQLException, IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToPatisseries(MouseEvent event)throws SQLException, IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClientPat.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToShop(MouseEvent event)throws SQLException, IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceShop.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToPromo(MouseEvent event) throws SQLException, IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePromo.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToReclamation(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceReclamation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToEvaluation(MouseEvent event) throws SQLException, IOException{
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceEvaluation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToPanier(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Lepanier.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void LogOut(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void Close(MouseEvent event) {
          Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
    EvaluationService Es= new EvaluationService();
    @FXML
    private void AjouterEvaluation(MouseEvent event) {
        Evaluation E = new Evaluation();
         PatisserieService Ps= new PatisserieService();
       E.setPatisserie_id(Ps.findByNom((String) patis.getValue()));
       E.setMail(mail.getText());
       
       
       if(Integer.valueOf(service.getText())<=5 && Integer.valueOf(service.getText())>=0){
           E.setService(Integer.valueOf(service.getText()));
       }else{
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Note doit etre entre 0 et 5");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
            } 
       }
       if(Integer.valueOf(local.getText())<=5 && Integer.valueOf(local.getText())>=0){
           E.setLocal(Integer.valueOf(local.getText()));
       }else{
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Note doit etre entre 0 et 5");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
            } 
        }      
       
       
       if(Integer.valueOf(prix.getText())<=5 && Integer.valueOf(prix.getText())>=0){
           E.setNoteprix(Integer.valueOf(prix.getText()));
       }else{
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Note doit etre entre 0 et 5");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
            } 
        }    
       
       if(Integer.valueOf(produits.getText())<=5 && Integer.valueOf(produits.getText())>=0){
           E.setNoteproduit(Integer.valueOf(produits.getText()));
       }else{
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Note doit etre entre 0 et 5");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
            } 
        } 
       
       if(Integer.valueOf(decor.getText())<=5 && Integer.valueOf(decor.getText())>=0){
           E.setDecor(Integer.valueOf(decor.getText()));
       }else{
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Note doit etre entre 0 et 5");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
            } 
        }       
           if(mail.getText()!=null && patis.getValue()!=null){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Evaluation ajoutée! Merci");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
             Es.add(E); 
       
            } 
       } else{
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Veuillez remplir tous les champs");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
            
       
            }   
           }
       
    }
    
}
