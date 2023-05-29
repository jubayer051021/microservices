package com.bjit.orderapp.repository;

import com.bjit.orderapp.entity.ItemListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemListRepository extends JpaRepository<ItemListEntity,Integer> {
}
