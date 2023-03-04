package exercise3;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnect;
import model.Company;

public class Exercise3 {
    public static List<Company> getAllCompany() {
        List<Company> companies = new ArrayList<>();
        final String sql = "SELECT * FROM companies";

        try {
            Connection conn = new DbConnect().connect();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Company company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("address"),
                        resultSet.getDouble("salary"));
                companies.add(company);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return companies;
    }
}