/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Evaluation;
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
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.EvaluationService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceAdmin_EvaluationController implements Initializable {

    @FXML
    private AnchorPane anco;
    @FXML
    private SplitPane Panel;
    @FXML
    private ImageView CHomePage;
    @FXML
    private VBox CBoxAdminHome;
    @FXML
    private VBox CBoxClients;
    @FXML
    private Text Cclients;
    @FXML
    private VBox CBoxResponsables;
    @FXML
    private VBox CBoxProuits;
    @FXML
    private VBox CBoxRecettes;
    @FXML
    private Text Crecettes;
    @FXML
    private VBox CBoxPrmotion;
    @FXML
    private VBox CBoxReclamation;
    @FXML
    private VBox CBoxEvaluation;
    @FXML
    private VBox CBoxPanier;
    @FXML
    private VBox ChangeItGirls;
    @FXML
    private Text Admin_Name;
    @FXML
    private ImageView btnClose;
    @FXML
    private TableView<Evaluation> TablePatisserie;
    @FXML
    private TableColumn<Evaluation, String> NomPat;
    @FXML
    private TableColumn<Evaluation, String> mail;
    @FXML
    private TableColumn<Evaluation, Integer> local;
    @FXML
    private TableColumn<Evaluation, Integer> service;
    @FXML
    private TableColumn<Evaluation, Integer> prix;
    @FXML
    private TableColumn<Evaluation, Integer> produit;
    @FXML
    private TableColumn<Evaluation, Integer> decor;

    /**
     * Initializes the controller class.
     */
     ObservableList<Evaluation> Liste_Patisserie = FXCollections.observableArrayList();
     EvaluationService ES = new EvaluationService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Admin_Name.setText(Session.LoggedUser.getUsername());
           Liste_Patisserie = FXCollections.observableArrayList(ES.getAll());
              TablePatisserie.setItems(Liste_Patisserie);
               NomPat.setCellValueFactory((TableColumn.CellDataFeatures<Evaluation, String> param) -> new SimpleStringProperty(param.getValue().getPatisserie_id().getNom()));
        
        //ici mail
        mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        mail.cellFactoryProperty();
        
            local.setCellValueFactory(new PropertyValueFactory<>("local"));
      local.cellFactoryProperty();
      
                  service.setCellValueFactory(new PropertyValueFactory<>("service"));
      service.cellFactoryProperty();
      
                  prix.setCellValueFactory(new PropertyValueFactory<>("noteprix"));
      prix.cellFactoryProperty();
      
                  produit.setCellValueFactory(new PropertyValueFactory<>("noteproduit"));
     produit.cellFactoryProperty();
      
                  decor.setCellValueFactory(new PropertyValueFactory<>("decor"));
     decor.cellFactoryProperty();
        // TODO
    }    

  
   @FXML
    private void goToHome(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    

    @FXML
    private void goToClients(MouseEvent event)  throws SQLException, IOException  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Clients.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToResponsables(MouseEvent event) throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceAdmin_Responsables.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToProduits(MouseEvent event)  throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceAdmin_Prod.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToRecettes(MouseEvent event)  throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Recettes1.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToPromotion(MouseEvent event) throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Promotion.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToReclamation(MouseEvent event)  throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Reclamation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToEvaluation(MouseEvent event)  throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Evaluation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToPanier(MouseEvent event) throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("commandeaffichage.fxml"));
                
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
         Stage stage = (Stage) btnClose.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
}
