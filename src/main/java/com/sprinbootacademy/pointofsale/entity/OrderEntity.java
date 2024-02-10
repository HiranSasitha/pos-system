package com.sprinbootacademy.pointofsale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor

@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})


public class OrderEntity {
    @Id
    @Column(name = "order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date date;
    @Column(name = "total",nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private CustomerEntity customerEntity;

    @Column(name = "active_state",columnDefinition = "TINYINT default 0")
    private Boolean active;

    @OneToMany(mappedBy = "orderEntity")
    private Set<OrderDetailsEntity> orderDetailsEntities;
}
