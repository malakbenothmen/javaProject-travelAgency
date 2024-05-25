package service;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Airline;
import models.Billflight;
import controllers.AirlineController;
import controllers.DBUtils;
import controllers.RevBilletController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class FlightRevAdminService {




    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label homeLabel;
    @FXML
    private Label fullnameLabel;
    @FXML
    private Hyperlink logoutLink;
    @FXML
    private Button logoutBtn;
    @FXML
    private AnchorPane sideBar;
    @FXML
    private Button userBtn;
    @FXML
    private Button servicesBtn11;
    @FXML
    private Button hotelBtn;
    @FXML
    private Button homeBtn;
    @FXML
    private Button flightBtn;
    @FXML
    private TableView<Billflight> tableViewRv;
    @FXML
    private TableColumn<Billflight, Integer> revIdCol;
    @FXML
    private TableColumn<Billflight, String> flightNumCol;
    @FXML
    private TableColumn<Billflight, String> fullNameCol;
    @FXML
    private TableColumn<Billflight, String> categoryCol;
    @FXML
    private TableColumn<Billflight, String> classCol;
    @FXML
    private TableColumn<Billflight, String> passportCol;
    @FXML
    private TableColumn<Billflight, Integer> seatCol;
    @FXML
    private ChoiceBox<String> airlineNameField;
    @FXML
    private DatePicker dDepartField;
  

    private RevBilletController revBilletController;
    
    private AirlineController airlineController;
    
    private List<Airline> listAirline = new ArrayList<>();
    @FXML
    private void initialize() {
        revBilletController = new RevBilletController();
      
        airlineController = new AirlineController();
        
        // Initializing table columns
        revIdCol.setCellValueFactory(new PropertyValueFactory<>("billflight_id"));
        flightNumCol.setCellValueFactory(new PropertyValueFactory<>("flight_id")); 
        fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        classCol.setCellValueFactory(new PropertyValueFactory<>("SeatType"));
        passportCol.setCellValueFactory(new PropertyValueFactory<>("passport"));
        seatCol.setCellValueFactory(new PropertyValueFactory<>("numSeat"));

        AirlineList();
       

        loadReservations();
    }

    private void loadReservations() {
        ObservableList<Billflight> reservations = FXCollections.observableArrayList(revBilletController.findAllReservation());
        
        // Imprimer les données récupérées dans la console
        for (Billflight reservation : reservations) {
            System.out.println("Réservation : " + reservation.toString()); // Assurez-vous que la méthode toString() de Billflight est correctement implémentée pour afficher les détails de la réservation
        }
        
        // Afficher les données dans le TableView
        tableViewRv.setItems(reservations);
    }
    
    private void AirlineList()
    {	List<String> l = new ArrayList<>();
    	listAirline = airlineController.getAllAirlines();
    	for(Airline e : listAirline)
    	{l.add(e.getName());}
    	
    	airlineNameField.getItems().addAll(l);
    	
    }
    
    
    @FXML
    public void searchBtnAction(ActionEvent event) {
        String selectedAirline = airlineNameField.getValue();
        LocalDate selectedDepartureDate = dDepartField.getValue();

        if (selectedAirline != null && selectedDepartureDate != null) {
            
            List<Billflight> reservationsByAirline = revBilletController.findByAirlineName(selectedAirline);

           
            List<Billflight> reservationsByDepartureDate = revBilletController.findByDepartureDate(selectedDepartureDate);

            List<Billflight> filteredReservations = new ArrayList<>(reservationsByAirline);
            filteredReservations.retainAll(reservationsByDepartureDate);

        
            tableViewRv.setItems(FXCollections.observableArrayList(filteredReservations));
        } else {
          
            System.out.println("Veuillez sélectionner une compagnie aérienne et une date de départ.");
        }
    }
    
    
    
    
    
    
    
    
    @FXML
   	public void switchToHome(ActionEvent event) throws IOException {
   	    	DBUtils.changeScene(event, "/views/admin/HomePage.fxml", "Admin Dashboard", null);
   	
   	}
       @FXML
       public void switchToAdminRoom(ActionEvent event) throws IOException {
       	DBUtils.changeScene(event, "/views/admin/RoomManagement.fxml", "Admin Dashboard", null);
       }
       
       @FXML
       public void switchToAdminAircraft(ActionEvent event) throws IOException {
       	DBUtils.changeScene(event, "/views/admin/Aircraft-view.fxml", "Admin Dashboard", null);
       }
       
       @FXML
       public void switchToAdminAirline(ActionEvent event) throws IOException {
       	DBUtils.changeScene(event, "/views/admin/Airline-view.fxml", "Admin Dashboard", null);
       }
       @FXML
       public void switchToAdminHotel(ActionEvent event) throws IOException {
       	DBUtils.changeScene(event, "/views/admin/Hotel-view.fxml", "Admin Dashboard", null);
       }
       @FXML
       public void handleSwitchServices(ActionEvent event) throws IOException {
       	DBUtils.changeScene(event, "/views/admin/services.fxml", "Admin Dashboard", null);
       }
       @FXML
       public void switchToAdminUser(ActionEvent event) throws IOException {
       	DBUtils.changeScene(event, "/views/admin/UserManagement.fxml", "Admin Dashboard", null);
       }
       
       @FXML
       public void logout(ActionEvent event) throws IOException {
       	DBUtils.changeScene(event, "/views/auth/Welcome-view.fxml", "Welcome", null);
       }
       
       @FXML
       public void BackPage(ActionEvent event) throws IOException {
       	DBUtils.changeScene(event, "/views/auth/Welcome-view.fxml", "Welcome", null);
       }
       
       @FXML
       public void switchToAdminRevFlights (ActionEvent event) throws IOException {
          	DBUtils.changeScene(event, "/views/admin/Rev-flight-view.fxml", "Welcome", null);
          }
  
}
