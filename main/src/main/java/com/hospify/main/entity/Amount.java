package com.hospify.main.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Amount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amount_id")
    private long amountId;
    

    private User user;
    
    private Hospital hospital;
    
    @Column(unique = false, nullable = false)
    private long amount;

    @CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false)
    private LocalDateTime CreatedAt;
    
    @LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt", nullable = false)
    private LocalDateTime UpdateAt;

    //Getter And Setter


    public long getAmountId() {
        return amountId;
    }

    public void setAmountId(long amountId) {
        this.amountId = amountId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
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
        return "Amount{" +
                "amountId=" + amountId +
                ", user=" + user +
                ", hospital=" + hospital +
                ", amount=" + amount +
                ", CreatedAt=" + CreatedAt +
                ", UpdateAt=" + UpdateAt +
                '}';
    }
}
