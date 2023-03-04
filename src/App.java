import java.util.Arrays;
import java.util.List;

import exercise1.Exercise1;
import exercise2.Exercise2;
import exercise3.Exercise3;
import model.Company;

public class App {
    public static void main(String[] args) {
        // Exercice 1
        Exercise1.createTable();

        // Exercice 2
        List<Company> companies = Arrays.asList(
                new Company(1, "Paul", 32, "California", 20000.00),
                new Company(2, "Allen", 25, "Texas", 15000.00),
                new Company(3, "Teddy", 23, "Norway", 20000.00),
                new Company(4, "Mark", 25, "Rich-Mond ", 65000.00));
        Exercise2.insertCompany(companies);

        // Exercice 3
        List<Company> companiesFromBD = Exercise3.getAllCompany();
        System.out.println("***** Companies list *****");
        companiesFromBD.forEach(System.out::println);
    }
}
