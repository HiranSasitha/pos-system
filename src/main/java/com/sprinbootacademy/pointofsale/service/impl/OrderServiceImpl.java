package com.sprinbootacademy.pointofsale.service.impl;

import com.sprinbootacademy.pointofsale.dto.request.RequestOrderDetailsDto;
import com.sprinbootacademy.pointofsale.dto.request.RequestOrderSaveDto;
import com.sprinbootacademy.pointofsale.entity.OrderDetailsEntity;
import com.sprinbootacademy.pointofsale.entity.OrderEntity;
import com.sprinbootacademy.pointofsale.repo.CustomerRepository;
import com.sprinbootacademy.pointofsale.repo.ItemRepository;
import com.sprinbootacademy.pointofsale.repo.OrderDetailsRepo;
import com.sprinbootacademy.pointofsale.repo.OrderRepo;
import com.sprinbootacademy.pointofsale.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Override
    @Transactional
    public String SaveOrder(RequestOrderSaveDto requestOrderSaveDto) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTotal(requestOrderSaveDto.getTotal());
        orderEntity.setDate(requestOrderSaveDto.getDate());
        orderEntity.setCustomerEntity(customerRepository.getReferenceById(requestOrderSaveDto.getCustomerId()));
        orderRepo.save(orderEntity);

        if (orderRepo.existsById(orderEntity.getOrderId())){

            List<OrderDetailsEntity> orderDetailsEntities = new ArrayList<>();
            for (RequestOrderDetailsDto orderDetailsDto:requestOrderSaveDto.getOrderDetailsDtos()){
                OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
                orderDetailsEntity.setOrderEntity(orderEntity);
                orderDetailsEntity.setItemEntity(itemRepository.getReferenceById(orderDetailsDto.getItemId()));
                orderDetailsEntity.setAmount(orderDetailsDto.getAmount());
                orderDetailsEntity.setQty(orderDetailsDto.getQty());
                orderDetailsEntity.setItemName(orderDetailsDto.getItemName());
                orderDetailsEntities.add(orderDetailsEntity);
            }

            orderDetailsRepo.saveAll(orderDetailsEntities);
            return "saved";

        }

        throw new RuntimeException("Not Save");
    }
}
