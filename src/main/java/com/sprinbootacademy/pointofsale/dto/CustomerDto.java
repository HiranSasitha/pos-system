package com.sprinbootacademy.pointofsale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {


    private Integer customerId;

    private  String customerName;

    private  String customerAddress;

    private Double customerSlary;


    private ArrayList contactNumber;

    private Boolean active;
}
