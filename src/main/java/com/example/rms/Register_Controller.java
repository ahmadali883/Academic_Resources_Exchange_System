/**
 * Sample Skeleton for 'Register.fxml' Controller Class
 */

package com.example.rms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Register_Controller{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="address"
    private TextField password; // Value injected by FXMLLoader

    @FXML // fx:id="email"
    private TextField email; // Value injected by FXMLLoader

    @FXML // fx:id="fullName"
    private TextField fullName; // Value injected by FXMLLoader

    @FXML // fx:id="phoneNum"
    private TextField phoneNum; // Value injected by FXMLLoader

    @FXML // fx:id="registerButton"
    private Button registerButton; // Value injected by FXMLLoader

    @FXML
    private Label Invalid_Email;

    public String getPass() {
        return password.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getFullName() {
        return fullName.getText();
    }

    public String getPhoneNum() {
        return phoneNum.getText();
    }

    @FXML
    void CustomerRegistered(ActionEvent event) {
        String pass = getPass();
        String email_address = getEmail();
        String fullName = getFullName();
        String phoneNum = getPhoneNum();
        if(DBHandler.isValidEmail(email_address)) {
            DBHandler.insertUser(fullName, phoneNum, email_address, pass);
//            phoneNum.

            Invalid_Email.setText("User Registered Successfully");
        }
        else{
            Invalid_Email.setText("Invalid Email");

        }
//        System.out.println(address+" "+cnic+" "+fullName+" "+phoneNum);
    }


    @FXML
    void RegisterCustomer(ActionEvent event) {



    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Register.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'Register.fxml'.";
        assert fullName != null : "fx:id=\"fullName\" was not injected: check your FXML file 'Register.fxml'.";
        assert phoneNum != null : "fx:id=\"phoneNum\" was not injected: check your FXML file 'Register.fxml'.";
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'Register.fxml'.";

    }

}
