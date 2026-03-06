module org.example.pharmacypos_layered {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires jbcrypt;
    requires static lombok;

    exports org.example.pharmacypos_layered;
    opens org.example.pharmacypos_layered;

    exports org.example.pharmacypos_layered.controller.page;
    opens org.example.pharmacypos_layered.controller.page to javafx.fxml;
}
