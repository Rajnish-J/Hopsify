package com.hospify.main.service;


import com.hospify.main.Repo.AppointmentRepo;
import com.hospify.main.Response.UserResponse;
import com.hospify.main.bo.AppointmentsBo;
import com.hospify.main.entity.Appointment;
import com.hospify.main.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentsBo appointmentsBo;

    @Autowired
    private UserResponse userResponse;
    //Book Appointment
    public UserResponse bookAppointment(Appointment appointment) throws UserException, DoctorException, HospitalException, DOBException, AppointmentException {
        Appointment resappointment=appointmentsBo.bookAppointment(appointment);
        if(resappointment!=null){
            userResponse.setAppointment(resappointment);
            userResponse.setSuccessMessage("Appointment Booked Successfully");
            System.out.println(userResponse);
        }else{
            userResponse.setFailureMessage("Appointment is not Booked Successfully");
        }
        return userResponse;
    }

    //Update Appoitment
    public UserResponse updateAppointment(Appointment appointment) throws HospitalException, AppointmentException, UserException, DOBException, DoctorException {
        Appointment resAppointment=appointmentsBo.updateAppointment(appointment);
        if(resAppointment!=null){
            userResponse.setAppointment(resAppointment);
            userResponse.setSuccessMessage("Appointment Updated Successfully");
        }else{
            userResponse.setFailureMessage("Appointment is not Booked Successfully");
        }
       return userResponse;
    }

    //Filter Appointments
    public UserResponse filterAppointments(String status) throws AppointmentException {
        List<Appointment> resAppointments =appointmentsBo.filterAppointments(status);
        userResponse.setAppointmentList(resAppointments);
        return userResponse;
    }

    //Filter By Date
    public UserResponse filterByDate(LocalDate startDate, LocalDate endDate) throws DOBException {
        List<Appointment> resAppointments = appointmentsBo.filterByDate(startDate,endDate);
        userResponse.setAppointmentList(resAppointments);
        return userResponse;
    }
}
