module com.example.testejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testejavafx to javafx.fxml;
    exports com.example.testejavafx;
}