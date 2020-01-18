package global.coda.hms.service;

import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    PatientMapper mapper;

    public PatientService(PatientMapper mapper) {
        this.mapper = mapper;
    }

    public int createPatient(Patient patient) {
        mapper.createUser(patient);
        mapper.createPatient(patient);
        return patient.getPkUserId();
    }
    public List<Patient> getAllPatients(){
        List<Patient> patientList=mapper.getAllPatient();
        return patientList;
    }
    public Patient getPatientById(int id){
        Patient patient=mapper.getById(id);
        return patient;
    }
}
