package com.example.demo.bussines;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ShoppingCartDTO;

@Service
public interface ShoppingCartService {

	public List<ShoppingCartDTO> findAll();
	
	public ShoppingCartDTO create(ShoppingCartDTO dto);
	
	public boolean update(ShoppingCartDTO dto);
	
	public boolean delete(Long id);
}
