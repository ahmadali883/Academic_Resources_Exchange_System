package com.example.rms; /**
 * Sample Skeleton for 'adminMenu.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class adminMenu_Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="flaggedContentButton"
    private Button flaggedContentButton; // Value injected by FXMLLoader

    @FXML // fx:id="manageResourcesButton"
    private Button manageResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="reportsButton"
    private Button reportsButton; // Value injected by FXMLLoader

    @FXML // fx:id="reviewContributionsButton"
    private Button reviewContributionsButton; // Value injected by FXMLLoader

    @FXML // fx:id="userManagementButton"
    private Button userManagementButton; // Value injected by FXMLLoader

    @FXML
    void flaggedContent(ActionEvent event) {

    }

    @FXML
    void manageResources(ActionEvent event) {

    }

    @FXML
    void reports(ActionEvent event) {

    }

    @FXML
    void reviewContributions(ActionEvent event) {

    }

    @FXML
    void userManagement(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert flaggedContentButton != null : "fx:id=\"flaggedContentButton\" was not injected: check your FXML file 'adminMenu.fxml'.";
        assert manageResourcesButton != null : "fx:id=\"manageResourcesButton\" was not injected: check your FXML file 'adminMenu.fxml'.";
        assert reportsButton != null : "fx:id=\"reportsButton\" was not injected: check your FXML file 'adminMenu.fxml'.";
        assert reviewContributionsButton != null : "fx:id=\"reviewContributionsButton\" was not injected: check your FXML file 'adminMenu.fxml'.";
        assert userManagementButton != null : "fx:id=\"userManagementButton\" was not injected: check your FXML file 'adminMenu.fxml'.";

    }

}
