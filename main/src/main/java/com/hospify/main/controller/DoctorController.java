package com.hospify.main.controller;
import com.hospify.main.DTO.*;
import com.hospify.main.Response.DoctorResponse;
import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.Doctor;
import com.hospify.main.entity.Hospital;
import com.hospify.main.entity.Prescription;
import com.hospify.main.exception.*;
import com.hospify.main.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorResponse doctorResponse;

    @Autowired
    private DoctorService doctorService;

    // register doctor
    @PostMapping("/registerDoctor")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorDTO doctorDTO){
        try {
            doctorResponse = doctorService.registerDoctor(mapToEntity(doctorDTO));
            return ResponseEntity.ok(doctorResponse.getDoctor());
        } catch (PasswordException | PhoneNumberException | GenderException | MobileNumberException | EmailException |
                 DoctorException | DOBException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // update doctor details
    @PutMapping("/updateDoctor/{id}")
    public ResponseEntity<?> updateDoctor(@RequestBody DoctorDTO doctorDTO, @PathVariable long id){
        try {
            doctorResponse = doctorService.updateDoctorDetails(mapToEntity(doctorDTO), id);
            return ResponseEntity.ok(mapToDTO(doctorResponse.getDoctor()));
        } catch (PasswordException | EmailException | MobileNumberException | GenderException | UserException |
                 DOBException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/fetchAllAppointments/{id}")
    public ResponseEntity<?> viewAllappointments(@PathVariable long id) {
        try {
            doctorResponse = doctorService.viewAllAppointments(id);
            List<Appointment> appointmentsList = doctorResponse.getAppointmentList();
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

    // Method to convert Entity to DTO
    public DoctorDTO mapToDTO(Doctor doctor) {
        if (doctor == null) {
            return null;
        }

        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setDoctorId(doctor.getDoctorId());
        doctorDTO.setDoctorName(doctor.getDoctorName());
        doctorDTO.setSpecialization(doctor.getSpecialization());
        doctorDTO.setDoctorDob(doctor.getDoctorDob());
        doctorDTO.setEmail(doctor.getEmail());
        doctorDTO.setPassword(doctor.getPassword());
        doctorDTO.setGender(doctor.getGender());
        doctorDTO.setDoctorPhone(doctor.getDoctorPhone());

        // Map Hospital entity to DTO if it exists
        if (doctor.getHospital() != null) {
            HospitalDTO hospitalDTO = new HospitalDTO();
            hospitalDTO.setHospitalId(doctor.getHospital().getHospitalId());
            hospitalDTO.setHospitalName(doctor.getHospital().getHospitalName());
            doctorDTO.setHospital(hospitalDTO);
        }

        // Map Appointments
        if (doctor.getAppointments() != null) {
            List<AppointmentDTO> appointmentDTOs = doctor.getAppointments().stream()
                    .map(appointment -> {
                        AppointmentDTO appointmentDTO = new AppointmentDTO();
                        appointmentDTO.setAppointmentId(appointment.getAppointmentId());
                        appointmentDTO.setAppointmentDate(appointment.getAppointmentDate());
                        // Map other fields as necessary
                        return appointmentDTO;
                    }).collect(Collectors.toList());
            doctorDTO.setAppointments(appointmentDTOs);
        }

        // Map Prescriptions
        if (doctor.getPrescriptions() != null) {
            List<PrescriptionDTO> prescriptionDTOs = doctor.getPrescriptions().stream()
                    .map(prescription -> {
                        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
                        prescriptionDTO.setPrescriptionId(prescription.getPrescriptionId());
                        prescriptionDTO.setMedicines(prescription.getMedicines());
                        // Map other fields as necessary
                        return prescriptionDTO;
                    }).collect(Collectors.toList());
            doctorDTO.setPrescriptions(prescriptionDTOs);
        }

        return doctorDTO;
    }

    // Method to convert DTO to Entity
    public Doctor mapToEntity(DoctorDTO doctorDTO) {
        if (doctorDTO == null) {
            return null;
        }

        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorDTO.getDoctorId());
        doctor.setDoctorName(doctorDTO.getDoctorName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setDoctorDob(doctorDTO.getDoctorDob());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPassword(doctorDTO.getPassword());
        doctor.setGender(doctorDTO.getGender());
        doctor.setDoctorPhone(doctorDTO.getDoctorPhone());

        // Map Hospital DTO to Entity if it exists
        if (doctorDTO.getHospital() != null) {
            Hospital hospital = new Hospital();
            hospital.setHospitalId(doctorDTO.getHospital().getHospitalId());
            hospital.setHospitalName(doctorDTO.getHospital().getHospitalName());
            doctor.setHospital(hospital);
        }

        // Map Appointments
        if (doctorDTO.getAppointments() != null) {
            List<Appointment> appointments = doctorDTO.getAppointments().stream()
                    .map(appointmentDTO -> {
                        Appointment appointment = new Appointment();
                        appointment.setAppointmentId(appointmentDTO.getAppointmentId());
                        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
                        // Map other fields as necessary
                        return appointment;
                    }).collect(Collectors.toList());
            doctor.setAppointments(appointments);
        }

        // Map Prescriptions
        if (doctorDTO.getPrescriptions() != null) {
            List<Prescription> prescriptions = doctorDTO.getPrescriptions().stream()
                    .map(prescriptionDTO -> {
                        Prescription prescription = new Prescription();
                        prescription.setPrescriptionId(prescriptionDTO.getPrescriptionId());
                        prescriptionDTO.setMedicines(prescription.getMedicines());
                        // Map other fields as necessary
                        return prescription;
                    }).collect(Collectors.toList());
            doctor.setPrescriptions(prescriptions);
        }

        return doctor;
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
