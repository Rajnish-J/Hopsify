package com.hospify.main.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false,unique = true)
    private String  userContactNo;

    @Column(nullable = false,unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String Gender;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int weight;

    private List<appointment> appointments;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private City city;

    @Column(nullable = false)
    private state state;

    @Column(nullable = false)
    private country country;

    @Column(nullable = false)
    private long pincode;

    //@Column(nullable = false)
    private dietType diet;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime CreatedAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime UpdateAt;

    //Getter And Setter

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserContactNo() {
        return userContactNo;
    }

    public void setUserContactNo(String userContactNo) {
        this.userContactNo = userContactNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public dietType getDiet() {
        return diet;
    }

    public void setDiet(dietType diet) {
        this.diet = diet;
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
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userContactNo='" + userContactNo + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", Gender='" + Gender + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", appointments=" + appointments +
                ", streetName='" + streetName + '\'' +
                ", city=" + city +
                ", state=" + state +
                ", country=" + country +
                ", pincode=" + pincode +
                ", diet=" + diet +
                ", CreatedAt=" + CreatedAt +
                ", UpdateAt=" + UpdateAt +
                '}';
    }
}
