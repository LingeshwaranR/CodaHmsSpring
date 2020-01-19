package global.coda.hms.service;

import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Patient service.
 */
@Service
public class PatientService {

    /**
     * The Mapper.
     */
    PatientMapper mapper;

    /**
     * Instantiates a new Patient service.
     *
     * @param mapper the mapper
     */
  private   static Logger LOGGER= LogManager.getLogger(PatientService.class);

    public PatientService(PatientMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Create patient int.
     *
     * @param patient the patient
     * @return the int
     */
    public int createPatient(Patient patient) {
        LOGGER.entry(patient);
        mapper.createUser(patient);
        mapper.createPatient(patient);
        LOGGER.traceExit(patient);
        return patient.getPkUserId();
    }

    /**
     * Get all patients list.
     *
     * @return the list
     */
    public List<Patient> getAllPatients() {
        LOGGER.traceEntry();
        List<Patient> patientList = mapper.getAllPatient();
        LOGGER.traceExit(patientList);
        return patientList;
    }

    /**
     * Get patient by id patient.
     *
     * @param id the id
     * @return the patient
     */
    public Patient getPatientById(int id) {
        LOGGER.entry(id);
        Patient patient = mapper.getById(id);
        LOGGER.traceExit(patient);
        return patient;
    }

    /**
     * Update patient int.
     *
     * @param patient the patient
     * @return the int
     */
    public int updatePatient(Patient patient) {
        LOGGER.entry(patient);
        mapper.updateUser(patient);
        mapper.updatePatient(patient);
        LOGGER.traceExit(patient);
        return patient.getPkUserId();
    }

    /**
     * Delete patient int.
     *
     * @param patient the patient
     * @return the int
     */
    public int deletePatient(Patient patient) {
        LOGGER.entry(patient);
        mapper.deleteUser(patient);
        mapper.deletePatient(patient);
        LOGGER.traceExit(patient);
        return patient.getPkUserId();
    }
}
