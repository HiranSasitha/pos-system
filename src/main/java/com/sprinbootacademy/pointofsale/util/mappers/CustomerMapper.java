package com.sprinbootacademy.pointofsale.util.mappers;

import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import com.sprinbootacademy.pointofsale.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    List<CustomerDto> entityListToDtoList(List<CustomerEntity>customerEntities);
}
