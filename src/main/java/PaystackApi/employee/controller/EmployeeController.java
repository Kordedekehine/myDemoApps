package PaystackApi.employee.controller;

import PaystackApi.employee.entity.Employee;
import PaystackApi.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String saveEmployee(@ModelAttribute("employee") @RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/homepage";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable ( value = "id") long id,Model model ){

        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee",employee);
        return "update_employee";
    }

    @GetMapping("/searchByName/firstName")
    public String showFormUpdate(@RequestParam("firstName") String firstName,Model model ){

      //  Employee employee = (Employee) employeeService.findByFirstName(firstName);

        Employee employee = (Employee) employeeService.findByFirstName(firstName);

        model.addAttribute("employee",employee);
        return "search";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
     this.employeeService.deleteEmployeeById(id);
     return "redirect:/homepage";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees", listEmployees);
        return "index";
    }
}
