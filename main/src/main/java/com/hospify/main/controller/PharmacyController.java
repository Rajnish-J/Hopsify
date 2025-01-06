package com.hospify.main.controller;

import com.hospify.main.DTO.PharmacyDTO;
import com.hospify.main.entity.Pharmacy;
import com.hospify.main.entity.Prescription;
import com.hospify.main.exception.HospitalException;
import com.hospify.main.exception.PharmacyException;
import com.hospify.main.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {
    @Autowired
    private PharmacyService pharmacyService;

    //filter By Hospital
    @GetMapping("/filterbyhospital")
    public ResponseEntity<?> filterByHospitalId(@RequestParam long hospitalId){
        try {
            List<Pharmacy> pharmacyList = pharmacyService.filterByHospitalId(hospitalId);
            List<PharmacyDTO> pharmacyDTOList = new ArrayList<PharmacyDTO>();
            for(Pharmacy obj : pharmacyList){
                PharmacyDTO pharmacyRes = new PharmacyDTO();
                pharmacyRes.setPharmacyId(obj.getPharmacyId());
                pharmacyRes.setPharmacySpecialization(obj.getPharmacySpecialization());
                pharmacyDTOList.add(pharmacyRes);
            }
            return ResponseEntity.ok(pharmacyList);
        } catch (HospitalException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //find incomming Prescription
    @GetMapping("/incommingprescription")
    public ResponseEntity<?> inCommingPrescription(@RequestParam long pharmacyId){
        try {
          List<Prescription> prescriptionList = pharmacyService.inCommingPrescription(pharmacyId);
          return  ResponseEntity.ok(prescriptionList);
        } catch (PharmacyException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
