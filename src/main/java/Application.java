import dao.CityDAO;
import dao.CityDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "1234";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        Employee newEmployee = new Employee( "Maxim", "Sorokin", "male", 30 );

        City cityTesting = new City("Novosibirsk");
        cityDAO.create(cityTesting);

        employeeDAO.create(newEmployee);
        newEmployee.setCity(cityTesting);


        List<Employee> list = employeeDAO.getAllEmployees();

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
