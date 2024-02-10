package com.sprinbootacademy.pointofsale.repo;

import com.sprinbootacademy.pointofsale.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories

public interface ItemRepository extends JpaRepository<ItemEntity,Integer> {
    List<ItemEntity> findAllByItemNameEqualsAndActiveEquals(String itemName, boolean b);
    List<ItemEntity> findAllByItemName(String itemName);

    List<ItemEntity> findAllByActiveEquals(Boolean active);

    Page<ItemEntity> findAllByActiveEquals(Boolean active, Pageable pageable);


    Integer countAllByActiveEquals(Boolean active);
}
