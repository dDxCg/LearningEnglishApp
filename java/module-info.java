module lea.lea {
    requires javafx.controls;
    requires javafx.fxml;


    opens lea.lea to javafx.fxml;
    exports lea.lea;
}