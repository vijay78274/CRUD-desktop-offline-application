package com.example;

import javafx.fxml.FXML;

import javafx.collections.*;
import javafx.scene.control.*;


public class StudentController {

    @FXML private TextField nameField, emailField;
    @FXML private TableView<Student> table;
    @FXML private TableColumn<Student, Integer> idCol;
    @FXML private TableColumn<Student, String> nameCol, emailCol;

    private StudentDAO dao = new StudentDAO();

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getId()).asObject());
        nameCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));
        emailCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getEmail()));
        loadData();
    }

    private void loadData() {
        table.setItems(FXCollections.observableArrayList(dao.findAll()));
    }

    public void addStudent() {
        dao.save(new Student(0, nameField.getText(), emailField.getText()));
        loadData();
        nameField.clear();
        emailField.clear();
    }

    public void deleteStudent() {
        Student s = table.getSelectionModel().getSelectedItem();
        if (s != null) {
            dao.delete(s.getId());
            loadData();
        }
    }
}
