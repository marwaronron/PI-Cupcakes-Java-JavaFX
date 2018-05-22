/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author beryl kristina
 */
public class StatistiquesController implements Initializable {
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
    private AnchorPane anco;
    @FXML
    private PieChart piechart1;
    @FXML
    private PieChart piechart2;
    @FXML
    private Text biedeg;
    @FXML
    private Text brice;
    @FXML
    private Text millefeuille;
    @FXML
    private Text tourte;
    @FXML
    private Text croustina;
    @FXML
    private Text biscuit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buildPieChartDataDiff();
        ShowCoutPerc();
        produitstat();
        calculpour();
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
     private void buildPieChartDataDiff() {
           
            ObservableList<PieChart.Data> details =
            FXCollections.observableArrayList(
            new PieChart.Data("marwa", Session.iCommandes.CountCom(6)),
            new PieChart.Data("Daly", Session.iCommandes.CountCom(12))
           
            );  
         
    piechart1.setData(details);
     piechart1.setLabelLineLength(10);
    }
    
     
     private void ShowCoutPerc() {
        
        int C1=Session.iCommandes.CountCom(6);
        int C2=Session.iCommandes.CountCom(12);
        
        int CTotal= C1+C2;
                //Session.iRecetteService.NbTotalR();
        ///////
        double CP1=0.0;
        if(C1==0 || CTotal==0){
            CP1=0;
        }else{
         CP1=((double)C1/(double)CTotal)*100; 
         CP1=(double) Math.round(CP1 * 100) / 100; 	
        }
        //////
        double CP2=0.0;
        if(C2==0 || CTotal==0){
            CP2=0;
        }else{
         CP2=((double)C2/(double)CTotal)*100; 
         CP2=(double) Math.round(CP2 * 100) / 100; 	
        }
        ///////
        
        ///////
        
        biedeg.setText(String.valueOf(CP1)+"%");
        brice.setText(String.valueOf(CP2)+"%");
       
    }
     
     public void produitstat()
     {
         ObservableList<PieChart.Data> details =
            FXCollections.observableArrayList(
            new PieChart.Data("mille feuille", Session.iLignes.Countprod(1)),
            new PieChart.Data("tourte", Session.iLignes.Countprod(7)),
            new PieChart.Data("biscuit", Session.iLignes.Countprod(3)),
            new PieChart.Data("croustina", Session.iLignes.Countprod(4))
            
            );  
         
    piechart2.setData(details);
     piechart2.setLabelLineLength(10);
         
     }
     
     public void calculpour()
     {
          int D1=Session.iLignes.Countprod(1);
          int D2=Session.iLignes.Countprod(7);
          int D3=Session.iLignes.Countprod(3);
          int D4=Session.iLignes.Countprod(4);
        
        int DTotal= D1+D2+D3+D4;
                //Session.iRecetteService.NbTotalR();
        ///////
        double DP1=0.0;
        if(D1==0 || DTotal==0){
            DP1=0;
        }else{
         DP1=((double)D1/(double)DTotal)*100; 
         DP1=(double) Math.round(DP1 * 100) / 100; 	
        }
        //////
        double DP2=0.0;
        if(D2==0 || DTotal==0){
            DP2=0;
        }else{
         DP2=((double)D2/(double)DTotal)*100; 
         DP2=(double) Math.round(DP2 * 100) / 100; 	
        }
        ///////
        double DP3=0.0;
        if(D3==0 || DTotal==0){
            DP3=0;
        }else{
         DP3=((double)D3/(double)DTotal)*100; 
         DP3=(double) Math.round(DP3 * 100) / 100; 	
        }
        
        ///////
        double DP4=0.0;
        if(D4==0 || DTotal==0){
            DP4=0;
        }else{
         DP4=((double)D4/(double)DTotal)*100; 
         DP4=(double) Math.round(DP4 * 100) / 100; 	
        }
        
        millefeuille.setText(String.valueOf(DP1)+"%");
        tourte.setText(String.valueOf(DP2)+"%");
        biscuit.setText(String.valueOf(DP3)+"%");
        croustina.setText(String.valueOf(DP4)+"%");
       
         
     
     }

    
}
