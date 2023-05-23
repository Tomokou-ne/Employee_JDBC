import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "1234";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee newEmployee = new Employee("Maxim", "Sorokin", "male", 30, 4);
        employeeDAO.create(newEmployee);

        System.out.println(employeeDAO.getById(4));

        List<Employee> list = employeeDAO.getAllEmployees();

        for (Employee employee : list) {
            System.out.println(employee);
        }

        Employee newEmployeeTwo = new Employee(5,"Yulia", "Malitskaya", "female", 41, 5);

        employeeDAO.updateById(newEmployeeTwo);

        employeeDAO.deleteById(newEmployeeTwo);
    }
}
