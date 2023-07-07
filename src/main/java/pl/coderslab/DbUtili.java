package pl.coderslab;

import java.sql.*;

public class DbUtili {

    static String DB_URL = "jdbc:mysql://127.0.0.1:3306/exam2";
    static String DB_USER = "root";
    static String DB_PASS = "!Molly2022";

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static void retrieveUserMessages (Connection connection, int userId) throws SQLException {

        String QUERY1 = "SELECT * FROM exam2.messages WHERE user_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY1)) {
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Wiadomości dla użytkownika o ID " + userId + " :");
                    do {
                        int messageId = resultSet.getInt("id");
                        String messageText = resultSet.getNString("message");
                        // wyświetlenie informacji o wiadomości
                        System.out.println("ID wiadomości: " + messageId);
                        System.out.println("Treść wiadomości: " + messageText);
                    } while (resultSet.next());
                } else {
                    System.out.println("Brak wiadomości dla użytkownika o podanym ID.");
                }
        }
    }

    public static void retrieveUserOrders (Connection connection, int userID) throws SQLException {

        String QUERY2 = "SELECT * FROM exam2.orders WHERE user_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY2)) {
                preparedStatement.setInt(1, userID);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Zamówienia dla użytkownika o ID " + userID + " :");
                    do {
                        int orderId = resultSet.getInt("id");
                        String orderDetails = resultSet.getString("description");
                        // wyświetlanie informacji o zamówieniu
                        System.out.println("ID zamówienia: " + orderId);
                        System.out.println("Szczegóły zamówienia: " + orderDetails);
                    } while (resultSet.next());
                } else {
                    System.out.println("Brak zamówień dla użytkownika o podanym ID.");
                }

        }

    }


}

