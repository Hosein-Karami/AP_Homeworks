/**
 * this class is main class and give inputs from user and do tasks.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * this method help us to get invalid input from user.
     * @param Bound : max number which a user can choose.
     * @return : choose of user.
     */
    static int getchoose(int Bound){
        Scanner scanner = new Scanner(System.in);
        int number;
        while(true){
            number = scanner.nextInt();
            if(1 <= number && number <= Bound)
                return number;
            System.out.print("Invalid number.please choose from 1 to " + Bound + " : ");
        }
    }

    public static void main(String[] args){
        Admin admin = new Admin();
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);
        int choose;//for give user's choose.
        while(true){
            System.out.println("1. ADMIN – LOGIN\n2. PATIENT – LOGIN\n3. DOCTOR – LOGIN\n4. PATIENT – SIGNUP\n5. EXIT");
            System.out.print("Enter your choice number : ");
            choose = getchoose(5);//get choose of user.

            if(choose == 5)
                break;

            else if(choose == 1){
                System.out.print("Enter password : ");
                String password = scanner.nextLine();
                //check password :
                if(password.equals("123")){
                    while(true) {
                        System.out.println("1. DoctorsList\n2. PatientsList\n3. AddDoctor\n4. LogOut");
                        System.out.print("Enter your choice number : ");
                        choose = getchoose(4);
                        if (choose == 1)
                            admin.viewDoctors(hospital.getDoctors());
                        else if(choose == 2)
                            admin.viewPatients(hospital.getPatients());
                        else if (choose == 3)
                            admin.addDoctor(hospital.getDoctors());
                        else
                            break;
                    }
                }
                else
                    System.out.println("Invalid password.\n");
            }

            else if(choose == 2){
                //Check hospital has patient or not :
                if(hospital.getPatients().size() == 0)
                    System.out.println("There is no patient in this hospital.");

                else {
                    hospital.printPatients();//print patients.
                    System.out.print("choose a patient number : ");
                    choose = getchoose(hospital.getPatients().size());//get number of wishes patients.
                    Patient patient = hospital.getPatient(choose);//get wishes patient's refrence.

                    while (true) {

                        System.out.println("1. ViewProfile\n2. BookAppointments\n3. ViewReport\n4. LogOut");
                        System.out.print("Enter your choice : ");
                        choose = getchoose(4);

                        if (choose == 4)
                            break;

                        else if (choose == 1)
                            System.out.println(patient.toString());//print profile of wishes patient.

                        else if (choose == 2) {
                            System.out.println("Choose your doctor's expertise number :");
                            System.out.println("1. Eyes Specialist\n2. Ear Specialist\n3. Heart Specialist\n4. Bones Specialist\n5. Lungs Specialist");
                            choose = getchoose(5);//get wishes type of doctor.
                            String doctorType;
                            //set doctor's type in string format.
                            if (choose == 1)
                                doctorType = "Eyes Specialist";
                            else if (choose == 2)
                                doctorType = "Ear Specialist";
                            else if (choose == 3)
                                doctorType = "Heart Specialist";
                            else if (choose == 4)
                                doctorType = "Bones Specialist";
                            else
                                doctorType = "Lungs Specialist";
                            ArrayList<Doctor> doctors = new ArrayList<>();
                            hospital.DoctorsOfParticularType(doctorType, doctors);//print doctors with special type and add them to arraylist.
                            //Check size of wishes doctors :
                            if (doctors.size() == 0)
                                System.out.println("There is no doctor with this expertise in this hospital.");
                            else {
                                System.out.print("Choose your wish doctor : ");
                                choose = getchoose(doctors.size());
                                Doctor wishesDoctor = doctors.get(choose - 1);
                                Appointment appointment = new Appointment(wishesDoctor.getFirstName(), wishesDoctor.getLastName(), patient.getFirstName(), patient.getLastName(), doctorType, LocalDateTime.now());
                                wishesDoctor.addAppointment(appointment);//add appointment to list.
                                appointment.print();//print information of appointment
                                System.out.print("If undrestand,press enter : ");
                                scanner.nextLine();
                            }
                        } else if (choose == 3) {
                            System.out.println("Reports of this patient : ");
                            patient.showReports();
                            System.out.print("If undrestand,press enter :");
                            scanner.nextLine();//Stop to user press enter.
                        }

                    }
                }
            }

            else if(choose == 3){
                //check number of doctors in the hospital :
                if(hospital.getDoctors().size() == 0)
                    System.out.println("There is no doctor in this hospital.");
                else {
                    int temp = 1;
                    System.out.println("Doctors list :");
                    for (Doctor x : hospital.getDoctors()) {
                        System.out.println(temp + ") " + x.getFirstName() + "  " + x.getLastName());
                        temp++;
                    }
                    //Choose a doctor :
                    System.out.print("Enter your wish doctor's number : ");
                    choose = getchoose(hospital.getDoctors().size());
                    Doctor selectedDoctor = hospital.getDoctor(choose);
                    while(true){
                        System.out.println("1. ViewProfile\n2. ViewAppointments\n3. LogOut");
                        System.out.print("Enter your choice : ");
                        choose = getchoose(3);
                        if(choose == 1)
                            System.out.println(selectedDoctor.toString());

                        else if(choose == 2) {
                            if (selectedDoctor.getAppointments().size() == 0)
                                System.out.println("There is no appointment.");
                            else {
                                //choose an appointment :
                                Appointment selectedAppointment = selectedDoctor.getAppointment();
                                Patient selectedPatient = hospital.getPatientWithName(selectedAppointment.getPatientFirstName(), selectedAppointment.getDoctorLastName());
                                //Write report :
                                System.out.print("Medicines names : ");
                                String medicine = scanner.nextLine();
                                System.out.print("Comments : ");
                                String comments = scanner.nextLine();
                                Report newReport = new Report(selectedDoctor.getFirstName(), selectedDoctor.getLastName(), selectedPatient.getFirstName(), selectedPatient.getLastName(), medicine, comments);
                                selectedPatient.addReport(newReport);//add report.
                            }
                        }
                        else
                            break;
                    }
                }
            }

            else if(choose == 4){
                System.out.println("Enter information of patient : ");
                System.out.print("First name : ");
                String firstName = scanner.nextLine();
                System.out.print("Last name : ");
                String lastName = scanner.nextLine();
                System.out.print("Age : ");
                int age = scanner.nextInt();
                scanner.nextLine();//avoid ignore scanner.next() and scanner.nextLine() in continue.
                System.out.print("Address : ");
                String address = scanner.nextLine();
                Patient newPatient = new Patient(firstName,lastName,age,address);
                hospital.addPatient(newPatient);
                System.out.println("Patient successfully add.\n");
            }

        }
    }
}
