package com.doyur.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor // idsiz sen ekle const.
@Builder
//@Embeddable
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private int addressId;

    @Column(name = "addressName")
    private String addressName;

    @Lob
    @Column(name = "fullAddress") // ya da text alanı için columnDefinition = "text")
    private String fullAddress;


    @ManyToOne
    @JoinColumn(name = "countyId")
    private Counties countyId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;




}
