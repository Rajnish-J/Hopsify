package com.hospify.main.service;

import com.hospify.main.Response.DoctorResponse;
import com.hospify.main.Response.UserResponse;
import com.hospify.main.bo.DoctorBo;
import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.Doctor;
import com.hospify.main.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorBo doctorBo;

    @Autowired
    private DoctorResponse doctorResponse;

    // register Doctor
    public DoctorResponse registerDoctor(Doctor doctor) throws PasswordException, PhoneNumberException, MobileNumberException,
            GenderException, EmailException, DoctorException, DOBException {
        Doctor resDoctor = doctorBo.registerDoctor(doctor);
        if(resDoctor!=null){
            doctorResponse.setSuccessMessage("SuccessFull Created doctor" + resDoctor);
            doctorResponse.setDoctor(doctor);
        }else{
            doctorResponse.setFailureMessage("Failed To Create the doctor");
        }
        return doctorResponse;
    }

    // update doctor details
    public DoctorResponse updateDoctorDetails(Doctor doctor, Long id) throws PasswordException, MobileNumberException,
            GenderException, EmailException, UserException, DOBException {
        Doctor resDoctor = doctorBo.updateDoctorDetails(doctor, id);
        if(resDoctor != null){
            doctorResponse.setSuccessMessage("SuccessFull updated doctor" + resDoctor);
            doctorResponse.setDoctor(doctor);
        }
        else{
            doctorResponse.setFailureMessage("Failed to update");
        }
        return doctorResponse;
    }

    // view All appointments
    public DoctorResponse viewAllAppointments(Long id) throws UserException {
        List<Appointment> appointmentsList = doctorBo.viewAllAppointments(id);
        if(!appointmentsList.isEmpty()){
            doctorResponse.setSuccessMessage("All appointments fetched successfully");
            doctorResponse.setAppointmentList(appointmentsList);
        }
        else {
            doctorResponse.setFailureMessage("ERROR: Fetching all appointments");
        }
        return doctorResponse;
    }

}
