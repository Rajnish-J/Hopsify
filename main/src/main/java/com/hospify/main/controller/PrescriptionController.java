package com.hospify.main.controller;

import com.hospify.main.entity.Prescription;
import com.hospify.main.exception.*;
import com.hospify.main.service.PrecriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    private PrecriptionService precriptionService;

    //Add prescription
    @PostMapping("/addprecription")
    public ResponseEntity<?> addPrescription(@RequestBody Prescription prescription) {
        Prescription resprescription = null;
        try {
            resprescription = precriptionService.addPrescription(prescription);
            return ResponseEntity.ok(resprescription);
        } catch (AppointmentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (PharmacyException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (DoctorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (MedicineException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
