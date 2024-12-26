package com.hospify.main.controller;

import com.hospify.main.DTO.CityDTO;
import com.hospify.main.DTO.CountryDTO;
import com.hospify.main.DTO.StatesDTO;
import com.hospify.main.DTO.UserDTO;
import com.hospify.main.Response.UserResponse;
import com.hospify.main.entity.User;
import com.hospify.main.exception.*;
import com.hospify.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/registeruser")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
        try {
            UserResponse response = userService.registerUser(maptoEntity(userDTO));
            User user= response.getUser();
            return ResponseEntity.ok(user);
        } catch (PasswordException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (GenderException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (EmailException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (DOBException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (MobileNumberException e) {
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

    private UserDTO mapToDTO(User user) {
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

}
