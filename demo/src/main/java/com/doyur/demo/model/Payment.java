package com.doyur.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Entity
@Data
@Table(name = "payments") //tablolar için sona -s geliyor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @Column(name = "paymentDate")
    private Timestamp paymentDate;

    @Column(name = "amount")
    private float amount;

    private String paymentName;

  /*  @ManyToOne
    @JoinColumn(name = "paymentMethodId")
    private PaymentMethod paymentMethod; */


}

