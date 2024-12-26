package com.hospify.main.DTO;


import java.util.List;

public class DoctorDTO {

    private long doctorId;

    private String doctorName;

    private String specialization;

    private String email;

    private String password;

    private String gender;

    private long doctorPhone;

    private HospitalDTO hospital;

    private List<AppointmentDTO> appointments;

    private List<PrescriptionDTO> prescriptions;

}
