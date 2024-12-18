package com.hospify.main.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_id")
    private long pharmacyId;

    @Column(nullable = false)
    private User user;

    @Column(nullable = false)
    private appointment appointment;

    @Column(nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private Prescription prescription;

    @Column(nullable = false)
    private Hospital hospital;

    @Column(nullable = false)
    private Payment payment;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String pharmacySpecilization;

    @CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false)
    private LocalDateTime CreatedAt;
    
    @LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt", nullable = false)
    private LocalDateTime UpdateAt;

    //Getter And Setter


    public long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public com.hospify.main.entity.appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(com.hospify.main.entity.appointment appointment) {
        this.appointment = appointment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPharmacySpecilization() {
        return pharmacySpecilization;
    }

    public void setPharmacySpecilization(String pharmacySpecilization) {
        this.pharmacySpecilization = pharmacySpecilization;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        UpdateAt = updateAt;
    }

    //ToString

    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyId=" + pharmacyId +
                ", user=" + user +
                ", appointment=" + appointment +
                ", doctor=" + doctor +
                ", prescription=" + prescription +
                ", hospital=" + hospital +
                ", payment=" + payment +
                ", status='" + status + '\'' +
                ", pharmacySpecilization='" + pharmacySpecilization + '\'' +
                ", CreatedAt=" + CreatedAt +
                ", UpdateAt=" + UpdateAt +
                '}';
    }
}
