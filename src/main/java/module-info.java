module org.example.pharmacypos_layered {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires jbcrypt;
    requires static lombok;

    opens org.example.pharmacypos_layered.controller to javafx.fxml;

    exports org.example.pharmacypos_layered;
    opens org.example.pharmacypos_layered.controller.DashBoard to javafx.fxml;
}
