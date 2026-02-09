import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PetCareScheduler {

    HashMap<Integer, Pet> petMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PetCareScheduler scheduler = new PetCareScheduler();
        scheduler.loadData();
        scheduler.run();
    }

    private void run(){
        boolean exit = false;
        while(!exit){
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch(choice){
                case 1:
                    registerPet();
                    break;
                case 2:
                    scheduleAppointment();
                    break;
                case 3:
                    displayAllPets();
                    break;
                case 4:         
                    displayPetAppointments();
                    break;
                case 5:
                    displayUpcomingAppointments();
                    break;
                case 6:
                    displayPastAppointments();
                    break;      
                case 7:
                    reportUpcomingAppointments();   
                    break;
                case 8:
                    reportOverdueVetVisit();
                    break;
                case 9:
                    saveData();
                    break;
                case 10:
                    saveData();
                    exit = true;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 10.");
            }
        }
    }

    private void displayMenu(){
        System.out.println("======Pet Care Scheduler Menu======");
        System.out.println("1. Registrar nueva mascota");
        System.out.println("2. Agendar cita");
        System.out.println("3. Ver mascotas registradas");
        System.out.println("4. Ver citas de mascotas");
        System.out.println("5. Ver citas proximas");
        System.out.println("6. Ver historial de citas pasadas");
        System.out.println("7. Generar reporte - Mascotas con citas proximas");
        System.out.println("8. Generar reporte - Mascotas vencidas para veterinario");
        System.out.println(("9. Guardar datos"));
        System.out.println("10. Exit");
        System.out.println("====================================");
    }   

    private void registerPet(){
        System.out.println("======Registrar nueva mascota======");

        System.out.println("Ingresar ID de la mascota:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        try { 
            if(petMap.containsKey(id)){
            System.out.println("ID ya existe. Por favor, ingrese un ID único.");
            return;
            }
            if (id < 0) {
                throw new IllegalArgumentException("ID no puede ser negativo. Por favor, ingrese un ID válido.");
            }
            System.out.println("Ingresar nombre de la mascota:");
            String name = scanner.nextLine().trim();

            System.out.println("Ingresar tipo de mascota:");
            String type = scanner.nextLine().trim();

            System.out.println("Ingresar raza de la mascota:");
            String breed = scanner.nextLine().trim();

            System.out.println("Ingresar edad de la mascota:");
            int age = scanner.nextInt();
            if (age <= 0) {
                System.out.println("La edad debe ser un número positivo");
                return;
            }
            scanner.nextLine();

            System.out.println("Ingresar nombre del dueño:");
            String ownerName = scanner.nextLine().trim();

            System.out.println("Ingresar información de contacto del dueño:");
            String contactInfo = scanner.nextLine().trim();

            Pet newPet = new Pet(id, name, type, breed, age, ownerName, contactInfo, LocalDate.now(), new ArrayList<>());
            petMap.put(id, newPet);
            System.out.println("Mascota registrada exitosamente con ID: " + id + " y nombre: " + name);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }    
    }   

    private void displayAllPets(){
        System.out.println("======Mascotas Registradas======");
        if(petMap.isEmpty()){
            System.out.println("No hay mascotas registradas.");
            return;
        }
        for(Pet pet : petMap.values()){
            System.out.println(pet);
        }
    }

    private void displayPetAppointments(){
        System.out.println("======Citas de Mascota======");
        System.out.println("Ingresar ID de la mascota:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        if(!petMap.containsKey(id)){
            System.out.println("ID no encontrado. Por favor, ingrese un ID válido.");
            return;
        }
        Pet pet = petMap.get(id);
        if(pet.getAppointments().isEmpty()){
            System.out.println("No hay citas registradas para esta mascota.");
            return;
        }
        for(Appointment appointment : pet.getAppointments()){
            System.out.println(appointment);
        }
    }

    private void displayUpcomingAppointments(){
        System.out.println("======Citas Proximas======");
        LocalDate today = LocalDate.now();
        boolean hasUpcoming = false;
        for(Pet pet : petMap.values()){
            for(Appointment appointment : pet.getAppointments()){
                if(appointment.getAppointmentDateTime().toLocalDate().isAfter(today)){
                    System.out.println("Mascota: " + pet.getName() + " - " + appointment);
                    hasUpcoming = true;
                }
            }
        }
        if(!hasUpcoming){
            System.out.println("No hay citas proximas.");
        }

    }

    private void displayPastAppointments(){
        System.out.println("======Historial de Citas Pasadas======");
        LocalDate today = LocalDate.now();
        boolean hasPast = false;
        for(Pet pet : petMap.values()){
            for(Appointment appointment : pet.getAppointments()){
                if(appointment.getAppointmentDateTime().toLocalDate().isBefore(today)){
                    System.out.println("Mascota: " + pet.getName() + " - " + appointment);
                    hasPast = true;
                }
            }
        }
        if(!hasPast){
            System.out.println("No hay citas pasadas.");
        }
    }

    private void scheduleAppointment(){
        System.out.println("======Agendar Cita======");
        System.out.println("Ingresar ID de la mascota:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        if(!petMap.containsKey(id)){
            System.out.println("ID no encontrado. Por favor, ingrese un ID válido.");
            return;
        }

        System.out.println("Ingresar tipo de cita (vacunacion, consulta, grooming, etc.):");
        String appointmentType = scanner.nextLine().trim();

        System.out.println("Ingresar fecha y hora de la cita (formato: yyyy-MM-dd HH:mm):");
        String dateTimeStr = scanner.nextLine().trim();
    
        try {
            LocalDateTime appointmentDateTime;
            appointmentDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha y hora inválido. Por favor, use el formato: yyyy-MM-dd HH:mm");
            return;
        }

        Pet pet = petMap.get(id);
        Appointment newAppointment = new Appointment(appointmentType.hashCode(), appointmentType, LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), "");
        pet.addAppointment(newAppointment);
        System.out.println("Cita agendada exitosamente para la mascota: " + pet.getName());
    }

    private void saveData(){
        try {
           File dataDir = new File("data");
              if (!dataDir.exists()) {
                dataDir.mkdir();
            }
            FileOutputStream fileOut = new FileOutputStream("data/pets.txt");
            for (Pet pet : petMap.values()) 
            {
                String line = pet.getId() + "|" + pet.getName() + "|" + pet.getSpecies() + "|" + pet.getBreed() + "|" + pet.getAge() + "|" + pet.getOwnerName() + "|" + pet.getContactInfo() + "|" + pet.getRegistrationDate();
                fileOut.write((line + "\n").getBytes());
            }
            fileOut.close();

            FileOutputStream appointmentOut = new FileOutputStream("data/appointments.txt");

            for(Pet pet : petMap.values()){
                for(Appointment appointment : pet.getAppointments()){
                    String line = pet.getId() + "|" + 
                                appointment.getId() + "|" +
                                appointment.getAppointmentType() + "|" +
                                appointment.getAppointmentDateTime() + "|" +
                                appointment.getNotes();
                    appointmentOut.write((line + "\n").getBytes());
                }
}
            appointmentOut.close();
            System.out.println("Datos guardados exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

  private void loadData() {
    try {

        File petsFile = new File("data/pets.txt");
        if (!petsFile.exists()) {
            return;
        }
            
        Scanner petsScanner = new Scanner(petsFile);
        while (petsScanner.hasNextLine()) {
            String line = petsScanner.nextLine();
            String[] parts = line.split("\\|");
            
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String species = parts[2];
            String breed = parts[3];
            int age = Integer.parseInt(parts[4]);
            String ownerName = parts[5];
            String contactInfo = parts[6];
            LocalDate registrationDate = LocalDate.parse(parts[7]);
            
            Pet pet = new Pet(id, name, species, breed, age, ownerName, contactInfo, registrationDate, new ArrayList<>());
            petMap.put(id, pet);
        }
        petsScanner.close();
        
        File apptsFile = new File("data/appointments.txt");
        if (apptsFile.exists()) {
            Scanner apptsScanner = new Scanner(apptsFile);
            // Leer citas - Parsear correctamente
            while (apptsScanner.hasNextLine()) {
                String line = apptsScanner.nextLine();
                String[] parts = line.split("\\|");
                
                int petId = Integer.parseInt(parts[0]);
                int appointmentId = Integer.parseInt(parts[1]);
                String appointmentType = parts[2];
                LocalDateTime appointmentDateTime = LocalDateTime.parse(parts[3]);
                String notes = parts[4];
                
                Pet pet = petMap.get(petId);
                if (pet != null) {
                    Appointment appt = new Appointment(appointmentId, appointmentType, appointmentDateTime, notes);
                    pet.addAppointment(appt);
                }
            }
            apptsScanner.close();
        }
        
        System.out.println("Datos cargados exitosamente");
        
    } catch (Exception e) {
        System.out.println("Error al cargar datos: " + e.getMessage());
    }
    }

    private void reportUpcomingAppointments() {
    System.out.println("\n===== Reporte: Citas Próximas (7 días) =====");
    
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime nextWeek = now.plusDays(7);
    
    boolean found = false;
    
    for (Pet pet : petMap.values()) {
        for (Appointment appt : pet.getAppointments()) {
            LocalDateTime apptTime = appt.getAppointmentDateTime();
            
            if (apptTime.isAfter(now) && apptTime.isBefore(nextWeek)) {
                System.out.println("Mascota: " + pet.getName() + " - " + appt);
                found = true;
            }
        }
    }
    
    if (!found) {
        System.out.println("No hay citas próximas en los próximos 7 días");
    }
}

    private void reportOverdueVetVisit() {
    System.out.println("\n===== Reporte: Mascotas Vencidas para Vet =====");
    
    LocalDate today = LocalDate.now();
    LocalDate sixMonthsAgo = today.minusMonths(6);
    
    for (Pet pet : petMap.values()) {
        LocalDate lastVetVisit = null;
        
        for (Appointment appt : pet.getAppointments()) {
            if (appt.getAppointmentType().equalsIgnoreCase("Veterinario")) {
                LocalDate apptDate = appt.getAppointmentDateTime().toLocalDate();
                
                if (lastVetVisit == null || apptDate.isAfter(lastVetVisit)) {
                    lastVetVisit = apptDate;
                }
            }
        }
        
        if (lastVetVisit == null || lastVetVisit.isBefore(sixMonthsAgo)) {
            System.out.println("⚠️ " + pet.getName() + " - Vencida para visita al veterinario. Última visita: " + (lastVetVisit != null ? lastVetVisit : "Nunca"));
        }
    }
}
}
