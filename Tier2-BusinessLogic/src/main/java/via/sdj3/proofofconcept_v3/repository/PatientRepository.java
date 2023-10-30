package via.sdj3.proofofconcept_v3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import via.sdj3.proofofconcept_v3.entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
