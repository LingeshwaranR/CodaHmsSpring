package global.coda.hms.controller;


import global.coda.hms.exception.SystemException;
import global.coda.hms.model.CustomResponse;
import global.coda.hms.model.Doctor;
import global.coda.hms.service.DoctorService;
import org.apache.catalina.connector.Response;
import org.apache.catalina.filters.RequestFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * The type Doctor controller.
 */
@RestController
@CrossOrigin
@RequestMapping("/doctors")
public class DoctorController {
    /**
     * The Doctor service.
     */
    @Autowired
    private DoctorService doctorService;
    private static Logger LOGGER = LogManager.getLogger(PatientController.class);

    /**
     * Create patient custom response.
     *
     * @param doctor the doctor
     * @return the custom response
     */
    @PostMapping("/create")
    public CustomResponse<Integer> createPatient(@RequestBody Doctor doctor) {
        LOGGER.entry(doctor);
        CustomResponse<Integer> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setObject(doctorService.createDoctor(doctor));
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping("/getAllDoctor")
    public CustomResponse<List<Doctor>> getAll(HttpServletRequest httpServletRequest) {
        LOGGER.traceEntry();
        CustomResponse<List<Doctor>> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setRequestId((Integer) httpServletRequest.getAttribute("requestId"));
        customResponse.setObject(doctorService.getAllDoctors());
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Gets doctor by id.
     *
     * @param id the id
     * @return the doctor by id
     */
    @GetMapping("/{id}")
    public CustomResponse<Doctor> getDoctorById(@PathVariable("id") int id) {
        LOGGER.entry(id);
        CustomResponse<Doctor> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setObject(doctorService.getDoctorById(id));
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Update doctor custom response.
     *
     * @param doctor the doctor
     * @return the custom response
     */
    @PostMapping("/update")
    public CustomResponse<Integer> updateDoctor(@RequestBody Doctor doctor) {
        LOGGER.entry(doctor);
        CustomResponse<Integer> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setObject(doctorService.updateDoctor(doctor));
        LOGGER.traceExit(customResponse);
        return customResponse;
    }


    /**
     * Delete patient custom response.
     *
     * @param doctor the doctor
     * @return the custom response
     */
    @PostMapping("/delete")
    public CustomResponse<Integer> deletePatient(@RequestBody Doctor doctor) {
        LOGGER.entry(doctor);
        CustomResponse<Integer> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setObject(doctorService.deleteDoctor(doctor));
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Gets all patients under a doctor.
     *
     * @param doctorId the id
     * @return the all patients under a doctor
     */
    @GetMapping("/patients")
    public CustomResponse<List<Doctor>> getAllPatientsUnderADoctors(@PathParam("doctorId") Integer doctorId) throws SystemException {
        LOGGER.entry(doctorId);
        if (doctorId == null) {
            doctorId = 0;
        }
        CustomResponse<List<Doctor>> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setObject(doctorService.getAllPatientsUnderAllDoctors(doctorId));
        LOGGER.traceExit(customResponse);

        return customResponse;
    }



}
