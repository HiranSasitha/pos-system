package com.sprinbootacademy.pointofsale.dto.request;

import com.sprinbootacademy.pointofsale.entity.CustomerEntity;
import com.sprinbootacademy.pointofsale.entity.OrderDetailsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestOrderSaveDto {


    private Integer customerId;
    private Date date;
    private Double total;


    private List<RequestOrderDetailsDto> orderDetailsDtos;
}
