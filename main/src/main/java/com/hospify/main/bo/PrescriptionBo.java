package com.hospify.main.bo;

import com.hospify.main.Repo.PharmacyRepo;
import com.hospify.main.Repo.*;
import com.hospify.main.entity.*;
import com.hospify.main.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PrescriptionBo {
    @Autowired
    private PrescriptionRepo prescriptionRepo;
    @Autowired
    private AppointmentRepo appointmentsRepo;
    @Autowired
    private PharmacyRepo pharmacyRepo;
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MedicineRepo medicineRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;

    public Prescription addPrescription(Prescription prescription)
            throws AppointmentException, PharmacyException, DoctorException, UserException, MedicineException {
        // Validate all associated entities
        Appointment validatedAppointment = validateAppointment(prescription.getAppointment());
        prescription.setAppointment(validatedAppointment);

        validatePharmacy(prescription.getPharmacy());
        validateDoctor(prescription.getDoctor());
        validateUser(prescription.getUser());
        validateMedicine(prescription.getMedicines());

        // Save the prescription
        Prescription resObj = prescriptionRepo.save(prescription);

        // Link prescription to the appointment and save it
        validatedAppointment.setPrescription(resObj);
        appointmentRepo.save(validatedAppointment);

        return resObj;
    }


    //Validate Appointment
    private Appointment validateAppointment(Appointment appointment) throws AppointmentException {
        long appointmentId = appointment.getAppointmentId();
        Optional<Appointment> resAppointment = appointmentsRepo.findById(appointmentId);

        if (!resAppointment.isPresent()) {
            throw new AppointmentException("Invalid Appointment or Appointment Does not Exist in the Database");
        }

        return resAppointment.get();
    }


    //Validate pharmacy
    private void validatePharmacy(Pharmacy pharmacy) throws PharmacyException {
        long pharmacyid = pharmacy.getPharmacyId();
        Optional<Pharmacy> resPharmacy = pharmacyRepo.findById(pharmacyid);
        if(!resPharmacy.isPresent()){
            throw new PharmacyException("Pharmacy Doesnot Exit in DataBase");
        }
        pharmacy = resPharmacy.get();
    }

    //Validate Docotor
    private void validateDoctor(Doctor doctor) throws DoctorException {
        long doctorId = doctor.getDoctorId();
        Optional<Doctor> resDocotor = doctorRepo.findById(doctorId);
        if(!resDocotor.isPresent()){
            throw new DoctorException("Doctor Doesnot Exit in DataBase");
        }
        doctor = resDocotor.get();
    }

    //Validate User
    private void validateUser(User user) throws UserException {
        long userId = user.getUserId();
        Optional<User> resuser = userRepo.findById(userId);
        if(!resuser.isPresent()){
            throw new UserException("User not Exit in DataBase");
        }
        user = resuser.get();
    }

    //Validate Medicines
   private void validateMedicine(List<Medicine> medicines) throws MedicineException {
        List<Long> medicineIds = medicines.stream().map(Medicine::getMedicineId).toList();
        List<Medicine> medicineList = medicineRepo.findAllById(medicineIds);
        if(medicineList.isEmpty()){
            throw new MedicineException("Medicine Doesnot Exit in Pharamcy");
        }
        medicines.clear();
        medicines.addAll(medicineList);
    }


}
