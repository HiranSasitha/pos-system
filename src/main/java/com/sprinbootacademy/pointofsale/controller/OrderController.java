package com.sprinbootacademy.pointofsale.controller;

import com.sprinbootacademy.pointofsale.dto.ItemSaveRequestDto;
import com.sprinbootacademy.pointofsale.dto.request.RequestOrderSaveDto;
import com.sprinbootacademy.pointofsale.service.OrderService;
import com.sprinbootacademy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin


public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody RequestOrderSaveDto requestOrderSaveDto) {

      String massage = orderService.SaveOrder(requestOrderSaveDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",null),
                HttpStatus.CREATED

        );
    }
}
