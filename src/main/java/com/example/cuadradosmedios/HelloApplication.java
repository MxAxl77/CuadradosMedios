package com.example.cuadradosmedios;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    @FXML
    private TextField initialNumberField;
    @FXML
    private TextField numberOfDigitsField;
    @FXML
    private TextField numberOfRandomNumbersField;
    @FXML
    private Label resultLabel;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox root = fxmlLoader.load();

        initialNumberField = (TextField) root.lookup("#initialNumberField");
        numberOfDigitsField = (TextField) root.lookup("#numberOfDigitsField");
        numberOfRandomNumbersField = (TextField) root.lookup("#numberOfRandomNumbersField");
        resultLabel = (Label) root.lookup("#resultLabel");

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Cuadrados Medios");
        stage.setScene(scene);
        stage.show();
    }

    public void generateRandomNumbers() {
        try {
            int initialNumber = Integer.parseInt(initialNumberField.getText());
            int numberOfDigits = Integer.parseInt(numberOfDigitsField.getText());
            int numberOfRandomNumbers = Integer.parseInt(numberOfRandomNumbersField.getText());

            List<Integer> randomNumbers = generatePseudoRandomNumbers(initialNumber, numberOfDigits, numberOfRandomNumbers);
            resultLabel.setText("Números generados: " + randomNumbers.toString());
        } catch (NumberFormatException e) {
            resultLabel.setText("Por favor, ingrese números válidos en todos los campos.");
        }
    }

    private List<Integer> generatePseudoRandomNumbers(int initialNumber, int numberOfDigits, int count) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int square = initialNumber * initialNumber;
            String squareStr = String.valueOf(square);
            int numDigits = squareStr.length();
            int padding = numberOfDigits - numDigits;
            if (padding > 0) {
                squareStr = "0".repeat(padding) + squareStr;
            }
            int midIndex = (numDigits - numberOfDigits) / 2;
            int randomNumber = Integer.parseInt(squareStr.substring(midIndex, midIndex + numberOfDigits));
            randomNumbers.add(randomNumber);
            initialNumber = randomNumber; // Actualizar el número inicial para la siguiente iteración
        }
        return randomNumbers;
    }

    public static void main(String[] args) {
        launch();
    }
}
