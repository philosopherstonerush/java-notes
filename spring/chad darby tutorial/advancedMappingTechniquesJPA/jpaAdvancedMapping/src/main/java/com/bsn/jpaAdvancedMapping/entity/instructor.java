package com.bsn.jpaAdvancedMapping.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private instructorDetail instructorDetail;



}
