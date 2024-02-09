package com.sprinbootacademy.pointofsale.controller;


import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import com.sprinbootacademy.pointofsale.dto.ItemSaveRequestDto;
import com.sprinbootacademy.pointofsale.dto.response.ItemResponseDto;
import com.sprinbootacademy.pointofsale.service.ItemService;
import com.sprinbootacademy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin

public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody ItemSaveRequestDto itemSaveRequestDto) {

        String massage = itemService.SaveItem(itemSaveRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",massage),
                HttpStatus.CREATED

        );
    }

    @GetMapping("/get-by-name-active/{name}")
    public List<ItemResponseDto> getByNameAndActive(@PathVariable(value = "name") String name){
        return itemService.getByName(name);
    }
    @GetMapping("/get-by-name/{name}")
    public List<ItemResponseDto> getByName(@PathVariable(value = "name") String name){
        return itemService.getByNameOnly(name);
    }


    @GetMapping(value = "/get-by-All-items-active",
    params = {"active","page","size"})
    public ResponseEntity<?>getByNameAndActive(@RequestParam(value = "active") Boolean active,@RequestParam(value = "page") Integer page,@RequestParam(value = "size") Integer size){
        List<ItemResponseDto>itemResponseDtos = itemService.getAllItemActiveStatus(active,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",itemResponseDtos),
                HttpStatus.CREATED

        );

    }



}
