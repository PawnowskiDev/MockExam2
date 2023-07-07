package pl.coderslab;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main04 {

    public static void main(String[] args) {

        try (Connection connection = DbUtili.connection()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj ID użytkownika: ");
            int userId = scanner.nextInt();

            DbUtili.retrieveUserMessages(connection, userId);
            System.out.println();
            DbUtili.retrieveUserOrders(connection, userId);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
