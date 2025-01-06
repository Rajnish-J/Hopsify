package com.hospify.main.bo;

import com.hospify.main.DTO.PharmacyDTO;
import com.hospify.main.Repo.HospitalRepo;
import com.hospify.main.Repo.PharmacyRepo;
import com.hospify.main.Repo.PrescriptionRepo;
import com.hospify.main.controller.PharmacyController;
import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.Hospital;
import com.hospify.main.entity.Pharmacy;
import com.hospify.main.entity.Prescription;
import com.hospify.main.exception.HospitalException;
import com.hospify.main.exception.PharmacyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PharmacyBo {

    @Autowired
    private PharmacyRepo pharmacyRepo;

    @Autowired
    private HospitalRepo hospitalRepo;

    @Autowired
    private PrescriptionRepo prescriptionRepo;

    /*
     * update
     * accept or reject the incoming prescription
     * status of prescription
     * filter (delivered or un deleivered medicines to the patinets)
     * check quantity of the medicines in the storage.

     */

    //filter Pharmacy By hospitalid
    public List<Pharmacy> filterByHospitalId(long hospitalId) throws HospitalException {
        validateHospital(hospitalId);
        List<Pharmacy> pharmacyList = pharmacyRepo.findByHospitalHospitalId(hospitalId);
        if(pharmacyList.isEmpty()){
            return new ArrayList<Pharmacy>();
       }
        return pharmacyList;
    }

    //Incomming Prescription
    public List<Prescription> inCommingPrescription(long pharmacyId) throws PharmacyException {
        validatePharmacyID(pharmacyId);
        List<Prescription> prescriptionList = prescriptionRepo.findByPharmacyPharmacyId(pharmacyId);
        if(prescriptionList.isEmpty()){
            return new ArrayList<Prescription>();
        }
        return prescriptionList;
    }

    //Validate HospitalId
    private void validateHospital(long hospitalId) throws HospitalException {
        Optional<Hospital> hospital = hospitalRepo.findById(hospitalId);
        if(!hospital.isPresent()){
            throw new HospitalException("Hospital Not Exit in DataBase");
        }
    }

    //validate PharmacyId
    private void validatePharmacyID(long pharmacyId) throws PharmacyException {
        Optional<Pharmacy> pharmacy = pharmacyRepo.findById(pharmacyId);
        if(!pharmacy.isPresent()){
            throw new PharmacyException("Pharmacy Not Exit in DataBase");
        }
    }
}
