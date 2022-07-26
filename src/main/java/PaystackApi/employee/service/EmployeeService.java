package PaystackApi.employee.service;


import PaystackApi.employee.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

    List<Employee> findByFirstName(String name);

    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
