package com.hospify.main.controller;

import com.hospify.main.DTO.*;
import com.hospify.main.Response.UserResponse;
import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.User;
import com.hospify.main.exception.*;
import com.hospify.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserResponse userResponse;


    @PostMapping("/registeruser")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
        try {
            UserResponse response = userService.registerUser(maptoEntity(userDTO));
            User user= response.getUser();
            return ResponseEntity.ok(user);
        } catch (PasswordException | GenderException | EmailException | DOBException | MobileNumberException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/fetchAllAppointments/{id}")
    public ResponseEntity<?> viewAllappointments(@PathVariable long id) {
            try {
                UserResponse response = userService.viewAllAppointments(id);
                List<Appointment> appointmentsList = response.getAppointmentList();
                if(appointmentsList.isEmpty()){
                    return ResponseEntity.ok(new ArrayList<>());
                }

                List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
                for(Appointment vo : appointmentsList){
                    AppointmentDTO dto = mapToAppointmentDto(vo);
                    appointmentDTOS.add(dto);
                }
                return ResponseEntity.ok(appointmentDTOS);
            } catch (UserException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
    }

    //Map to Entity
    private User maptoEntity(UserDTO userDTO) {

        User user=new User();
        user.setUsername(userDTO.getUsername());
        user.setUserContactNo(userDTO.getUserContactNo());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserPassword(userDTO.getUserPassword());
        user.setUserDob(userDTO.getUserDob());
        user.setGender(userDTO.getGender());
/*      user.setHeight(userDTO.getHeight());
        user.setWeight(userDTO.getWeight());
        user.setMaritalStatus(userDTO.getMaritalStatus());
        user.setStreetName(userDTO.getStreetName());
        user.setPinCode(userDTO.getPinCode());
        user.setGender(userDTO.getGender());
        //I DONOT KNOW THE PURPOSE OF STATUS

        CountryDTO countryDTO= userDTO.getCountry();
        Country country=new Country();
        country.setCountryName(countryDTO.getCountryName());

        StatesDTO statesDTO=new StatesDTO();
        States state=new States();
        state.setStateName(statesDTO.getStateName());

        CityDTO cityDTO=new CityDTO();
        City city=new City();
        city.setCityName(cityDTO.getCityName()); */

        return user;
    }

    private UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername(user.getUsername());
        userDTO.setUserContactNo(user.getUserContactNo());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserPassword(user.getUserPassword());
        userDTO.setUserDob(user.getUserDob());
        userDTO.setGender(user.getGender());
        userDTO.setHeight(user.getHeight());
        userDTO.setWeight(user.getWeight());
        userDTO.setMaritalStatus(user.getMaritalStatus());
        userDTO.setStreetName(user.getStreetName());
        userDTO.setPinCode(user.getPinCode());
        userDTO.setGender(user.getGender());

        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountryName(user.getCountry().getCountryName());
        userDTO.setCountry(countryDTO);

        StatesDTO statesDTO = new StatesDTO();
        statesDTO.setStateName(user.getState().getStateName());
        userDTO.setState(statesDTO);

        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityName(user.getCity().getCityName());
        userDTO.setCity(cityDTO);

        return userDTO;
    }

    // Map to DTO
    private AppointmentDTO mapToAppointmentDto(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDTO.setReason(appointment.getReason());
        appointmentDTO.setAppointmentStatus(appointment.getAppointmentStatus());

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(appointment.getUser().getUserId());
        appointmentDTO.setUser(userDTO);

        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setDoctorId(appointment.getDoctor().getDoctorId());
        appointmentDTO.setDoctor(doctorDTO);

        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setHospitalId(appointment.getHospital().getHospitalId());
        appointmentDTO.setHospital(hospitalDTO);

        if (appointment.getPrescription() != null) {
            PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
            prescriptionDTO.setPrescriptionId(appointment.getPrescription().getPrescriptionId());
            appointmentDTO.setPrescription(prescriptionDTO);
        }

        if (appointment.getPayment() != null) {
            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setPaymentId(appointment.getPayment().getPaymentId());
            appointmentDTO.setPayment(paymentDTO);
        }

        return appointmentDTO;
    }

}
