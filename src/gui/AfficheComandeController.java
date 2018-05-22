/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Commandes;
import entities.Ligne_Commande;
import entities.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import service.UserService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author beryl kristina
 */
public class AfficheComandeController implements Initializable {
    
    @FXML
    private AnchorPane anco;
    @FXML
    private VBox ChangeItGirls;
    @FXML
    private SplitPane Panel;
    @FXML
    private ImageView CHomePage;
    @FXML
    private VBox CBoxClients;
    @FXML
    private Text Cclients;
    @FXML
    private VBox CBoxRecettes;
    @FXML
    private Text Crecettes;
    @FXML
    private VBox CBoxAdminHome;
    @FXML
    private VBox CBoxProuits;
    @FXML
    private VBox CBoxPrmotion;
    @FXML
    private VBox CBoxReclamation;
    @FXML
    private VBox CBoxEvaluation;
    @FXML
    private VBox CBoxPanier;
    @FXML
    private VBox CBoxResponsables;
    @FXML
    private ImageView close;

    @FXML
    private TableColumn<Commandes, Integer> id;
    @FXML
    private TableColumn<Commandes, java.util.Date> date;
    @FXML
    private TableColumn<Commandes, Float> prixtotal;
    @FXML
    private TableColumn<Commandes, String> user;
    @FXML
    private TableView<Commandes> liste;
    @FXML
    private JFXTextField recherche;
  
    ObservableList<Commandes> champs  = FXCollections.observableArrayList();
    ObservableList<Ligne_Commande> lis  = FXCollections.observableArrayList();
     
  
    @FXML
    private TableColumn<Commandes, String> adresse;
   
    @FXML
    private JFXButton details;
    @FXML
    private ImageView rech;
    @FXML
    private JFXButton suppression;
     @FXML
    private TableView<Ligne_Commande> liste_details;
    @FXML
    private TableColumn<Ligne_Commande, Integer> id_details;
    @FXML
    private TableColumn<Ligne_Commande, Date> date_commande;
    @FXML
    private TableColumn<Ligne_Commande, String> produit;
    @FXML
    private TableColumn<Ligne_Commande, Integer> quantite;
    @FXML
    private TableColumn<Ligne_Commande, Float> prix_produits;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // String bip = "C:/Users/beryl kristina/Downloads/Pi-java4/Pi-java4/src/utils/beryl.mp3";
          //Media hit = new Media(new File(bip).toURI().toString());
          //MediaPlayer mediaPlayer = new MediaPlayer(hit);
         //mediaPlayer.play();
        champs = FXCollections.observableArrayList(Session.iCommandes.getAll());
        System.out.println(champs);
        liste.setItems(champs);
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
     
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        prixtotal.setCellValueFactory(new PropertyValueFactory<>("prixtotal"));
       
        user.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commandes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Commandes, String> param) {
                return new SimpleStringProperty(param.getValue().getUser_id().getUsername());
            }
        });
        
        adresse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commandes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Commandes, String> param) {
                return new SimpleStringProperty(param.getValue().getAdresse_id().getAdresse());
            }
        });
       
        
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
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Responsables.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToProduits(MouseEvent event)  throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Produits.fxml"));
                
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
    private void goTostat(MouseEvent event)  throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("statistiques.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goTocommande(MouseEvent event) throws SQLException, IOException  {
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
    private void close(MouseEvent event) {
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
    @FXML
   private void onRecherche(MouseEvent event) {
        String x= recherche.getText();
       
       
        if("".equals(x)){
             Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("Tapez le nom d'utilisateur que vous voulez chercher");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
        }else if("Tous".equals(x) ){
           champs = FXCollections.observableArrayList(Session.iCommandes.DisplayAll());
        liste.setItems(champs);
        }
        else{
            UserService service = new UserService();
            List<User> us = service.getAll();
            User u = new User();
            for(int i = 0; i < us.size(); i++)
            {
                if(us.get(i).getUsername().equals(x))
                {
                    u = us.get(i);
                }
            }
        champs = FXCollections.observableArrayList(Session.iCommandes.findBy(u));
            liste.setItems(champs);
        }
    }
    @FXML
    private void Supprimercom(MouseEvent event) {
        if (!liste.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Commande");
            alert.setHeaderText("Etes vous sur de vouloir supprimer la commande " + liste.getSelectionModel().getSelectedItem().getId() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Session.iCommandes.remove(liste.getSelectionModel().getSelectedItem().getId());

                //Reclamation r= new Reclamation();
                //TableReclamation.setItems(());
                 ObservableList<Commandes> champs = FXCollections.observableArrayList(Session.iCommandes.DisplayAll());
                 System.out.println(champs);
                 
                 id.setCellValueFactory(new PropertyValueFactory<>("id"));
                 date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
                 prixtotal.setCellValueFactory(new PropertyValueFactory<>("prixtotal"));
       
                 user.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commandes, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Commandes, String> param) {
                return new SimpleStringProperty(param.getValue().getUser_id().getUsername());
                }
                });
                
               adresse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commandes, String>, ObservableValue<String>>() {
               @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Commandes, String> param) {
                return new SimpleStringProperty(param.getValue().getAdresse_id().affichA());
            }
        });
       
                liste.setItems(champs);
            }
        }
    }
    
    
     @FXML
     public void detailscom(MouseEvent event)
    {
        
       if (!liste.getSelectionModel().isEmpty()){
       
        lis = FXCollections.observableArrayList(Session.iLignes.getBycom(liste.getSelectionModel().getSelectedItem().getId()));
           System.out.println(lis);
        liste_details.setItems(lis);
        id_details.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        date_commande.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne_Commande, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Ligne_Commande, Date> param) {
                return new SimpleObjectProperty(param.getValue().getCommande().getDate());
            }
        });
        produit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne_Commande, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Ligne_Commande, String> param) {
                return new SimpleStringProperty(param.getValue().getProduit().getNom());
            }
        });
        quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        prix_produits.setCellValueFactory(new PropertyValueFactory<>("prixp"));
       

        
    
    }
    }
     

}
