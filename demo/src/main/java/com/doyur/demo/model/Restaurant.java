package com.doyur.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "restaurants") //tablolar için sona -s geliyor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantId")
    private int restaurantId;

    @Column(name = "restaurantName", unique = true)
    private String restaurantName;

    @ManyToOne
    @JoinColumn(name = "restaurantAddressId")
    private Address restaurantAddress;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private User owner;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "comment", columnDefinition = "text")
    private String comment;

    @Column(name = "minOrderAmount")
    private Float minOrderAmount;


}
