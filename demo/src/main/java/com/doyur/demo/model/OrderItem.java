package com.doyur.demo.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "orderItems") //tablolar için sona -s geliyor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderItemId")
    private int orderItemId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menuId")
    private Menu menu;

    @Column(name = "totalPrice")
    private Float totalPrice;

    @Column(name = "quantity")
    private int quantity;


}
