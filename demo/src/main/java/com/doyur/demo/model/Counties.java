package com.doyur.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "counties")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Counties  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countyId")
    private int countyId;

    @Column(name = "countyName")
    private String countyName;

    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cityId")
    @OnDelete(action = OnDeleteAction.CASCADE) //bir şehir silindiğinde bağlı ilçelerin de silinmesini sağlar.
    //@JsonIgnore
    private Cities cityId;
}
