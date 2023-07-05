package pl.coderslab;

import java.sql.Connection;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main1 {
    public static void main(String[] args) {

        try {
            Connection connection = DbUtili.connection();
            System.out.println("Połączono z bazą danych");


//            String QUERY1 = "CREATE TABLE exam2.users (" +
//                    "id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
//                    "name VARCHAR(60) NOT NULL," +
//                    "email VARCHAR(60) UNIQUE," +
//                    "password VARCHAR(60)" +
//                    ")";
//
//            String QUERY2 = "CREATE TABLE exam2.messages (" +
//                    "id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
//                    "user_id INT NOT NULL," +
//                    "message TEXT" +
//                    ")";
//
//            String QUERY3 = "CREATE TABLE exam2.items (" +
//                    "id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
//                    "name VARCHAR(40) NOT NULL," +
//                    "description TEXT," +
//                    "price DECIMAL(10,2) NOT NULL" +
//                    ")";
//
//            String QUERY4 = "CREATE TABLE exam2.orders (" +
//                    "id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
//                    "description TEXT," +
//                    "created DATE," +
//                    "user_id INT" +
//                    ")";
//
//            String QUERY5 = "CREATE TABLE exam2.orders (" +
//                    "item_id INT," +
//                    "order_id INT,," +
//                    "FOREIGN KEY (item_id) REFERENCES item(id)" +
//                    "FOREIGN KEY (order_id) REFERENCES orders(id)" +
//                    ")";

        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas połączenia z bazą danych : " + e.getMessage());
        }
    }
}