package com.sprinbootacademy.pointofsale.service.impl;

import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import com.sprinbootacademy.pointofsale.dto.UpdateCustomerDto;
import com.sprinbootacademy.pointofsale.dto.paginated.PaginatedResponseCustomerDto;
import com.sprinbootacademy.pointofsale.entity.CustomerEntity;
import com.sprinbootacademy.pointofsale.exception.NotFoundException;
import com.sprinbootacademy.pointofsale.repo.CustomerRepository;
import com.sprinbootacademy.pointofsale.service.CustomerService;
import com.sprinbootacademy.pointofsale.util.mappers.CustomerMapper;
import com.sun.jdi.PrimitiveValue;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        customerRepository.save(customerEntity);

        return "save";
    }

    @Override
    public String updateCustomer(UpdateCustomerDto updateCustomerDto) {
        if (customerRepository.existsById(updateCustomerDto.getCustomerId())) {
            CustomerEntity customerEntity = customerRepository.getReferenceById(updateCustomerDto.getCustomerId());
            customerEntity.setCustomerName(updateCustomerDto.getCustomerName());
            customerEntity.setCustomerAddress(updateCustomerDto.getCustomerAddress());
            customerEntity.setCustomerSlary(updateCustomerDto.getCustomerSlary());

            customerRepository.save(customerEntity);
            return "updated";
        } else {
            throw new RuntimeException("not fOund");
        }

    }

    @Override
    public CustomerDto getById(Integer id) {
        if (customerRepository.existsById(id)) {

            CustomerEntity customerEntity = customerRepository.getReferenceById(id);
            CustomerDto customerDto = modelMapper.map(customerEntity, CustomerDto.class);
            return customerDto;
        } else {
            throw new RuntimeException("invalid id");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();

        if (customerEntities.size() > 0) {
            List<CustomerDto> customerDtos = customerMapper.entityListToDtoList(customerEntities);


            return customerDtos;
        }else {
            throw new NotFoundException("No Customer Found");
        }


    }

    @Override
    public String deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return "delete Success";
    }

    @Override
    public List<CustomerDto> getCustomerByStatus(Boolean isActive) {
        List<CustomerEntity> customerEntities = customerRepository.findAllByActiveEquals(isActive);

        List<CustomerDto> customerDtos = customerMapper.entityListToDtoList(customerEntities);


        return customerDtos;
    }

    @Override
    public PaginatedResponseCustomerDto getAllCustomerByActiveWithPaginated(Boolean isActive, Integer page, Integer size) {
        Page<CustomerEntity>customerEntities = customerRepository.findAllByActiveEquals(isActive, PageRequest.of(page,size));
        List<CustomerDto> customerDtos=customerMapper.pageListToDtoList(customerEntities);
        if(customerEntities.getSize()>0){
            return new PaginatedResponseCustomerDto(customerDtos,customerRepository.countAllByActiveEquals(isActive));
        }else {
            throw new NotFoundException("No Customer Data");
        }
    }
}
