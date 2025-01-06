package com.hospify.main.service;

import com.hospify.main.bo.PharmacyBo;
import com.hospify.main.entity.Pharmacy;
import com.hospify.main.entity.Prescription;
import com.hospify.main.exception.HospitalException;
import com.hospify.main.exception.PharmacyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyService {
    @Autowired
    private PharmacyBo pharmacyBo;

    //Filter By Hospital Id
    public List<Pharmacy> filterByHospitalId(long hospitalId) throws HospitalException {
        List<Pharmacy> pharmacyList = pharmacyBo.filterByHospitalId(hospitalId);
        return pharmacyList;
    }

    //Incomming Prescription for Pharmacy
    public List<Prescription> inCommingPrescription(long pharmacyId) throws PharmacyException {
        List<Prescription> prescriptionList = pharmacyBo.inCommingPrescription(pharmacyId);
        return prescriptionList;
    }
}
