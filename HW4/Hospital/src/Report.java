/**
 * this class is used to save information of a patient's report and get access to this information.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

public class Report {

    private final String doctorFirstName;
    private final String doctorLastName;
    private final String patientFirstName;
    private final String patientLastName;
    private final String medicinePrescribed;
    private final String doctorsComment;

    //Constructor :
    Report(String doctorFirstName,String doctorLastName,String patientFirstName,String patientLastName,String medicinePrescribed,String doctorsComment){
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.medicinePrescribed = medicinePrescribed;
        this.doctorsComment = doctorsComment;
    }

    /**
     * this method is used to print information of report.
     */
    void showReport(){
        System.out.println("\nInformation of this report :");
        System.out.println("Doctor name : "+doctorFirstName+"  "+doctorLastName+"\nPatient name : "+patientFirstName+"  "+patientLastName+"\nMedicine : "+medicinePrescribed+"\nComment of doctor : "+doctorsComment);
        System.out.println();//go to next line.
    }

}
