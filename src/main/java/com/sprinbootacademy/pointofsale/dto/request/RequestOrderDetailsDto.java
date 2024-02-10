package com.sprinbootacademy.pointofsale.dto.request;

import com.sprinbootacademy.pointofsale.entity.ItemEntity;
import com.sprinbootacademy.pointofsale.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class RequestOrderDetailsDto {


    private String itemName;

    private Double qty;

    private Double amount;

    private Integer itemId;

    private Integer orderId;




}
