package com.hospify.main.controller;

import com.hospify.main.DTO.*;
import com.hospify.main.Response.UserResponse;
import com.hospify.main.entity.*;
import com.hospify.main.exception.*;
import com.hospify.main.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentsController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/bookappointment")
    public ResponseEntity<?> registerUser(@RequestBody AppointmentDTO appointmentDTO){
        System.out.println(appointmentDTO);
        try {
           UserResponse resObj = appointmentService.bookAppointment(mapToEntity(appointmentDTO));
            return ResponseEntity.ok(mapToDto(resObj.getAppointment()));
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (DoctorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (HospitalException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (DOBException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (AppointmentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

        @PostMapping("updateappointment")
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDTO appointmentDTO){
        try {
            UserResponse resObj=appointmentService.updateAppointment(mapToEntity(appointmentDTO));
            return ResponseEntity.ok(mapToDto(resObj.getAppointment()));
        } catch (HospitalException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (AppointmentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (DOBException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (DoctorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    //Map TO Entity
    private Appointment mapToEntity(AppointmentDTO appointmentDTO) {

        Appointment appointment=new Appointment();
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setReason(appointmentDTO.getReason());
        if(appointmentDTO.getAppointmentId()!=0){
            appointment.setAppointmentId(appointmentDTO.getAppointmentId());
        }

        User user=new User();
        user.setUserId(appointmentDTO.getUser().getUserId());
        appointment.setUser(user);

        Doctor doctor=new Doctor();
        doctor.setDoctorId(appointmentDTO.getDoctor().getDoctorId());
        appointment.setDoctor(doctor);

        Hospital hospital=new Hospital();
        hospital.setHospitalId(appointmentDTO.getHospital().getHospitalId());
        appointment.setHospital(hospital);

        if(appointmentDTO.getAppointmentStatus()!=null){
            appointment.setAppointmentStatus(appointmentDTO.getAppointmentStatus());
        }
        if(appointmentDTO.getPrescription()!=null){
            PrescriptionDTO prescriptionDTO=appointmentDTO.getPrescription();
            Prescription prescription=new Prescription();
            prescription.setPrescriptionId(prescriptionDTO.getPrescriptionId());
        }
        if(appointmentDTO.getPayment()!=null){
            PaymentDTO paymentDTO=appointmentDTO.getPayment();
            Payment payment=new Payment();
            payment.setPaymentId(paymentDTO.getPaymentId());
        }


        return appointment;
    }

    // Map to DTO
    private AppointmentDTO mapToDto(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDTO.setReason(appointment.getReason());
        appointmentDTO.setAppointmentStatus(appointment.getAppointmentStatus());
        appointmentDTO.setAppointmentId(appointment.getAppointmentId());

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
