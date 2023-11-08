package com.project.storemanagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_itemId")
    private  int orderItemId;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private  int productId;

    @Column(name = "quantity")
    private  int quantity;


}
