package PaystackApi.employee.service;


import PaystackApi.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);
}
