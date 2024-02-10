package com.sprinbootacademy.pointofsale.service;

import com.sprinbootacademy.pointofsale.dto.paginated.PaginatedResponseOrderDetailsDto;
import com.sprinbootacademy.pointofsale.dto.request.RequestOrderSaveDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    String SaveOrder(RequestOrderSaveDto requestOrderSaveDto);

    PaginatedResponseOrderDetailsDto getAllOrderDetails(boolean status, Integer page, Integer size);
}
