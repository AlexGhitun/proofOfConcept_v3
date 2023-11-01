using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class PatientHttpClient : IPatientService
{
    private readonly HttpClient client;

    public PatientHttpClient(HttpClient client)
    {
        this.client = client;
    }


    public async Task<Patient> ProofOfConcept(PatientCreationDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("http://localhost:8989/patients/test", dto);
        // HttpClients.Implementations.UserHttpClient.Register(UserRegisterDto dto) in C:\Users\37062\Documents\GitHub\ForumBox\HttpClients\Implementations\UserHttpClient.cs:line 25
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        Patient patient = JsonSerializer.Deserialize<Patient>(result);
        return patient;
    }
    
}