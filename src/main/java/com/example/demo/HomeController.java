package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    LaptopRepository laptopRepository;

    @RequestMapping("/")
    public String loadData(Model model){
        Employee e1 = new Employee();
        e1.setName("Alice Smith");
        e1.setAddress("123 Smith St, Potomac, MD 20850");

        Employee e2 = new Employee();
        e2.setName("Bob Steven");
        e2.setAddress("456 Steven Ave, McLean, VA 20320");

        Laptop l1 = new Laptop();
        l1.setModel("A1");
        l1.setBrand("Dell");

        Laptop l2 = new Laptop();
        l2.setModel("B2");
        l2.setBrand("IBM");

        e1.setLaptop(l1);
        e2.setLaptop(l2);

        l1.setEmployee(e1);
        l2.setEmployee(e2);

        employeeRepository.save(e1);
        employeeRepository.save(e2);

        laptopRepository.save(l1);
        laptopRepository.save(l2);

        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("laptops", laptopRepository.findAll());

        return "index";

    }
}
