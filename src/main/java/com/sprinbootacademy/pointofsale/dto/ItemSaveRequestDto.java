package com.sprinbootacademy.pointofsale.dto;

import com.sprinbootacademy.pointofsale.entity.enums.MeasureringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ItemSaveRequestDto {
    private  String itemName;

    private MeasureringUnitType measureringUnitType;

    private Double qty;

    private Double supplierPrice;


    private Double sellingPrice;
}
