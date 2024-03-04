package com.vaccnow.application.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="vaccine")
@Getter
@Setter
@NoArgsConstructor
public class VaccineEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="vaccine_name")
    private String vaccineName;
    @Column(name="manufacturer")
    private String manufacturer;
    @Column(name="type")
    private String type;
    @Column(name="description")
    private String description;

}
