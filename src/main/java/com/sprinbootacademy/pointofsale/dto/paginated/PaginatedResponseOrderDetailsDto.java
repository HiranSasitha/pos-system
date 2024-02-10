package com.sprinbootacademy.pointofsale.dto.paginated;

import com.sprinbootacademy.pointofsale.dto.response.ResponseOrderDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetailsDto {
    List<ResponseOrderDetailsDto> responseOrderDetailsDtos;
    private Long dataCount;
}
