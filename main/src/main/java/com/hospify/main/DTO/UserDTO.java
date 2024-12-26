package com.hospify.main.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {

    private long userId;

    private String username;

    private long userContactNo;

    private String userEmail;

    private String userPassword;

    private LocalDate userDob;

    private int height;

    private int weight;

    private String maritalStatus;

    private String streetName;

    private long pinCode;

    private String status;

    private CityDTO city;

    private StatesDTO state;

    private String gender;

    private CountryDTO country;

    private List<AppointmentDTO> appointments;

    private List<PaymentDTO> payments;

    private List<PrescriptionDTO> prescriptions;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
