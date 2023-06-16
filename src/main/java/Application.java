import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "1234";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        String queryEmployee = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(queryEmployee, Employee.class);

        List<Employee> employees = query.getResultList();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        entityManager.close();
        entityManagerFactory.close();

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
