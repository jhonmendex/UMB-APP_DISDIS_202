package com.example.demo.persistent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ShoppingCartEntity;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCartEntity, Long> {

}
