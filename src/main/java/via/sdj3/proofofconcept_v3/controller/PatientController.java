package via.sdj3.proofofconcept_v3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.sdj3.proofofconcept_v3.entity.Patient;
import via.sdj3.proofofconcept_v3.service.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    private PatientService patientService;

    public PatientController() {

    }

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // REQUESTS //

    @PostMapping(value="/patient")
    public ResponseEntity<Object> addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
        return new ResponseEntity<>("Patient is successfully added.", HttpStatus.CREATED);
    }

    @GetMapping(value="/patients")
    public ResponseEntity<Object> getAllPatients(){
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping(value="/patients/{Id}")
    public ResponseEntity<Object> getPatientById(@PathVariable("Id") int id){
        Optional<Patient> patient = patientService.getPatientById(id);
        if (!patient.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patient.get(), HttpStatus.OK);
    }

}

