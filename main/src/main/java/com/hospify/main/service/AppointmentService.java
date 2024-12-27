package com.hospify.main.service;


import com.hospify.main.Repo.AppointmentRepo;
import com.hospify.main.bo.AppointmentsBo;
import com.hospify.main.entity.Appointment;
import com.hospify.main.exception.DOBException;
import com.hospify.main.exception.DoctorException;
import com.hospify.main.exception.HospitalException;
import com.hospify.main.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentsBo appointmentsBo;
    //Book Appointment
    public Appointment bookAppointment(Appointment appointment) throws UserException, DoctorException, HospitalException, DOBException {
        Appointment resappointment=appointmentsBo.bookAppointment(appointment);
        return resappointment;
    }
}
