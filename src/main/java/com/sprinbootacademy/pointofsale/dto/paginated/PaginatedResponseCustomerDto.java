package com.sprinbootacademy.pointofsale.dto.paginated;

import com.sprinbootacademy.pointofsale.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaginatedResponseCustomerDto {

    List<CustomerDto> list;
    private  Long count;

}
