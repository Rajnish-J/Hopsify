package com.hospify.main.DTO;


import java.time.LocalDate;

public class PaymentDTO {

    private long paymentId;

    private LocalDate paymentDate;

    private String paymentType;

    private String paymentStatus;

    private double amount;

    private UserDTO user;

    private HospitalDTO hospital;

}
