package com.doyur.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "orderStatus") //tablolar için sona -s geliyor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusId")
    private int statusId;

    @Column(name = "statusName", unique = true)
    private String statusName;


}
