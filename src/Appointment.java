import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private String appointmentType;
    private LocalDateTime appointmentDateTime;
    private String notes;

    public Appointment(int id, String appointmentType, LocalDateTime appointmentDateTime, String notes) {
        this.id = id;
        this.appointmentType = appointmentType;
        this.appointmentDateTime = appointmentDateTime;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "\nAppointment\nid=" + id + "\nappointmentType=" + appointmentType + "\nappointmentDateTime=" + appointmentDateTime + "\nnotes=" + notes + "]";
    }

    
    
}
