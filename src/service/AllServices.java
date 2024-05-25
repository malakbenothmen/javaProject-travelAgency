package service;

import java.io.IOException;

import controllers.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AllServices {
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
       public void switchToAdminRevHotel(ActionEvent event) throws IOException {
       	DBUtils.changeScene(event, "/views/admin/HotelReservations.fxml", "Admin Dashboard", null);
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
