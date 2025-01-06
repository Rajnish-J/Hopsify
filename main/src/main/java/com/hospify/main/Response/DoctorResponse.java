package com.hospify.main.Response;

import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.Doctor;
import com.hospify.main.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class DoctorResponse {

    private Doctor doctor;
    private Appointment appointment;
    private String successMessage;
    private String failureMessage;
    private List<Appointment> appointmentList;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @Override
    public String toString() {
        return "DoctorResponse{" +
                "doctor=" + doctor +
                ", appointment=" + appointment +
                ", successMessage='" + successMessage + '\'' +
                ", failureMessage='" + failureMessage + '\'' +
                ", appointmentList=" + appointmentList +
                '}';
    }
}
