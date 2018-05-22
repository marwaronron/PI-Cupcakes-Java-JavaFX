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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.PromotionService;
import service.ReclamationService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfacePromoController implements Initializable {

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
    private TableView<Promotion> TablePatisserie;
    @FXML
    private TableColumn<Promotion, String> NomProduit;
    @FXML
    private TableColumn<Promotion, String> pourcentage;

    /**
     * Initializes the controller class.
     */
    PromotionService RS =new PromotionService();
            ObservableList<Promotion> Liste_Patisserie = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //  Admin_Name.setText(Session.LoggedUser.getUsername());
        //   Liste_Patisserie = FXCollections.observableArrayList(RS.getAll());
         //     TablePatisserie.setItems(Liste_Patisserie);
          //     NomProduit.setCellValueFactory((TableColumn.CellDataFeatures<Promotion, String> param) -> new SimpleStringProperty(param.getValue().getProduit_id().getNom()));
        
        //ici mail
      //  pourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
     //  pourcentage.cellFactoryProperty();
        
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
}
