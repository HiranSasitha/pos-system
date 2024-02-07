package com.sprinbootacademy.pointofsale.service;

import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import com.sprinbootacademy.pointofsale.dto.UpdateCustomerDto;

import java.util.List;

public interface CustomerService {

    String saveCustomer(CustomerDto customerDto);

    String updateCustomer(UpdateCustomerDto updateCustomerDto);

    CustomerDto getById(Integer id);

    List<CustomerDto> getAllCustomer();

    String deleteCustomer(Integer id);

    List<CustomerDto> getCustomerByStatus(Boolean isActive);
}
