package com.stackroute.controller;


import com.stackroute.domain.Customer;
import com.stackroute.service.CrudOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Customer customer = (Customer) context.getBean("customer");

    private CrudOperationService crudOperationService;

    @Autowired
    public CustomerController(CrudOperationService crudOperationService) {
        this.crudOperationService = crudOperationService;
    }

    public void setCrudOperationService(CrudOperationService crudOperationService) {
        this.crudOperationService = crudOperationService;
    }

    @GetMapping ("/")
    public String displayCustomerByName()
    {
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("myObj",crudOperationService.displayCustomerByName(name));

         return "index";
    }

}
