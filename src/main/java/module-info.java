module com.example.calculadoradedesempenhovesp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculadoradedesempenhovesp to javafx.fxml;
    exports com.example.calculadoradedesempenhovesp;
}