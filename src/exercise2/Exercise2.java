package exercise2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.DbConnect;
import model.Company;

public class Exercise2 {
    public static void insertCompany(List<Company> companies) {
        final String sql = "INSERT INTO companies(id, name, age, address, salary) "
                + "VALUES(?, ?, ?, ?, ?)";

        try {
            Connection conn = new DbConnect().connect();
            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;

            for (Company company : companies) {
                statement.setInt(1, company.getId());
                statement.setString(2, company.getName());
                statement.setInt(3, company.getAge());
                statement.setString(4, company.getAddress());
                statement.setDouble(5, company.getSalary());

                statement.addBatch();
                count++;
                if (count == companies.size()) {
                    statement.executeBatch();
                }
            }
            System.out.println("Data inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}