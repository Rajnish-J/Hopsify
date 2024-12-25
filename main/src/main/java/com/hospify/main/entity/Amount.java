package com.hospify.main.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;


//Note : I didnot Add to Hospital And User

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Amount {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amount_id")
    private long amountId;


 /*   @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "userId")
    private User user; */

 /*   @ManyToOne
    @JoinColumn(name = "hospitalId", referencedColumnName = "hospitalId")
    private Hospital hospital; */

    @OneToOne
    @JoinColumn(name="medicine_id")
    private Medicine medicine;

    @Column(nullable = false)
    private double amount;

    //Getter And Setter
}
