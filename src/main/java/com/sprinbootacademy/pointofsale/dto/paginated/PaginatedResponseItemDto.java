package com.sprinbootacademy.pointofsale.dto.paginated;

import com.sprinbootacademy.pointofsale.dto.response.ItemResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaginatedResponseItemDto {
    List<ItemResponseDto> list;
    private Long dataCount;
}
