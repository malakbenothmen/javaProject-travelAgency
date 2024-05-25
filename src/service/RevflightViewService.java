package service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import models.Aircraft;
import models.Billflight;
import models.Flight;
import controllers.DBUtils;
import controllers.FlightController;
import controllers.RevBilletController;

import java.io.IOException;
import java.util.HashMap;

public class RevflightViewService {

    @FXML
    private TextField FlightNumField;
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField passportField;
    @FXML
    private ComboBox<String> SeatTypeField;
    @FXML
    private Label pricetot;
    @FXML
    private Label numSeat;
    @FXML
    private RadioButton AdultRadioButton;
    @FXML
    private RadioButton InfantRadioButton;
    @FXML
    private RadioButton StudantRadioButton;
    @FXML
    private RadioButton BabyRadioButton;
    @FXML
    private TextField flightIdField;
    @FXML
    private TextField userIdField;

    private ToggleGroup categoryGroup;
    
    FlightController flightController = new FlightController();

    // Example price calculation data
    private final HashMap<String, Double> categoryPrices = new HashMap<String, Double>() {{
        put("Adult", 100.0);
        put("Infant", 50.0);
        put("Studant", 75.0);
        put("Baby", 25.0);
    }};

    private final HashMap<String, Double> classPrices = new HashMap<String, Double>() {{
        put("First", 200.0);
        put("Economy", 100.0);
        put("Business", 150.0);
    }};

    // Example seat availability data
    private final HashMap<String, Integer> availableSeats = new HashMap<String, Integer>() {{
        put("First", 10);
        put("Economy", 50);
        put("Business", 20);
    }};

    @FXML
    private void initialize() {
        categoryGroup = new ToggleGroup();
        AdultRadioButton.setToggleGroup(categoryGroup);
        InfantRadioButton.setToggleGroup(categoryGroup);
        StudantRadioButton.setToggleGroup(categoryGroup);
        BabyRadioButton.setToggleGroup(categoryGroup);

        SeatTypeField.getItems().addAll("First", "Economy", "Business");
    }

    @FXML
    private void handleContinue() {
        RadioButton selectedCategory = (RadioButton) categoryGroup.getSelectedToggle();
        String category = selectedCategory != null ? selectedCategory.getText() : null;
        String seatClass = SeatTypeField.getValue();

        if (category == null || seatClass == null) {
            showAlert(AlertType.ERROR, "Selection Error", "Please select a category and a seat class.");
            return;
        }

        double categoryPrice = categoryPrices.getOrDefault(category, 0.0);
        double classPrice = classPrices.getOrDefault(seatClass, 0.0);
        double totalPrice = categoryPrice + classPrice;

        pricetot.setText(String.format("$%.2f", totalPrice));

        // Calculate seat number
        int availableSeat = availableSeats.getOrDefault(seatClass, 0);
        if (availableSeat > 0) {
            numSeat.setText(String.valueOf(availableSeat));
            availableSeats.put(seatClass, availableSeat - 1);
        } else {
            numSeat.setText("None");
            showAlert(AlertType.WARNING, "Availability Warning", "No available seats in " + seatClass);
        }
    }

    @FXML
    private void handlePaiment() {
        try {
            int flightId = Integer.parseInt(flightIdField.getText());
            int userId = Integer.parseInt(userIdField.getText());
            String fullName = fullNameField.getText();
            int passport = Integer.parseInt(passportField.getText());
            String category = ((RadioButton) categoryGroup.getSelectedToggle()).getText();
            String seatType = SeatTypeField.getValue();
            double priceFrais = Double.parseDouble(pricetot.getText().replace("$", "").replace(",", "."));
            int seatNumber = Integer.parseInt(numSeat.getText());

            Billflight billflight = new Billflight(flightId, userId, fullName, passport, priceFrais, category, seatType, seatNumber);
            RevBilletController revBilletController = new RevBilletController();
            revBilletController.createBillflight(billflight);
            setAvailabilityFlight(flightId,category) ;

            showAlert(AlertType.INFORMATION, "Payment", "The flight ticket has been successfully created.");
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Input Error", "Please check your input values.");
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Error", "An unexpected error occurred.");
            e.printStackTrace();
        }
    }
   
    
    	

    private void setAvailabilityFlight(int flightId, String seatType) {
		Flight flight =flightController.getFlightById(flightId);
		int cap_class;
		if (seatType=="Economy")
		 cap_class = flight.getAircraft().getEconomic_cap();
		else 
		{if(seatType=="Business")
			cap_class = flight.getAircraft().getBusiness_cap();
		else
			cap_class = flight.getAircraft().getFirst_cap();
			
			}
		
	
	}

	private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
	
	
	@FXML
	public void switchToAircrafts(ActionEvent event) throws IOException {
	    DBUtils.changeScene(event, "/views/admin/Aircraft-view.fxml", "Admin Dashboard", null);
	}

    @FXML
    public void switchToHotels(ActionEvent event) throws IOException {
        DBUtils.changeScene(event, "/views/admin/Hotel-view.fxml", "Admin Dashboard", null);
    }

    @FXML
    public void switchToAirlines(ActionEvent event) throws IOException {
        DBUtils.changeScene(event, "/views/admin/Airline-view.fxml", "Admin Dashboard", null);
    }

    @FXML
    public void switchToFlights(ActionEvent event) throws IOException {
        DBUtils.changeScene(event, "/views/admin/Flight-view.fxml", "Admin Dashboard", null);
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
       public void switchToServices(ActionEvent event) throws IOException {
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
