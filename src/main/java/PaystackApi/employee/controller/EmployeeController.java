package PaystackApi.employee.controller;

import PaystackApi.employee.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class EmployeeController {

    EmployeeServiceImpl employeeService;

    public String homePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "homepage";
    }
}
