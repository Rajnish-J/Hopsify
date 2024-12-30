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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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

    //Filter By Status Appointments
    public List<Appointment> filterAppointments(String status) throws AppointmentException {
        validateAppointmentstatus(status);
        List<Appointment> resAppointment=appointmentRepo.findByAppointmentStatus(status);
        if(resAppointment.isEmpty()){
            return new ArrayList<Appointment>();
        }
        return resAppointment;
    }

    //Filter By Date
    public List<Appointment> filterByDate(LocalDate startDate, LocalDate endDate) throws DOBException {
        validateStartDateAndEndDate(startDate,endDate);
        List<Appointment> appointmentList=appointmentRepo.findAppointmentsByDateRange(startDate,endDate);
        if(appointmentList.isEmpty()){
            return new ArrayList<Appointment>();
        }
        return appointmentList;
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
    private void validateDate(LocalDateTime appointmentDateTime) throws DOBException {
        // Separate date and time components
        LocalDate appointmentDate = appointmentDateTime.toLocalDate();
        LocalTime appointmentTime = appointmentDateTime.toLocalTime();

        // Current date and time
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        // Validate the date component
        if (appointmentDate.isBefore(currentDate)) {
            throw new DOBException("The appointment date cannot be in the past.");
        }
        if (appointmentDate.isAfter(currentDate.plusMonths(1))) {
            throw new DOBException("The appointment date must be within one month from the current date.");
        }

        // Validate the time component only if the appointment date is today
        if (appointmentDate.isEqual(currentDate) && appointmentTime.isBefore(currentTime)) {
            throw new DOBException("The appointment time cannot be in the past for today's date.");
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

    //Validate StartDate And EndDate
    private void validateStartDateAndEndDate(LocalDate startDate, LocalDate endDate) throws DOBException {
        if (startDate == null || endDate == null) {
            throw new DOBException("Start date and end date cannot be null.");
        }
        // Validate that startDate is before endDate
        if (!startDate.isBefore(endDate)) {
            throw new DOBException("The start date must be before the end date.");
        }
        // Current date
        LocalDate today = LocalDate.now();
        // Ensure the start date is not more than a year in the past
        if (startDate.isBefore(today.minusYears(1))) {
            throw new DOBException("The start date cannot be more than a year in the past.");
        }
        // Ensure the end date is not more than a year in the future
        if (endDate.isAfter(today.plusYears(1))) {
            throw new DOBException("The end date cannot be more than a year in the future.");
        }
        // Optional: Add business-specific rules, such as ensuring the duration is reasonable
        if (startDate.until(endDate, java.time.temporal.ChronoUnit.DAYS) > 30) {
            throw new DOBException("The date range cannot exceed 30 days.");
        }
    }


}
