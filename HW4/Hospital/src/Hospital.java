/**
 * this class is used to access hospital's information and update them.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.ArrayList;

public class Hospital {

    private final ArrayList<Doctor> doctors = new ArrayList<>();
    private final ArrayList<Patient> patients = new ArrayList<>();

    /**
     * this method get access to doctors of hospital.
     * @return : Arraylist of doctors.
     */
    ArrayList<Doctor> getDoctors(){
        return doctors;
    }

    /**
     * this method get access to patients of hospital.
     * @return : List of patients.
     */
    ArrayList<Patient> getPatients(){
        return patients;
    }

    /**
     * this method is used to return a patient's refrence with it's index in list.
     * @param index : index of a particular patient in patients of hospital.
     * @return : refrence of a particular patient.
     */
    Patient getPatient(int index){
        return patients.get(index - 1);
    }

    /**
     * this method is used to return a doctor's refrence with it's index in list.
     * @param index : index of a particular doctor in patients of hospital.
     * @return : refrence of a particular doctor.
     */
    Doctor getDoctor(int index){
        return doctors.get(index - 1);
    }

    /**
     * this method is used to print patients when user choose PATIENT – LOGIN in main class.
     */
    void printPatients(){
        int temp = 1;
        for(Patient x : patients){
            System.out.println(temp + ")" + x.getFullName());
            temp++;
        }
    }
    /**
     * this method is used to add a patient to hospital's patient.
     * @param newPatient : new patient's refrence.
     */
    void addPatient(Patient newPatient){
        patients.add(newPatient);
    }

    /**
     * this method is used to return a refrence of a selected patient with his/her name.
     * @param patientFirstName : patient's first name.
     * @param patientLastName : patient's last name.
     * @return : wish patient.
     */
    Patient getPatientWithName(String patientFirstName,String patientLastName){
        for(Patient x : patients){
            if((x.getFirstName().equals(patientFirstName)) && (x.getLastName().equals(patientLastName)))
                return x;
        }
        return null;
    }

    /**
     * this method is used to print doctors with a particular type.
     * @param doctorType : type of doctor which patient want to choose.
     */
    void DoctorsOfParticularType(String doctorType,ArrayList<Doctor> wishesDoctors){
        System.out.println("Doctors : ");
        int temp = 1;
        for(Doctor x : doctors) {
            if (x.getDoctorType().equals(doctorType)) {
                wishesDoctors.add(x);
                System.out.println(temp + ") " + x.toString());
                temp++;
            }
        }
    }
}
