module org.example.pharmacypos_layered {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires static lombok;
    requires jbcrypt;

    opens org.example.pharmacypos_layered to javafx.fxml;
    exports org.example.pharmacypos_layered;

    opens org.example.pharmacypos_layered.controller to javafx.fxml;

}