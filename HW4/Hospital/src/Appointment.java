/**
 * this class is used to save and get access to a appointment information.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private final String doctorFirstName;
    private final String doctorLastName;
    private final String patientFirstName;
    private final String patientLastName;
    private final String doctorType;
    private final LocalDateTime date;

    //Constructor :
    Appointment(String doctorFirstName,String doctorLastName,String patientFirstName,String patientLastName,String doctorType,LocalDateTime date){
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.doctorType = doctorType;
        this.date = date;
    }

    /**
     * this method get access to patient's first name.
     * @return : first name of patient.
     */
    String getPatientFirstName(){
        return patientFirstName;
    }

    /**
     * this method get access to patient's last name.
     * @return : last name of patient.
     */
    String getDoctorLastName(){
        return patientLastName;
    }
    /**
     * this method get access to patient's full name.
     * @return : full name of patient in string format.
     */
    String getPatientFullName(){
        return (patientFirstName + "  " + patientLastName);
    }

    void print(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Information of appointment : ");
        System.out.println("Doctor firstname : " + doctorFirstName + "  Doctor lastname : " + doctorLastName);
        System.out.println("Patient firstname : " + patientFirstName + "  Patient lastname : " + patientLastName);
        System.out.println("Doctor expertise : " + doctorType + "\nTime : " + formatter.format(date));
    }
}
