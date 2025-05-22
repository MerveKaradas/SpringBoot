package com.doyur.demo.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "paymentMethods") //tablolar için sona -s geliyor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentMethodId")
    private int paymentMethodId;

    @Column(name = "paymentMethodName", unique = true)
    private String paymentMethodName;


}
