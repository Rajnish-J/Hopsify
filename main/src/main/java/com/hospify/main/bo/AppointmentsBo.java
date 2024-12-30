package com.hospify.main.bo;

import com.hospify.main.Repo.AppointmentRepo;
import com.hospify.main.Repo.DoctorRepo;
import com.hospify.main.Repo.HospitalRepo;
import com.hospify.main.Repo.UserRepo;
import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.Doctor;
import com.hospify.main.entity.Hospital;
import com.hospify.main.entity.User;
import com.hospify.main.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class AppointmentsBo {
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private HospitalRepo hospitalRepo;

    /*

     * if patient books appointment, it will goes respective doctors page
     * after appointment booked it will send message in the mail as appointment added message
     * Payment (after payment it will send an mail to the respective hospital)
     * doctor can add the prescription respect to the patient
     * after done appointment the prescription could be redirected to the pharmacy with prescription id, to deleiver the medicines

     */

    public Appointment bookAppointment(Appointment appointment) throws UserException, DoctorException, HospitalException, DOBException, AppointmentException {
        validateUser(appointment.getUser());
        validateDoctor(appointment.getDoctor());
        validateHospital(appointment.getHospital());
        validateDate(appointment.getAppointmentDate());
        validateAppointmentreason(appointment.getReason());
        appointment.setAppointmentStatus("Pending");
        Appointment resAppointment=appointmentRepo.save(appointment);
        return resAppointment;
    }

    //Update Appointment
    public Appointment updateAppointment(Appointment appointment) throws UserException, DOBException, HospitalException, DoctorException, AppointmentException {
        validateUser(appointment.getUser());
        validateDate(appointment.getAppointmentDate());
        validateHospital(appointment.getHospital());
        validateDoctor(appointment.getDoctor());
        validateAppointmentId(appointment.getAppointmentId());
        validateAppointmentstatus(appointment.getAppointmentStatus());
        validateAppointmentreason(appointment.getReason());
        Appointment resAppointment=appointmentRepo.save(appointment);
        return appointment;
    }

    //Validate User
    private void validateUser(User user) throws UserException {
        Optional<User> userObj=userRepo.findById(user.getUserId());
        if(!userObj.isPresent()){
            throw new UserException("User Not Exit in DataBase");
        }
        user=userObj.get();
    }

    //Validate Doctor
    private void validateDoctor(Doctor doctor) throws DoctorException {
       Optional<Doctor> doctorObj= doctorRepo.findById(doctor.getDoctorId());
       if(!doctorObj.isPresent()){
           throw new DoctorException("Docotor Not Exit in DataBase");
       }
       doctor=doctorObj.get();
    }

    //Validation Hospital
    private void validateHospital(Hospital hospital) throws HospitalException {
        Optional<Hospital> hospitalObj=hospitalRepo.findById(hospital.getHospitalId());
        if(!hospitalObj.isPresent()){
            throw new HospitalException("Hospital Not Exit in DataBase");
        }
        hospital=hospitalObj.get();
    }

    //Validate Date
    private void validateDate(LocalDate appointmentDate) throws DOBException {
        LocalDate currentDate = LocalDate.now();
        if (appointmentDate.isBefore(currentDate)) {
            throw new DOBException("The appointment date cannot be in the past.");
        }
        if (appointmentDate.isAfter(currentDate.plusMonths(1))) {
            throw new DOBException ("The appointment date must be within one month from the current date.");
        }
    }

    //Validate AppointmentId
    private void validateAppointmentId(long appointmentId) throws AppointmentException {
        Optional<Appointment> appointment=appointmentRepo.findById(appointmentId);
        if(appointment.get()==null){
            throw new AppointmentException("Appointment Id is Not Exit in DataBase");
        }
    }

    //Validate AppoitmentStatus
    private void validateAppointmentstatus(String appointmentStatus) throws AppointmentException {
        appointmentStatus=appointmentStatus.trim();
        if(!(appointmentStatus.equalsIgnoreCase("Scheduled")||appointmentStatus.equalsIgnoreCase("Pending") ||appointmentStatus.equalsIgnoreCase("Cancel")||appointmentStatus.equalsIgnoreCase("Reschedule")||appointmentStatus.equalsIgnoreCase("Completed"))){
            throw new AppointmentException("Invalid AppointmentStaus");
        }
    }

    //Validate Appointment Reason
    private void validateAppointmentreason(String reason) throws AppointmentException {
        if(reason.length()>50){
            throw new AppointmentException("Reason must Contain 50 Characters including Spaces");
        }
        if (!reason.matches("[a-zA-Z ]+")) {
            throw new AppointmentException("Reason must contain only alphabets and spaces");
        }
    }


}
