module com.example.ratatouille23 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ratatouille23 to javafx.fxml;
    exports com.example.ratatouille23;
    exports com.example.ratatouille23.homepage;
    opens com.example.ratatouille23.homepage to javafx.fxml;
    exports com.example.ratatouille23.personalizzaMenu;
    opens com.example.ratatouille23.personalizzaMenu to javafx.fxml;
    exports com.example.ratatouille23.creaUtente;
    opens com.example.ratatouille23.creaUtente to javafx.fxml;
    opens com.example.ratatouille23.inserisciAvvisi to javafx.fxml;
    exports com.example.ratatouille23.inserisciAvvisi;
}