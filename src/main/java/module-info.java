module com.example.labo11 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.labo11 to javafx.fxml;
    exports com.example.labo11;
}
