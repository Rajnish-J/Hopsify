package com.hospify.main.service;

import com.hospify.main.Response.UserResponse;
import com.hospify.main.bo.UserBo;
import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.User;
import com.hospify.main.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserBo userBo;

    @Autowired
    private UserResponse userResponse;

    //New User Register
    public UserResponse registerUser(User user) throws PasswordException, GenderException, EmailException, DOBException, MobileNumberException {
        User resUser=userBo.registerUser(user);
        if(resUser!=null){
            userResponse.setSuccessMessage("SuccessFull Created User"+resUser);
            userResponse.setUser(user);
            System.out.println(userResponse);
        }else{
            userResponse.setFailureMessage("Failed To Create the User");
        }
        return userResponse;
    }

    // view All appointments
    public UserResponse viewAllAppointments(Long id) throws UserException {
        List<Appointment> appointmentsList = userBo.viewAllAppointments(id);
        if(!appointmentsList.isEmpty()){
            userResponse.setSuccessMessage("All appointments fetched successfully");
            userResponse.setAppointmentList(appointmentsList);
        }
        else {
            userResponse.setFailureMessage("ERROR: Fetching all appointments");
        }
        return userResponse;
    }
}
