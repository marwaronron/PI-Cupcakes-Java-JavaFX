/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Patisserie;
import entities.Reclamation;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.PatisserieService;
import service.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceReclamationController implements Initializable {

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
    private TextArea desc;
    @FXML
    private Button btn;
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
ReclamationService Rs= new ReclamationService();
    @FXML
    private void AjouterReclamation(MouseEvent event) {
        Reclamation rc= new Reclamation();
        PatisserieService Ps= new PatisserieService();
       rc.setPatisserie_id(Ps.findByNom((String) patis.getValue()));
       rc.setMail(mail.getText());
       rc.setDescription(desc.getText());
       
       if(mail.getText()!=null && desc.getText()!=null && patis.getValue()!=null){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Réclamation ajoutée! Merci");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
              Rs.add(rc); 
       
            } 
       }else{
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
