package com.sprinbootacademy.pointofsale.repo;

import com.sprinbootacademy.pointofsale.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
    List<CustomerEntity> findAllByActiveEquals(Boolean isActive);

    Page<CustomerEntity> findAllByActiveEquals(Boolean isActive, Pageable pageable);

    Long countAllByActiveEquals(Boolean isActive);
}
