package com.sprinbootacademy.pointofsale.repo;

import com.sprinbootacademy.pointofsale.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
}
