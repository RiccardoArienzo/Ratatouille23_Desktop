module com.example.ratatouille23 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ratatouille23 to javafx.fxml;
    exports com.example.ratatouille23;
    exports com.example.ratatouille23.Controller;
    opens com.example.ratatouille23.Controller to javafx.fxml;
}