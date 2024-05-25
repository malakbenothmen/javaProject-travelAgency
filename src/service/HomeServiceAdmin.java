package service;

import java.io.IOException;

import controllers.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HomeServiceAdmin {
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
    
}
