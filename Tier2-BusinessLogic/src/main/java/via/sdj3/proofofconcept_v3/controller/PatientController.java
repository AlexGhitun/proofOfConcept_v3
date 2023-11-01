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


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // REQUESTS //

    @PostMapping(value="/patients/test")
    public ResponseEntity<Object> addPatient(@RequestBody Patient patient){

        try {
			patientService.addPatient(patient);
			System.out.println("Im about to return entity");
			return ResponseEntity.ok().body(patient);
		}
		catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }

    @GetMapping(value="/patients")
    public ResponseEntity<Object> getAllPatients(){
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping(value="/patients/{Id}")
    public ResponseEntity<Object> getPatientById(@PathVariable("Id") int id){
        Optional<Patient> patient = patientService.getPatientById(id);
        if (!patient.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patient.get(), HttpStatus.OK);
    }

}

