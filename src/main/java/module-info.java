module com.example.ratatouille23 {
    requires javafx.controls;
    requires javafx.fxml;
    requires software.amazon.awssdk.services.cognitoidentityprovider;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.awscore;
    requires software.amazon.awssdk.auth;
    requires javafx.base;
    requires javafx.graphics;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    // add icon pack modules
    requires org.kordamp.ikonli.devicons;
    requires org.kordamp.ikonli.material;
    requires org.kordamp.ikonli.materialdesign;
    requires org.controlsfx.controls;
    requires unirest.java;
    requires com.google.gson;

    exports com.example.ratatouille23.Controller;
    opens com.example.ratatouille23.Controller to javafx.fxml;
    exports com.example.ratatouille23.View;
    opens com.example.ratatouille23.View to javafx.fxml;
    exports com.example.ratatouille23;
    opens com.example.ratatouille23 to javafx.fxml;
    exports com.example.ratatouille23.View.AddettoSala;
    opens com.example.ratatouille23.View.AddettoSala to javafx.fxml;
    exports com.example.ratatouille23.Controller.AddettoSala;
    opens com.example.ratatouille23.Controller.AddettoSala to javafx.fxml;
    exports com.example.ratatouille23.View.Admin;
    opens com.example.ratatouille23.View.Admin to javafx.fxml;
    exports com.example.ratatouille23.View.AddettoCucina;
    opens com.example.ratatouille23.View.AddettoCucina to javafx.fxml;
    exports com.example.ratatouille23.Controller.Amministratore;
    opens com.example.ratatouille23.Controller.Amministratore to javafx.fxml;
    exports com.example.ratatouille23.Controller.Login;
    opens com.example.ratatouille23.Controller.Login to javafx.fxml;
    exports com.example.ratatouille23.View.Login;
    opens com.example.ratatouille23.View.Login to javafx.fxml;
    exports com.example.ratatouille23.View.Supervisore;
    opens com.example.ratatouille23.View.Supervisore to javafx.fxml;
    exports com.example.ratatouille23.Utils;
    opens com.example.ratatouille23.Utils to com.google.gson;

}