package com.hospify.main.bo;

import com.hospify.main.Repo.DoctorRepo;
import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.Doctor;
import com.hospify.main.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorBo {

    @Autowired
    private DoctorRepo doctorRepo;

    /*

     * login
     * requesting to add profile in the hospital (redirect to the respective hospital mail) => sign in
     * update details
     * doctor can approve or reject the incoming appointments
     * view appoitments
     * filter (for appointments) -> (canceled, upcoming, outdated, inbetween two days, )
     * update appointments (if the doctor updates or cancel the message will redirect to the paient email)
     * cancel appointments (if the doctor updates or cancel the message will redirect to the paient email)

     */

    // sign in or requesting
    public Doctor registerDoctor(Doctor doctor) throws DoctorException, EmailException, DOBException, PasswordException, GenderException,
            MobileNumberException, PhoneNumberException {

        if(doctor == null){
            throw new DoctorException("No records found");
        }

        validateEmail(doctor.getEmail());
        validatePassword(doctor.getPassword());
        validateGender(doctor.getGender());
        validateDOB(doctor.getDoctorDob());
        validatePhoneNumber(doctor.getDoctorPhone());

        boolean emailExists = doctorRepo.existsByEmail(doctor.getEmail());
        boolean phoneExists = doctorRepo.existsByPhone(doctor.getDoctorPhone());

        if (emailExists) {
            throw new EmailException("Email is already registered. Please try logging in.");
        }
        if (phoneExists) {
            throw new PhoneNumberException("Phone number is already registered. Please try logging in.");
        }

        Doctor docObj = doctorRepo.save(doctor);

        return docObj;

    }

    // update details
    public Doctor updateDoctorDetails(Doctor doctor, long id) throws UserException, PasswordException, MobileNumberException,
            GenderException, EmailException, DOBException {
        if (validateID(id)) {
            Doctor existingDetails = doctorRepo.findById(id).orElseThrow(() ->
                    new UserException("Doctor with ID " + id + " not found"));

            // Update the doctor's name
            existingDetails.setDoctorName(doctor.getDoctorName());

            // Update specialization
            existingDetails.setSpecialization(doctor.getSpecialization());

            // Update email
            if (validateEmail(doctor.getEmail())) {
                existingDetails.setEmail(doctor.getEmail());
            } else {
                throw new EmailException("Invalid email format.");
            }

            // Update phone number
            if (validatePhoneNumber(doctor.getDoctorPhone())) {
                existingDetails.setDoctorPhone(doctor.getDoctorPhone());
            } else {
                throw new MobileNumberException("Invalid mobile number.");
            }

            // Update gender
            if (validateGender(doctor.getGender())) {
                existingDetails.setGender(doctor.getGender());
            } else {
                throw new GenderException("Invalid gender value.");
            }

            // Update date of birth
            if (validateDOB(doctor.getDoctorDob())) {
                existingDetails.setDoctorDob(doctor.getDoctorDob());
            } else {
                throw new DOBException("Invalid date of birth.");
            }

            // Update professional status
            existingDetails.setProfessionalStatus(doctor.getProfessionalStatus());

            // Save and return updated doctor details
            return doctorRepo.save(existingDetails);
        } else {
            throw new UserException("Invalid ID.");
        }
    }

    // view all appointments
    public List<Appointment> viewAllAppointments(long id) throws UserException {
        if(validateID(id)){
            List<Appointment> appointmentsList = doctorRepo.findAllAppointments(id);
            if(appointmentsList.isEmpty()){
                return (new ArrayList<>());
            }
            return appointmentsList;
        }
        return null;
    }

    //Validation

    // validate doctor
    public boolean validateDoctor(Doctor doctor) throws DOBException, UserException, EmailException, PasswordException, MobileNumberException, GenderException {
        return (validateID(doctor.getDoctorId()) && validateDOB(doctor.getDoctorDob()) && validateEmail(doctor.getEmail()) && validatePassword(doctor.getPassword()) &&
                validatePhoneNumber(doctor.getDoctorPhone()) && validateGender(doctor.getGender()));
    }

    //Validate Email
    private boolean validateEmail(String userEmail) throws EmailException {
        if(!userEmail.contains("@gmail.com") || userEmail.isEmpty()){
            throw new EmailException("Invalid Email");
        }
        return true;
    }

    //ValidatePassword
    private boolean validatePassword(String userPassword) throws PasswordException {
        if (userPassword == null || userPassword.isEmpty()) {
            throw new PasswordException("Password cannot be null or empty.");
        }
        if (userPassword.length() < 8) {
            throw new PasswordException("Password must be at least 8 characters long.");
        }
        if (!userPassword.matches(".*[A-Z].*")) {
            throw new PasswordException("Password must contain at least one uppercase letter.");
        }
        if (!userPassword.matches(".*[a-z].*")) {
            throw new PasswordException("Password must contain at least one lowercase letter.");
        }
        if (!userPassword.matches(".*\\d.*")) {
            throw new PasswordException("Password must contain at least one digit.");
        }
        if (!userPassword.matches(".*[@$!%*?&].*")) {
            throw new PasswordException("Password must contain at least one special character (@$!%*?&).");
        }
        return true;
    }

    //Validation DOB
    private boolean validateDOB(LocalDate doctorDOB) throws DOBException {
        if (doctorDOB == null) {
            throw new DOBException("Date of Birth cannot be null.");
        }
        LocalDate today = LocalDate.now();
        int age = Period.between(doctorDOB, today).getYears();
        if (age < 18) {
            throw new DOBException("User must be at least 18 years old.");
        }
        return true;
    }

    //Validate Gender
    private boolean validateGender(String gender) throws GenderException {
        if (gender == null || gender.isEmpty()) {
            throw new GenderException("Gender cannot be null or empty.");
        }
        String normalizedGender = gender.trim().toLowerCase();
        if (!(normalizedGender.equals("male") ||
                normalizedGender.equals("female") ||
                normalizedGender.equals("notprefertosay"))) {
            throw new GenderException("Gender must be Male, Female, or NotPreferToSay.");
        }
        return true;
    }
    //Validate PhoneNumber
    private boolean validatePhoneNumber(long userContactNo) throws MobileNumberException {
        String number=userContactNo+"";
        if(number.length()!=10){
            throw new MobileNumberException("Mobile Number must be 10 digits");
        }
        return true;
    }

    // validate that patient that existing in the database or not:
    public boolean validateID(Long id) throws UserException {
        boolean contains = doctorRepo.existsById(id);
        if (!contains) {
            throw new UserException("ERROR: patient ID not exist in the database");
        }
        if (id == null) {
            throw new UserException("ERROR: patient Id field could not be null");
        } else if (id <= 0) {
            throw new UserException("ERROR: patient ID could not be negative or zero");
        }

        return true;
    }

}
