package service;

import java.io.IOException;

import controllers.AirlineController;
import controllers.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import models.Airline;

public class AirlineViewService {

    @FXML
    private TextField nameField;
    @FXML
    private TextField airlineIdField;
    @FXML
    private TextField conventionField;
    @FXML
    private ListView<String> airlineListView;

    private AirlineController airlineController;

    public AirlineViewService() {
        airlineController = new AirlineController();
    }

    @FXML
    private void initialize() {
        refreshAirlineList();
        
    }

    @FXML
    private void handleAddAirline() {
        try {
            String name = nameField.getText();
            
            int convention = Integer.parseInt(conventionField.getText());

            airlineController.createAirline(name,convention);
            refreshAirlineList();
            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Invalid Convention Value", "Please enter a valid integer for the convention field.");
        }
    }

    @FXML
    private void handleUpdateAirline() {
        try {
            String name = nameField.getText();
            String airlineId = airlineIdField.getText();
            int convention = Integer.parseInt(conventionField.getText());

            airlineController.updateAirline(airlineId, name, convention);
            refreshAirlineList();
            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Invalid Convention Value", "Please enter a valid integer for the convention field.");
        }
    }

    @FXML
    private void handleDeleteAirline() {
        String airlineId = airlineIdField.getText();
        boolean success = airlineController.deleteAirline(airlineId);
        if (success) {
            refreshAirlineList();
            clearFields();
        } else {
            showAlert("Deletion Failed", "Airline Not Found", "No airline found with the provided ID.");
        }
    }
    @FXML
    public void switchToAdminHotel(ActionEvent event) throws IOException {
    	DBUtils.changeScene(event, "/views/admin/Hotel-view.fxml", "Admin Dashboard", null);
    }

    @FXML
    private void handleGetAirlineById() {
        String airlineId = airlineIdField.getText();
        Airline airline = airlineController.getAirlineById(airlineId);
        if (airline != null) {
            nameField.setText(airline.getName());
            conventionField.setText(String.valueOf(airline.getConvention()));
        } else {
            showAlert("Not Found", "Airline Not Found", "No airline found with the provided ID.");
        }
    }

    private void refreshAirlineList() {
        airlineListView.getItems().clear();
        for (Airline airline : airlineController.getAllAirlines()) {
            airlineListView.getItems().add(airline.getAirline_id()+ "-" +airline.getName() + " - "+ airline.getConvention());
        }
    }
    
    @FXML
    private void handleAirlineSelection(MouseEvent event) {
        String selectedAirlineString = airlineListView.getSelectionModel().getSelectedItem();
        if (selectedAirlineString != null) {
            String[] parts = selectedAirlineString.split(" - ");
            String airlineId = parts[0]; 

            Airline selectedAirline = airlineController.getAirlineById(airlineId);
            if (selectedAirline != null) {
                airlineIdField.setText(String.valueOf(selectedAirline.getAirline_id()));
                nameField.setText(selectedAirline.getName());
                conventionField.setText(String.valueOf(selectedAirline.getConvention()));
            }
        }
    }

    private void clearFields() {
        nameField.clear();
        airlineIdField.clear();
        conventionField.clear();
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
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
}
