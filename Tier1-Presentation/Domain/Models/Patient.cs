namespace Domain.Models;

public class Patient
{
    public int Id { get; }
    public string Name { get; }
    
    public Patient(int Id, string Name)
    {
        this.Id = Id;
        this.Name = Name;
    }
}