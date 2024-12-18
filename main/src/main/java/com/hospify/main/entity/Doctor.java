package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private long doctorId;
    
    @Column(unique = false, nullable = false)
    private String doctorName;
    
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
    
    private List<appointment> appointmentList;
    
    @CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false)
    private LocalDateTime CreatedAt;
    
    @LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt", nullable = false)
    private LocalDateTime UpdateAt;

}
