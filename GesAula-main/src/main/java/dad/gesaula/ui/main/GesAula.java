package dad.gesaula.ui.main;

import dad.gesaula.ui.controller.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class GesAula extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        RootController root = new RootController();
        Stage stage = new Stage();
        stage.setTitle("GesAula");
        stage.setScene(new Scene(root.getRoot()));
        stage.show();
    }
}
