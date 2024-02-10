package com.sprinbootacademy.pointofsale.service;

import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import com.sprinbootacademy.pointofsale.dto.UpdateCustomerDto;
import com.sprinbootacademy.pointofsale.dto.paginated.PaginatedResponseCustomerDto;

import java.util.List;

public interface CustomerService {

    String saveCustomer(CustomerDto customerDto);

    String updateCustomer(UpdateCustomerDto updateCustomerDto);

    CustomerDto getById(Integer id);

    List<CustomerDto> getAllCustomer();

    String deleteCustomer(Integer id);

    List<CustomerDto> getCustomerByStatus(Boolean isActive);

    PaginatedResponseCustomerDto getAllCustomerByActiveWithPaginated(Boolean isActive, Integer page, Integer size);
}
