package com.hospify.main.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentDTO {

    private long appointmentId;

    private LocalDate appointmentDate;

    private String reason;

    private String appointmentStatus;

    private UserDTO user;

    private DoctorDTO doctor;

    private HospitalDTO hospital;

    private PrescriptionDTO prescription;

    private PaymentDTO payment;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
