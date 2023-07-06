package pl.coderslab;

import java.sql.*;

public class Main02 {
    public static void main(String[] args) {

        try { Connection connection = DbUtili.connection();

            String QUERY1 = "SELECT * FROM exam2.items WHERE price > 50 ORDER BY price ASC";
            String QUERY2 = "INSERT INTO exam2.items (name, description, price) VALUES ('product1', 'desc1' , 9.99)";
            String QUERY3 = "DELETE FROM exam2.users WHERE id = 3";
            String QUERY4 = "SELECT id, name, email FROM exam2.users WHERE id IN (SELECT DISTINCT user_id FROM exam2.messages) ORDER BY id DESC";
            String QUERY5 = "SELECT * FROM exam2.items WHERE id = (SELECT item_id FROM exam2.items_orders WHERE order_id = 1 ORDER BY item_id DESC LIMIT 1)";
            String QUERY6 = "SELECT * FROM exam2.orders WHERE created = '2017-11-12'";
            String QUERY7 = "INSERT INTO exam2.items_orders (item_id, order_id) VALUES (2, 3)";
            String QUERY8 = "SELECT * FROM exam2.messages WHERE message LIKE 'a%'";

            Statement statement = connection.createStatement();
            statement.executeQuery(QUERY1);
            statement.executeUpdate(QUERY2);
            statement.executeUpdate(QUERY3);
            statement.executeQuery(QUERY4);
            statement.executeQuery(QUERY5);
            statement.executeQuery(QUERY6);
            statement.executeUpdate(QUERY7);
            statement.executeQuery(QUERY8);

            System.out.println("Wykonano zapytania");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
