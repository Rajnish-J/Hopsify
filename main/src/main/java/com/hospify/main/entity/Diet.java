package com.hospify.main.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dietId;

    @ManyToOne
    @JoinColumn(name = "diet_type_id")
    private DietType dietType;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
}
