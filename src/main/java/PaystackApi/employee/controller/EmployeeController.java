package PaystackApi.employee.controller;

import PaystackApi.employee.entity.Employee;
import PaystackApi.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/homepage")
    public String homePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "homepage";
    }

    @GetMapping("/newEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }

   @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable ( value = "id") long id,Model model ){

        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee",employee);
        return "update_employee";
    }

    public String deleteEmployee(@PathVariable (value = "id") long id){
     this.employeeService.deleteEmployeeById(id);
     return "redirect:/";
    }
}
