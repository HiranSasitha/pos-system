package com.sprinbootacademy.pointofsale.service;

import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import com.sprinbootacademy.pointofsale.dto.UpdateCustomerDto;

public interface CustomerService {

    String saveCustomer(CustomerDto customerDto);

    String updateCustomer(UpdateCustomerDto updateCustomerDto);

    CustomerDto getById(Integer id);

}
