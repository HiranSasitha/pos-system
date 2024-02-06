package com.sprinbootacademy.pointofsale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UpdateCustomerDto {
    private Integer customerId;
    private  String customerName;

    private  String customerAddress;

    private Double customerSlary;
}
