namespace Domain.DTOs;

public class PatientCreationDto
{
    public int Id { get; }
    public string Name { get; }

    public PatientCreationDto(int Id, string Name)
    {
        this.Id = Id;
        this.Name = Name;
    }

}