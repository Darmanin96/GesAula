package dad.gesaula.ui.controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class RootController implements Initializable {


    @FXML
    private Tab Alumno;

    @FXML
    private Tab Grupo;

    @FXML
    private Button New;

    @FXML
    private Button Save;

    @FXML
    private BorderPane root;

    @FXML
    private TextField Nombre;

    @FXML
    void onNewAction(ActionEvent event) {
        try {
            String archivo = Nombre.getText().trim();
            if (archivo.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Nombre del archivo vacío");
                alert.setContentText("El nombre del archivo está vacío. Por favor, introduce un nombre.");
                alert.showAndWait();
            } else {
                File file = new File(archivo);
                if (file.exists()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("El archivo ya existe");
                    alert.setContentText("El archivo ya existe. Por favor, introduce un nombre diferente.");
                    alert.showAndWait();
                } else {
                    file.createNewFile();
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Hecho");
                        alert.setHeaderText("Se ha creado el archivo");
                        alert.setContentText("EL archivo se ha creado con el nombre de " + Nombre.getText());
                        alert.showAndWait();

                }
            }
        } catch (IOException e) {
            // Manejar excepciones IO
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Entrada/Salida");
            alert.setHeaderText("Ocurrió un error al crear el archivo.");
            alert.setContentText("Detalles del error: " + e.getMessage());
            alert.showAndWait();  // Mostrar la alerta de error con el detalle de la excepción
        }

    }

    @FXML
    void onSaveAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public RootController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextField getNombre() {
        return Nombre;
    }

    public void setNombre(TextField nombre) {
        Nombre = nombre;
    }

    public Tab getAlumno() {
        return Alumno;
    }

    public void setAlumno(Tab alumno) {
        Alumno = alumno;
    }

    public Tab getGrupo() {
        return Grupo;
    }

    public void setGrupo(Tab grupo) {
        Grupo = grupo;
    }

    public Button getNew() {
        return New;
    }

    public void setNew(Button aNew) {
        New = aNew;
    }

    public Button getSave() {
        return Save;
    }

    public void setSave(Button save) {
        Save = save;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }
}
