package com.sprinbootacademy.pointofsale.controller;

import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import com.sprinbootacademy.pointofsale.dto.UpdateCustomerDto;
import com.sprinbootacademy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/save")
    public  String saveCustomer (@RequestBody CustomerDto customerDto){
        customerService.saveCustomer(customerDto);
        String massage = "Saved";
        return massage;
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody UpdateCustomerDto updateCustomerDto){
        customerService.updateCustomer(updateCustomerDto);
        return "updated";
    }

    @GetMapping("/get-by-id/{id}")
    public CustomerDto getCustById(@PathVariable Integer id){
        return customerService.getById(id);
    }

}
