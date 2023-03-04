package exercise1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DbConnect;

public class Exercise1 {
    public static void createTable() {
        String sql = "CREATE TABLE companies " +
                "(id INT PRIMARY KEY NOT NULL," +
                "name TEXT NOT NULL," +
                "age INT NOT NULL," +
                "address CHAR(50)," +
                "salary REAL,)";

        try {
            Connection conn = new DbConnect().connect();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}