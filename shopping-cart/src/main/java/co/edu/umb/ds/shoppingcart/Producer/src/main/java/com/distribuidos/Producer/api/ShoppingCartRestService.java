package com.example.demo.api;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bussines.ShoppingCartService;
import com.example.demo.dto.ShoppingCartDTO;



@RestController

@RequestMapping("/shoppingCart")

	public class ShoppingCartRestService {

	@Autowired
	private ShoppingCartService service;
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ShoppingCartDTO>> findAll() {
		try {
			List<ShoppingCartDTO> shoppingCart = this.service.findAll();
	
			ResponseEntity<List<ShoppingCartDTO>> response = new ResponseEntity<List<ShoppingCartDTO>>(shoppingCart, HttpStatus.OK);
		
			return response;
		}catch (Exception e) {
			System.out.println("Error en capacidad findAll" + e.getMessage());
		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ShoppingCartDTO> create(
			@RequestBody(required=true) @Valid ShoppingCartDTO shoppingCart{
		try {						
			shoppingCart = this.service.create(shoppingCart);
			ResponseEntity<ShoppingCartDTO> response = new ResponseEntity<ShoppingCartDTO>(shoppingCart, HttpStatus.OK);
			
			return response;
		}catch (IllegalArgumentException e) {
			System.out.println("Error en capacidad create " + e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
		}catch (Exception e) {
			System.out.println("Error en capacidad create " + e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
			
			@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE},
					value="/{id}")
		public ResponseEntity<Void> update(
				@PathVariable(name="id") Long id,
				@RequestBody(required=true) @Valid ShoppingCartDTO shoppingCart){
			try {								
				Assert.notNull(shoppingCart.getPrice, "precio es obligatorio");
				Assert.notNull(shoppingCart.getQuantity, "cantidad es obligatorio");
				shoppingCart.setPrice(price);
				shoppingCart.setQuantity(quantity);
				boolean actualizo = this.service.update(shoppingCart);
				
				if(actualizo) {
					return new ResponseEntity<Void>(HttpStatus.OK);
				}else {
					return new ResponseEntity<Void>(HttpStatus.CREATED);
				}
			}catch (IllegalArgumentException e) {
				System.out.println("Error en capacidad update " + e.getMessage());
				
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
			}catch (Exception e) {
				System.out.println("Error en capacidad update " + e.getMessage());
				
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
			}
		}

			@DeleteMapping()
			public ResponseEntity<Void> delete(
					@RequestParam(name="id", required=true) Long id){
				try {						
					boolean existe = this.service.delete(id);
					
					if(existe) {
						return new ResponseEntity<Void>(HttpStatus.OK);
					}else {
						return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
					}
				}catch (Exception e) {
					System.out.println("Error en capacidad delete " + e.getMessage());
					
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
				}
			} 
			
			
	
	
	
		
}
