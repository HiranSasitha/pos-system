package com.sprinbootacademy.pointofsale.entity;





import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor

@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})


public class CustomerEntity {

    @Id
    @Column(name = "customer_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    @Column(name = "customer_name",length = 100)
    private  String customerName;
    @Column(name = "customer_address",length = 100)
     private  String customerAddress;
    @Column(name = "customer_salary")
    private Double customerSlary;

    @Type(type = "json")
    @Column(name = "contact_numbers",columnDefinition = "json")
    private ArrayList contactNumber;
    @Column(name = "active_state",columnDefinition = "TINYINT default 0")
    private Boolean active;

    @OneToMany(mappedBy = "customerEntity")
    private Set<OrderEntity>orderEntities;
}
