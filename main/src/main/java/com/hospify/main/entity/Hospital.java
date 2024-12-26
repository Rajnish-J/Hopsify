package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.List;

//No Mapping for City , State ,Country...

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hospitalId;

    @Column(nullable = false)
    private String hospitalName;

    @Column(unique = true,nullable = false)
    private String hospitalEmail;

    @Column(nullable = false)
    private String hospitalPassword;

    @Column(unique = true,nullable = false)
    private long phoneNumber;

    @Column(nullable = false)
    private String street;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private States state;


    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(nullable = false)
    private long pincode;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Pharmacy> pharmacies;


}
