/**
 * this class is used to save information of a doctor ang get access to them.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Doctor {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String doctorType;
    private final int entryCharge;
    private final ArrayList<Appointment> appointments = new ArrayList<>();

    //Constructor :
    Doctor(String firstName,String lastName,int age,String doctorType,int entryCharge){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.doctorType = doctorType;
        this.entryCharge = entryCharge;
    }

    /**
     * this method get access to doctor's firstname.
     * @return : Firstname of doctor.
     */
    String getFirstName(){
        return firstName;
    }

    /**
     * this method get access to appointments of a doctor.
     * @return : appointments list of a doctor.
     */
    ArrayList<Appointment> getAppointments(){
        return appointments;
    }

    /**
     * this method get access to doctor's lastname.
     * @return : Lastname of doctor.
     */
    String getLastName(){
        return lastName;
    }

    /**
     * this method is used to get access to type of doctor.
     * @return : type of doctor.
     */
    String getDoctorType(){
        return doctorType;
    }

    /**
     * this method is used to add a appointment to doctor's appointment's list.
     * @param appointment : refrence of a particular appointment.
     */
    void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }

    /**
     * this method is used to return a refrence of an appointment.
     * @return : refrence of wish appointment.
     */
    Appointment getAppointment(){
        int temp = 1;
        for(Appointment x : appointments){
            System.out.println(temp + ") " + x.getPatientFullName());
            temp++;
        }
        Scanner scanner = new Scanner(System.in);
        int index;
        System.out.print("Enter your wish appointment number : ");
        //Check input :
        while(true){
            index = scanner.nextInt();
            if(1 <= index && index <= appointments.size())
                break;
            System.out.print("Choose from 1 to " + appointments.size());
        }
        return appointments.get(index - 1);
    }

    /**
     * this method is used to get access to doctor's information for print them.
     * @return : information of a doctor in string format.
     */
    @Override
    public String toString() {
        return
                "firstname = " + firstName  +
                "    lastname = " + lastName  +
                "    age = " + age +
                "    doctortype = " + doctorType +
                "    entrycharge = " + entryCharge;
    }

}
