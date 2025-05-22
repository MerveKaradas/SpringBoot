package com.doyur.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "menus") //tablolar için sona -s geliyor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuId")
    private int menuId;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @Column(name = "menuName", unique = true)
    private String menuName;

    @Column(name = "price")
    private Float price;

    @Column(name = "description", columnDefinition = "text")
    private String description;

}
