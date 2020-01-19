package global.coda.hms.service;

import global.coda.hms.mapper.DoctorMapper;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Doctor service.
 */
@Service
public class DoctorService {

    /**
     * The Mapper.
     */
    DoctorMapper mapper;
    private static Logger LOGGER = LogManager.getLogger(DoctorService.class);

    /**
     * Instantiates a new Doctor service.
     *
     * @param mapper the mapper
     */
    public DoctorService(DoctorMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Create doctor int.
     *
     * @param doctor the doctor
     * @return the int
     */
    public int createDoctor(Doctor doctor) {
        LOGGER.entry(doctor);
        mapper.createUser(doctor);
        mapper.createDoctor(doctor);
        LOGGER.traceExit(doctor);
        return doctor.getPkUserId();
    }

    /**
     * Gets all doctors.
     *
     * @return the all doctors
     */
    public List<Doctor> getAllDoctors() {
        LOGGER.traceEntry();
        List<Doctor> doctorList = mapper.getAllDoctors();
        LOGGER.traceExit(doctorList);
        return doctorList;
    }

    /**
     * Gets doctor by id.
     *
     * @param id the id
     * @return the doctor by id
     */
    public Doctor getDoctorById(int id) {
        LOGGER.entry(id);
        Doctor doctor = mapper.getDoctorById(id);
        LOGGER.traceExit(doctor);
        return doctor;
    }

    /**
     * Update doctor int.
     *
     * @param doctor the doctor
     * @return the int
     */
    public int updateDoctor(Doctor doctor) {
        LOGGER.entry(doctor);
        mapper.updateUser(doctor);
        mapper.updateDoctor(doctor);
        LOGGER.traceExit(doctor);
        return doctor.getPkUserId();
    }


    /**
     * Delete doctor int.
     *
     * @param doctor the doctor
     * @return the int
     */
    public int deleteDoctor(Doctor doctor) {
        LOGGER.entry(doctor);
        mapper.deleteUser(doctor);
        mapper.deleteDoctor(doctor);
        LOGGER.traceExit(doctor);
        return doctor.getPkUserId();
    }

    /**
     * Gets all patient under a doctor.
     *
     * @param id the id
     * @return the all patient under a doctor
     */
    public List<Patient> getAllPatientUnderADoctor(int id) {
        LOGGER.traceEntry();
        List<Patient> patientList = mapper.getPatientUnderADoctor(id);
        LOGGER.traceExit(patientList);
        return patientList;
    }

    /**
     * Gets all patients under all doctors.
     *
     * @return the all patients under all doctors
     */
    public List<Doctor> getAllPatientsUnderAllDoctors() {
        LOGGER.traceEntry();
        List<Doctor> doctorList = mapper.getAllPatientUnderAllDoctors();
        LOGGER.traceExit(doctorList);
        return doctorList;
    }
}
