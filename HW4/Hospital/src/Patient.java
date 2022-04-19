/**
 * this class is used to save information of a patient and get access to information.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.ArrayList;

public class Patient {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;
    private final ArrayList<Report> reports = new ArrayList<>();

    //Constructor :
    Patient(String firstName,String lastName,int age,String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    /**
     * this method get access to a patient's firstname.
     * @return : firstname of patients.
     */
    String getFirstName(){
        return firstName;
    }

    /**
     * this method get access to a patient's lastname.
     * @return : lastname of patients.
     */
    String getLastName(){
        return lastName;
    }
    /**
     * this method get access to a patient full name.
     * @return : full name of a patient.
     */
    String getFullName(){
        return firstName + "  " + lastName;
    }

    /**
     * this method is used to add a report to reports list of patient.
     * @param newReport : new report.
     */
    void addReport(Report newReport){
        reports.add(newReport);
    }

    /**
     * this method is used to show all reports of patient.
     */
    void showReports(){
        int temp = 1;
        for(Report x : reports){
            System.out.print(temp + ")");
            x.showReport();
            temp++;
        }
    }

    /**
     * this method is used to get access to doctor's information for print them.
     * @return : information of a patient in string format.
     */
    @Override
    public String toString() {
        return "firstname = " + firstName +
                "   lastname = " + lastName +
                "   age = " + age +
                "   address = " + address;
    }
}
