package com.hospify.main.DTO;

import java.util.List;

public class PrescriptionDTO {

    private long prescriptionId;

    private String medicines;

    private UserDTO user;

    private DoctorDTO doctor;

    private AppointmentDTO appointment;

    private List<MedicineDTO> medicineList;

}
