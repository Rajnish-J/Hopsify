package com.hospify.main.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private long doctorId;
    
    @Column(unique = false, nullable = false)
    private String doctorName;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    private Hospital hospital;
    
    @Column(unique = true, nullable = false)
    private long phoneNumber;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(unique = false, nullable = false)
    private String password;
    
    @Column(unique = false, nullable = false)
    private String gender;
    
    @Column(unique = true, nullable = false)
    private String specilization;

    @OneToMany(mappedBy = "doctor")
    private List<appointment> appointmentList;


    @CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false)
    private LocalDateTime CreatedAt;
    
    @LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt", nullable = false)
    private LocalDateTime UpdateAt;

    //Getter And Setter


    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecilization() {
        return specilization;
    }

    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    public List<appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<appointment> appointmentList) {
        this.appointmentList = appointmentList;
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
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", hospital=" + hospital +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", specilization='" + specilization + '\'' +
                ", appointmentList=" + appointmentList +
                ", CreatedAt=" + CreatedAt +
                ", UpdateAt=" + UpdateAt +
                '}';
    }
}
