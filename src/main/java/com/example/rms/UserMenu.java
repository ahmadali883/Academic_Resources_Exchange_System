/**
 * Sample Skeleton for 'CustomerMenu.fxml' Controller Class
 */

package com.example.rms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserMenu {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="bookTicketButton"
    private Button bookTicketButton; // Value injected by FXMLLoader

    @FXML // fx:id="cancelTicketButton"
    private Button cancelTicketButton; // Value injected by FXMLLoader

    @FXML // fx:id="seatChangeButton"
    private Button seatChangeButton; // Value injected by FXMLLoader

    @FXML
    void ChkFare(ActionEvent event) {

    }

    @FXML
    void Complaints(ActionEvent event) {

    }

    @FXML
    void ProceedToSeatChange(ActionEvent event) {

    }

    @FXML
    void ProceedToTicketBooking(ActionEvent event) {

    }

    @FXML
    void ProceedToTicketCancellation(ActionEvent event) {

    }

    @FXML
    void RegisterCustomer(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert bookTicketButton != null : "fx:id=\"bookTicketButton\" was not injected: check your FXML file 'CustomerMenu.fxml'.";
        assert cancelTicketButton != null : "fx:id=\"cancelTicketButton\" was not injected: check your FXML file 'CustomerMenu.fxml'.";
        assert seatChangeButton != null : "fx:id=\"seatChangeButton\" was not injected: check your FXML file 'CustomerMenu.fxml'.";

    }

}
