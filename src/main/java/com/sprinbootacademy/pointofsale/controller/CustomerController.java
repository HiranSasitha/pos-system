package com.sprinbootacademy.pointofsale.controller;

import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import com.sprinbootacademy.pointofsale.dto.UpdateCustomerDto;
import com.sprinbootacademy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        String massage = "Saved";
        return massage;
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody UpdateCustomerDto updateCustomerDto) {
        customerService.updateCustomer(updateCustomerDto);
        return "updated";
    }

    @GetMapping("/get-by-id/{id}")
    public CustomerDto getCustById(@PathVariable Integer id) {
        return customerService.getById(id);
    }

    @GetMapping("/get-all")
    public List<CustomerDto> getAll() {
        return customerService.getAllCustomer();
    }


    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") Integer id) {
        String delete = customerService.deleteCustomer(id);
        return delete;

    }


    @GetMapping("/get-all-customer/{status}")
    public List<CustomerDto> getCustomerByStatus(@PathVariable(value = "status") Boolean isActive) {
        return customerService.getCustomerByStatus(isActive);
    }
}