module com.example.cuadradosmedios {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.cuadradosmedios to javafx.fxml;
    exports com.example.cuadradosmedios;
}