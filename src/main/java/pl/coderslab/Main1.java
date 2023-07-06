package pl.coderslab;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {
    public static void main(String[] args) {

        try {
            Connection connection = DbUtili.connection();
            System.out.println("Połączono z bazą danych");


            String QUERY1 = "CREATE TABLE exam2.users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
                    "name VARCHAR(60) NOT NULL," +
                    "email VARCHAR(60) UNIQUE," +
                    "password VARCHAR(60)" +
                    ")";

            String QUERY2 = "CREATE TABLE exam2.messages (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
                    "user_id INT NOT NULL," +
                    "message TEXT" +
                    "FOREIGN KEY (user_id) REFERENCES exam2.users(id)" +
                    ")";

            String QUERY3 = "CREATE TABLE exam2.items (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
                    "name VARCHAR(40) NOT NULL," +
                    "description TEXT," +
                    "price DECIMAL(10,2) NOT NULL" +
                    ")";

            String QUERY4 = "CREATE TABLE exam2.orders (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
                    "description TEXT," +
                    "created DATE," +
                    "user_id INT" +
                    "FOREIGN KEY (user_id) REFERENCES exam2.users(id)" +
                    ")";

            String QUERY5 = "CREATE TABLE exam2.items_orders (" +
                    "item_id INT," +
                    "order_id INT," +
                    "PRIMARY KEY (item_id, order_id)," +
                    "FOREIGN KEY (item_id) REFERENCES exam2.items(id)," +
                    "FOREIGN KEY (order_id) REFERENCES exam2.orders(id)" +
                    ")";


            Statement statement = connection.createStatement();
            statement.executeUpdate(QUERY1);
            statement.executeUpdate(QUERY2);
            statement.executeUpdate(QUERY3);
            statement.executeUpdate(QUERY4);
            statement.executeUpdate(QUERY5);

            System.out.println("Utworzono tabele : users, message, items, orders, orders_items");

        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas połączenia z bazą danych : " + e.getMessage());
        }
    }
}