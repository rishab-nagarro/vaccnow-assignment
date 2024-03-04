package com.vaccnow.application.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="branch")
@Getter
@Setter
@NoArgsConstructor
public class BranchEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name="address")
    private String address;
    @Column(name="contact_info")
    private String contactInfo;

}
