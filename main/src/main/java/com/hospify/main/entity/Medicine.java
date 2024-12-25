package com.hospify.main.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private long medicineId;

    @Column(nullable = false)
    private String medicineName;

    @Column(nullable = false)
    private long medicinePrice;

    @OneToOne
    @JoinColumn(name = "amount_id")
    private Amount amount;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
}
