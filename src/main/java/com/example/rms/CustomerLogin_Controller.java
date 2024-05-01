/**
 * Sample Skeleton for 'CustomerLogin.fxml' Controller Class
 */

package com.example.rms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CustomerLogin_Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cnic"
    private TextField cnic; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader

    @FXML
    void GoToCustomerMenu(ActionEvent event) {

    }

    @FXML
    void GoToMainPage(ActionEvent event) {

    }

    @FXML
    void RegisterCustomer1(ActionEvent event) throws IOException {
        BorderPane root = (BorderPane) FXMLLoader.load(this.getClass().getResource("Register.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void validateCnic(KeyEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cnic != null : "fx:id=\"cnic\" was not injected: check your FXML file 'CustomerLogin.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'CustomerLogin.fxml'.";

    }

}
