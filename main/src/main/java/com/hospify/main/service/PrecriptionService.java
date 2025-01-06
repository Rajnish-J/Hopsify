package com.hospify.main.service;

import com.hospify.main.bo.PrescriptionBo;
import com.hospify.main.entity.Prescription;
import com.hospify.main.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrecriptionService {
    @Autowired
    private PrescriptionBo prescriptionBo;

    //Add Prescription
    public Prescription addPrescription(Prescription prescription)throws AppointmentException, PharmacyException, DoctorException, UserException, MedicineException {
        Prescription resObj = prescriptionBo.addPrescription(prescription);
        return resObj;
    }
}
