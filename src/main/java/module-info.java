module com.example.rms {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.rms to javafx.fxml;
    exports com.example.rms;
//    exports application;
//    opens application to javafx.fxml;

}