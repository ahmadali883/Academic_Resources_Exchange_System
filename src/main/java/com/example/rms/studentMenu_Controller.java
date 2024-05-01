/**
 * Sample Skeleton for 'studentMenu.fxml' Controller Class
 */

package com.example.rms;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class studentMenu_Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="browseResourcesButton"
    private Button browseResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="downloadExamPapersButton"
    private Button downloadExamPapersButton; // Value injected by FXMLLoader

    @FXML
    void browseResourcesAction(ActionEvent event) {

    }

    @FXML
    void collaborateProjectsAction(ActionEvent event) {

    }

    @FXML
    void contributeMaterialsAction(ActionEvent event) throws IOException {
        VBox root = (VBox) FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TestFIleupload.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void downloadExamPapersAction(ActionEvent event) {

    }

    @FXML
    void favoritesAction(ActionEvent event) {

    }

    @FXML
    void rateReviewAction(ActionEvent event) {

    }

    @FXML
    void requestResourcesAction(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert browseResourcesButton != null : "fx:id=\"browseResourcesButton\" was not injected: check your FXML file 'studentMenu.fxml'.";
        assert downloadExamPapersButton != null : "fx:id=\"downloadExamPapersButton\" was not injected: check your FXML file 'studentMenu.fxml'.";

    }

}
