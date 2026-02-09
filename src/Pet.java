import java.time.LocalDate;
import java.util.ArrayList;

public class Pet {
    private int id;
    private String name;
    private String species;
    private String breed;
    private int age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;
    private ArrayList<Appointment> appointments;

    public Pet(int id, String name, String species, String breed, int age, String ownerName, String contactInfo,
            LocalDate registrationDate, ArrayList<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.registrationDate =  registrationDate;
        this.appointments = appointments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "\nPet\nid=" + id + "\nname  =" + name + "\nspecies=" + species + "\nbreed=" + breed + "\nage=" + age + ",\nownerName="
                + ownerName + "\ncontactInfo=" + contactInfo + "\nregistrationDate=" + registrationDate
                + "\nappointments=" + appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
