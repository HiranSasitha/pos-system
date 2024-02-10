package com.sprinbootacademy.pointofsale.util.mappers;

import com.sprinbootacademy.pointofsale.dto.queryInterfaces.OrderDetailsInterface;
import com.sprinbootacademy.pointofsale.dto.response.ResponseOrderDetailsDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface OrderMapper {

    List<ResponseOrderDetailsDto> interfaceListToDtoList(List<OrderDetailsInterface>orderDetailsInterfaces);
}
