module com.example.projet1javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires javafx.graphics;

    opens com.example.projet1javafx to javafx.fxml;
    exports com.example.projet1javafx;
}