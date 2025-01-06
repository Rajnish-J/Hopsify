package com.hospify.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

//Doubt : Because One Pharmacy can Contain multiple Appointments.

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pharmacyId;

    @Column(nullable = false)
    private String pharmacySpecialization;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
   // @JsonIgnore
    private Hospital hospital;

   // @JsonIgnore
    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
    private List<Medicine> medicines;

    public long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacySpecialization() {
        return pharmacySpecialization;
    }

    public void setPharmacySpecialization(String pharmacySpecialization) {
        this.pharmacySpecialization = pharmacySpecialization;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
