package service;

import java.io.IOException;
import java.util.List;

import controllers.DBUtils;
import controllers.UsersController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.User;

public class UsersViewService {

    private UsersController usersController;
   

    @FXML
    private TextField address_field;

    @FXML
    private TextField cin_field;

    @FXML
    private TextField email_field;

    @FXML
    private TextField fullname_field;

    @FXML
    private TextField passport_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField phone_field;

    @FXML
    private ListView<String> userListView;

    @FXML
    private TextField UserIdField;

    @FXML
    private TextField searchField;

    public UsersViewService() {
        usersController = new UsersController();
    }

    @FXML
    private void initialize() {
        refreshUserList();
    }

    private void refreshUserList() {
        userListView.getItems().clear();
        for (User u : UsersController.getAllUsers()) {
            String userString = String.format("%d - %s - %s - %s - %s - %s - %s - %s - %s - %s",
                    u.getUserId(), u.getFullName(), u.getCin(), u.getPassport(), u.getPhone(),
                    u.getEmail(), u.getPassword(), u.getAddress(), u.getRole(), u.getAccountStatus());
            userListView.getItems().add(userString);
        }
    }

    @FXML
    private void handleAddUser() {
        String fullname = fullname_field.getText();
        String cin = cin_field.getText();
        String passport = passport_field.getText();
        String phone = phone_field.getText();
        String email = email_field.getText();
        String password = password_field.getText();
        String address = address_field.getText();

        if (fullname.isEmpty() || cin.isEmpty() || passport.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty()) {
            showAlert("Input Error", "Empty Fields", "All fields must be filled.");
            return;
        }

        usersController.handleAddUser(fullname, cin, passport, phone, email, password, address);
        refreshUserList();
    }

    @FXML
    private void handleUpdateUser() {
        int userId;
        try {
            userId = Integer.parseInt(UserIdField.getText());
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Invalid ID", "User ID must be a valid integer.");
            return;
        }

        String fullname = fullname_field.getText();
        String cin = cin_field.getText();
        String passport = passport_field.getText();
        String phone = phone_field.getText();
        String email = email_field.getText();
        String password = password_field.getText();
        String address = address_field.getText();
        String accountStatus = "Active"; // Assuming a default value for account status

        if (fullname.isEmpty() || cin.isEmpty() || passport.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty()) {
            showAlert("Input Error", "Empty Fields", "All fields must be filled.");
            return;
        }

        User updatedUser = UsersController.updateUser(userId, fullname, cin, passport, phone, email, password, address, accountStatus);
        if (updatedUser != null) {
            refreshUserList();
        } else {
            showAlert("Update Error", "Update Failed", "Failed to update user details.");
        }
    }

    @FXML
    private void handleDeleteUser() {
        int userId;
        try {
            userId = Integer.parseInt(UserIdField.getText());
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Invalid ID", "User ID must be a valid integer.");
            return;
        }

        boolean isDeleted = usersController.deleteUser(userId);
        if (isDeleted) {
            refreshUserList();
        } else {
            showAlert("Deletion Error", "Deletion Failed", "Failed to delete the user.");
        }
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void handleSearch() {
        String query = searchField.getText();
        List<User> searchResults = usersController.searchUsers(query);
        userListView.getItems().clear();
        for (User u : searchResults) {
            String userString = String.format("%d - %s - %s - %s - %s - %s - %s - %s - %s - %s",
                    u.getUserId(), u.getFullName(), u.getCin(), u.getPassport(), u.getPhone(),
                    u.getEmail(), u.getPassword(), u.getAddress(), u.getRole(), u.getAccountStatus());
            userListView.getItems().add(userString);
        }
    }

    @FXML
    private void handleUsersSelection(MouseEvent event) {
        String selectedUserString = userListView.getSelectionModel().getSelectedItem();
        if (selectedUserString != null) {
            String[] parts = selectedUserString.split(" - ");
            if (parts.length == 10) { 
                int userId = Integer.parseInt(parts[0]);
                String fullName = parts[1];
                String cin = parts[2];
                String passport = parts[3];
                String phone = parts[4];
                String email = parts[5];
                String password = parts[6];
                String address = parts[7];
                String role = parts[8];
                String accountStatus = parts[9];

                UserIdField.setText(String.valueOf(userId));
                fullname_field.setText(fullName);
                cin_field.setText(cin);
                passport_field.setText(passport);
                phone_field.setText(phone);
                email_field.setText(email);
                password_field.setText(password);
                address_field.setText(address);
            } else {
                System.err.println("Invalid format for selected user string.");
            }
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
}
