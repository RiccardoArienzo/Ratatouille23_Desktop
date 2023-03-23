module com.example.ratatouille23 {
    requires javafx.controls;
    requires javafx.fxml;
    requires software.amazon.awssdk.services.cognitoidentityprovider;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.awscore;
    requires software.amazon.awssdk.auth;

    exports com.example.ratatouille23.Controller;
    opens com.example.ratatouille23.Controller to javafx.fxml;
    exports com.example.ratatouille23.View;
    opens com.example.ratatouille23.View to javafx.fxml;
    exports com.example.ratatouille23;
    opens com.example.ratatouille23 to javafx.fxml;
}