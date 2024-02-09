package com.sprinbootacademy.pointofsale.entity;

import com.sprinbootacademy.pointofsale.entity.enums.MeasureringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ItemEntity {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
    @Column(name = "item_name",length = 100 ,nullable = false)
    private  String itemName;
    @Enumerated(EnumType.STRING)

    @Column(name = "measure_type",length = 100,nullable = false)
    private MeasureringUnitType measureringUnitType;
    @Column(name = "qty",length = 100,nullable = false)
    private Double qty;
    @Column(name = "supplier_price",length = 100,nullable = false)
    private Double supplierPrice;

    @Column(name = "selling_price",length = 100,nullable = false)
    private Double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 0")
    private Boolean active;


}
