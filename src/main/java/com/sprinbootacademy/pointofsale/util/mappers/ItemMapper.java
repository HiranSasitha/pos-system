package com.sprinbootacademy.pointofsale.util.mappers;

import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import com.sprinbootacademy.pointofsale.dto.paginated.PaginatedResponseItemDto;
import com.sprinbootacademy.pointofsale.dto.response.ItemResponseDto;
import com.sprinbootacademy.pointofsale.entity.CustomerEntity;
import com.sprinbootacademy.pointofsale.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")



public interface ItemMapper {
    List<ItemResponseDto> entityListToDtoList(List<ItemEntity> itemEntities);
    List<ItemResponseDto> pageToDtoList(Page<ItemEntity>itemEntities);

}
