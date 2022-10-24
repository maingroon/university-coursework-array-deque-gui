module com.sumdu.arraydequegui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sumdu.arraydequegui to javafx.fxml;
    exports com.sumdu.arraydequegui;
}