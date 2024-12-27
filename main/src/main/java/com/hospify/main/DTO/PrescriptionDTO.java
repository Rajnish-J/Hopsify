package com.hospify.main.DTO;

import java.util.List;

public class PrescriptionDTO {

    private long prescriptionId;

    private String medicines;

    private UserDTO user;

    private DoctorDTO doctor;

    private AppointmentDTO appointment;

    private List<MedicineDTO> medicineList;

    public long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public AppointmentDTO getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentDTO appointment) {
        this.appointment = appointment;
    }

    public List<MedicineDTO> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<MedicineDTO> medicineList) {
        this.medicineList = medicineList;
    }
}
