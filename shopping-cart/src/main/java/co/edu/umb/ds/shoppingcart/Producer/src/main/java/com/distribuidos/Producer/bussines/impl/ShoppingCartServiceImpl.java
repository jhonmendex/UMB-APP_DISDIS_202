package com.example.demo.bussines.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.bussines.ShoppingCartService;
import com.example.demo.dto.ShoppingCartDTO;
import com.example.demo.entity.ShoppingCartEntity;
import com.example.demo.persistent.ShoppingCartRepository;



@Service
@Primary
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	@Autowired
	private ShoppingCartRepository rep;
	
	@Override
	public List<ShoppingCartDTO> findAll() {
		List<ShoppingCartDTO> shoppingCart = new ArrayList<>();
		Iterable<ShoppingCartEntity> shoppingCartEntity = rep.findAll();
		
		ShoppingCartEntity.forEach(shoppingCart) -> {
			ShoppingCartDTO dto = new ShoppingCartDTO(shoppingCart.getId(),shoppingCart.getQuantity()
					shoppingCart.getTotalṔrice(),shoppingCart.getIdProduct());			
			shoppingCart.add(dto);
		});
		
		return shoppingCart;
	}

	@Override
	public ShoppingCartDTO create(ShoppingCartDTO dto) {
		ShoppingCartEntity entity = new ShoppingCartEntity();
		entity.setIdProduct(dto.getIdProduct());
		entity.setQuantity(dto.getQuantity());
		entity.setTotalṔrice(dto.getTotalPrice());

		entity = this.rep.save(entity);
		
		dto.setId(entity.getId());
		
		return dto;
	}

	@Override
	public boolean update(ShoppingCartDTO dto) {
		Optional<ShoppingCartEntity> shoppingCart = this.rep.findAll(dto.getId());
		
		ShoppingCartEntity shoppingCartEntity = null;
		
		if(shoppingCart.isPresent()) {
			shoppingCartEntity = shoppingCart.get();
			shoppingCartEntity.setIdProduct(dto.getIdProduct());
			shoppingCartEntity.setQuantity(dto.getQuantity());
			shoppingCartEntity.setTotalṔrice(dto.getTotalṔrice());
	
			this.rep.save(shoppingCartEntity);

			return true;
		}else {
			
			return false;
		}									
	}
	@Override
	public boolean delete(Long id) {
		Optional<ShoppingCartEntity> shoppingCart = this.rep.findAll(id);
		
		if(shoppingCart.isPresent()) {
			this.rep.deleteById(id);
			
			return true;
		}
		
		return false;
	}


}
