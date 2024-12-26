package com.hospify.main.DTO;

import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.Pharmacy;
import jakarta.persistence.*;

import java.util.List;

public class HospitalDTO {

    private long hospitalId;

    private String hospitalName;

    private String hospitalEmail;

    private String hospitalPassword;

    private long phoneNumber;

    private String city;

    private String street;

    private String state;

    private String country;

    private long pincode;

    private List<Appointment> appointments;

    private List<Pharmacy> pharmacies;

}
