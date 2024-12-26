package com.hospify.main.bo;
import com.hospify.main.Repo.UserRepo;
import com.hospify.main.entity.User;
import com.hospify.main.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class UserBo {

    @Autowired
    private UserRepo userRepo;

  /*   * Login: for old patients.
            * sign in: for new patients.(initial it takes only 4 details after successful account creation user could update or add their required details)
            [if the new patient upload the pdf means it will take the information from the pdf and updates the details... ],
            [if the patient update or signed in means it should send the message in gmail]
            * make Appointments.(first hospital view -> check the reviews -> select doctor -> select date and time -> payment process)
            * update Appointments.
            * cancel Appointments.
            * view all Appointments.
    * filter(canceled, upcoming, outdated, inbetween two days, )
    * doctor availability.
            * appointment export option.
    * claim or request for new Insurance
    * pay to renew Insurance  */


    //New User Registration
    public User registerUser(User user) throws EmailException, PasswordException, DOBException, GenderException, MobileNumberException {
        validateEmail(user.getUserEmail());
        validatePassword(user.getUserPassword());
        validateDOB(user.getUserDob());
        validateGender(user.getGender());
        validatePhoneNumber(user.getUserContactNo());
        User userObj = userRepo.save(user);
        return userObj;
    }

    //Validation

    //Validate Email
    private void validateEmail(String userEmail) throws EmailException {
        if(!userEmail.contains("@gmail.com") || userEmail.isEmpty()){
            throw new EmailException("Invalid Email");
        }
    }

    //ValidatePassword
    private void validatePassword(String userPassword) throws PasswordException {
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
    }

    //Validation DOB
    private void validateDOB(LocalDate userDob) throws DOBException {
        if (userDob == null) {
            throw new DOBException("Date of Birth cannot be null.");
        }
        LocalDate today = LocalDate.now();
        int age = Period.between(userDob, today).getYears();
        if (age < 18) {
            throw new DOBException("User must be at least 18 years old.");
        }
    }

    //Validate Gender
    private void validateGender(String gender) throws GenderException {
        if (gender == null || gender.isEmpty()) {
            throw new GenderException("Gender cannot be null or empty.");
        }
        String normalizedGender = gender.trim().toLowerCase();
        if (!(normalizedGender.equals("male") ||
                normalizedGender.equals("female") ||
                normalizedGender.equals("notprefertosay"))) {
            throw new GenderException("Gender must be Male, Female, or NotPreferToSay.");
        }
    }
    //Validate PhoneNumber
    private void validatePhoneNumber(long userContactNo) throws MobileNumberException {
        String number=userContactNo+"";
        if(number.length()!=10){
            throw new MobileNumberException("Mobile Number must be 10 digits");
        }
    }

}
