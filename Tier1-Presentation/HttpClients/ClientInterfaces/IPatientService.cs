using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IPatientService
{
    Task<Patient> ProofOfConcept(PatientCreationDto dto);
}