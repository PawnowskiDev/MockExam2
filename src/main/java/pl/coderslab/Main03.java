package pl.coderslab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main03 {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = DbUtili.connection()) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Wprowadź nazwę produktu: ");
            String name = scanner.nextLine();

            System.out.println("Wprowadź opis: ");
            String description = scanner.nextLine();

            double price = 0.0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    // obsługa wyjątku InputMismatchException
                    System.out.println("Wprowadź cenę: ");
                    price = scanner.nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Błędny format ceny. Wprowadź poprawną wartość liczbową.");
                    scanner.nextLine();
                }

                String QUEER1 = "INSERT INTO exam2.items (name, description, price) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(QUEER1);
                statement.setString(1, name);
                statement.setString(2, description);
                statement.setDouble(3, price);

                System.out.println("Wprowadzono przedmiot");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}