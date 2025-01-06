package com.hospify.main.DTO;

import com.hospify.main.entity.Hospital;
import com.hospify.main.entity.Medicine;
import jakarta.persistence.*;

import java.util.List;

public class PharmacyDTO {

   private long pharmacyId;
   private String pharmacySpecialization;

    public long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacySpecialization() {
        return pharmacySpecialization;
    }

    public void setPharmacySpecialization(String pharmacySpecialization) {
        this.pharmacySpecialization = pharmacySpecialization;
    }

    //To String

    @Override
    public String toString() {
        return "PharmacyDTO{" +
                "pharmacyId=" + pharmacyId +
                ", pharmacySpecialization='" + pharmacySpecialization + '\'' +
                '}';
    }
}
