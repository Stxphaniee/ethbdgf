package com.example.labo11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.control.Button;
import org.poo.laboratorio.Empleado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HelloController {
    private final List<Empleado> employees = new ArrayList<>();
    private ObservableList<Empleado> itemsToRender;

    @FXML
    private ListView<Empleado> lvEmployees;

    @FXML
    private Button btnSortByName;

    @FXML
    private Button btnSortBySalary;

    protected void initList() {
        employees.add(new Empleado("Marta", 40, 1500.89));
        employees.add(new Empleado("Enrique", 35, 500.5));
        employees.add(new Empleado("María", 32, 450.0));
        employees.add(new Empleado("Melissa", 56, 2000.0));
        employees.add(new Empleado("Víctor", 28, 1200.0));
        employees.add(new Empleado("Daniel", 32, 1000.0));
        employees.add(new Empleado("Rebeca", 41, 800.0));
        employees.add(new Empleado("Eduardso", 25, 1500.89));
    }

    public void initialize() {
        initList();


        // configuracion de listView
        itemsToRender = FXCollections.observableArrayList(employees);
        lvEmployees.setItems(itemsToRender);


        lvEmployees.setCellFactory(param -> new ListCell<Empleado>() {
            @Override
            protected void updateItem(Empleado item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item.getName() + " - Age: " + item.getAge() + ", Salary: " + item.getSalary());
                }
            }
        });



        btnSortByName.setOnAction(event -> sortByName());
        btnSortBySalary.setOnAction(event -> sortBySalary());
    }

    private void sortByName() {
        FXCollections.sort(itemsToRender, Comparator.comparing(Empleado::getName));
    }


    private void sortBySalary() {
        FXCollections.sort(itemsToRender, Comparator.comparing(Empleado::getSalary));
    }
}