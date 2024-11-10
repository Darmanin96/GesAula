package dad.gesaula.ui.controller;

import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Sexo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class AlumnController implements Initializable {

    @FXML
    private TableColumn<Alumno, String> Apellidos;

    @FXML
    private TableColumn<Alumno, String> Nombre;

    @FXML
    private TableColumn<Alumno, String> sexoColumn;

    @FXML
    private TableColumn<Alumno, LocalDate> fechaNacimiento;

    @FXML
    private TableView<Alumno> tableAlumn;

    @FXML
    private Button Nuevo;

    @FXML
    private Button Delete;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidosField;

    @FXML
    private DatePicker fechaNacimientoPicker;

    @FXML
    private ComboBox<Sexo> sexoComboBox;

    @FXML
    private CheckBox repiteCheckBox;

    @FXML
    private AnchorPane detallePanel;

    private ObservableList<Alumno> alumnosList = FXCollections.observableArrayList();

    @FXML
    void onNewAction(ActionEvent event) {
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre("Sin nombre");
        nuevoAlumno.setApellidos("Sin apellidos");
        nuevoAlumno.setSexo(null);
        nuevoAlumno.setFechaNacimiento(null);
        nuevoAlumno.setRepite(false);
        alumnosList.add(nuevoAlumno);
    }

    @FXML
    void onDeleteAction(ActionEvent event) {
        Alumno selectedAlumno = tableAlumn.getSelectionModel().getSelectedItem();
        if (selectedAlumno != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar alumno");
            alert.setHeaderText("Se va a eliminar el alumno: " + selectedAlumno.getNombre() + " " + selectedAlumno.getApellidos());
            alert.setContentText("¿Está seguro?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                alumnosList.remove(selectedAlumno);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Inicializar lista y columnas
        tableAlumn.setItems(alumnosList);

        Nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        Apellidos.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        fechaNacimiento.setCellValueFactory(cellData -> cellData.getValue().fechaNacimientoProperty());

        // Convertir Sexo en String para la columna de sexo
        sexoColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getSexo() != null ? cellData.getValue().getSexo().toString() : "")
        );

        // Inicializar ComboBox de sexo con valores del enum Sexo
        sexoComboBox.setItems(FXCollections.observableArrayList(Sexo.values()));
        sexoComboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Sexo sexo) {
                return sexo != null ? sexo.name() : "";
            }

            @Override
            public Sexo fromString(String string) {
                return Sexo.valueOf(string);
            }
        });

        // Sincronizar los campos del panel derecho con el alumno seleccionado en la tabla
        tableAlumn.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            detallePanel.setVisible(newSelection != null); // Muestra o esconde el panel según la selección
            if (newSelection != null) {
                // Sincronizar campos con el objeto Alumno seleccionado
                nombreField.setText(newSelection.getNombre());
                apellidosField.setText(newSelection.getApellidos());
                fechaNacimientoPicker.setValue(newSelection.getFechaNacimiento());
                sexoComboBox.setValue(newSelection.getSexo());
                repiteCheckBox.setSelected(newSelection.isRepite());
            }
        });

        // Escuchar cambios en los campos y actualizar el alumno seleccionado
        nombreField.textProperty().addListener((obs, oldText, newText) -> {
            Alumno selectedAlumno = tableAlumn.getSelectionModel().getSelectedItem();
            if (selectedAlumno != null) {
                selectedAlumno.setNombre(newText);
            }
        });

        apellidosField.textProperty().addListener((obs, oldText, newText) -> {
            Alumno selectedAlumno = tableAlumn.getSelectionModel().getSelectedItem();
            if (selectedAlumno != null) {
                selectedAlumno.setApellidos(newText);
            }
        });

        fechaNacimientoPicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            Alumno selectedAlumno = tableAlumn.getSelectionModel().getSelectedItem();
            if (selectedAlumno != null) {
                selectedAlumno.setFechaNacimiento(newDate);
            }
        });

        sexoComboBox.valueProperty().addListener((obs, oldSexo, newSexo) -> {
            Alumno selectedAlumno = tableAlumn.getSelectionModel().getSelectedItem();
            if (selectedAlumno != null) {
                selectedAlumno.setSexo(newSexo);
            }
        });

        repiteCheckBox.selectedProperty().addListener((obs, oldRepite, newRepite) -> {
            Alumno selectedAlumno = tableAlumn.getSelectionModel().getSelectedItem();
            if (selectedAlumno != null) {
                selectedAlumno.setRepite(newRepite);
            }
        });
    }
}
