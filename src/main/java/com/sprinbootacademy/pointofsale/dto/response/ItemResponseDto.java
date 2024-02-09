package com.sprinbootacademy.pointofsale.dto.response;

import com.sprinbootacademy.pointofsale.entity.enums.MeasureringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDto {
    private  String itemName;

    private Integer itemId;
    private Boolean active;

    private Double qty;

    private Double supplierPrice;


    private Double sellingPrice;
}
