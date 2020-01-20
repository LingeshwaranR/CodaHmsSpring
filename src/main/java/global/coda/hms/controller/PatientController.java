package global.coda.hms.controller;


import global.coda.hms.model.CustomResponse;
import global.coda.hms.model.Patient;
import global.coda.hms.service.PatientService;
import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Patient controller.
 */
@RestController
@RequestMapping("/patients")
public class PatientController {

    /**
     * The Patient service.
     */
    @Autowired
   private PatientService patientService;
    private static Logger LOGGER = LogManager.getLogger(PatientController.class);


    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping("/getAllPatient")
    public CustomResponse<List<Patient>> getAll() {
        LOGGER.traceEntry();
        CustomResponse<List<Patient>> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setObject(patientService.getAllPatients());
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public CustomResponse<Patient> getById(@PathVariable("id") int id) {
        LOGGER.entry(id);
        CustomResponse<Patient> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setObject(patientService.getPatientById(id));
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Create patient custom response.
     *
     * @param patient the patient
     * @return the custom response
     */
    @PostMapping("/create")
    public CustomResponse<Integer> createPatient(@RequestBody Patient patient) {
        LOGGER.entry(patient);
        CustomResponse<Integer> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setObject(patientService.createPatient(patient));
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Update patient custom response.
     *
     * @param patient the patient
     * @return the custom response
     */
    @PostMapping("/update")
    public CustomResponse<Integer> updatePatient(@RequestBody Patient patient) {
        LOGGER.entry(patient);
        CustomResponse<Integer> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setObject(patientService.updatePatient(patient));
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Delete patient custom response.
     *
     * @param patient the patient
     * @return the custom response
     */
    @PostMapping("/delete")
    public CustomResponse<Integer> deletePatient(@RequestBody Patient patient) {
        LOGGER.entry(patient);
        CustomResponse<Integer> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setObject(patientService.deletePatient(patient));
        LOGGER.traceExit(customResponse);
        return customResponse;
    }
}
