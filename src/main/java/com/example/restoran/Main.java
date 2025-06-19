package com.example.restoran;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    DishManager manager = new DishManager();
    TableView<Dish> table = new TableView<>();

    @Override
    public void start(Stage stage) {

        TextField nameField = new TextField();
        nameField.setPromptText("Название");

        TextField compField = new TextField();
        compField.setPromptText("Состав");

        TextField priceField = new TextField();
        priceField.setPromptText("Цена");

        TextField searchField = new TextField();
        searchField.setPromptText("Поиск по названию");

        Button addButton = new Button("Добавить");
        Button searchButton = new Button("Найти");

        TableColumn<Dish, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Dish, String> nameCol = new TableColumn<>("Название");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Dish, String> compCol = new TableColumn<>("Состав");
        compCol.setCellValueFactory(new PropertyValueFactory<>("composition"));

        TableColumn<Dish, Double> priceCol = new TableColumn<>("Цена");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(idCol, nameCol, compCol, priceCol);


        addButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                String comp = compField.getText();
                double price = Double.parseDouble(priceField.getText());

                manager.addDish(name, comp, price);
                updateTable(manager.getAllDishes());

                nameField.clear();
                compField.clear();
                priceField.clear();
            } catch (NumberFormatException ex) {
                showAlert("Ошибка", "Введите правильную цену");
            }
        });
        
        searchButton.setOnAction(e -> {
            String query = searchField.getText();
            List<Dish> result = manager.searchByName(query);
            updateTable(result);
        });

        HBox inputBox = new HBox(10, nameField, compField, priceField, addButton);
        HBox searchBox = new HBox(10, searchField, searchButton);
        VBox root = new VBox(10, inputBox, searchBox, table);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 700, 400);
        stage.setTitle("Меню блюд");
        stage.setScene(scene);
        stage.show();
    }

    private void updateTable(List<Dish> dishes) {
        table.setItems(FXCollections.observableArrayList(dishes));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
