package com.doyur.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "orders") //tablolar için sona -s geliyor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @Column(name = "orderDate")
    private Timestamp orderDate; // gün ve saat olarak tutacak

    @ManyToOne
    @JoinColumn(name = "statusId")
    private OrderStatus status;


}
