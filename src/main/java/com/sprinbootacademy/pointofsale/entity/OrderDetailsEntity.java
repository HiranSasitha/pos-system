package com.sprinbootacademy.pointofsale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "orders_details")
@Data
@NoArgsConstructor
@AllArgsConstructor

@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})

public class OrderDetailsEntity {
    @Id
    @Column(name = "order_details_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderDetailsId;

    @Column(name = "item_name",length = 100 ,nullable = false)
    private  String itemName;

    @Column(name = "qty",length = 100 ,nullable = false)
    private  Double qty;

    @Column(name = "amount",length = 100 ,nullable = false)
    private  Double amount;

    @ManyToOne
    @JoinColumn(name = "item_id",nullable = false)
    private ItemEntity itemEntity;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private OrderEntity orderEntity;


}
