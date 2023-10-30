package via.sdj3.proofofconcept_v3.repository;

import org.springframework.data.repository.CrudRepository;
import via.sdj3.proofofconcept_v3.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
