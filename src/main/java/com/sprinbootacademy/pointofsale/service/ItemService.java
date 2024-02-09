package com.sprinbootacademy.pointofsale.service;

import com.sprinbootacademy.pointofsale.dto.ItemSaveRequestDto;
import com.sprinbootacademy.pointofsale.dto.response.ItemResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface ItemService {
    String SaveItem(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemResponseDto> getByName(String itemName);

    List<ItemResponseDto> getByNameOnly(String name);

    List<ItemResponseDto> getAllItemActiveStatus(Boolean active,Integer page,Integer size);
}
