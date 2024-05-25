package service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import models.Room;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controllers.DBUtils;

public class serviceviewService implements Initializable {

    @FXML
    private Button bookingBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    @FXML
    public void switchToHotelBooking(ActionEvent event) {
        DBUtils.changeScene(event, "/views/customer/Hotels-view.fxml", "Hotel Booking", null);
    }
    
    


}





