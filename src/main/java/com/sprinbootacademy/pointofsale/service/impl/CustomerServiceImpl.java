package com.sprinbootacademy.pointofsale.service.impl;

import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import com.sprinbootacademy.pointofsale.dto.UpdateCustomerDto;
import com.sprinbootacademy.pointofsale.entity.CustomerEntity;
import com.sprinbootacademy.pointofsale.repo.CustomerRepository;
import com.sprinbootacademy.pointofsale.service.CustomerService;
import com.sun.jdi.PrimitiveValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity(customerDto.getCustomerId(),
                customerDto.getCustomerName(),
                customerDto.getCustomerAddress(),
                customerDto.getCustomerSlary(),
                customerDto.getContactNumber(),
                customerDto.getActive());
        customerRepository.save(customerEntity);

        return "save";
    }

    @Override
    public String updateCustomer(UpdateCustomerDto updateCustomerDto) {
        if(customerRepository.existsById(updateCustomerDto.getCustomerId())){
            CustomerEntity customerEntity = customerRepository.getReferenceById(updateCustomerDto.getCustomerId());
            customerEntity.setCustomerName(updateCustomerDto.getCustomerName());
            customerEntity.setCustomerAddress(updateCustomerDto.getCustomerAddress());
            customerEntity.setCustomerSlary(updateCustomerDto.getCustomerSlary());

            customerRepository.save(customerEntity);
            return "updated";
        }
        else {
            throw new RuntimeException("not fOund");
        }

    }

    @Override
    public CustomerDto getById(Integer id) {
        if(customerRepository.existsById(id)) {

            CustomerEntity customerEntity = customerRepository.getReferenceById(id);
            CustomerDto customerDto = new CustomerDto(customerEntity.getCustomerId(),
                    customerEntity.getCustomerName(),
                    customerEntity.getCustomerAddress(),
                    customerEntity.getCustomerSlary(),
                    customerEntity.getContactNumber(),
                    customerEntity.getActive());
            return customerDto;
        }else {
            throw new RuntimeException("invalid id");
        }
    }
}
