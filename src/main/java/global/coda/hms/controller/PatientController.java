package global.coda.hms.controller;



import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;
import global.coda.hms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;



    @GetMapping("/getAllPatient")
    public List<Patient> getAll() {
        List<Patient> patientList=patientService.getAllPatients();
        return patientList;
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable("id") int id) {
      return   patientService.getPatientById(id);

    }
    @PostMapping("/create")
    public int createPatient(@RequestBody Patient patient) {
        return  patientService.createPatient(patient);

    }

}
