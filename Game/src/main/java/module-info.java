module com.example.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.game to javafx.fxml;
    exports com.example.game;
    exports model;
    opens model to javafx.fxml;
    exports Hero;
    opens Hero to javafx.fxml;
}