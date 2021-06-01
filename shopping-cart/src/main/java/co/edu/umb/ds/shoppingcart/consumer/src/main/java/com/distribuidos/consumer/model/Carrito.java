package com.distribuidos.consumer.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Carrito{

    private int id;
    private int quantity;
    private double total_price;
    private int id_product;
}