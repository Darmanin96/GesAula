package dad.gesaula.ui.controller;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.net.*;
import java.util.*;

public class GroupController implements Initializable {

    @FXML
    private Label ActitudLabel;

    @FXML
    private Slider ActitudSlider;

    @FXML
    private TextField Denominacion;

    @FXML
    private Label ExamLabel;

    @FXML
    private Slider ExamenesSlider;

    @FXML
    private DatePicker InicioCurso;

    @FXML
    private Label PracticasLabel;

    @FXML
    private Slider PracticasSlider;

    @FXML
    private DatePicker finCurso;

    @FXML
    private GridPane root;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ExamenesSlider.setOnMouseReleased(event -> {
            ExamLabel.setText(String.format("%.0f%%", ExamenesSlider.getValue()));
        });

        PracticasSlider.setOnMouseReleased(event -> {
            PracticasLabel.setText(String.format("%.0f%%", PracticasSlider.getValue()));
        });

        ActitudSlider.setOnMouseReleased(event -> {
            ActitudLabel.setText(String.format("%.0f%%", ActitudSlider.getValue()));
        });
    }

    public GroupController() {

    }


    public Label getActitudLabel() {
        return ActitudLabel;
    }

    public void setActitudLabel(Label actitudLabel) {
        ActitudLabel = actitudLabel;
    }

    public Slider getActitudSlider() {
        return ActitudSlider;
    }

    public void setActitudSlider(Slider actitudSlider) {
        ActitudSlider = actitudSlider;
    }

    public TextField getDenominacion() {
        return Denominacion;
    }

    public void setDenominacion(TextField denominacion) {
        Denominacion = denominacion;
    }

    public Label getExamLabel() {
        return ExamLabel;
    }

    public void setExamLabel(Label examLabel) {
        ExamLabel = examLabel;
    }

    public Slider getExamenesSlider() {
        return ExamenesSlider;
    }

    public void setExamenesSlider(Slider examenesSlider) {
        ExamenesSlider = examenesSlider;
    }

    public DatePicker getInicioCurso() {
        return InicioCurso;
    }

    public void setInicioCurso(DatePicker inicioCurso) {
        InicioCurso = inicioCurso;
    }

    public Label getPracticasLabel() {
        return PracticasLabel;
    }

    public void setPracticasLabel(Label practicasLabel) {
        PracticasLabel = practicasLabel;
    }

    public Slider getPracticasSlider() {
        return PracticasSlider;
    }

    public void setPracticasSlider(Slider practicasSlider) {
        PracticasSlider = practicasSlider;
    }

    public DatePicker getFinCurso() {
        return finCurso;
    }

    public void setFinCurso(DatePicker finCurso) {
        this.finCurso = finCurso;
    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }
}
