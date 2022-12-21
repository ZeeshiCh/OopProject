module com.example.oopproject {
    requires javafx.controls;
    requires javafx.fxml;


    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    //requires de.jensd.fx.fontawesomefx.fontawesome;

    opens com.example.oopproject to javafx.fxml;
    exports com.example.oopproject;
}