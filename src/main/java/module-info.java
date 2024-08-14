module com.example.databaseproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example.databaseproject to javafx.fxml;
    exports com.example.databaseproject;
}