package com.hospify.main.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diet_id")
    private long dietId;
    
    private dietType dietType;
    
    private List<Food> food;

    @CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false)
    private LocalDateTime CreatedAt;
    
    @LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt", nullable = false)
    private LocalDateTime UpdateAt;

    //Getter And Setter


    public long getDietId() {
        return dietId;
    }

    public void setDietId(long dietId) {
        this.dietId = dietId;
    }

    public com.hospify.main.entity.dietType getDietType() {
        return dietType;
    }

    public void setDietType(com.hospify.main.entity.dietType dietType) {
        this.dietType = dietType;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
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
        return "diet{" +
                "dietId=" + dietId +
                ", dietType=" + dietType +
                ", food=" + food +
                ", CreatedAt=" + CreatedAt +
                ", UpdateAt=" + UpdateAt +
                '}';
    }
}
