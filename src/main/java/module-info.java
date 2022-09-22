module com.example.arraysproject {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.arraysproject to javafx.fxml;
    exports com.example.arraysproject;
}