package pl.coderslab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtili {

    static String DB_URL = "jdbc:mysql://127.0.0.1:3306/exam2";
    static String DB_USER = "root";
    static String DB_PASS = "!Molly2022";

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

}
