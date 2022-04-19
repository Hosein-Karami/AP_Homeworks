/**
 * this class is used when user choose ADMIN-LOGIN in main menu.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    Scanner scanner = new Scanner(System.in);

    /**
     * this method is used to print all doctors of hospital with their information.
     * @param doctorsOfHospital : Arraylist of doctors of hospital.
     */
    void viewDoctors(ArrayList<Doctor> doctorsOfHospital){
        System.out.println();
        System.out.println("Doctors : ");
        int temp = 1;
        for(Doctor x : doctorsOfHospital) {
            System.out.println(temp + ") " + x.toString());
            temp++;
        }
        System.out.println();
    }

    /**
     * this method get information of a doctor and make a refrence and add to doctor's list in hospital class.
     */
    void addDoctor(ArrayList<Doctor> doctorsOfHospital){
        System.out.println("Enter information of doctor : ");
        System.out.print("First name : ");
        String firstName = scanner.nextLine();
        System.out.print("Last name : ");
        String lastName = scanner.nextLine();
        System.out.print("Age : ");
        int age = scanner.nextInt();
        scanner.nextLine();//avoid ignore scanner.next() and scanner.nextLine() in continue.
        System.out.println("1. Eyes Specialist\n2. Ear Specialist\n3. Heart Specialist\n4. Bones Specialist\n5. Lungs Specialist");
        System.out.print("Choose doctor's type : ");
        int doctorType;
        while (true){
            doctorType = scanner.nextInt();
            if(1 <= doctorType && doctorType <= 5)
                break;
            System.out.print("Invalid input.Choose from 1 to 5 : ");
        }
        scanner.nextLine();//avoid ignore scanner.next() and scanner.nextLine() in continue.

        //process doctor type :
        String typeOfDoctor;
        if(doctorType == 1)
            typeOfDoctor = "Eyes Specialist";
        else if(doctorType == 2)
            typeOfDoctor = "Ear Specialist";
        else if(doctorType == 3)
            typeOfDoctor = "Heart Specialist";
        else if(doctorType == 4)
            typeOfDoctor = "Bones Specialist";
        else
            typeOfDoctor = "Lungs Specialist";

        System.out.print("Entrycharge value : ");
        int entryCharge = scanner.nextInt();
        scanner.nextLine();//avoid ignore scanner.next() and scanner.nextLine() in continue.
        Doctor newDoctor = new Doctor(firstName,lastName,age,typeOfDoctor,entryCharge);
        doctorsOfHospital.add(newDoctor);//add to list.
        System.out.println("Doctor successfully added.\n");
    }

    /**
     * this method is used to print patient's list for user to choose between them.
     * @param patients : refrence of list of hospital's patients.
     */
    void viewPatients(ArrayList<Patient> patients){
        System.out.println();
        int temp = 1;
        System.out.println("Patients list :");
        for(Patient x : patients) {
            System.out.println(temp + " )" + x.toString());
            temp++;
        }
        System.out.println();
    }
}
