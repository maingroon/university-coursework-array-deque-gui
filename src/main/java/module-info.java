module com.sumdu {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sumdu to javafx.fxml;
    exports com.sumdu;
    exports com.sumdu.controller;
    opens com.sumdu.controller to javafx.fxml;
}