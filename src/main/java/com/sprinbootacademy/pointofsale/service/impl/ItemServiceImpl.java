package com.sprinbootacademy.pointofsale.service.impl;

import com.sprinbootacademy.pointofsale.dto.ItemSaveRequestDto;
import com.sprinbootacademy.pointofsale.dto.response.ItemResponseDto;
import com.sprinbootacademy.pointofsale.entity.ItemEntity;
import com.sprinbootacademy.pointofsale.exception.NotFoundException;
import com.sprinbootacademy.pointofsale.repo.ItemRepository;
import com.sprinbootacademy.pointofsale.service.ItemService;
import com.sprinbootacademy.pointofsale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String SaveItem(ItemSaveRequestDto itemSaveRequestDto) {

        ItemEntity itemEntity = modelMapper.map(itemSaveRequestDto,ItemEntity.class);
        itemEntity.setActive(false);

            itemRepository.save(itemEntity);
            return "saved";

    }

    @Override
    public List<ItemResponseDto> getByName(String itemName) {
        List<ItemEntity> itemEntities= itemRepository.findAllByItemNameEqualsAndActiveEquals(itemName,true);
        if(itemEntities.size()>0){
            List<ItemResponseDto>itemResponseDtos = modelMapper.map(itemEntities,new TypeToken<List<ItemResponseDto>>(){}.getType());
            return itemResponseDtos;
        }else {
            throw new RuntimeException("Not Items");
        }



    }

    @Override
    public List<ItemResponseDto> getByNameOnly(String name) {
        List<ItemEntity> itemEntities= itemRepository.findAllByItemName(name);
        if(itemEntities.size()>0){
            List<ItemResponseDto>itemResponseDtos = itemMapper.entityListToDtoList(itemEntities);
            return itemResponseDtos;
        }else {
            throw new RuntimeException("Not Items");
        }
    }

    @Override
    public List<ItemResponseDto> getAllItemActiveStatus(Boolean active,Integer page,Integer size) {
        List<ItemEntity>itemEntities = itemRepository.findAllByActiveEquals(active);
        if(itemEntities.size()>0){
            List<ItemResponseDto>itemResponseDtos = itemMapper.entityListToDtoList(itemEntities);
            return itemResponseDtos;
        }else {
            throw new NotFoundException("Not Active Items");
        }
    }
}
