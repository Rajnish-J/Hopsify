package com.hospify.main.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private long hospitalId;

    @Column(nullable = false,unique = false)
    private String hospitalName;

    @Column(nullable = false,unique = false)
    private String phoneNumber;

    @Column(nullable = false,unique = false)
    private String hospitalEmail;

    @Column(nullable = false)
    private String hospitalPassword;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctorList;

    @OneToMany(mappedBy = "hospital")
    private List<appointment> appointments;

    @Column(nullable = false)
    private String streetName;

    @OneToMany(mappedBy = "hospital")
    private List<Pharmacy> pharmacies;

    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "state", referencedColumnName = "state_id")
    private state state;

    @ManyToOne
    @JoinColumn(name = "country", referencedColumnName = "country_id")
    private country country;

    @Column(nullable = false)
    private long pincode;

    @CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false)
    private LocalDateTime CreatedAt;
    
    @LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt", nullable = false)
    private LocalDateTime UpdateAt;

    //Getter And Setter
    public long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHospitalEmail() {
        return hospitalEmail;
    }

    public void setHospitalEmail(String hospitalEmail) {
        this.hospitalEmail = hospitalEmail;
    }

    public String getHospitalPassword() {
        return hospitalPassword;
    }

    public void setHospitalPassword(String hospitalPassword) {
        this.hospitalPassword = hospitalPassword;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public List<appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<appointment> appointments) {
        this.appointments = appointments;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public com.hospify.main.entity.state getState() {
        return state;
    }

    public void setState(com.hospify.main.entity.state state) {
        this.state = state;
    }

    public com.hospify.main.entity.country getCountry() {
        return country;
    }

    public void setCountry(com.hospify.main.entity.country country) {
        this.country = country;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
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
        return "Hospital{" +
                "hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hospitalEmail='" + hospitalEmail + '\'' +
                ", hospitalPassword='" + hospitalPassword + '\'' +
                ", doctorList=" + doctorList +
                ", appointments=" + appointments +
                ", streetName='" + streetName + '\'' +
                ", city=" + city +
                ", state=" + state +
                ", country=" + country +
                ", pincode=" + pincode +
                ", CreatedAt=" + CreatedAt +
                ", UpdateAt=" + UpdateAt +
                '}';
    }
}
