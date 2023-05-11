module com.example.ratatouille23 {
    requires javafx.controls;
    requires javafx.fxml;
    requires software.amazon.awssdk.services.cognitoidentityprovider;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.awscore;
    requires software.amazon.awssdk.auth;
//    requires javafx.base;
    requires javafx.graphics;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    // add icon pack modules
    requires org.kordamp.ikonli.devicons;
    requires org.kordamp.ikonli.material;
    requires org.kordamp.ikonli.materialdesign;
    //per http
    requires unirest.java;


    requires java.base;
    requires com.google.gson;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

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
    opens com.example.ratatouille23.Model to com.google.gson;
//    opens java.base to com.google.gson;


}







//module com.example.ratatouille23 {

//    requires javafx.controls;
//    requires javafx.fxml;
//    requires software.amazon.awssdk.services.cognitoidentityprovider;
//    requires software.amazon.awssdk.regions;
//    requires software.amazon.awssdk.awscore;
//    requires software.amazon.awssdk.auth;
//    requires javafx.base;
//    requires javafx.graphics;
//    requires org.kordamp.ikonli.core;
//    requires org.kordamp.ikonli.javafx;
//    // add icon pack modules
//    requires org.kordamp.ikonli.devicons;
//    requires org.kordamp.ikonli.material;
//    requires org.kordamp.ikonli.materialdesign;
//    requires gson;
//    //per http
//    requires unirest.java;
//
//    requires java.sql;
//    requires com.fasterxml.jackson.databind;
//
//    exports com.example.ratatouille23.Controller;
//    opens com.example.ratatouille23.Controller to javafx.fxml;
//    exports com.example.ratatouille23.View;
//    opens com.example.ratatouille23.View to javafx.fxml;
//    exports com.example.ratatouille23;
//    opens com.example.ratatouille23 to javafx.fxml;
//    exports com.example.ratatouille23.View.AddettoSala;
//    opens com.example.ratatouille23.View.AddettoSala to javafx.fxml;
//    exports com.example.ratatouille23.Controller.AddettoSala;
//    opens com.example.ratatouille23.Controller.AddettoSala to javafx.fxml;
//    exports com.example.ratatouille23.View.Admin;
//    opens com.example.ratatouille23.View.Admin to javafx.fxml;
//    exports com.example.ratatouille23.View.AddettoCucina;
//    opens com.example.ratatouille23.View.AddettoCucina to javafx.fxml;
//    exports com.example.ratatouille23.Controller.Amministratore;
//    opens com.example.ratatouille23.Controller.Amministratore to javafx.fxml;
//    exports com.example.ratatouille23.Controller.Login;
//    opens com.example.ratatouille23.Controller.Login to javafx.fxml;
//    exports com.example.ratatouille23.View.Login;
//    opens com.example.ratatouille23.View.Login to javafx.fxml;
//    exports com.example.ratatouille23.View.Supervisore;
//    opens com.example.ratatouille23.View.Supervisore to javafx.fxml;
//   // opens com.example.ratatouille23.Model to gson;
//   // opens com.example.ratatouille23 to com.google.gson;

//}