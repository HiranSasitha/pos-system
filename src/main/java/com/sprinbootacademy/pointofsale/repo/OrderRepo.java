package com.sprinbootacademy.pointofsale.repo;

import com.sprinbootacademy.pointofsale.dto.queryInterfaces.OrderDetailsInterface;
import com.sprinbootacademy.pointofsale.dto.response.ResponseOrderDetailsDto;
import com.sprinbootacademy.pointofsale.entity.OrderEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<OrderEntity,Integer> {
    @Query(value = "select c.customer_name as CustomerName , c.customer_address as CustomerAddress , c.contact_numbers as ContactNumber , o.order_date as Date , o.total as Total from customer c,orders o where o.active_state = ?1 and c.customer_id = o.customer_id" ,nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDtails(boolean status, Pageable pageable);


    @Query(value = "select count(*) from customer c,orders o where o.active_state = ?1 and c.customer_id = o.customer_id",nativeQuery = true)
    Long countAllOrdrDetails(boolean status);
}
